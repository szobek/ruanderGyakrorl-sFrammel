package ruanderGyakorlasFrammel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.event.ActionListener;

public class UjTanulo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNev;
	private JComboBox cmbMatek;
	private JComboBox cmbAngol;
	private JComboBox cmbTori;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,List<Tanulo> lista) {
		try {
			UjTanulo dialog = new UjTanulo(lista);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UjTanulo(List<Tanulo> lista) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lista.add(new Tanulo(textFieldNev.getText(),Integer.parseInt(cmbMatek.getSelectedItem().toString()  ) ,3,3));
				}
			});
			okButton.setBounds(57, 181, 76, 23);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("M\u00E9gse");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Tanulo.dialogOpened=false;
					dispose();
				}
			});
			
			cancelButton.setBounds(292, 192, 132, 23);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		
		textFieldNev = new JTextField();
		textFieldNev.setBounds(180, 21, 86, 20);
		contentPanel.add(textFieldNev);
		textFieldNev.setColumns(10);
		
		
		
		
		cmbMatek = new JComboBox();
		cmbMatek.setModel(new DefaultComboBoxModel(Jegyek.values()));
		cmbMatek.setBounds(190, 52, 47, 22);
		contentPanel.add(cmbMatek);
		
		cmbAngol = new JComboBox();
		cmbAngol.setModel(new DefaultComboBoxModel(Jegyek.values()));
		cmbAngol.setBounds(190, 87, 47, 22);
		contentPanel.add(cmbAngol);
		
		cmbTori = new JComboBox();
		cmbTori.setModel(new DefaultComboBoxModel(Jegyek.values()));
		cmbTori.setBounds(190, 121, 47, 22);
		contentPanel.add(cmbTori);
		
		JLabel lblNewLabel = new JLabel("Tanul\u00F3 neve");
		lblNewLabel.setBounds(113, 24, 67, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblMatek = new JLabel("Matek");
		lblMatek.setBounds(113, 56, 67, 14);
		contentPanel.add(lblMatek);
		
		JLabel lblAngol = new JLabel("Angol");
		lblAngol.setBounds(113, 91, 67, 14);
		contentPanel.add(lblAngol);
		
		JLabel lblTri = new JLabel("T\u00F6ri");
		lblTri.setBounds(113, 125, 67, 14);
		contentPanel.add(lblTri);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
