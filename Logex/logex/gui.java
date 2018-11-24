package logex;

import java.lang.String;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import logex.Logex;
public class gui extends JFrame implements ActionListener

{
    Container panel;
    JButton setbtn, clearbtn;
    JLabel lb1;
    JTextField txtf;
	JTextPane txtPane;
	JScrollPane scrollPane;
	Highlighter.HighlightPainter textColor;
	Logex logex;

    public gui() {
        JPanel pan1 = new JPanel();
		logex = new Logex();
		txtPane = new JTextPane();
		scrollPane = new JScrollPane(txtPane);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textColor = new DefaultHighlighter.DefaultHighlightPainter(Color.decode("0xF6B6C7"));
       
		setLayout(new BorderLayout());
		txtPane.setBackground(Color.decode("0x8AB2E1"));
		
        add(pan1, BorderLayout.NORTH);
		add(scrollPane);

        lb1 = new JLabel("Input Expression :");
        txtf = new JTextField(20);
        setbtn = new JButton("Search");
		clearbtn = new JButton("Clear");
		
        pan1.setBackground(Color.decode("0xDF3E60"));
        pan1.add(lb1);
        pan1.add(txtf);
        pan1.add(setbtn);
        pan1.add(clearbtn);
		
        this.setTitle("Logex");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        setbtn.addActionListener(this);
        clearbtn.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(setbtn)){
				String str = new String(txtPane.getText().replace("\n",""));
				str = str.concat("\0");
				logex.setExpression(txtf.getText(), str);

				StringBuilder text = new StringBuilder();
				logex.matching(text);
				
				//substring
				//txtPane.setText(text.toString());
				System.out.println("text: " + text);
				
				int j = 0;
				try{
					for(int i = 0; i < str.length()-1; i++){
						if(str.charAt(i) == text.toString().charAt(j)){
	//this line occur Exception in thread "AWT-EventQueue-0" java.lang.StringIndexOutOfBoundsException: String index out of range: 159 
	// but It is no problem while executing program.
							txtPane.getHighlighter().addHighlight(i, i+1, textColor);
							j++;
						}
					}
				}
				catch(BadLocationException ble){
				}
		}
        else if(e.getSource().equals(clearbtn)){
			txtf.setText("");
			txtPane.setText("");
            txtf.requestFocus();
        }
    }

}