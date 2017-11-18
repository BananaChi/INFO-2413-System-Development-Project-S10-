package TestGoFish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;



/* PasswordDemo.java requires no other files. */

public class PasswordDemo extends JPanel
                          implements ActionListener {
    private static String OK = "ok";
    private static String HELP = "help";
    private static String enteredName;
    private JFrame controllingFrame; //needed for dialogs
    private JPasswordField passwordField;
    private static String enteredPassword;

    public PasswordDemo(JFrame f) {
        //Use the default FlowLayout.
        controllingFrame = f;

        //Create everything.
        passwordField = new JPasswordField(10);
        passwordField.setActionCommand(OK);
        passwordField.addActionListener(this);

        JLabel label = new JLabel("Enter the password: ");
        label.setLabelFor(passwordField);

        JComponent buttonPane = createButtonPanel();

        //Lay out everything.
        JPanel textPane = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        textPane.add(label);
        textPane.add(passwordField);

        add(textPane);
        add(buttonPane);
    }

    protected JComponent createButtonPanel() {
        JPanel p = new JPanel(new GridLayout(0,1));
        JButton okButton = new JButton("OK");
        JButton helpButton = new JButton("Help");

        okButton.setActionCommand(OK);
        helpButton.setActionCommand(HELP);
        okButton.addActionListener(this);
        helpButton.addActionListener(this);

        p.add(okButton);
        p.add(helpButton);

        return p;
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (OK.equals(cmd)) { //Process the password.
            char[] input = passwordField.getPassword();
            if (isPasswordCorrect(input)) {
            	if(Demo.getRegister() == false)
            	{
	                JOptionPane.showMessageDialog(controllingFrame,
	                    "Success! You typed the right password.");
	                     Demo.setWaiting(0);
	                     return;
            	}
            	if(Demo.getRegister() == true)
            	{
            		JOptionPane.showMessageDialog(controllingFrame,
    	                    "Wowser! Nice password mate!");
    	                     Demo.setWaiting(0);
    	                     return;
            	}
            } else {
                JOptionPane.showMessageDialog(controllingFrame,
                    "Invalid password. Try again.",
                    "Error Message",
                    JOptionPane.ERROR_MESSAGE);
            }

            //Zero out the possible password, for security.
            Arrays.fill(input, '0');

            passwordField.selectAll();
            resetFocus();
        } else { //The user has asked for help.
            JOptionPane.showMessageDialog(controllingFrame,
                "You can get the password by searching this example's\n"
              + "source code for the string \"correctPassword\".\n"
              + "Or look at the section How to Use Password Fields in\n"
              + "the components section of The Java Tutorial.");
        }
    }

    /**
     * Checks the passed-in array against the correct password.
     * After this method returns, you should invoke eraseArray
     * on the passed-in array.
     */
    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        if (Demo.getRegister()==false)
        {
        	char[] correctPassword = Driver.getPlayerPassword(enteredName).toCharArray();// { 'b', 'u', 'g', 'a', 'b', 'o', 'o' };
            
            //har[] c_arr = g.toCharArray(); // returns a length 4 char array ['l','i','n','e']

            if (input.length != correctPassword.length) {
                isCorrect = false;
            } else {
                isCorrect = Arrays.equals (input, correctPassword);
            }

            //Zero out the password.
            Arrays.fill(correctPassword,'0');
        }
        else 
        {
        	String e = new String(input);
        	//Driver.addUser(enteredName, e); this is already handled in the register method
        	enteredPassword = e;
        }
        /*char[] correctPassword = Driver.getPlayerPassword(enteredName).toCharArray();// { 'b', 'u', 'g', 'a', 'b', 'o', 'o' };
        
        //har[] c_arr = g.toCharArray(); // returns a length 4 char array ['l','i','n','e']

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals (input, correctPassword);
        }

        //Zero out the password.
        Arrays.fill(correctPassword,'0');*/

        return isCorrect;
    }

    //Must be called from the event dispatch thread.
    protected void resetFocus() {
        passwordField.requestFocusInWindow();
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    static void createAndShowGUI(String username) {
        //Create and set up the window.
    	enteredName = username;
        JFrame frame = new JFrame("PasswordDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        final PasswordDemo newContentPane = new PasswordDemo(frame);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Make sure the focus goes to the right component
        //whenever the frame is initially given the focus.
        frame.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                newContentPane.resetFocus();
            }
        });

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        while(Demo.getWaiting()!=0)
        {
         //busyWAiting
        	System.out.print("");
        }
        frame.setVisible(false);
    }
    
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("PasswordDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        final PasswordDemo newContentPane = new PasswordDemo(frame);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Make sure the focus goes to the right component
        //whenever the frame is initially given the focus.
        frame.addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                newContentPane.resetFocus();
            }
        });

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        while(Demo.getWaiting()!=0)
        {
         //busyWAiting
        }
        frame.setVisible(false);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		createAndShowGUI();
            }
        });
    }
    
    public static String getPassword()
    {
    	return enteredPassword;
    }
}