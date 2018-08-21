
package CaseManagementSystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jun
 */
public class CaseManagementSystem {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(); // panel is for put things inside of the frame window.
        JPanel btnPanel = new JPanel();
        JLabel label = new JLabel("Healthcare Software");
        JButton btn1 = new JButton("Login");
        JButton btn2 = new JButton("Exit");
        JTextArea textArea = new JTextArea(); // 한줄 이상 
        JTextField textField = new JTextField();// 한줄 정도
        
        panel.setLayout(new BorderLayout()); //setlayout 은 자기가 원하는 방식대로 panel label 과 버튼을 자기가 원하는 위치에 place.
                                                // borderlayout 은  위,왼쪽오른쪽, 아래 자기가 원하는데에 특정한부분에 원하는 것들을 놔둘수있다.
        panel.add(label, BorderLayout.NORTH); // 윗쪽에 label 놔두기
        panel.add(btnPanel, BorderLayout.EAST);
        btnPanel.add(btn1);
        btnPanel.add(btn2);
        panel.add(textArea, BorderLayout.CENTER); 
        
        btn1.addActionListener(new ActionListener()  // click button 에 기능추가하기.
         {
            @Override
            public void actionPerformed(ActionEvent e) {
               textArea.append("Not supported yet.\n"); //To change body of generated methods, choose Tools | Templates.
            //label.setText(textArea.getText); 택스필드안에있는 텍스 가져오고싶을때  
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        frame.add(panel); // to put frame inside of window frame. otherwise it will be seperated.
        frame.setResizable(true); // resizing the window size, if set to false the size of window will be set.
        frame.setVisible(true);
        frame.setPreferredSize(new Dimension(840, 840/12*9));
        frame.setSize(840, 840/12*9);
        frame.setLocationRelativeTo(null); // pop up window in the centre of monitor.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프로그램을껏을떄 완전히 다꺼지게. otherwise it keeps running evenif we close the window.
        
    }
}
