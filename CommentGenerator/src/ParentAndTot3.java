import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ParentAndTot3 extends JFrame {

	/**
	 * Declaration of the variables
	 */
	private JPanel contentPane;
	private JTextField nameSpc;
	private JLabel title;
	private JLabel strngthDscrption;
	private JComboBox slctStrngth;
	private JLabel wknssDscrption;
	private JComboBox slctWknss;
	private JButton backBtn;
	private JButton gnrateComntBtn;
	private JLabel sttsDscrption;
	private JComboBox psFlDscrption;
	private JLabel gndrDscrption;
	private JComboBox gndrSlction;
	private String[][] strngths;
	private String[][] wknsss;
	private String[] psFl;
	private String[] gndr;
	private JLabel nameDscrption;
	private String[] skills;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParentAndTot3 frame = new ParentAndTot3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ParentAndTot3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		skills = new String[]
		{
			"Jump Entry (Asssited)",
			"Entry and Exit",
			"Submerge",
			"Hold Breath",
			"Object Recovery",
			"Jump Entry (PFD)",
			"Front StarFish",
			"Back StarFish",
			"Front Pencil",
			"Back Pencil",
			"Front Kick",
			"Back Kick",
			"Underwater Pass"
		};
				
		strngths = new String [][]
		{
		};
				
		wknsss = new String[][]
		{
		};
		
		psFl = new String[]
		{
			"Pass",
			"Fail"
		};
		
		gndr = new String[]
		{
			"Male",
			"Female"
		};
		
		title = new JLabel("Parent And Tot 3");
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		title.setBounds(143, 5, 168, 25);
		contentPane.add(title);
		
		strngthDscrption = new JLabel("Select A Strength");
		strngthDscrption.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		strngthDscrption.setBounds(35, 42, 130, 25);
		contentPane.add(strngthDscrption);
		
		slctStrngth = new JComboBox(skills);
		slctStrngth.setBounds(33, 68, 178, 27);
		contentPane.add(slctStrngth);
		
		wknssDscrption = new JLabel("Select A Weakness");
		wknssDscrption.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		wknssDscrption.setBounds(35, 107, 140, 25);
		contentPane.add(wknssDscrption);
		
		slctWknss = new JComboBox(skills);
		slctWknss.setBounds(33, 133, 178, 27);
		contentPane.add(slctWknss);
		
		backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent event) 
			{
				dispose();
				Menu.main(null);
			}
		});
		backBtn.setBounds(20, 230, 117, 29);
		contentPane.add(backBtn);
		
		gnrateComntBtn = new JButton("Generate Comment");
		gnrateComntBtn.setBounds(275, 230, 155, 29);
		contentPane.add(gnrateComntBtn);
		
		nameDscrption = new JLabel("Name");
		nameDscrption.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		nameDscrption.setBounds(244, 46, 61, 16);
		contentPane.add(nameDscrption);
		
		nameSpc = new JTextField();
		nameSpc.setBounds(244, 67, 130, 26);
		contentPane.add(nameSpc);
		nameSpc.setColumns(10);
		
		sttsDscrption = new JLabel("Pass/Fail");
		sttsDscrption.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		sttsDscrption.setBounds(244, 112, 107, 16);
		contentPane.add(sttsDscrption);
		
		psFlDscrption = new JComboBox(psFl);
		psFlDscrption.setBounds(244, 133, 107, 27);
		contentPane.add(psFlDscrption);
		
		gndrDscrption = new JLabel("Gender");
		gndrDscrption.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		gndrDscrption.setBounds(35, 172, 61, 16);
		contentPane.add(gndrDscrption);
		
		gndrSlction = new JComboBox(gndr);
		gndrSlction.setBounds(35, 192, 117, 27);
		contentPane.add(gndrSlction);
	}

}
