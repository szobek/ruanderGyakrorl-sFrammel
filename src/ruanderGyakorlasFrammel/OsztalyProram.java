package ruanderGyakorlasFrammel;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;

public class OsztalyProram {
	private JFrame frame;
	private static List<Tanulo> tanuloLista = new ArrayList<Tanulo>();
	
private DefaultListModel<String> listaModell;
private JList<String> listElemtanulokLista;
String data[][];

private JTable j;
private JLabel lblOsztalyAtlag;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OsztalyProram window = new OsztalyProram();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OsztalyProram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Object[] opciok = {"Igen", "Nem"};
				if (JOptionPane.showOptionDialog(frame, "Biztos ki akar lépni?", "Kilépés",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciok, opciok[1]) == JOptionPane.YES_OPTION) {
					
					System.exit(0);
					
				}
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle( "Osztály");
		
		
		
		
		FileHandling.readFile("tanulok.txt", ";", tanuloLista);

	    lblOsztalyAtlag = new JLabel("");
	    lblOsztalyAtlag.setBounds(10, 306, 386, 14);
	   addElemToList();
		
	    
	   String column[]={"Név","Angol","Töri","Matek","Átlag"};         
	    
	    
	    j = new JTable(data, column);
        j.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(j);
        sp.setSize(604, 200);
        sp.setLocation(20, 20);
        frame.getContentPane().add(sp);
        
        
        
        
        
        
	    frame.getContentPane().add(sp);          
	    
	    frame.getContentPane().add(lblOsztalyAtlag);
	    
	    
	    frame.setSize(701,400);    
	    frame.setVisible(true);
		
	}
	
	private double sumClassAverage(double all) {		
		return all/tanuloLista.size();
		
	}
	
	private void addElemToList() {
		double atlag = 0;
		data = new String[tanuloLista.size()][5];
		for(int i=0;i<tanuloLista.size();i++) {
			data[i][0]=tanuloLista.get(i).getNev();
			data[i][1]=tanuloLista.get(i).getAngol()+"";
			data[i][2]=tanuloLista.get(i).getTori()+"";
			data[i][3]=tanuloLista.get(i).getMatek()+"";
			data[i][4]=String.format("%.2f",tanuloLista.get(i).getAtlag());  
			atlag+=tanuloLista.get(i).getAtlag();
		}
		lblOsztalyAtlag.setText("Osztályátlag: "+String.format("%.2f",sumClassAverage(atlag)));
		
		
	}
}
