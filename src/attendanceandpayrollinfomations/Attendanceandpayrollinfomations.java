/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceandpayrollinfomations;
//import swing programs and other programs
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JTable;

class AttendanceandPayrollSystem extends JFrame implements ActionListener {
    //Create component classes 
    private JLabel title,name,attendance,medicalleave,annualleave,unpaidleave,ot_hours,ot_salary,total_salary,totalsalary2,gender,Id,Date,working_days;
    private JPanel panel;
    private JTextField name1,othours1,id2;
    private JTextArea retrievetext;
    private JRadioButton male, female;
    private JComboBox date1,month,medicalleave2,annualleave2,unpaidleave2,day;
    private ButtonGroup genderbutton;
    private JButton add,edit,delete,retrieve,save,reset;
    private JTable model;
    private JScrollPane scrollpane;
    private ImageIcon icon;
    FileWriter writer;
    FileReader reader;
    private String dates[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
                            "21","22","23","24","25","26","27","28","29","30","31"};
    private String months[]={"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", 
    "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
    
   
     // Create an array of medical leave days
    private String medicalleave3[]={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
                            "21","22","23","24","25","26","27","28","29","30","31"};
     // Create an array of annual leave days
    private String annualleave3[]={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
                            "21","22","23","24","25","26","27","28","29","30","31"};
     // Create an array of unpaid leave days
    private String unpaidleave3[]={"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20",
                            "21","22","23","24","25","26","27","28","29","30","31"};
    // Create an array of days
    private String days[] 
    = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", 
    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", 
    "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", 
    "31" }; 
    
