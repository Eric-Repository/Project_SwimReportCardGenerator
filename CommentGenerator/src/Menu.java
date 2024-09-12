import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu{

	/**
	 * Declaration of the variables
	 */
	private JFrame frame;
	private JLabel title;
	private JLabel comboBoxDescription;
	//Note variable "swimLevelSelection" is not parameterized.
	//Though this is will not affect the execution of the program it is incorrect and should be changed when Windows builder updates/supports java 1.8 parameters
	//The correct code is:
	//private JComboBox<String> swimLevelSelection;
	private JComboBox<String> swimLevelSelection;
	private String[] swimLevels;
	private JButton continueButton;
	private JFrame[] frames;
	private JButton bckBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception exception1) 
				{
					exception1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		swimLevels = new String[] 
		{
			"Parent and Tot 1",
			"Parent and Tot 2",
			"Parent and Tot 3",
			"Preschool 1",
			"Preschool 2",
			"Preschool 3",
			"Preschool 4",
			"Preschool 5",
			"Swimmer 1",
			"Swimmer 2",
			"Swimmer 3",
			"Swimmer 4",
			"Swimmer 5",
			"Swimmer 6",
			"Rookie Patrol",
			"Ranger Patrol",
			"Star Patrol",
			"Adult 1",
			"Adult 2",
			"Adult 3"
		};
		
		ParentAndTot1 prntTot1 = new ParentAndTot1();
		ParentAndTot2 prntTot2 = new ParentAndTot2();
		ParentAndTot3 prntTot3 = new ParentAndTot3();
		Preschool1 preschl1 = new Preschool1();
		Preschool2 preschl2 = new Preschool2();
		Preschool3 preschl3 = new Preschool3();
		Preschool4 preschl4 = new Preschool4();
		Preschool5 preschl5 = new Preschool5();
		Swimmer1 swmr1 = new Swimmer1();
		Swimmer2 swmr2 = new Swimmer2();
		Swimmer3 swmr3 = new Swimmer3();
		Swimmer4 swmr4 = new Swimmer4();
		Swimmer5 swmr5 = new Swimmer5();
		Swimmer6 swmr6 = new Swimmer6();
		Patrol1_Rookie rkyPtrl = new Patrol1_Rookie();
		Patrol2_Ranger rngrPtrl = new Patrol2_Ranger();
		Patrol3_Star strPtrl = new Patrol3_Star();
		Adult1 adlt1 = new Adult1();
		Adult2 adlt2 = new Adult2();
		Adult3 adlt3 = new Adult3();
		
		frames = new JFrame[] 
		{
			prntTot1,
			prntTot2,
			prntTot3,
			preschl1,
			preschl2,
			preschl3,
			preschl4,
			preschl5,
			swmr1,
			swmr2,
			swmr3,
			swmr4,
			swmr5,
			swmr6,
			rkyPtrl,
			rngrPtrl,
			strPtrl,
			adlt1,
			adlt2,
			adlt3
		};
		
		title = new JLabel("Report Card Comment Generator");
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		title.setBounds(76, 27, 328, 25);
		frame.getContentPane().add(title);
		
		comboBoxDescription = new JLabel("Select a Swim Level");
		comboBoxDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxDescription.setBounds(35, 82, 146, 16);
		frame.getContentPane().add(comboBoxDescription);
		
		//Note variable "swimLevelSelection" is not parameterized.
		//Though this is will not affect the execution of the program it is incorrect and should be changed when Windows builder updates/supports java 1.8 parameters
		//The correct code is:
		//swimlevelSelection = new JComboBox<String>(swimLevels);
		swimLevelSelection = new JComboBox<String>(swimLevels);
		swimLevelSelection.setBounds(33, 110, 238, 27);
		frame.getContentPane().add(swimLevelSelection);
		
		continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				int index = swimLevelSelection.getSelectedIndex();
				JFrame newFrame = frames[index];
				frame.dispose();
				newFrame.setVisible(true);
			}
		});
		continueButton.setBounds(308, 225, 117, 29);
		frame.getContentPane().add(continueButton);
		
		bckBtn = new JButton("Close");
		bckBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				frame.dispose();
			}
		});
		bckBtn.setBounds(20, 225, 117, 29);
		frame.add(bckBtn);
	}
}
