package ruanderGyakorlasFrammel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TanuloAdatok extends JDialog {

	private final JPanel contentPanel = new JPanel();
Tanulo tanulo;
private JLabel lblNevErtek;
private JLabel lblKorErtek;
private JLabel lblIskolaErtek;
private JLabel lblMatekErtek;
private JLabel lblAngolErtek;
private JLabel lblToriErtek;
private JLabel lblAtlagErtek;
	

	/**
	 * Create the dialog.
	 */
	public TanuloAdatok(Tanulo tanulo) {
		this.tanulo=tanulo;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblIskola = new JLabel("Iskola");
		lblIskola.setBounds(28, 84, 46, 14);
		contentPanel.add(lblIskola);
		
		JLabel lblKor = new JLabel("Kor");
		lblKor.setBounds(28, 52, 46, 14);
		contentPanel.add(lblKor);
		
		JLabel lblNev = new JLabel("N\u00E9v");
		lblNev.setBounds(28, 11, 46, 14);
		contentPanel.add(lblNev);
		
		JLabel lblMatek = new JLabel("Matek");
		lblMatek.setBounds(28, 109, 46, 14);
		contentPanel.add(lblMatek);
		
		JLabel lblAngol = new JLabel("Angol");
		lblAngol.setBounds(28, 134, 46, 14);
		contentPanel.add(lblAngol);
		
		JLabel lblTori = new JLabel("T\u00F6ri");
		lblTori.setBounds(28, 160, 46, 14);
		contentPanel.add(lblTori);
		
		JLabel lblAtlag = new JLabel("\u00C1tlag");
		lblAtlag.setBounds(28, 185, 46, 14);
		contentPanel.add(lblAtlag);
		
		lblNevErtek = new JLabel("");
		lblNevErtek.setHorizontalAlignment(SwingConstants.CENTER);
		lblNevErtek.setBounds(84, 11, 239, 14);
		contentPanel.add(lblNevErtek);
		
		lblKorErtek = new JLabel("");
		lblKorErtek.setHorizontalAlignment(SwingConstants.CENTER);
		lblKorErtek.setBounds(84, 52, 233, 14);
		contentPanel.add(lblKorErtek);
		
		lblIskolaErtek = new JLabel("");
		lblIskolaErtek.setHorizontalAlignment(SwingConstants.CENTER);
		lblIskolaErtek.setBounds(84, 84, 233, 14);
		contentPanel.add(lblIskolaErtek);
		
		lblMatekErtek = new JLabel("");
		lblMatekErtek.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatekErtek.setBounds(84, 109, 233, 14);
		contentPanel.add(lblMatekErtek);
		
		lblAngolErtek = new JLabel("");
		lblAngolErtek.setHorizontalAlignment(SwingConstants.CENTER);
		lblAngolErtek.setBounds(84, 134, 233, 14);
		contentPanel.add(lblAngolErtek);
		
		lblToriErtek = new JLabel("");
		lblToriErtek.setHorizontalAlignment(SwingConstants.CENTER);
		lblToriErtek.setBounds(84, 160, 233, 14);
		contentPanel.add(lblToriErtek);
		
		lblAtlagErtek = new JLabel("");
		lblAtlagErtek.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtlagErtek.setBounds(84, 185, 233, 14);
		contentPanel.add(lblAtlagErtek);
		setAllData();
	}
	private void setAllData() {
		lblNevErtek.setText(tanulo.getNev());
		
		
	}
}
