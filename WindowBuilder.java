//imports
import java.awt.Color;
import java.lang.Math.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.*;




public class WindowBuilder extends JFrame
{
    //create text fields
    JTextField in1TB, memBox;
    
    //create labels for top menu (***JUST FOR SHOW - NOT functional!)
    JLabel editB, viewB, helpB;
    
    //create buttons 
    JButton bAdd, bSubtract, bDivide, bSqrt, bMultiply, bPercent, b1OverX, 
            bPlusOrMinus, bDot, bEquals, bMc, bMr, bMs, bMplus, b7, b8, b9, b4,
            b5, b6, b1, b2, b3, b0;
    
    //add panels 
    BottomRightPanel p1;
    MemoryButtonPanel p2;
    TopPanel p3;   
    
    //variables used in math operations
    double in1, in2, ans;
    
    double memory = 0; //used in memory buttons 
    
    //backspace, clear entry, clear buttons
    JButton bBackspace = new JButton("Backspace");
    JButton bCe = new JButton("CE");
    JButton bC = new JButton("C");
    
    //formatting
    public NumberFormat formatter = new DecimalFormat("#.####"); 
    
    //used to identify operation for "for" loop
    double calcOp = 0;

    JButton[] p1Buttons;
   
    
    public WindowBuilder(String title, int width, int height, int x, int y)
    {
        super(title);
        setSize(width, height);
        setLocation(x, y);
    
        //getContentPane().setBackground(contentPaneColor);
        getContentPane().setBackground(new Color(236, 233, 216));
       
        setLayout(null);
       
        //---STEP 1: CREATE ATOMIC OBJECTS---
        
        //Create text boxes 
        in1TB = new JTextField("0");       
        memBox = new JTextField("0");
        
        //Create labels         
    
        editB = new JLabel("Edit");
        viewB = new JLabel("View");
        helpB = new JLabel("Help");
        
        //Set starting text of text boxes
        in1TB.setText("");
        memBox.setText("");
        String s = in1TB.getText();      
      
        
        //Align text of these text boxes
        in1TB.setHorizontalAlignment(JTextField.RIGHT);
     
        
     
        
        //Create buttons and assign text       
        bAdd = new JButton("+");
        bAdd.setText("+");
        
        bSubtract = new JButton("-");
        bSubtract.setText("-");
        
        b7 = new JButton("7");
        b7.setText("7");
        
        b8 = new JButton("8");
        b8.setText("8");
        
        b9 = new JButton("9");
        b9.setText("9");
        
        bDivide = new JButton("/");
        bDivide.setText("/");
        
        bSqrt = new JButton("sqrt");
        bSqrt.setText("sqrt");
        
        b4 = new JButton("4");
        b4.setText("4");
        
        b5 = new JButton("5");
        b5.setText("5");
        
        b6 = new JButton("6");
        b6.setText("6");
        
        bMultiply = new JButton("*");
        bMultiply.setText("*");
        
        bPercent = new JButton("%");
        bPercent.setText("%");
        
        b1 = new JButton("1");
        b1.setText("1");
        
        b2 = new JButton("2");
        b2.setText("2");
        
        b3 = new JButton("3");
        b3.setText("3");
        
        b1OverX = new JButton("1/x");
        b1OverX.setText("1/x");
        
        b0 = new JButton("0");
        b0.setText("0");
        
        bPlusOrMinus = new JButton("+/-");
        bPlusOrMinus.setText("+/-");
        
        bDot = new JButton(".");
        bDot.setText(".");

        bEquals = new JButton("=");
        bEquals.setText("=");
       
        
        bMc = new JButton("MC");
        bMr = new JButton("MR");
        bMs = new JButton("MS"); 
        bMplus = new JButton("M+");
        
        //Create a button grid panel 
        p1 = new BottomRightPanel();
        p2 = new MemoryButtonPanel();
        p3 = new TopPanel();

        //---STEP 2: SPECIFY COMPONENT PROPERTIES---

        in1TB.setBounds(10,30,250,20);

        memBox.setBounds(15, 65, 30, 25);
        memBox.setBackground(new Color(236, 233, 216));
      
      
        bAdd.setBounds(170,100,60,20);
       
        editB.setBounds(3, 1, 60, 20);
        editB.setFont(new Font("Arial", Font.PLAIN, 11));
        viewB.setBounds(35, 1, 60, 20);
        viewB.setFont(new Font("Arial", Font.PLAIN, 11));
        helpB.setBounds(73, 1, 60, 20);
        helpB.setFont(new Font("Arial", Font.PLAIN, 11));

        //---STEP 3: GROUP COMPONENTS---

        //---STEP 4: ADD THE COMPONENTS TO THE CONTAINER---

        add(in1TB);      
        add(memBox);         
        add(editB);
        add(viewB);
        add(helpB);
        add(p1);    
        add(p2);
        add(p3);
        
        //Registering the event handlers 
        b1.addActionListener(new B1Listener());   
        b2.addActionListener(new B2Listener());  
        b3.addActionListener(new B3Listener());  
        b4.addActionListener(new B4Listener());  
        b5.addActionListener(new B5Listener());  
        b6.addActionListener(new B6Listener());  
        b7.addActionListener(new B7Listener());  
        b8.addActionListener(new B8Listener());  
        b9.addActionListener(new B9Listener());  
        b0.addActionListener(new B0Listener()); 
        bDot.addActionListener(new BDotListener());
        bAdd.addActionListener(new BAddHandler());
        bSubtract.addActionListener(new BSubHandler());
        bMultiply.addActionListener(new BMultiplyHandler());
        bDivide.addActionListener(new BDivideHandler());
        bEquals.addActionListener(new EqualsHandler());
        bSqrt.addActionListener(new BSqrtHandler());
        bC.addActionListener(new BClearHandler()); 
        bPercent.addActionListener(new BPercentHandler()); 
        b1OverX.addActionListener(new B1OverXHandler());  
        bPlusOrMinus.addActionListener(new BPlusOrMinusHandler()); 
        bBackspace.addActionListener(new BackspaceHandler());
        bCe.addActionListener(new BCEHandler());
        bMplus.addActionListener(new MPlusHandler());
        bMc.addActionListener(new MCHandler());
        bMr.addActionListener(new MRHandler());
        bMs.addActionListener(new MSHandler());
    }
    

