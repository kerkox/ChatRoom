/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.descompilado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

public class MCliente
  extends Thread
{
  private int port;
  private String url;
  private Socket s;
  private boolean bConectado;
  VCliente ventana;
  private String nick;
  
  public MCliente(int port, String url, String nick, VCliente ventana)
  {
    this.port = port;
    this.url = url;
    this.ventana = ventana;
    this.nick = nick;
  }
  
  public void run()
  {
    try
    {
      this.s = new Socket(this.url, this.port);
      DataInputStream dis = new DataInputStream(this.s.getInputStream());
      enviarTrama(1, this.nick);
      this.bConectado = true;
      while (this.bConectado)
      {
        int nCodigo = dis.readInt();
        String sTrama = dis.readUTF();
        switch (nCodigo)
        {
        case 1: 
          this.ventana.nuevaPersona(sTrama);
          JOptionPane.showMessageDialog(this.ventana, "Un Nuevo Usuario Conectado, Verifique su Lista de Contactos Online");
          break;
        case 2: 
          this.ventana.mensajeRecibido(sTrama);
          
          break;
        case 3: 
          try
          {
            int nPos = Integer.parseInt(sTrama);
            this.ventana.borrarPersona(nPos);
          }
          catch (Exception e2) {}
        }
      }
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(this.ventana, "No se pudo establecer la conexi�n, Habilite el Puerto para Admitir la Conexi�n");
    }
  }
  
  public void enviarMensaje(String sMensaje)
  {
    enviarTrama(2, sMensaje);
  }
  
  public void enviarTrama(int nCodigo, String sTrama)
  {
    try
    {
      DataOutputStream dos = new DataOutputStream(this.s.getOutputStream());
      dos.writeInt(nCodigo);
      dos.writeUTF(sTrama);
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(this.ventana, "No se pudo enviar el mensaje");
    }
  }
}
