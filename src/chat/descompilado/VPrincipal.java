/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.descompilado;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.GroupLayout.ParallelGroup;
import org.jdesktop.layout.GroupLayout.SequentialGroup;

public class VPrincipal
  extends JFrame
{
  private JButton jButton1;
  private JButton jButton2;
  
  public VPrincipal()
  {
    initComponents();
  }
  
  private void initComponents()
  {
    this.jButton1 = new JButton();
    this.jButton2 = new JButton();
    
    setDefaultCloseOperation(3);
    setResizable(false);
    
    this.jButton1.setText("Abrir ventana servidor");
    this.jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        VPrincipal.this.jButton1ActionPerformed(evt);
      }
    });
    this.jButton2.setText("Abrir ventana cliente");
    this.jButton2.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        VPrincipal.this.jButton2ActionPerformed(evt);
      }
    });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(2, false).add(1, this.jButton2, -1, -1, 32767).add(1, this.jButton1, -1, -1, 32767)).addContainerGap(-1, 32767)));
    
    layout.setVerticalGroup(layout.createParallelGroup(1).add(layout.createSequentialGroup().addContainerGap().add(this.jButton1).addPreferredGap(0).add(this.jButton2).addContainerGap(-1, 32767)));
    
    pack();
  }
  
  private void jButton2ActionPerformed(ActionEvent evt)
  {
    new VCliente().setVisible(true);
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)
  {
    new VServidor().setVisible(true);
  }
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        new VPrincipal().setVisible(true);
      }
    });
  }
}
