package modifyDialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Line;
import classes.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgLineModify extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Line lineMod;
	private Color lineColor;
	private JTextField txtStartX;
	private JTextField txtStartY;
	private JTextField txtEndX;
	private JTextField txtEndY;
	public JButton btnColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLineModify dialog = new DlgLineModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLineModify() {
		setModal(true);
		setBounds(100, 100, 450, 327);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		JLabel lblStartPoint = new JLabel("Start point - X coordinate:");
		JLabel lblStartPoint_1 = new JLabel("Start point - Y coordinate:");
		JLabel lblEndPoint = new JLabel("End point - X coordinate:");
		JLabel lblEndPoint_1 = new JLabel("End point - Y coordinate:");
		txtStartX = new JTextField();
		txtStartX.setColumns(10);
		txtStartY = new JTextField();
		txtStartY.setColumns(10);
		txtEndX = new JTextField();
		txtEndX.setColumns(10);
		txtEndY = new JTextField();
		txtEndY.setColumns(10);
		btnColor = new JButton("Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineColor = JColorChooser.showDialog(null, "Choose color for the line", lineMod.getColor());
				if(lineColor == null) { lineColor = lineMod.getColor(); }
				btnColor.setBackground(lineColor);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStartPoint)
						.addComponent(lblStartPoint_1)
						.addComponent(lblEndPoint)
						.addComponent(lblEndPoint_1))
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addComponent(txtEndY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(txtEndX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtStartY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
								.addComponent(btnColor)))
						.addComponent(txtStartX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartPoint)
						.addComponent(txtStartX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartPoint_1)
						.addComponent(txtStartY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndPoint)
						.addComponent(txtEndX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndPoint_1)
						.addComponent(txtEndY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(57)
					.addComponent(btnColor, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(58))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save changes");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtStartX.getText().trim().equals("") || txtStartY.getText().trim().equals("") || txtEndX.getText().trim().equals("") || txtEndY.getText().trim().equals("")) 							
							JOptionPane.showMessageDialog(null, "All fields must be filled in!", "Error", JOptionPane.ERROR_MESSAGE, null);
						try {
							int startX = Integer.parseInt(txtStartX.getText());
							int startY = Integer.parseInt(txtStartY.getText());
							int endX = Integer.parseInt(txtEndX.getText());
							int endY = Integer.parseInt(txtEndY.getText());
							lineMod.setStartPoint(new Point(startX,startY));
							lineMod.setEndPoint(new Point(endX,endY));
							lineMod.setColor(lineColor);
							dispose();
						} catch(NumberFormatException ec) {
							JOptionPane.showMessageDialog(null, "Incorrect data type inserted!", "Error", JOptionPane.ERROR_MESSAGE, null);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void fillTheFields(Line shapeToModify) {
		this.lineMod = shapeToModify;
		txtStartX.setText(String.valueOf(lineMod.getStartPoint().getX()));
		txtStartY.setText(String.valueOf(lineMod.getStartPoint().getY()));
		txtEndX.setText(String.valueOf(lineMod.getEndPoint().getX()));
		txtEndY.setText(String.valueOf(lineMod.getEndPoint().getY()));
		lineColor = lineMod.getColor();
		btnColor.setBackground(lineMod.getColor());
	}

}
