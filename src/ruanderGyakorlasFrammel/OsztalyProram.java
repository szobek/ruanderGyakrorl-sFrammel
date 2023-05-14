package ruanderGyakorlasFrammel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class OsztalyProram {
	private JFrame frame;
	private static List<Tanulo> tanuloLista = new ArrayList<Tanulo>();

	private DefaultListModel<String> listaModell;
	private JList<String> listElemtanulokLista;
	String data[][];

	private JTable jtable;
	String column[] = { "Név", "Angol", "Töri", "Matek", "Átlag" };
	DefaultTableModel model;

	private JLabel lblOsztalyAtlag;
	
	
	private RowSorter<TableModel> fSorter;

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
				Object[] opciok = { "Igen", "Nem" };
				if (JOptionPane.showOptionDialog(frame, "Biztos ki akar lépni?", "Kilépés", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, opciok, opciok[1]) == JOptionPane.YES_OPTION) {

					System.exit(0);

				}
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Osztály");

		FileHandling.readFile("tanulok.txt", ";", tanuloLista);

		lblOsztalyAtlag = new JLabel("");
		lblOsztalyAtlag.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblOsztalyAtlag.setHorizontalAlignment(SwingConstants.CENTER);
		lblOsztalyAtlag.setBounds(226, 256, 177, 35);

		
		
		
		model = new DefaultTableModel(data,column);
		jtable = new JTable(model);
		
		
		jtable.setFont(new Font("Tahoma", Font.ITALIC, 13));
		jtable.setBounds(30, 40, 200, 300);
		jtable.setAutoCreateRowSorter(true);
		model.setColumnIdentifiers(column);// beállítja az oszlopneveket

		
		
		
		
		
		addElemToList();

		setTableTextAlignment();
		JScrollPane scroll = new JScrollPane(jtable);
		scroll.setSize(621, 214);
		scroll.setLocation(26, 34);
		frame.getContentPane().add(scroll);
		frame.getContentPane().add(scroll);
		frame.getContentPane().add(lblOsztalyAtlag);
		//Image frame
//frame.setIconImage(null);
		JButton btnOver4 = new JButton("4 feletti \u00E1tlag\u00FAak");
		btnOver4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listOver4AvgPeople();
			}
		});
		btnOver4.setForeground(new Color(51, 0, 153));
		btnOver4.setBackground(new Color(153, 204, 204));
		btnOver4.setMnemonic('4');
		btnOver4.setBounds(421, 262, 144, 23);
		frame.getContentPane().add(btnOver4);
		
				JButton btnNewButton = new JButton("Legal\u00E1bb 3 az \u00E1tlag");
				btnNewButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						listOver3AvgPeople();
					}

				});
				btnNewButton.setMnemonic('3');
				btnNewButton.setBounds(421, 310, 144, 23);
				frame.getContentPane().add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 2, 685, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Men\u00FC");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("F\u00E1jlba \u00EDr\u00E1s\r\n");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileHandling.writeFile("tanulok.txt", ";", tanuloLista, frame);
			}
		});
	
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u00DAj elem");
		mnNewMenu.add(mntmNewMenuItem_1);
		frame.setSize(701, 400);
		frame.setVisible(true);

	}

	private void setTableTextAlignment() {
		DefaultTableCellRenderer alignRenderer = new DefaultTableCellRenderer();
		alignRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 1; i < 4; i++) {
			jtable.getColumnModel().getColumn(i).setCellRenderer(alignRenderer);
		}

		DefaultTableCellRenderer alignRenderer2 = new DefaultTableCellRenderer();
		alignRenderer2.setHorizontalAlignment(JLabel.RIGHT);
		jtable.getColumnModel().getColumn(4).setCellRenderer(alignRenderer2);

	}

	private double sumClassAverage(double all) {
		return all / tanuloLista.size();

	}

	private void createRows(int i) {
		Object[] o = new Object[5];
		o[0] = tanuloLista.get(i).getNev();
		o[1] = tanuloLista.get(i).getAngol();
		o[2] = tanuloLista.get(i).getTori();
		o[3] = tanuloLista.get(i).getMatek();
		o[4] = String.format("%.2f", tanuloLista.get(i).getAtlag());
		model.addRow(o);
	}
	
	private void listOver4AvgPeople() {
		removeAllRows();
		for (int i = 0; i < tanuloLista.size(); i++) {
			if (tanuloLista.get(i).getAtlag() > 4) {
				createRows(i);
			}

		}

	}

	private void listOver3AvgPeople() {
		removeAllRows();
		for (int i = 0; i < tanuloLista.size(); i++) {
			if (tanuloLista.get(i).getAtlag() > 3) {
				createRows(i);
			}

		}


	}

	private void addElemToList() {
		double atlag = 0;
		for (int i = 0; i < tanuloLista.size(); i++) {
			createRows(i);
			atlag += tanuloLista.get(i).getAtlag();
		}
		lblOsztalyAtlag.setText("Osztályátlag: " + String.format("%.2f", sumClassAverage(atlag)));

	}

	private void removeAllRows() {
		int rowCount = model.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			model.removeRow(i);
		}
	}
	

}
