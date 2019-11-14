package siapro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import siapro.controller.CriterioController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class TelaAddCriterio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomeCriterio;
	private JTextField textFieldDescricao;
	private JTextField textFieldNotaMinima;
	private JTextField textFieldNotaMaxima;
	
	public void salvar() {
		new CriterioController().Salvar(textFieldNomeCriterio.getText(), textFieldDescricao.getText(), textFieldNotaMinima.getText(), textFieldNotaMaxima.getText());
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAddCriterio frame = new TelaAddCriterio();
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
	public TelaAddCriterio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCategoria = new JLabel("ADICIONAR CRITERIOS");
		lblCategoria.setBounds(12, 12, 229, 23);
		contentPane.add(lblCategoria);
		
		JLabel lblCategoria_1 = new JLabel("Categoria");
		lblCategoria_1.setBounds(37, 36, 72, 23);
		contentPane.add(lblCategoria_1);
		
		JLabel lblNewLabel = new JLabel("Criterios de Avalia\u00E7\u00E3o");
		lblNewLabel.setBounds(37, 90, 273, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCriterio = new JLabel("Criterio");
		lblCriterio.setBounds(57, 115, 126, 14);
		contentPane.add(lblCriterio);
		
		JComboBox comboBoxCategorias = new JComboBox();
		comboBoxCategorias.setBounds(36, 57, 147, 22);
		contentPane.add(comboBoxCategorias);
		
		textFieldNomeCriterio = new JTextField();
		textFieldNomeCriterio.setBounds(57, 136, 164, 20);
		contentPane.add(textFieldNomeCriterio);
		textFieldNomeCriterio.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(57, 167, 147, 14);
		contentPane.add(lblDescrio);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(57, 192, 164, 71);
		contentPane.add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		btnSalvar.setBounds(57, 280, 89, 23);
		contentPane.add(btnSalvar);
		
		textFieldNotaMinima = new JTextField();
		textFieldNotaMinima.setBounds(255, 233, 77, 30);
		contentPane.add(textFieldNotaMinima);
		textFieldNotaMinima.setColumns(10);
		
		textFieldNotaMaxima = new JTextField();
		textFieldNotaMaxima.setColumns(10);
		textFieldNotaMaxima.setBounds(393, 233, 77, 30);
		contentPane.add(textFieldNotaMaxima);
		
		JLabel lblNotaMinima = new JLabel("Nota Minima");
		lblNotaMinima.setBounds(257, 205, 133, 15);
		contentPane.add(lblNotaMinima);
		
		JLabel lblNotaMaxima = new JLabel("Nota Maxima");
		lblNotaMaxima.setBounds(383, 205, 133, 15);
		contentPane.add(lblNotaMaxima);
	}
}
