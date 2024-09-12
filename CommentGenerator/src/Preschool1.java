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

public class Preschool1 extends JFrame {

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
	private String prtcpntGndr2ndCap;
	private String prtcpntGndr3rdCap;
	private String prtcpntGndr2ndLwr;
	private String prtcpntGndr3rdLwr;
	private String prtcpntGndr4thCap;
	private String prtcpntGndr4thLwr;

	public void gndrId()
	{
		if (gndrSlction.getSelectedIndex() == 0)
		{
			prtcpntGndr2ndCap = "He";
			prtcpntGndr2ndLwr = "he";
			prtcpntGndr3rdCap = "His";
			prtcpntGndr3rdLwr = "his";
			prtcpntGndr4thCap = "Him";
			prtcpntGndr4thLwr = "him";
		}
		else
		{
			prtcpntGndr2ndCap = "She";
			prtcpntGndr2ndLwr = "she";
			prtcpntGndr3rdCap = "Her";
			prtcpntGndr3rdLwr = "her";
			prtcpntGndr4thCap = "Her";
			prtcpntGndr4thLwr = "her";
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Preschool1 frame = new Preschool1();
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
	public Preschool1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		strngths = new String[][]
		{
			{
				" is very confident when entering and exiting the pool. ",
				" is very comfortable when entering and exiting the pool. ",
				" is very eager to enter the pool. ",
				" safely enters and exits the pool. ",
				" is very enthusiastic when entering and exiting the pool. "
			},
			{
				" is very confident when jumping into the pool. ",
				" is very eager to jump into the pool. ",
				" is very comfortable in the water and enjoys jumping into the pool. ",
				" enjoys jumping into the pool. ",
				" is very enthusiastic when jumping into the pool. "
			},
			{
				" is very confident in the water and can easily put " + prtcpntGndr3rdLwr + " face in the water. ",
				" is very comfortable in the water and has no issue putting " + prtcpntGndr3rdLwr + " face in the water. ",
				" can easily keep " + prtcpntGndr3rdLwr + " face submerged, and is very good at blowing out bubbles. ",
				" can easily keep " + prtcpntGndr3rdLwr + " face submerged, and has no problem opening " + prtcpntGndr3rdLwr + " eyes underwater. ",
				" has no problem exhaling while keeping " + prtcpntGndr3rdLwr + " face submerged. "
			},
			{
				" "
			}
		};
		
		wknsss = new String[][]
		{		
		};
		
		skills = new String[]
		{
			"Entery and Exit",
			"Jumps",
			"Face in Water",
			"Front Float (Assisted)",
			"Back Float (Assisted)",
			"Movement in water",
			"Glide on Front (Assisted)",
			"Glide on Back (Assisted)"
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
		
		title = new JLabel("Preschool 1");
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		title.setBounds(175, 5, 168, 25);
		contentPane.add(title);
		
		strngthDscrption = new JLabel("Select A Strength");
		strngthDscrption.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		strngthDscrption.setBounds(35, 42, 130, 25);
		contentPane.add(strngthDscrption);
		
		slctStrngth = new JComboBox<String>(skills);
		slctStrngth.setBounds(33, 68, 178, 27);
		contentPane.add(slctStrngth);
		
		wknssDscrption = new JLabel("Select A Weakness");
		wknssDscrption.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		wknssDscrption.setBounds(35, 107, 140, 25);
		contentPane.add(wknssDscrption);
		
		slctWknss = new JComboBox<String>(skills);
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
		
		psFlDscrption = new JComboBox<String>(psFl);
		psFlDscrption.setBounds(244, 133, 107, 27);
		contentPane.add(psFlDscrption);
		
		gndrDscrption = new JLabel("Gender");
		gndrDscrption.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		gndrDscrption.setBounds(35, 172, 61, 16);
		contentPane.add(gndrDscrption);
		
		gndrSlction = new JComboBox<String>(gndr);
		gndrSlction.setBounds(35, 192, 117, 27);
		contentPane.add(gndrSlction);
	}

}

