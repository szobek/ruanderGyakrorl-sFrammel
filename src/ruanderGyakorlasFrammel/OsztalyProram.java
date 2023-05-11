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

public class OsztalyProram {
	private JFrame frame;
	private static List<Tanulo> tanuloLista = new ArrayList<Tanulo>();
	
private DefaultListModel<String> listaModell;
private JList<String> listElemtanulokLista;
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
		listaModell= new DefaultListModel();
		
		/*
		 *  model = new DefaultListModel();
    list = new JList(model);
		 */
		
		
		
		
		FileHandling.readFile("tanulok.txt", ";", tanuloLista);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 0, 241, 182);
		frame.getContentPane().add(scrollPane);
		listElemtanulokLista = new JList(listaModell);
		scrollPane.setViewportView(listElemtanulokLista);
		addElemToList();
	}
	
	private void addElemToList() {
		for(Tanulo tanulo:tanuloLista) {
			listaModell.addElement(tanulo.getNev()+",angol: " +tanulo.getAngol());
		}
		
	}
}
