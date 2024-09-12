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

public class Adult1 extends JFrame {

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
	public Adult1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		skills = new String[]
		{
			"Entries and Exits",
			"Sideways Entry",
			"Jump into Deep Water",
			"Tread Water (PFD)",
			"Face in the water/Bubbles/Eyes",
			"Object Recovery",
			"Front Float",
			"Back Float",
			"Lateral Roll",
			"Front Glide",
			"Back Glide",
			"Side Glide",
			"Front Kick",
			"Back Kick",
			"Side Kick",
			"Whip Kick",
			"Front Crawl (arms)",
			"Front Crawl (breathing)",
			"Front Crawl (kick)",
			"Back Crawl (arms)",
			"Back Crawl (head position)",
			"Back Crawl (kick)"
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
		
		title = new JLabel("Adult 1");
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
				prtcpntGndr2ndCap + " is very confident when entering and exiting the pool. ",
				prtcpntGndr2ndCap + " is very comfortable when entering and exiting the pool. ",
				prtcpntGndr2ndCap + " is very eager to enter the pool. ",
				prtcpntGndr2ndCap + " safely enters and exits the pool. ",
				prtcpntGndr2ndCap + " is very enthusiastic when entering and exiting the pool. "
			},
			{
				prtcpntGndr2ndCap + " is very confident when entering the pool on " + prtcpntGndr3rdLwr + " side. ",
				prtcpntGndr2ndCap + " can easily enter the pool on " + prtcpntGndr3rdLwr + " side. ",
				prtcpntGndr2ndCap + " can safely enter the pool on " + prtcpntGndr3rdLwr + " side. ",
				prtcpntGndr2ndCap + " does not hesitate when entering the pool on " + prtcpntGndr3rdLwr + " side. ",
				prtcpntGndr2ndCap + " is very calm when entering the pool on " + prtcpntGndr3rdLwr + " side. "
			},
			{
				prtcpntGndr2ndCap + " is very confident when entering and exiting the pool. ",
				prtcpntGndr2ndCap + " is very comfortable when entering and exiting the pool. ",
				prtcpntGndr2ndCap + " is very eager to enter the pool. ",
				prtcpntGndr2ndCap + " safely enters and exits the pool. ",
				prtcpntGndr2ndCap + " is very enthusiastic when entering and exiting the pool. "
			},
			{
				prtcpntGndr2ndCap + " has a strong kick, and is very confident when performing surface support. ",
				prtcpntGndr2ndCap + " is very comfortable while performing surface support. ",
				prtcpntGndr2ndCap + " can easily keep afloat on top of the water while treading. ",
				prtcpntGndr2ndCap + " can comfortably keep afloat on top of the water while treading. ",
				prtcpntGndr2ndCap + " has successfully learned how to tread using proper sculling arm technique. "
			},
			{
				prtcpntGndr2ndCap + " is very confident in the water and can easily put " + prtcpntGndr3rdLwr + " face in the water. ",
				prtcpntGndr2ndCap + " is very comfortable in the water and has no issue putting " + prtcpntGndr3rdLwr + " face in the water. ",
				prtcpntGndr2ndCap + " can easily keep " + prtcpntGndr3rdLwr + " face submerged, and is very good at blowing out bubbles. ",
				prtcpntGndr2ndCap + " can easily keep " + prtcpntGndr3rdLwr + " face submerged, and has no problem opening " + prtcpntGndr3rdLwr + " eyes underwater. ",
				prtcpntGndr2ndCap + " has no problem exhaling while keeping " + prtcpntGndr3rdLwr + " face submerged. "
			},
			{
				prtcpntGndr2ndCap + " is very comfortable in the water and has no issue retrieving objects from the bottom of the pool. ",
				prtcpntGndr2ndCap + " is very confident in the water and has no issue retrieving objects from the bottom of the pool. ",
				prtcpntGndr2ndCap + " is very enthusiatic and has no issue retrieving objects from the botttom of the pool. ",
				prtcpntGndr2ndCap + " is very comfortable in the water and can easily retrive objects from the bottom of the pool. ",
				prtcpntGndr2ndCap + " is very confident in the water and can easily retrive objects from the bottom of the pool. "
			},
			{
				prtcpntGndr2ndCap + " is very comfortable performing " + prtcpntGndr3rdLwr + " front floats. ",
				prtcpntGndr2ndCap + " is very confident when floating on " + prtcpntGndr3rdLwr + " front. ",
				prtcpntGndr2ndCap + " is very comfortable and relaxed when floating on " + prtcpntGndr3rdLwr + " front. ",
				prtcpntGndr2ndCap + " always blows a lot of bubbles when floating on " + prtcpntGndr3rdLwr + " front. ",
				prtcpntGndr2ndCap + " can easily hold " + prtcpntGndr3rdLwr + " face in the water while floating on " + prtcpntGndr3rdLwr + " front. "
			},
			{
				prtcpntGndr2ndCap + " is very comfortable performing " + prtcpntGndr3rdLwr + " back floats",
				prtcpntGndr2ndCap + " is very confident when floating on " + prtcpntGndr3rdLwr + " back. ",
				prtcpntGndr2ndCap + " is very comfortable and relaxed when floating on " + prtcpntGndr3rdLwr + " back. ",
				prtcpntGndr2ndCap + " always keeps " + prtcpntGndr3rdLwr + " head back and stomach up while floating on " + prtcpntGndr3rdLwr + " back. ",
				prtcpntGndr2ndCap + " can easily and comfortably float on " + prtcpntGndr3rdLwr + " back without any assitance. "
			},
			{
				prtcpntGndr2ndCap + " is very comfortable performing lateral rolls. ",
				prtcpntGndr2ndCap + " is very comfortable transitioning between front and back floats. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " body horizontal while performing lateral rolls. ",
				prtcpntGndr2ndCap + " can easily perform lateral rolls. ",
				prtcpntGndr2ndCap + " can confidently perform lateral rolls. "
			},
			{
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " body streamlined while performing front glides. ",
				prtcpntGndr2ndCap + " is very confident while performing front glides. ",
				prtcpntGndr2ndCap + " always blows a lot of bubbles while doing front glides. ",
				prtcpntGndr2ndCap + " is very comfortable in the water and can easily glide 5m on " + prtcpntGndr3rdLwr + " front. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " face fully submerged while performing front glides. "
			},
			{
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " head back and stomach up while performing back glides. ",
				prtcpntGndr2ndCap + " is very confident while performing front glides. ",
				prtcpntGndr2ndCap + " is very comfortable in the water and can easily glide 5m on " + prtcpntGndr3rdLwr + " back. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " body streamlined while gliding on " + prtcpntGndr3rdLwr + " back. ",
				prtcpntGndr2ndCap + " has no issue gliding on " + prtcpntGndr3rdLwr + " back for the full 5m. "
			},
			{
				prtcpntGndr2ndCap + " is very confident while performing side glides. ",
				prtcpntGndr2ndCap + " can easily glide for the full 5m on " + prtcpntGndr3rdLwr + " side. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " body streamlined while gliding on " + prtcpntGndr3rdLwr + " side. ",
				prtcpntGndr2ndCap + " can comfortably glide for the full 5m on " + prtcpntGndr3rdLwr + " side. ",
				prtcpntGndr2ndCap + " has no issue gliding on " + prtcpntGndr3rdLwr + " side for the full 5m. "
			},
			{
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " body streamlined while kicking on " + prtcpntGndr3rdLwr + " front. ",
				prtcpntGndr2ndCap + " has a strong flutter kick that propels " + prtcpntGndr4thLwr + " quickly through the water. ",
				prtcpntGndr2ndCap + " can easily kick on " + prtcpntGndr3rdLwr + " front for the full 5m. ",
				prtcpntGndr3rdCap + " flutter kick is initiated at the hip and moves " + prtcpntGndr4thLwr + " effiently through the water. ",
				prtcpntGndr2ndCap + " has a strong flutter kick that is initated at the hip. "
			},
			{
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " body streamlined while kicking on " + prtcpntGndr3rdLwr + " back. ",
				prtcpntGndr2ndCap + " has a strong flutter kick that moves " + prtcpntGndr4thLwr + " quickly through the water. ",
				prtcpntGndr2ndCap + " can easily kick on " + prtcpntGndr3rdLwr + " front for the full 5m. ",
				prtcpntGndr2ndCap + " has no issue kicking for the full 5m on " + prtcpntGndr3rdLwr + " back. ",
				prtcpntGndr3rdCap + " flutter kick is initiated at the hip and moves " + prtcpntGndr4thLwr + " efficiently through the water. "
			},
			{
				prtcpntGndr2ndCap + " is very confident while kicking on " + prtcpntGndr3rdLwr + " side. ",
				prtcpntGndr2ndCap + " can easily kick on " + prtcpntGndr3rdLwr + " side for the full 5m. ",
				prtcpntGndr2ndCap + " has no issue kicking for the full 5m on " + prtcpntGndr3rdLwr + " side",
				prtcpntGndr2ndCap + " can comfortably kick for the full 5m on " + prtcpntGndr3rdLwr + " side. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " body streamlined while kicking on " + prtcpntGndr3rdLwr + " side. "
			},
			{
				prtcpntGndr2ndCap + " has a strong whip-kick that moves " + prtcpntGndr3rdLwr + " quickly through the water. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " feet flexed while performing whip-kick. ",
				prtcpntGndr2ndCap + " keeps " + prtcpntGndr3rdLwr + " legs synchronized and knees together while performing whip-kick. ",
				prtcpntGndr2ndCap + " is very confident while performing whip-kick on " + prtcpntGndr3rdLwr + " back. ",
				prtcpntGndr2ndCap + " is very comfortable in the water and can easily whip-kick in vertical position for the full 30 seconds. "
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
			}
		};
		
		wknsss = new String[][]
		{
			{
				" should continue to spend more time in the water until " + prtcpntGndr2ndLwr + " becomes more comfortable with the water. ",
				" should practice entering and exiting the pool till " + prtcpntGndr2ndLwr + " can do so safely. ",
				" should practice entering and exiting the pool till " + prtcpntGndr2ndLwr + " can do so comfortably. ",
				" is encouraged to spend more time in the water until " + prtcpntGndr2ndLwr + " becomes more comfortable with the water. ",
				" is encouraged to spend more time in the water until " + prtcpntGndr2ndLwr + " develops a strong level of comfort in the water. "
			},
			{
				" should continue to spend more time in the water until " + prtcpntGndr2ndLwr + " becomes more comfortable with the water. ",
				" should practice entering and exiting the pool till " + prtcpntGndr2ndLwr + " can do so safely. ",
				" should practice entering and exiting the pool till " + prtcpntGndr2ndLwr + " can do so comfortably. ",
				" is encouraged to spend more time in the water until " + prtcpntGndr2ndLwr + " becomes more comfortable with the water. ",
				" is encouraged to spend more time in the water until " + prtcpntGndr2ndLwr + " develops a strong level of comfort in the water. "
			},
			{
				" should continue to spend more time in the water until " + prtcpntGndr2ndLwr + " becomes more comfortable with the water. ",
				" should practice entering and exiting the pool till " + prtcpntGndr2ndLwr + " can do so safely. ",
				" should practice entering and exiting the pool till " + prtcpntGndr2ndLwr + " can do so comfortably. ",
				" is encouraged to spend more time in the water until " + prtcpntGndr2ndLwr + " becomes more comfortable with the water. ",
				" is encouraged to spend more time in the water until " + prtcpntGndr2ndLwr + " develops a strong level of comfort in the water. "
			},
			{
				" is encouraged to use sculling arms while performing surface support. ",
				" is encouraged to kick and keep " + prtcpntGndr3rdLwr + " body in a vertical position while performing surface support. ",
				" should practice treading to the point where " + prtcpntGndr2ndLwr + " is able to support " + prtcpntGndr4thLwr + "self for the full 30 seconds. ",
				" is encouraged to use sculling arms while treading. ",
				" is encouraged to kick and keep " + prtcpntGndr3rdLwr + " body in a vertical position while treading. "
			},
			{
				" is encouraged to practice putting " + prtcpntGndr3rdLwr + " face in the water for the full 5 seconds. ",
				" should practice blowing bubbles till " + prtcpntGndr2ndLwr + " is comfortable putting " + prtcpntGndr3rdLwr + " face in the water. ",
				" should keep practicing blowing bubbles, and strive to blow bubbles with " + prtcpntGndr3rdLwr + " face in the water. ",
				" is encouraged to practice blowing bubbles, and strive to blow bubbles with " + prtcpntGndr3rdLwr + " face in the water. ",
				" is encouraged to practice blowing bubbles till " + prtcpntGndr2ndLwr + " is comfortable putting " + prtcpntGndr3rdLwr + " face in the water. "
			},
			{
				" is encouraged to practice retrieving objects from the bottom of the pool. ",
				" should continue to practice retrieving objects from increasingly deep water while blowing bubbles. ",
				" should remember to blow bubbles and put " + prtcpntGndr3rdLwr + " face in the water while recovering objects from deep water. ",
				" is encouraged to practice blowing bubbles and put " + prtcpntGndr3rdLwr + " face in the water while recovering objects from deep water. ",
				" is encouraged to practice retrieving objects from increasingly deep water while blowing bubbles. "
			},
			{
				" should remember to put " + prtcpntGndr3rdLwr + " face in the water while floating on " + prtcpntGndr3rdLwr + " front. ",
				" should remember to put " + prtcpntGndr3rdLwr + " face in the water while performing front floats. ",
				" should remember to keep " + prtcpntGndr3rdLwr + " arms and legs out like a \"star-fish\" while doing front floats. ",
				" is encouraged to put " + prtcpntGndr3rdLwr + " face in the water while floating on " + prtcpntGndr3rdLwr + " front. ",
				" is encouraged to put " + prtcpntGndr3rdLwr + " face in the water while performing front floats. "
			},
			{
				" should remember to keep " + prtcpntGndr3rdLwr + " head back and stomach up while floating on " + prtcpntGndr3rdLwr + " back. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " head back and stomach up while floating on " + prtcpntGndr3rdLwr + " back. ",
				" should remember to put " + prtcpntGndr3rdLwr + " ears in the water while floating on " + prtcpntGndr3rdLwr + " back. ",
				" is encouraged to put " + prtcpntGndr3rdLwr + " ears in the water while floating on " + prtcpntGndr3rdLwr + " back. ",
				" should remember to keep" + prtcpntGndr3rdLwr + " arms and legs relaxed and breathe regularly. "
			},
			{
				" should remember to keep horizontal when rolling from front to back. ",
				" should remember to put " + prtcpntGndr3rdLwr + " face in the water when rolling laterally from " + prtcpntGndr3rdLwr + " front. ",
				" should remember to keep " + prtcpntGndr3rdLwr + " head back and stomach up when rolling laterally from " + prtcpntGndr3rdLwr + " back. "
			},
			{
				" is encouraged to blow bubbles while gliding on " + prtcpntGndr3rdLwr + " front. ",
				" should remember to blow bubbles while gliding on " + prtcpntGndr3rdLwr + " front. ",
				" should remember to put " + prtcpntGndr3rdLwr + " face in the water while gliding on " + prtcpntGndr3rdLwr + " front. ",
				" is encouraged to put " + prtcpntGndr3rdLwr + " face in the water while gliding on " + prtcpntGndr3rdLwr + " front. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " body streamlined while gliding on " + prtcpntGndr3rdLwr + " front. "
			},
			{
				" is encouraged to keep " + prtcpntGndr3rdLwr + " ears in the water while gliding on " + prtcpntGndr3rdLwr + " back. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " head back and stomach up while gliding on " + prtcpntGndr3rdLwr + " back. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " body streamlined while gliding on " + prtcpntGndr3rdLwr + " back. ",
				" should remember to keep " + prtcpntGndr3rdLwr + " ears in the water while gliding on " + prtcpntGndr3rdLwr + " back. ",
				" should remember to keep " + prtcpntGndr3rdLwr + " head back and stomach up while gliding on " + prtcpntGndr3rdLwr + " back. "
			},
			{
				" should remember to keep " + prtcpntGndr3rdLwr + " body streamlined while gliding on " + prtcpntGndr3rdLwr + " side. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " body streamlined while gliding on " + prtcpntGndr3rdLwr + " side. ",
				" is encouraged to keep one arm extended and the other by " + prtcpntGndr3rdLwr + " side while gliding on " + prtcpntGndr3rdLwr + " side. ",
				" should remember to keep one arm extended and the other by " + prtcpntGndr3rdLwr + " side while gliding on " + prtcpntGndr3rdLwr + " side. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " head rested on " + prtcpntGndr3rdLwr + " bottom arm while gliding on " + prtcpntGndr3rdLwr + " side. "
			},
			{
				" is encouraged to blow bubbles while kicking on " + prtcpntGndr3rdLwr + " front. ",
				" should remember to kick with a slight knee bend while kicking on " + prtcpntGndr3rdLwr + " front. ",
				" should remember to put " + prtcpntGndr3rdLwr + " face in the water while kicking on " + prtcpntGndr3rdLwr + " front. ",
				" is encouraged to put " + prtcpntGndr3rdLwr + " face in the water while kicking on " + prtcpntGndr3rdLwr + " front. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " body streamlined while kicking on " + prtcpntGndr3rdLwr + " front. "
			},
			{
				" is encouraged to " + prtcpntGndr3rdLwr + " head back and stomach up while kicking on " + prtcpntGndr3rdLwr + " back. ",
				" should remember to kick with a slight knee bend while kicking on " + prtcpntGndr3rdLwr + " back. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " ears in the water while kicking on " + prtcpntGndr3rdLwr + " back. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " body streamlined while kicking on " + prtcpntGndr3rdLwr + " back. ",
				" should remember to keep " + prtcpntGndr3rdLwr + " ears in the water while kicking on " + prtcpntGndr3rdLwr + " back. "
			},
			{
				" should remember to keep " + prtcpntGndr3rdLwr + " body streamlined while kicking on " + prtcpntGndr3rdLwr + " side. ",
				" should remember to kick with a slight knee bend while kicking on " + prtcpntGndr3rdLwr + " side. ",
				" is encouraged to keep one arm extended and the other by " + prtcpntGndr3rdLwr + " side while kicking on " + prtcpntGndr3rdLwr + " side. ",
				" should remember to keep one arm extended and the other by " + prtcpntGndr3rdLwr + " side while kicking on " + prtcpntGndr3rdLwr + " side. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " head rested on " + prtcpntGndr3rdLwr + " bottom arm while kicking on " + prtcpntGndr3rdLwr + " side. "
			},
			{
				" should remember to remain vertical while whip-kicking in place. ",
				" should remember to keep " + prtcpntGndr3rdLwr + " feet flexed while whip-kicking. ",
				" should remember to keep " + prtcpntGndr3rdLwr + " knees together while whip-kicking. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " feet flexed while whip-kicking. ",
				" is encouraged to kick with symmetrical legs while whip-kicking. "
			},
			{
				" should remember to reach all the way forward and back with " + prtcpntGndr3rdLwr + " arms while performing front crawl. ",
				" should remeber  to bring " + prtcpntGndr3rdLwr + " arms all the way out of the water while performing front crawl. ",
				" should remember to constantly alternates " + prtcpntGndr3rdLwr + " arms while performing front crawl. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " arms constantly moving while performing front crawl. ",
				" is encouraged to reach " + prtcpntGndr3rdLwr + " arms all the way forward and back while performing front crawl. "
			},
			{
				" is encouraged to exhale fully before breathing while performing front crawl. ",
				" should remember to keep " + prtcpntGndr3rdLwr + " face fully submerged and look at the floor while performing front crawl. ",
				" should remember to keep " + prtcpntGndr3rdLwr + " face in the water while performing front crawl. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " face in the water and exhale fully before lifting " + prtcpntGndr3rdLwr + " to breathe. ",
				" is encouraged to blow bubbles while " + prtcpntGndr3rdLwr + " face is in the water during front crawl. "
			},
			{
				" should remember to initiate " + prtcpntGndr3rdLwr + " kick at the hip instead of the knee. ",
				" should remember that " + prtcpntGndr3rdLwr + " should start at the hip with a slight knee bend. ",
				" should remember that flutter kick should be rhythmic with alternate leg action. ",
				" is encouraged to stop bending " + prtcpntGndr3rdLwr + " knees while performing flutter kick. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " legs straight and initate " + prtcpntGndr3rdLwr + " flutter kick from the hip. "
			},
			{
				" is encouraged to bring " + prtcpntGndr3rdLwr + " arms all the way out of the water while performing back crawl. ",
				" should remember to always keep " + prtcpntGndr3rdLwr + " arms moving while performing back crawl. ",
				" should remember to rotate " + prtcpntGndr3rdLwr + " hand so that the thumb leaves the water first, and the pinky enters the water first while doing back crawl. ",
				" should remember to stretch and reach all the way formward and back with " + prtcpntGndr3rdLwr + " arms while performing back crawl. "
			},
			{
				" should remember to keep " + prtcpntGndr3rdLwr + " head back and stomach up while performing back crawl. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " head back and look up at the ceiling while perfomring back crawl. ",
				" should remember to relax and control " + prtcpntGndr3rdLwr + " breathing while performing back crawl. ",
				" should remember to stay streamlined on " + prtcpntGndr3rdLwr + " back while performing back crawl. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " head back and stomach up while performing back crawl. "
			},
			{
				" should remember to initiate " + prtcpntGndr3rdLwr + " kick at the hip instead of the knee. ",
				" should remember that " + prtcpntGndr3rdLwr + " should start at the hip with a slight knee bend. ",
				" should remember that flutter kick should be rhythmic with alternate leg action. ",
				" is encouraged to stop bending " + prtcpntGndr3rdLwr + " knees while performing flutter kick. ",
				" is encouraged to keep " + prtcpntGndr3rdLwr + " legs straight and initate " + prtcpntGndr3rdLwr + " flutter kick from the hip. "
			}
		};
	}
}
