import Games.*;
import javax.swing.*;
import java.awt.event.*;  

public class App extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JButton bEnter, bExit;
	JLabel lChallenge, lStatus;
	JTextField tResponse;
	Game game;

	private App(){
		super("Quick Math");  
		game = new QuickMath(10);

    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   	setSize(400,400);
		setLayout(null);
		   
		bEnter = new JButton("Enter");
		bExit = new JButton("Exit"); bExit.setVisible(false);
		lStatus = new JLabel(); lStatus.setVisible(false);
		lChallenge = new JLabel();
		lChallenge.setText(game.getChallenge());
		tResponse = new JTextField();
		   
		bEnter.setBounds(250,162,100,25); 
		bExit.setBounds(250,212,100,25); 
		bExit.setMnemonic(KeyEvent.VK_A);
		lChallenge.setBounds(50, 150, 100, 50);
		lStatus.setBounds(50, 200, 100, 50);
		tResponse.setBounds(100, 165, 100, 20);

		bEnter.addActionListener(this);
		bExit.addActionListener(this);
		tResponse.addActionListener(this);
		
		getContentPane().add(bEnter);
		getContentPane().add(bExit);
		getContentPane().add(lChallenge);
		getContentPane().add(lStatus);
	   	getContentPane().add(tResponse);
       	setVisible(true);
	}

	

	public void actionPerformed(ActionEvent e){
		if (e.getSource()==bExit) System.exit(0);
		else if (e.getSource()==bEnter || (e.getSource()==tResponse)){
			String text = tResponse.getText();
			if (text.equals("") || !text.matches("-?\\d+(\\.\\d+)?") || text.length()>6){
				tResponse.setText("");
				return;
			}
			tResponse.setText("");
			lStatus.setText(game.setAnswer(text));
			lStatus.setVisible(true);
			if (game.hasNext())lChallenge.setText(game.getChallenge());
			else{
				lChallenge.setText("Score: " + game.getScore());
				tResponse.setEnabled(false);
				tResponse.setVisible(false);
				tResponse.removeActionListener(this);
				bEnter.setEnabled(false);
				bExit.setVisible(true);
			}
		}
	}

	public static void main(String[] args){
		System.out.println("test");
		new App();
	}


}