    // Start with AttendanceAndPayrollSystem constructor 
    public AttendanceandPayrollSystem(){
        //create a new JFrame container
        //Give the frame the intial size
        // Terminate the program when the user closes the application.
        
        JFrame frame=new JFrame("International Network and Electronics Sdn.Bhd.(INE)");
        frame.setBounds(280, 100,1000,650);
        frame.setResizable(true);
        
        //Terminate the program when the user closes the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        // Create a new JPanel
        // Set the background colour and the layout of the panel
        // Add it to the frame
        
        panel=new JPanel();
        panel.setBackground(Color.ORANGE);
        panel.setLayout(null);
        frame.add(panel);
 

        // Create a label for title
        // Set the font, size, and location of title label
        // Add it to the panel
       
        title=new JLabel("Attendance and Payroll of INE Employees", SwingConstants.CENTER);
        title.setFont(new Font("Britannic Bold", Font.BOLD, 25)); 
        title.setSize(800, 50); 
        title.setLocation(100, 25); 
        panel.add(title);
        
         // Create a label for name
         // Set the font, size, and location of name label
         // Add it to the panel
        
        name = new JLabel("Name:", SwingConstants.LEFT); 
        name.setFont(new Font("Britannic Bold", Font.PLAIN, 17)); 
        name.setSize(200, 20);
        name.setLocation(70,100); 
        panel.add(name);
        
        // Create a name1 text field to enable the user to enter the text
        // Set the font, size and location of name1 text field
        // Add it to the panel
       
        
        name1 = new JTextField(); 
        name1.setFont(new Font("Tahoma", Font.PLAIN, 17)); 
        name1.setSize(580, 20); 
        name1.setLocation(250, 100); 
        panel.add(name1);
      
        // Create a label for gender
        // Set the font, size, and location of gender label
        // Add it to the panel
        
        
        gender = new JLabel("Gender :",SwingConstants.LEFT);
        gender.setFont(new Font("Britannic Bold", Font.PLAIN, 17)); 
        gender.setSize(200, 20); 
        gender.setLocation(70, 140); 
        panel.add(gender);
        
        // Create male and female radio button for the user to select to his/hers gender
        // Set the font, size, and location of each button
        // Add them to the panel
        
        male=new JRadioButton("Male");
        male.setFont(new Font("Times New Roman", Font.PLAIN,16));
        male.setSelected(true);
        male.setSize(70, 20);
        male.setLocation(250,140);
        panel.add(male);
        
        
        female=new JRadioButton("Female");
        female.setFont(new Font("Times New Roman", Font.PLAIN,16));
        female.setSelected(false);
        female.setSize(70, 20);
        female.setLocation(330, 140);
        panel.add(female);
        
        // Define a button group
        // Add the male and female radio button to a button group

        genderbutton = new ButtonGroup();
        genderbutton.add(male); 
        genderbutton.add(female);
        
          // Create a label for Id
          // Set the font, size, and location of Id label
          // Add it to the panel
        
        Id=new JLabel("ID : ",SwingConstants.LEFT);
        Id.setFont(new Font("Britannic Bold",Font.PLAIN,17));
        Id.setSize(200, 20);
        Id.setLocation(470, 140);
        panel.add(Id);
        
        // Create a id2 text field to enable the user to enter the text
        // Set the font, size and location of id2 text field
        // Add it to the panel
        
        id2 = new JTextField(); 
        id2.setFont(new Font("Times New Roman", Font.PLAIN, 17)); 
        id2.setSize(170, 20); 
        id2.setLocation(500, 140); 
        panel.add(id2);
        
        // Create a label of date
        // Set the font, size, and location of date label
        // Add it to the panel
        
        
        Date=new JLabel("Date : ",SwingConstants.LEFT);
        Date.setFont(new Font("Britannic Bold",Font.PLAIN,17));
        Date.setSize(200, 20);
        Date.setLocation(700, 140);
        panel.add(Date);
        
        // Create a JComboBox of date and month to let the user selects the date and month from the list given
        // Set the font, size and location of every combo box
        // Add them to the panel 
        
        date1 = new JComboBox(dates);
        date1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        date1.setSize(50, 20);
        date1.setLocation(750, 140);
        panel.add(date1);
        
        month = new JComboBox(months);
        month.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        month.setSize(100, 20);
        month.setLocation(820, 140);
        panel.add(month);
        
        // Create a label of working days
        // Set the font, size, and location of working days label
        // Add it to the panel
        
          working_days = new JLabel("Working Days:", SwingConstants.LEFT); 
          working_days.setFont(new Font("Britannic Bold", Font.PLAIN, 15)); 
          working_days.setSize(100, 20); 
          working_days.setLocation(70, 180); 
          panel.add(working_days);

        // Create a JComboBox of day to let the user selects their total working days from the list given
        // Set the font, size and location of every combo box
        // Add them to the panel 
           
          day = new JComboBox(days); 
          day.setFont(new Font("Tahoma", Font.PLAIN, 15)); 
          day.setSize(50, 20); 
          day.setLocation(250, 180); 
          panel.add(day); 
        
        
         // Create  a label of medical leave
         // Set the font, size, and location of medical leave label
         // Add it to the panel
        
        
        medicalleave=new JLabel("Medical Leave : ",SwingConstants.LEFT);
        medicalleave.setFont(new Font("Britannic Bold",Font.PLAIN,15));
        medicalleave.setSize(150,20);
        medicalleave.setLocation(330, 180);
        panel.add(medicalleave);
        
        // Create a JComboBox of medical leave2 to let the user select their medical leaves days from the list given
        // Set the font, size and location of every combo box
        // Add them to the panel 
        
        
        
        medicalleave2 = new JComboBox(medicalleave3);
        medicalleave2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        medicalleave2.setSize(50, 20);
        medicalleave2.setLocation(450, 180);
        panel.add(medicalleave2);
        
         // Create  a label of annual leave
         // Set the font, size, and location of annualleave label
         // Add it to the panel
        
        annualleave=new JLabel("Annual Leave : ",SwingConstants.LEFT);
        annualleave.setFont(new Font("Britannic Bold",Font.PLAIN,15));
        annualleave.setSize(150,20);
        annualleave.setLocation(530,180);
        panel.add(annualleave);
        // Create a JComboBox of annual leave2 to let the user select their annual leaves days from the list given
        // Set the font, size and location of every combo box
        // Add them to the panel 
        
        annualleave2 = new JComboBox(annualleave3);
        annualleave2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        annualleave2.setSize(50, 20);
        annualleave2.setLocation(650, 180);
        panel.add(annualleave2);
        
        // Create a label of unpaid leave
        // Set the font, size, and location of unpaidleave label
        // Add it to the panel
        
        unpaidleave=new JLabel("Unpaid Leave:",SwingConstants.LEFT);
        unpaidleave.setFont(new Font("Britannic Bold",Font.PLAIN,15));
        unpaidleave.setSize(150,20);
        unpaidleave.setLocation(740, 180);
        panel.add(unpaidleave);
        
        // Create a JComboBox of unupaid leave2 to let the user select their unpaid leaves days from the list given
        // Set the font, size and location of every combo box
        // Add them to the panel 
        
        unpaidleave2 = new JComboBox(unpaidleave3);
        unpaidleave2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        unpaidleave2.setSize(50, 20);
        unpaidleave2.setLocation(850, 180);
        panel.add(unpaidleave2);
        
        
         // Create a label for working overtime
         // Set the font, size, and location of working overtime label
         // Add it to the panel
        
        ot_hours=new JLabel("Overtime Hours : ",SwingConstants.LEFT);
        ot_hours.setFont(new Font("Britannic Bold",Font.PLAIN,15));
        ot_hours.setSize(150,20);
        ot_hours.setLocation(70, 220);
        panel.add(ot_hours);
        
         // Create a othours1 (overtime hours) text field to enable the user to enter the text 
         // Set the font, size and location of othours1 text field
         // Add it to the panel
        
        othours1=new JTextField("",SwingConstants.LEFT);
        othours1.setFont(new Font("Times New Roman",Font.PLAIN,15));
        othours1.setSize(100,20);
        othours1.setLocation(250, 220);
        panel.add(  othours1);
       
         //Create a label for total_salary
         // Set the font, size, and location of total_salary label
         // Add it to the panel
        total_salary=new JLabel("Total Salary :RM  ",SwingConstants.LEFT);
        total_salary.setFont(new Font("Britannic Bold",Font.PLAIN,15));
        total_salary.setSize(150,20);
        total_salary.setLocation(450, 220);
        panel.add(total_salary);
        
        // Create a totalsalary2 text field to enable the user to enter the text 
         // Set the font, size and location of totalsalary text field
         // Add it to the panel
        
       
        totalsalary2=new JLabel("",SwingConstants.LEFT);
        totalsalary2.setFont(new Font("Britannic Bold",Font.PLAIN,15));
        totalsalary2.setSize(150,20);
        totalsalary2.setLocation(570, 220);
        panel.add(totalsalary2);
        
        // Create a register button to let the user press add after filing up the working days , over time hours,annual leaves,medical leaves and unpaid leave for total salary
        // Set the font, size and location of the button
        // Add action listener
        // Add it to the panel 
        
        add = new JButton("ADD"); 
        add.setFont(new Font("Arial", Font.BOLD, 12)); 
        add.setSize(100, 20); 
        add.setLocation(70, 260); 
        add.addActionListener(this); 
        panel.add(add); 
        
        
        // Create a register button to let the user press edit to change any details in the system
        // Set the font, size and location of the button
        // Add action listener
        // Add it to the panel 
        
        edit = new JButton("EDIT"); 
        edit.setFont(new Font("Arial", Font.BOLD, 12)); 
        edit.setSize(100, 20); 
        edit.setLocation(250, 260); 
        edit.addActionListener( this); 
        panel.add(edit); 
        
        // Create a register button to let the user press delete if wrongly key in the details.
        // Set the font, size and location of the button
        // Add action listener
        // Add it to the panel 
        
        delete = new JButton("DELETE"); 
        delete.setFont(new Font("Arial", Font.BOLD, 12)); 
        delete.setSize(100, 20); 
        delete.setLocation(400, 260); 
        delete.addActionListener(this); 
        panel.add(delete); 
        // Create a register button to let the user press save to save the details in a text.
        // Set the font, size and location of the button
        // Add action listener
        // Add it to the panel 
        save = new JButton("SAVE"); 
        save.setFont(new Font("Arial", Font.BOLD, 12)); 
        save.setSize(100, 20); 
        save.setLocation(550, 260); 
        save.addActionListener(this); 
        panel.add(save); 
        // Create a register button to let the user press retrieve to check the saved details in the text.
        // Set the font, size and location of the button
        // Add action listener
        // Add it to the panel
        retrieve = new JButton("RETRIEVE"); 
        retrieve.setFont(new Font("Arial", Font.BOLD, 12)); 
        retrieve.setSize(100, 20); 
        retrieve.setLocation(680, 260); 
        retrieve.addActionListener(this); 
        panel.add(retrieve); 
        // Create a retrieve text to checked the saved details in the text
        // Set the font, size and location of the button
        // Add action listener
        // Add it to the panel
        
       
        scrollpane=new JScrollPane(retrievetext);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        retrievetext = new JTextArea("RETRIEVED HERE"); 
        panel.add(scrollpane);
        retrievetext.setFont(new Font("Tahoma", Font.PLAIN, 15)); 
        retrievetext.setBackground(Color.WHITE); 
     
        retrievetext.setLineWrap(true); 
        retrievetext.setEditable(false); 
        scrollpane.setBounds(30, 30, 500, 310);
        scrollpane.setLocation(200,300);
        scrollpane.getViewport().add(retrievetext);
        panel.add(scrollpane);
        
        
        
        // Display the frame
        frame.setVisible(true);      
        
    }
        //Handling the buttons
        //Method actionPerformed() 
        // To perform the action according to the user
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==save){
                // If the user press the SAVE
                // The output will be printed out on the retrivetext box area
                
                String title="Attendance and Payroll Of INE Employees\n\n";
                String name2="Name :"+name1.getText()+"\n\n";
                String gender4;
                if(male.isSelected()){
                    gender4="Gender: Male\n\n";
                }else{
                    gender4="Gender: Female\n\n";
                }
                String id3="ID :"+ Id.getText()+ "\n\n";
                String date2="Date :"+ (String)date1.getSelectedItem() + " "+ (String)month.getSelectedItem() + " ";
                String wd="Working Days :" + (String)day.getSelectedItem()+" " ;
                String medical="Medical Leave :" + (String)medicalleave2.getSelectedItem()+" " ;
                String annual="Annual Leave :" + (String)annualleave2.getSelectedItem()+" " ;
                String unpaid="Unpaid Leave :" + (String)unpaidleave2.getSelectedItem()+" " ;
                String othour="Overtime Hour :"+  othours1.getText()+"\n\n";
                String total="Total Salary : RM"+totalsalary2.getText()+"\n\n";
               // Create a dialog that show a message
                
                 JOptionPane.showMessageDialog(null, "Employees Information has been successfully saved!");
                // Create a text file to enable input to be read from external storage file 
                // and write the output to external file
               
                      
            try{
                writer=new FileWriter("Attendance and Payroll of INE Employees.txt",true);
                writer.write("Attendance and Payroll of INE Employees");
                writer.write(System.getProperty("line.separator"));
                writer.write(System.getProperty("line.separator"));
                writer.write(name.getText() +""+ name1.getText());
                writer.write(System.getProperty("line.separator"));
                 if(male.isSelected()){
                    writer.write(gender.getText()+""+ "Male");
                }else{
                    writer.write(gender.getText()+""+ "Female");
                }
               
                writer.write(System.getProperty("line.separator"));
                writer.write(Id.getText() +""+ id2.getText());
                writer.write(System.getProperty("line.separator"));
                writer.write(Date.getText() +""+ (String)date1.getSelectedItem() + " " +(String)month.getSelectedItem() );
                writer.write(System.getProperty("line.separator"));
                writer.write(working_days.getText() + "" + (String)day.getSelectedItem() );
                writer.write(System.getProperty("line.separator"));
                writer.write(medicalleave.getText() + "" + (String)medicalleave2.getSelectedItem() );
                writer.write(System.getProperty("line.separator"));
                writer.write(annualleave.getText() + "" + (String)annualleave2.getSelectedItem() );
                writer.write(System.getProperty("line.separator"));
                writer.write(unpaidleave.getText() + "" + (String)unpaidleave2.getSelectedItem() );
                writer.write(System.getProperty("line.separator"));
                writer.write(ot_hours.getText() + "" +   othours1.getText());
                writer.write(System.getProperty("line.separator"));
                writer.write(total_salary.getText() + "" + totalsalary2.getText());
                writer.write(System.getProperty("line.separator"));
                writer.close();
                 // Create a dialog that show a message
                JOptionPane.showMessageDialog(null, "Informations of the employee has been stored to the text");
                
            
                
                
                
            } catch(Exception ae){
                JOptionPane.showMessageDialog(null, "ERROR");
            }       
            }
            // If the user press RETRIEVE button, all the information will be retrieved 
            else if(e.getSource()==retrieve){
                    try{
             reader=new FileReader("Attendance and Payroll of INE Employees.txt");
            BufferedReader br=new BufferedReader(reader);
            retrievetext.read(br,null);

            br.close();
            retrievetext.requestFocus();
             // Create a dialog that show a message
             JOptionPane.showMessageDialog(null, "Informations of the employee has been retrieved");
              }catch(Exception ae){
            JOptionPane.showMessageDialog(null, e);
               }   
                      
                      
                      
                      
                      
                }
            // If the user press DELETE button, all the information will be cleared
            else if(e.getSource()==delete){
                
                name1.setText("");
                id2.setText("");
                date1.setSelectedIndex(0);
                month.setSelectedIndex(0);
                day.setSelectedIndex(0);
                medicalleave2.setSelectedIndex(0);
                annualleave2.setSelectedIndex(0);
                unpaidleave2.setSelectedIndex(0);
                othours1.setText("");
                totalsalary2.setText("");
                
                 // Create a dialog that show a message
                 JOptionPane.showMessageDialog(null, "Informations of the employee has been deleted");
                
            }
            // If the user press ADD button, a new set of employee information can be added
            else if(e.getSource()==add){
                int ot_hour,days,annual,medic,total;
                ot_hour=Integer.parseInt(  othours1.getText());
                days=Integer.parseInt((String) day.getSelectedItem());
                annual=Integer.parseInt((String) annualleave2.getSelectedItem());
                medic=Integer.parseInt((String) medicalleave2.getSelectedItem());
                
                        
                int salary_per_day=48;
                int ot_per_hour=4;
                
              
                total=((days*salary_per_day)+(annual*salary_per_day)+(medic*salary_per_day)+(ot_hour*ot_per_hour));
               String totalsalary = Integer.toString(total);
                totalsalary2.setText(totalsalary);
                
                
                // Create a dialog that show a message
                 JOptionPane.showMessageDialog(null, "Total salary has been calculated");
                
                
                
            }
            // If the user press EDIT button, the information that were added can be edited
            else if(e.getSource()==edit){
                
               
               
                try{
                writer=new FileWriter("Attendance and Payroll of INE Employees.txt",true);
                writer.write("Attendance and Payroll of INE Employees");
                writer.write(System.getProperty("line.separator"));
                writer.write(System.getProperty("line.separator"));
                writer.write(name.getText() +""+ name1.getText());
                writer.write(System.getProperty("line.separator"));
                 if(male.isSelected()){
                    writer.write(gender.getText()+""+ "Male");
                }else{
                    writer.write(gender.getText()+""+ "Female");
                }
               
                writer.write(System.getProperty("line.separator"));
                writer.write(Id.getText() +""+ id2.getText());
                writer.write(System.getProperty("line.separator"));
                writer.write(Date.getText() +""+ (String)date1.getSelectedItem() + " " +(String)month.getSelectedItem() );
                writer.write(System.getProperty("line.separator"));
                writer.write(working_days.getText() + "" + (String)day.getSelectedItem() );
                writer.write(System.getProperty("line.separator"));
                writer.write(medicalleave.getText() + "" + (String)medicalleave2.getSelectedItem() );
                writer.write(System.getProperty("line.separator"));
                writer.write(annualleave.getText() + "" + (String)annualleave2.getSelectedItem() );
                writer.write(System.getProperty("line.separator"));
                writer.write(unpaidleave.getText() + "" + (String)unpaidleave2.getSelectedItem() );
                writer.write(System.getProperty("line.separator"));
                writer.write(ot_hours.getText() + "" +   othours1.getText());
                writer.write(System.getProperty("line.separator"));
                writer.write(total_salary.getText() + "RM" + totalsalary2.getText());
                writer.write(System.getProperty("line.separator"));
                writer.close();
                  // Create a dialog that show a message
                
                JOptionPane.showMessageDialog(null, "Informations of the employee has been edited");
                
            
                
                
                
            } catch(Exception ae){
                JOptionPane.showMessageDialog(null, "ERROR");
            }       
              
                      
        
       
            }
                      
            }
       
        }
        //driver class
   class Attendanceandpayrollinfomations{
     public static void main(String[] args) {
      

        new AttendanceandPayrollSystem();
    }

}