    //Store Number Entered to Memory 
    public class MSHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            memory = Double.parseDouble(in1TB.getText());            
        }
    }

    //Recall Memory 
    public class MRHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {    
            String str = String.valueOf((formatter.format(memory)));
            in1TB.setText(str);           
        }
    }
    
    //Memory Clear 
    public class MCHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            memory = 0;
            in1TB.setText("");          
        }
    }
    
    //Add Number Entered to memory
    public class MPlusHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {            
            double d2 = Double.parseDouble(in1TB.getText());
            memory = (memory + d2);
        }      
    }
    
    
    //Listeners for all number button clicks 
    public class B1Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String s;
            s = in1TB.getText();
            in1TB.setText(s + "1");
        }
    }
    
    public class B2Listener implements ActionListener
    {
    @Override
    public void actionPerformed(ActionEvent e)
        {
            String s;
            s = in1TB.getText();
            in1TB.setText(s + "2");
        }
    }
    
    public class B3Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String s;
            s = in1TB.getText();
            in1TB.setText(s + "3");
        }
    }
    
    public class B4Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String s;
            s = in1TB.getText();
            in1TB.setText(s + "4");
        }
    }
    
    public class B5Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String s;
            s = in1TB.getText();
            in1TB.setText(s + "5");
        }
    }
    
    public class B6Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String s;
            s = in1TB.getText();
            in1TB.setText(s + "6");
        }
    }
    
    public class B7Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String s;
            s = in1TB.getText();
            in1TB.setText(s + "7");
        }
    }
    
    public class B8Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String s;
            s = in1TB.getText();
            in1TB.setText(s + "8");
        }
    }    
    
    public class B9Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String s;
            s = in1TB.getText();
            in1TB.setText(s + "9");
        }        
    }
    
    public class B0Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String s;
            s = in1TB.getText();
            in1TB.setText(s + "0");
        }        
    }
    
    public class BDotListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String s;
            s = in1TB.getText();
            in1TB.setText(s + ".");
        }        
    }
    
    
    //Operator Listeners
    public class BAddHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            calcOp = 1;
            in1 = Double.parseDouble(in1TB.getText());
            in1TB.setText(""); 
        }      
    }
 
    public class BSubHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            calcOp = 2;
            in1 = Double.parseDouble(in1TB.getText());
            in1TB.setText(""); 
        }      
    }
  
    public class BMultiplyHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            calcOp = 3;
            in1 = Double.parseDouble(in1TB.getText());
            in1TB.setText(""); 
        }      
    }
    
    public class BDivideHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            calcOp = 4;
            in1 = Double.parseDouble(in1TB.getText());
            in1TB.setText("");
        }      
    } 
    
    
    //clear handler 
    public class BClearHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            calcOp = 5;
            in1 = Double.parseDouble(in1TB.getText());
            in1TB.setText(""); 
       
        }      
    }
    
    //clear entry handler
    public class BCEHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {           
            in1TB.setText(""); 
          
        }      
    }
    
    //percent 
    public class BPercentHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {        
           in1 = Double.parseDouble(in1TB.getText());
           ans = (in1/100);
           in1TB.setText((formatter.format(ans)));  
        }
    }
    
    //square root handler
    public class BSqrtHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
           in1 = Double.parseDouble(in1TB.getText());
           ans = Math.sqrt(in1);
           in1TB.setText((formatter.format(ans)));           
        }      
    }
    
    // 1/x handler
    public class B1OverXHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
           in1 = Double.parseDouble(in1TB.getText());
           ans = (1/in1);
           in1TB.setText((formatter.format(ans)));           
        }      
    }

    //changes num to negative or positive
    public class BPlusOrMinusHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            in1 = Double.parseDouble(in1TB.getText());
            ans = (-in1);
            in1TB.setText((formatter.format(ans)));
        }      
    }
    
    //backspace
    public class BackspaceHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
       
            in1 = Double.parseDouble(in1TB.getText());
            String bS = in1TB.getText();
            if(bS.length() > 0)
            {
                StringBuilder strB = new StringBuilder(bS);
                strB.deleteCharAt(bS.length() - 1);
                String backspace = strB.toString();
                in1TB.setText(backspace);
            }
        }      
    }
    
    //equals key listener
    //if statements for operators
    public class EqualsHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //add
            if(calcOp == 1)
            {
            in2 = Double.parseDouble(in1TB.getText());
            ans = in1 + in2;
            in1TB.setText((formatter.format(ans)));
            }
            
            //subtract
            if(calcOp == 2)
            {
            in2 = Double.parseDouble(in1TB.getText());
            ans = in1 - in2;
            in1TB.setText((formatter.format(ans)));
            }
            
            //multiply
            if(calcOp == 3)
            {
            in2 = Double.parseDouble(in1TB.getText());
            ans = in1 * in2;
            in1TB.setText((formatter.format(ans)));
            }
            
            //divide
            if(calcOp == 4)
            {
            in2 = Double.parseDouble(in1TB.getText());
            ans = (in1 / in2);
            in1TB.setText((formatter.format(ans)));
            }
            
            //clear
            if(calcOp == 5)
            {
            in1 = 0;
            in2 = 0;
            ans = 0;
            in1TB.setText("");           
            }  
        }
    }
       
    //bottom right panel with buttons using gridlayout
    public class BottomRightPanel extends JPanel
    {
        public BottomRightPanel()
        {
            setBackground(new Color(236, 233, 216));
            //note: button color should be approx 246, 246, 243
            setBounds(61, 97, 200, 130);
            setLayout(new GridLayout(4,5,4,4));  
            
            p1Buttons = new JButton[25];            
              
            //add and set margins for bottom right panel           
            add(b7);
            b7.setMargin(new Insets(0,0,0,0));
            
            add(b8);
            b8.setMargin(new Insets(0,0,0,0));
            
            add(b9);
            b9.setMargin(new Insets(0,0,0,0));
            
            add(bDivide);
            bDivide.setMargin(new Insets(0,0,0,0));
            
            add(bSqrt);
            bSqrt.setMargin(new Insets(0,0,0,0));
            
            add(b4);
            b4.setMargin(new Insets(0,0,0,0));
            
            add(b5);
            b5.setMargin(new Insets(0,0,0,0));
            
            add(b6);
            b6.setMargin(new Insets(0,0,0,0));
            
            add(bMultiply);
            bMultiply.setMargin(new Insets(0,0,0,0));
            
            add(bPercent);
            bPercent.setMargin(new Insets(0,0,0,0));
            
            add(b1);
            b1.setMargin(new Insets(0,0,0,0));
            
            add(b2);
            b2.setMargin(new Insets(0,0,0,0));
            
            add(b3);
            b3.setMargin(new Insets(0,0,0,0));
            
            add(bSubtract);
            bSubtract.setMargin(new Insets(0,0,0,0));
            
            add(b1OverX);
            b1OverX.setMargin(new Insets(0,0,0,0));
            
            add(b0);
            b0.setMargin(new Insets(0,0,0,0));
            
            add(bPlusOrMinus);
            bPlusOrMinus.setMargin(new Insets(0,0,0,0));
            
            add(bDot);
            bDot.setMargin(new Insets(0,0,0,0));
            
            add(bAdd);
            bAdd.setMargin(new Insets(0,0,0,0));
            
            add(bEquals);
            bEquals.setMargin(new Insets(0,0,0,0));           
        }        
    } 
    
    //memory button panel
    public class MemoryButtonPanel extends JPanel
    {
        public MemoryButtonPanel()
        {
            setBackground(new Color(236, 233, 216));
            //note: button color should be approx 246, 246, 243
            setBounds(10, 97, 40, 130);
            setLayout(new GridLayout(4,1,4,4)); 
            add(bMc);
            add(bMr);
            add(bMs);
            add(bMplus);
            bMc.setMargin(new Insets(0,0,0,0)); 
            bMr.setMargin(new Insets(0,0,0,0)); 
            bMs.setMargin(new Insets(0,0,0,0)); 
            bMplus.setMargin(new Insets(0,0,0,0));             
        }
    }
    
    //Top Panel using flow
    public class TopPanel extends JPanel
    {
        public TopPanel()
        {            
            setBackground(new Color(236, 233, 216));
            //note: button color should be approx 246, 246, 243
            //setBounds(15, 97, 40, 130);
            
            //note: button color should be approx 246, 246, 243
            setBounds(61, 62, 200, 30);
           
            
            bBackspace.setPreferredSize(new Dimension(70,25));            
            bCe.setPreferredSize(new Dimension(59,25));
            bC.setPreferredSize(new Dimension(56,25));

            bC.setMargin(new Insets(0,0,0,0)); 
            bBackspace.setMargin(new Insets(0,0,0,0)); 
            bCe.setMargin(new Insets(0,0,0,0)); 
            
            add(bBackspace);
            add(bCe);
            add(bC);               
        }
    }
}
