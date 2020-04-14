import java.io.*;
import java.net.*;
import java.lang.Thread.*;


class UDPServer extends Thread
{
  DatagramSocket serverSocket;
  DatagramPacket receivePacket;
  DatagramPacket sendPacket;
  String sentence = "dings";

  //macht geilen Server mit udp
  public void run() {
    try {
      serverSocket = new DatagramSocket(9876);
    } catch(SocketException sex){
      System.out.println(sex.getLocalizedMessage());
    }
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            while(!sentence.equals("exit"))
               {
                  receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  try {
                    serverSocket.receive(receivePacket);
                  } catch (IOException ioe){
                    System.out.println(ioe.getLocalizedMessage());
                  }

                  /*try {
                    Thread.sleep((int)Math.random()*1000);
                  }
                  catch(InterruptedException e) {
                  }*/


                  sentence = new String( receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());

                  System.out.println("RECEIVED: " + sentence);
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();


                  sendData = sentence.getBytes();
                  sendPacket =
                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  try {
                    serverSocket.send(sendPacket);
                  } catch(IOException ioee){
                    System.out.println(ioee.getLocalizedMessage());
                  }

               }    //TODO bzw. sleep bis nachricht da, dann go to die
  }

}