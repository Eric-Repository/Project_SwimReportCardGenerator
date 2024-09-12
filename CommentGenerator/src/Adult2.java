import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Adult2 extends JFrame {

	/**
	 * Declaration of the variables
	 */
	private JPanel contentPane;
	private JTextField nameSpc;
	private JLabel title;
	private JLabel strngthDscrption;
	private JComboBox<String> slctStrngth;
	private JLabel wknssDscrption;
	private JComboBox<String> slctWknss;
	private JButton backBtn;
	private JButton gnrateComntBtn;
	private JLabel sttsDscrption;
	private JComboBox<String> psFlDscrption;
	private JLabel gndrDscrption;
	private JComboBox<String> gndrSlction;
	private String[][] strngths;
	private String[][] wknsss;
	private String[] psFl;
	private String[] gndr;
	private JLabel nameDscrption;
	private String[] skills;
	private String prtcpntName;
	private String prtcpntGndr2ndCap;
	private String prtcpntGndr3rdCap;
	private String prtcpntGndr2ndLwr;
	private String prtcpntGndr3rdLwr;
	private String prtcpntGndr4thCap;
	private String prtcpntGndr4thLwr;
	private JTextArea textArea;
	private String[][] intro;
	private String[][] closng;
	private String level;
	private int pssFl;
	private int strngthIndex;
	private int wknsIndex;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adult1 frame = new Adult1();
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
	public Adult2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		skills = new String[]
		{
			"Standing Dive",
			"Forward Roll w/ PFD",
			"Tuck Jump",
			"Tread Water",
			"Handstand",
			"Front Somersault (in water)",
			"Swim Underwater",
			"Flutter kick (back)",
			"Flutter kick (front)",
			"Whip Kick (back)",
			"Whip Kick (front)",
			"Breast stroke (arms drill)",
			"Front Crawl (arms)",
			"Front Crawl (breathing)",
			"Front Crawl (kick)",
			"Back Crawl (arms)",
			"Back Crawl (breathing)",
			"Back Crawl (kick)",
			"Endurance"
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
		
		title = new JLabel("Adult 2");
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		title.setBounds(190, 5, 168, 25);
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
		gnrateComntBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				gndrId();
				nmId();
				getLvl();
				psFlValue();
				strngthWkns();
				initiateArrays();
				textArea = new JTextArea(10, 40);
				textArea.setLineWrap(true);
				textArea.setText(intro[pssFl][rng(intro[pssFl].length)] + strngths[strngthIndex][rng(strngths[strngthIndex].length)] + prtcpntName + wknsss[wknsIndex][rng(wknsss[wknsIndex].length)] + closng[pssFl][rng(closng[pssFl].length)]);
				textArea.setEditable(false);
				JScrollPane scrollPane = new JScrollPane(textArea); 
				JOptionPane.showMessageDialog(contentPane, scrollPane);
			}
		});
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
	
	public int rng(int size)
	{
		int random = (int) (Math.random()*size);
		return random;
	}

	public void psFlValue()
	{
		pssFl = psFlDscrption.getSelectedIndex();
	}
	
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
	
	public void strngthWkns()
	{
		strngthIndex = slctStrngth.getSelectedIndex();
		wknsIndex = slctWknss.getSelectedIndex();
	}
	
	public void nmId()
	{
		prtcpntName = nameSpc.getText();
	}
	
	public void getLvl()
	{
		level = title.getText();
	}
	
	public void initiateArrays()
	{
		intro = new String[][]
		{
			{
				prtcpntName + " has been a great swimmer, and has completed all of the requirements for " + level + ". ",
				prtcpntName + " has been an outstanding swimmer, and has completed " + level + ". ",
				prtcpntName + " has successfully demonstrated all of the requirements for " + level + ". ",
				prtcpntName + " has been a great swimmer, and has successfully completed " + level + ". ",
				prtcpntName + " has successfully demonstrated all of the skills for " + level + ". "
			},
			{
				prtcpntName + " has improved a lot over the past session however " + prtcpntGndr2ndLwr + " is not yet ready for the next level. ",
				prtcpntName + " should continue to keep up the great work " + prtcpntGndr3rdLwr +  " skills are developing well. ",
				prtcpntName + " has put forward a great effort this session however " + prtcpntGndr2ndLwr + " is not yet ready for the next level. ",
				prtcpntName + " has put forward a strong effort in " + prtcpntGndr3rdLwr + " swimming lessons. ",
				prtcpntName + " has done an awesome job swimming so far. "
			}
		};
		
		closng = new String[][]
		{
			{
				"Great job " + prtcpntName + " keep up the great work.",
				"Way to go " + prtcpntName + "! Have fun in your next swim level.",
				"Excellent work " + prtcpntName + " keep up the great job.",
				"Keep up the excellent work next session.",
				"Outstanding job " + prtcpntName + " keep it up."
			},
			{
				"Keep trying! You can do it.",
				"Your almost there, keep up the great effort.",
				"Your becoming such a great swimmer, good job " + prtcpntName + ".",
				"Your swimming skills have progressed a lot over the past few weeks. Keep it up.",
				"Great work, keep practicing for next session."
			}
		};
		
		strngths = new String[][]
		{
			{
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " head tucked and body straight when doing standing dives. ",
				prtcpntGndr2ndCap + " always enters the water head first when performing standing dives. ",
				prtcpntGndr2ndCap + " is very comfortable entering the water by performing standing dives. ",
				prtcpntGndr2ndCap + " has a controlled return to the surface after finishing " + prtcpntGndr3rdLwr + " standing dive. ",
				prtcpntGndr3rdCap + " standing dive is controled as " + prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " body streamlined and head tucked throughout. "
			},
			{
				prtcpntGndr2ndCap + " has no issue doing front rolls without a PFD into the deep end. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " head and arms tucked when doing front rolls into the water without a PFD. ",
				prtcpntGndr2ndCap + " has great control when returning to the surface after finishing " + prtcpntGndr3rdLwr + " front roll. ",
				prtcpntGndr3rdCap + " controled return to the surface after finishing a front roll is great. "
			},
			{
				prtcpntGndr2ndCap + " has no issue doing tuck jumps to enter the water. ",
				prtcpntGndr2ndCap + " has great control when returning to the surface after finishing his tuck jump. ",
				prtcpntGndr3rdCap + " controled return to the surface after finishing a tuck jump is great. "
			},
			{
				prtcpntGndr2ndCap + " can easily keep " + prtcpntGndr3rdLwr + " mouth and nose above the water when treading. ",
				prtcpntGndr2ndCap + " can easily tread water for the full 2 minutes. ",
				prtcpntGndr3rdCap + " legs are in constant motion when treading water. ",
				prtcpntGndr2ndCap + " body is always kept vertical when treading water. "
			},
			{
				prtcpntGndr2ndCap + " can easily perform a handstand with " + prtcpntGndr3rdLwr + " hands on the ground and feet in the air. ",
				prtcpntGndr3rdCap + " handstand is very good. " + prtcpntGndr2ndCap +  " keeps " + prtcpntGndr3rdLwr + " hands grounded and feet in the air",
				prtcpntGndr2ndCap + " can easily and comfortably perform and recover from a handstand while in the water. "
			},
			{
				prtcpntGndr2ndCap + " has a great front somersault where " + prtcpntGndr3rdLwr + " keep the head over heals rotation. ",
				prtcpntGndr2ndCap + " can easily perform a front somersault in the water. ",
				prtcpntGndr3rdCap + " keeps " + prtcpntGndr3rdLwr + " body tucked during the head over heals rotation of the front somersault. "
			},
			{
				prtcpntGndr2ndCap + " can easily swim underwater for the full 10m. ",
				prtcpntGndr2ndCap + " can comfortably swim underwater for the full 10m. ",
				prtcpntGndr2ndCap + " is able to keep " + prtcpntGndr3rdLwr + " body fully submerged for the full 10m of the underwater swim. ",
				prtcpntGndr2ndCap + " stays fully submerged for the full 10m of the underwater swim. "
			},
			{
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " body streamlined while kicking on " + prtcpntGndr3rdLwr + " back. ",
				prtcpntGndr2ndCap + " has a strong flutter kick that moves " + prtcpntGndr4thLwr + " quickly through the water. ",
				prtcpntGndr2ndCap + " can easily kick on " + prtcpntGndr3rdLwr + " back for the full 5m. ",
				prtcpntGndr2ndCap + " has no issue kicking for the full 5m on " + prtcpntGndr3rdLwr + " back. ",
				prtcpntGndr3rdCap + " flutter kick is initiated at the hip and moves " + prtcpntGndr4thLwr + " efficiently through the water. "
			},
			{
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " body streamlined while kicking on " + prtcpntGndr3rdLwr + " front. ",
				prtcpntGndr2ndCap + " has a strong flutter kick that propels " + prtcpntGndr4thLwr + " quickly through the water. ",
				prtcpntGndr2ndCap + " can easily kick on " + prtcpntGndr3rdLwr + " front for the full 5m. ",
				prtcpntGndr3rdCap + " flutter kick is initiated at the hip and moves " + prtcpntGndr4thLwr + " effiently through the water. ",
				prtcpntGndr2ndCap + " has a strong flutter kick that is initated at the hip. "
			},
			{
				prtcpntGndr2ndCap + " has a strong whip-kick that moves " + prtcpntGndr3rdLwr + " quickly through the water. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " feet flexed while performing whip-kick. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " legs synchronized and knees together while performing whip-kick. ",
				prtcpntGndr2ndCap + " is very confident while performing whip-kick on " + prtcpntGndr3rdLwr + " back. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " head back and body streamlined when performing whip-kick on " + prtcpntGndr3rdLwr + " back. "
			},
			{
				prtcpntGndr2ndCap + " has a strong whip-kick that moves " + prtcpntGndr3rdLwr + " quickly through the water. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " feet flexed while performing whip-kick. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " legs synchronized and knees together while performing whip-kick. ",
				prtcpntGndr2ndCap + " is very confident while performing whip-kick on " + prtcpntGndr3rdLwr + " back. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " face down and body streamlined when performing whip-kick on " + prtcpntGndr3rdLwr + " front. "
			},
			{
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " arms symmetrical when pulling towards " + prtcpntGndr3rdLwr + " chest. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " elbows higher than " + prtcpntGndr3rdLwr + " hands when performing the breastroke arm drill. ",
				prtcpntGndr2ndCap + " a performs symmetrical arm recover beyond " + prtcpntGndr3rdLwr + " head. ",
				prtcpntGndr2ndCap + " can easily perform the minimum distance of 10 - 15m for the breaststroke arms drill. ",
				prtcpntGndr2ndCap + " keeps a regular breathing pattern while performing the breast stroke arms drill. "
			},
			{
				prtcpntGndr2ndCap + " reaches all the way forward and back with " + prtcpntGndr3rdLwr + " arms while performing front crawl. ",
				prtcpntGndr2ndCap + " brings " + prtcpntGndr3rdLwr + " arms all the way out of the water while performing front crawl. ",
				prtcpntGndr2ndCap + " constantly alternates " + prtcpntGndr3rdLwr + " arms while performing front crawl. "
			},
			{
				prtcpntGndr2ndCap + " breathes to the side while performing front crawl. ",
				prtcpntGndr2ndCap + " blows bubbles while doing front crawl. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " face in the water while doing front crawl. ",
				prtcpntGndr2ndCap + " exhales fully before breathing while doing front crawl. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " face submerged while performing front crawl. "
			},
			{
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " body streamlined while performing front crawl. ",
				prtcpntGndr2ndCap + " has a strong flutter kick that propels " + prtcpntGndr4thLwr + " quickly through the water. ",
				prtcpntGndr2ndCap + " can easily kick on " + prtcpntGndr3rdLwr + " front for the full 5m of front crawl. ",
				prtcpntGndr3rdCap + " flutter kick is initiated at the hip and moves " + prtcpntGndr4thLwr + " effiently through the water. ",
				prtcpntGndr2ndCap + " has a strong flutter kick that is initated at the hip. "
			},
			{
				prtcpntGndr2ndCap + " brings " + prtcpntGndr3rdLwr + " arms all the way out of the water while performing back crawl. ",
				prtcpntGndr2ndCap + " constantly alternates " + prtcpntGndr3rdLwr + " arms while performing back crawl. ",
				prtcpntGndr2ndCap + " reaches " + prtcpntGndr3rdLwr + " arms all the way out of the water while performing back crawl. "
			},
			{
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " head back and chin up while doing back crawl. ",
				prtcpntGndr2ndCap + " looks all the way up at the ceiling while performing back crawl. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " body streamlined while doing back crawl. "
			},
			{
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " body streamlined while doing back crawl. ",
				prtcpntGndr2ndCap + " has a strong flutter kick that moves " + prtcpntGndr4thLwr + " quickly through the water. ",
				prtcpntGndr2ndCap + " can easily kick on " + prtcpntGndr3rdLwr + " back for the full 5m of back crawl. ",
				prtcpntGndr2ndCap + " has no issue kicking for the full 5m on " + prtcpntGndr3rdLwr + " back. ",
				prtcpntGndr3rdCap + " flutter kick is initiated at the hip and moves " + prtcpntGndr4thLwr + " efficiently through the water. "
			},
			{
				prtcpntGndr2ndCap + " has no issue performing the minimum distances for this swim level with ease. ",
				prtcpntGndr2ndCap + " can easily complete the minimum distances for this swim level with ease. ",
				prtcpntGndr2ndCap + " easily completes the minimum distance requirements for this swim level with ease. "
			}
		};
		
		wknsss = new String[][]
		{
			{
				" should remember to keep " + prtcpntGndr3rdLwr + " head tucked and body straight when performing dives. ",
				" should remember to enter the water head first when performing standing dives. ",
				" should keep practicing standing dives till " + prtcpntGndr2ndLwr + " is comfortable entering the water by performing standing dives. ",
				" should make sure to perform a controlled return to the surface after finishing " + prtcpntGndr3rdLwr + " standing dive. ",
				" should try to keep " + prtcpntGndr3rdLwr + "standing dive controled, keeping " + prtcpntGndr3rdLwr + " body streamlined and head tucked throughout. "
			},
			{
				" should keep practicing front rolls into the deep end with a PFD to get more comfortable with the water. ",
				" should remember to keeps " + prtcpntGndr3rdLwr +" head and arms tucked when doing front rolls into the water without a PFD. ",
				" has great control when returning to the surface after finishing his front roll. ",
				" controled return to the surface after finishing a front roll is great. "
			},
			{
				" should keep practicing tuck jumps so that " + prtcpntGndr2ndLwr + " gets more comfortable with the water. ",
				" should remember to do a controlled return to the surface after finishing " + prtcpntGndr3rdLwr + "tuck jump. ",
				" needs to practice " + prtcpntGndr3rdLwr + "controlled return to the surface after finishing a tuck jump. "
			},
			{
				" should remember to keep " + prtcpntGndr3rdLwr + " mouth and nose above the water when treading. ",
				" should practice treading till " + prtcpntGndr3rdLwr + " can tread water for the full 2 minutes. ",
				" should remember to keep " + prtcpntGndr3rdLwr + " legs in constant motion when treading water. ",
				" needs to keep " + prtcpntGndr3rdLwr + " always keep his body vertical when treading water. "
			},
			{
				" needs to keep " + prtcpntGndr3rdLwr + " hands on the ground and feet in the air while performing hand stands. ",
				" handstand needs improvement. " + prtcpntGndr2ndCap +  " should remember to keep " + prtcpntGndr3rdLwr + " hands grounded and feet in the air",
				" should practice handstands until " + prtcpntGndr2ndCap + " can easily and comfortably perform and recover from a handstand while in the water. "
			},
			{
				" should keep practicing front somersaults where " + prtcpntGndr2ndLwr + " keeps a head over heals rotation. ",
				" should remember to keep " + prtcpntGndr3rdLwr + " body tucked during the head over heals rotation of the front somersault. "
			},
			{
				" should keep practicing underwater swim until " + prtcpntGndr2ndLwr + "can comfortably swim underwater for the full 10m. ",
				" should remember to keep " + prtcpntGndr3rdLwr + " body fully submerged for the full 10m of the underwater swim. ",
				" should practice staying fully submerged for the full 10m of the underwater swim. "
			},
			{
				" should remember to keep " + prtcpntGndr3rdLwr + " body streamlined while kicking on " + prtcpntGndr3rdLwr + " back. ",
				" should keep practicing kicking on " + prtcpntGndr3rdLwr + " so that " + prtcpntGndr3rdLwr + " can complete the full 5m of back kicking ",
				" should remember to keep kicking for the full 5m on " + prtcpntGndr3rdLwr + " back. ",
				" needs to remember to have " + prtcpntGndr3rdLwr + "flutter kick initiated at the hip and moves " + prtcpntGndr4thLwr + " efficiently through the water. "
			},
			{
				" should remember to keep " + prtcpntGndr3rdLwr + " body streamlined while kicking on " + prtcpntGndr3rdLwr + " front. ",
				" should keep practicing kicking on " + prtcpntGndr3rdLwr + " so that " + prtcpntGndr3rdLwr + " can complete the full 5m of front kicking ",
				" should remember to keep kicking for the full 5m on " + prtcpntGndr3rdLwr + " front. ",
				" needs to remember to have " + prtcpntGndr3rdLwr + "flutter kick initiated at the hip and moves " + prtcpntGndr4thLwr + " efficiently through the water. "
			},
			{
				
			},
			{
				"Whip Kick (back)",
				"Whip Kick (front)",
				"Breast stroke (arms drill)",
				"Front Crawl (arms)",
				"Front Crawl (breathing)",
				"fc (kick)",
				"Back Crawl (arms)",
				"Back Crawl (breathing)",
				"bc kick",
				"Endurance"
			}
		};
	}
}
