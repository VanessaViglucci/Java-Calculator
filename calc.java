 //IMPORTS
 import java.awt.*; 
 import java.awt.event.*; 
 import javax.swing.*; 

public class calc implements ActionListener
{
    public static void main(String args[])
    {
        //instant of calc
        calc calc = new calc(); 
    }
    //Declarationss
    JFrame frame; 
    JPanel panel; 
    JTextField textfield; 
    //array of buttons that holds the number buttons 
    JButton[] numbers = new JButton[10]; 
    //array of buttons that holds the operation buttons 
    JButton[] operations = new JButton[9];
        JButton addition, subtraction, multiplication, division, decimal, equals, delete, clear,negative; 
    //Font 
    Font font = new Font("Helvetica", Font.BOLD, 35); 
    //Colors
    Color numberbuttonColor = new Color(255,255,255);
    Color operationsbuttonColor = new Color(167,217,250); 
    Color backgroundColor = new Color(111,139,171); 
    Color panelColor = new Color(29,59,92); 
    //Numbers 
    double  num1 = 0, num2 = 0, result = 0;  

    char operator; 
    //Constructor 
    calc()
    {
        //create frame
        frame = new JFrame("Calculator"); 
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            frame.setSize(450, 550); 
            frame.setLayout(null); 

        //create textfield 
        textfield = new JTextField(); 
            textfield.setBounds(25,25,400,75); 
            textfield.setFont(font); 
            textfield.setEditable(false); 
            textfield.setBorder(BorderFactory.createLineBorder (panelColor,2)); 

        //create operation buttons and add them to array of operation buttons 
        addition = new JButton("+"); 
            operations[0] = addition; 
        subtraction = new JButton("-"); 
            operations[1] = subtraction; 
        multiplication = new JButton("*"); 
            operations[2] = multiplication; 
        division = new JButton("/"); 
            operations[3] = division; 
        decimal = new JButton("."); 
            operations[4] = decimal;
        equals = new JButton("="); 
            operations[5] = equals; 
        delete = new JButton("del"); 
            operations[6] = delete; 
        clear = new JButton("clr"); 
            operations[7] = clear;  
        negative = new JButton("(-)"); 
            operations[8] = negative; 

        for(int i = 0; i<9; i++)
        {
            operations[i].addActionListener(this); //creates action listener for each operation button
            operations[i].setFont(font); //sets font of each operation button 
            operations[i].setFocusable(false);            
        }

        //creates number Jbuttons 
        for(int i = 0; i<10; i++)
        {
            numbers[i] = new JButton(String.valueOf(i)); 
            numbers[i].addActionListener(this); 
            numbers[i].setFont(font); 

        }
        //Negative, delete and clear button sizes
        negative.setBounds(36,430,114,50);
        delete.setBounds(168,430,114,50); 
        clear.setBounds(300, 430, 114, 50); 

        panel = new JPanel(); 
            panel.setBounds(25, 120, 400, 300); 
            panel.setLayout(new GridLayout(4,4,10,10)); 
            panel.setBackground(panelColor);
            panel.add(numbers[1]); 
            panel.add(numbers[2]); 
            panel.add(numbers[3]);
            panel.add(addition); 
            panel.add(numbers[4]); 
            panel.add(numbers[5]); 
            panel.add(numbers[6]); 
            panel.add(subtraction); 
            panel.add(numbers[7]); 
            panel.add(numbers[8]); 
            panel.add(numbers[9]);  
            panel.add(multiplication); 
            panel.add(decimal);
            panel.add(numbers[0]); 
            panel.add(equals); 
            panel.add(division);        

        //change color of background and then at the panel with the numbers and operations
        //also add the delete, negative and clear button
        frame.getContentPane().setBackground(backgroundColor);
        frame.add(panel); 
        frame.add(negative);
        frame.add(delete); 
        frame.add(clear); 
        frame.add(textfield); //make textfield visibile 
        frame.setVisible(true); 
    }
    //What happened when a button is clicked? 
    public void actionPerformed(ActionEvent e)
    {
        //if any of the numbers are pressed, display the number in the textfield 
        for(int i = 1; i <10; i++)
        {
            if(e.getSource() == numbers[i])
            {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        //display a decimal if the decimal button is pressed
        if(e.getSource() == decimal)
        {
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource() == addition)
        {
            num1 = Double.parseDouble(textfield.getText()); //set num1 to the first user input 
            operator = '+'; 
            textfield.setText(""); //remove the number so the next can be inserted 
        }
        if(e.getSource() == subtraction)
        {
            num1 = Double.parseDouble(textfield.getText()); 
            operator = '-';
            textfield.setText(""); 
        }
        if(e.getSource() == multiplication)
        {
            num1 = Double.parseDouble(textfield.getText()); 
            operator = '*';
            textfield.setText(""); 
        }
        if(e.getSource() == division)
        {
            num1 = Double.parseDouble(textfield.getText()); 
            operator = '/';
            textfield.setText(""); 
        }
        //preform necessary operation 
        if(e.getSource()==equals)
        {
            num2 = Double.parseDouble(textfield.getText()); //set num2 to the double inserted after the operator 
            if(operator == '+')
                result = num1+num2; 
            if(operator == '-') 
                result = num1 - num2; 
            if(operator == '*')
                result = num1*num2; 
            if (operator == '/')
                result = num1/num2; 

            textfield.setText(String.valueOf(result)); 
            num1 = result; //set num1 as the result so the result can then be worked upon 
        }
        if(e.getSource()==clear)
        {
            textfield.setText(""); //remove all text
        }
        //deletes the last entered digit 
        if(e.getSource()==delete)
        {
            String string = textfield.getText(); 
            textfield.setText(""); 
            for(int i = 0; i<string.length()-1; i++)
            {
                textfield.setText(textfield.getText()+string.charAt(i)); 
            }
        }
    }
}
