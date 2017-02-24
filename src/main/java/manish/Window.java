package manish;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static JTextArea txtrDetails; 
	static Window frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception{
		try {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						frame = new Window();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}catch(Exception e) {e.printStackTrace();}
	}

	/**
	 * Create the frame.
	 */
	public Window() {
		setBackground(new Color(255,236,179));
		setForeground(new Color(55,71,79));
		setFont(new Font("Big Caslon", Font.BOLD, 15));
		setTitle("Jindal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 379);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255,236,179));
		contentPane.setForeground(new Color(55,71,79));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExcelFile = new JLabel("Excel File");
		lblExcelFile.setForeground(new Color(55,71,79));
		lblExcelFile.setBounds(34, 16, 59, 16);
		contentPane.add(lblExcelFile);
		
		textField = new JTextField();
		textField.setBounds(98, 11, 310, 26);
		contentPane.add(textField);
		textField.setColumns(25);
		
		final JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBackground(new Color(66,165,245));
		btnBrowse.setForeground(new Color(250,250,250));
		btnBrowse.setBounds(413, 10, 88, 29);
		btnBrowse.setOpaque(true);
		btnBrowse.setBorderPainted(false);
		
		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Chose Excel File");
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileChooser.showDialog(getParent(), "Choose");
				textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBrowse.setBackground(new Color(25,118,210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBrowse.setBackground(new Color(66,165,245));
			}
		});
		
		contentPane.add(btnBrowse);
		
		JLabel lblPathToImages = new JLabel("Images Folder");
		lblPathToImages.setForeground(new Color(55,71,79));
		lblPathToImages.setBounds(6, 50, 88, 16);
		contentPane.add(lblPathToImages);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 45, 310, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(23);
		
		final JButton btnBrowse_1 = new JButton("Browse");
		btnBrowse_1.setBackground(new Color(66,165,245));
		btnBrowse_1.setForeground(new Color(250,250,250));
		btnBrowse_1.setBounds(413, 45, 88, 29);
		btnBrowse_1.setOpaque(true);
		btnBrowse_1.setBorderPainted(false);
		
		btnBrowse_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Chose the Folder Containing the Images");
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.showDialog(getParent(), "Choose");
				textField_1.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBrowse_1.setBackground(new Color(25,118,210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBrowse_1.setBackground(new Color(66,165,245));
			}
		});
		contentPane.add(btnBrowse_1);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setForeground(new Color(55,71,79));
		lblDestination.setBounds(20, 86, 73, 16);
		contentPane.add(lblDestination);
		
		textField_2 = new JTextField();
		textField_2.setBounds(98, 81, 310, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(25);
		
		final JButton btnBrowse_2 = new JButton("Browse");
		btnBrowse_2.setBackground(new Color(66,165,245));
		btnBrowse_2.setForeground(new Color(250,250,250));
		btnBrowse_2.setBounds(413, 81, 88, 29);
		btnBrowse_2.setOpaque(true);
		btnBrowse_2.setBorderPainted(false);
		
		btnBrowse_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Chose the Destination Folder");
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				fileChooser.showDialog(getParent(), "Choose");
				textField_2.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBrowse_2.setBackground(new Color(25,118,210));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBrowse_2.setBackground(new Color(66,165,245));
			}
		});
		contentPane.add(btnBrowse_2);
		
		final JButton btnGo = new JButton("Go");
		btnGo.setBackground(new Color(77,182,172));
		btnGo.setForeground(new Color(250,250,250));
		btnGo.setOpaque(true);
		btnGo.setBorderPainted(false);
		
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					App myObj = new App(textField.getText(), textField_1.getText(), textField_2.getText(), frame);
					myObj.compute();
				}catch(Exception ex) {ex.printStackTrace();}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnGo.setBackground(new Color(0,121,107));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnGo.setBackground(new Color(77,182,172));
			}
		});
		btnGo.setBounds(198, 119, 117, 29);
		contentPane.add(btnGo);
		
		txtrDetails = new JTextArea();
		txtrDetails.setEditable(false);
		txtrDetails.setToolTipText("Displays the log of files copied");
		txtrDetails.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrDetails.setBackground(new Color(0, 0, 128));
		txtrDetails.setForeground(new Color(220, 20, 60));
		txtrDetails.setText("Log:");
		txtrDetails.setBounds(29, 147, 143, 191);
		contentPane.add(txtrDetails);
		
		JScrollPane scrollPane = new JScrollPane(txtrDetails, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setLocation(6, 160);
		scrollPane.setSize(505, 190);
		contentPane.add(scrollPane);
		contentPane.setVisible(true);
	}
	public void log(String msg) {txtrDetails.append(msg + "\n");}
}
