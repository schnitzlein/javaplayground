import java.io.*;
import java.net.*;
import java.lang.Thread.*;

class UDPClient extends Thread
{

  DatagramSocket clientSocket;
  DatagramPacket sendPacket;
  DatagramPacket receivePacket;
  InetAddress IPAddress;
  String sentence = "joa";
  String modifiedSentence = "dings";
  BufferedReader inFromUser;
  
  int portnummer;
  //TODO: alles auf if ..==null überprüfen, dann sleep machen
  
  //macht geilen Client mit udp
  public void run() {

      inFromUser =
         new BufferedReader(new InputStreamReader(System.in));
         
      try {
        clientSocket = new DatagramSocket();
      }  catch(SocketException sex){
        System.out.println(sex.getLocalizedMessage());
      }
      try {
        IPAddress = InetAddress.getByName("localhost");
      } catch (UnknownHostException uhe){
        System.out.println(uhe);
      }

      while(!sentence.equals("exit")){
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        try {
          sentence = inFromUser.readLine();
        } catch (IOException ioe){
          System.out.println("blah");
        }
        //TODO den alten Datensalat loeschen
        sendData = sentence.getBytes();
        sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

        try {
          clientSocket.send(sendPacket);
        } catch(IOException ioe){
          System.out.println("blub");
        }

        receivePacket = new DatagramPacket(receiveData, receiveData.length);
        try {
          clientSocket.receive(receivePacket);
        } catch(IOException ioe){
          System.out.println("ja");
        }


        modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);
      }

      //clientSocket.close();
  }
}