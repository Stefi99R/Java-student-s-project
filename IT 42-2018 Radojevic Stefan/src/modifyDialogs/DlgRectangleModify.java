package modifyDialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Point;
import classes.Rectangle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DlgRectangleModify extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Rectangle recMod;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private Color outlineColor;
	private Color fillColor;
	private JButton btnColor;
	private JButton btnFillColor;
	public boolean isOkRectangleModify;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangleModify dialog = new DlgRectangleModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangleModify() {
		setModal(true);
		setBounds(100, 100, 508, 319);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		JLabel lblUpperLeftPoint = new JLabel("Upper left point - X coordinate:");
		JLabel lblUpperLeftPoint_1 = new JLabel("Upper left point - Y coordinate:");
		JLabel lblWidth = new JLabel("Width:");
		JLabel lblHeight = new JLabel("Height:");
		txtX = new JTextField();
		txtX.setColumns(10);
		txtY = new JTextField();
		txtY.setText("");
		txtY.setColumns(10);
		txtWidth = new JTextField();
		txtWidth.setColumns(10);
		{
			txtHeight = new JTextField();
			txtHeight.setColumns(10);
		}
		
		btnColor = new JButton("Outline color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outlineColor = JColorChooser.showDialog(null, "Choose outline color", recMod.getColor());
				if(outlineColor == null) { outlineColor = recMod.getColor(); }
				btnColor.setBackground(outlineColor);
			}
		});
		
		btnFillColor = new JButton("Fill color");
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillColor = JColorChooser.showDialog(null, "Choose fill color", recMod.getSurfaceColor());
				if(fillColor == null) { fillColor =  recMod.getSurfaceColor(); }
				btnFillColor.setBackground(fillColor);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUpperLeftPoint)
						.addComponent(lblUpperLeftPoint_1)
						.addComponent(lblWidth)
						.addComponent(lblHeight))
					.addGap(27)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnFillColor, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
						.addComponent(btnColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(38)
							.addComponent(btnFillColor, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUpperLeftPoint)
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUpperLeftPoint_1)
								.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWidth)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHeight)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(27))
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
						isOkRectangleModify = true;
						if(txtX.getText().trim().equals("") || txtY.getText().trim().equals("") || txtWidth.getText().trim().equals("") || txtHeight.getText().trim().equals("")) {
							JOptionPane.showMessageDialog(null, "All fields must be filled in!", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOkRectangleModify = false;
							return;
						} else if(Float.parseFloat(txtWidth.getText()) < 0 || Float.parseFloat(txtHeight.getText()) < 0) {
							JOptionPane.showMessageDialog(null, "Width and height must be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOkRectangleModify = false;
							return;
						}
						try {
							float x = Float.parseFloat(txtX.getText());
							float y = Float.parseFloat(txtY.getText());
							float width = Float.parseFloat(txtWidth.getText());
							float height = Float.parseFloat(txtHeight.getText());
							if(isOkRectangleModify) {
								recMod.setX(x);
								recMod.setY(y);
								recMod.setWidth(width);
								recMod.setHeight(height);
								recMod.setColor(outlineColor);
								recMod.setSurfaceColor(fillColor);
								dispose();
							}
							} catch(NumberFormatException ec) {
							JOptionPane.showMessageDialog(null, "Incorrect data type inserted!", "Error", JOptionPane.ERROR_MESSAGE, null);
							isOkRectangleModify = false; }
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
	public void fillTheFields(Rectangle shapeToModify) {
		this.recMod = shapeToModify;
		txtX.setText(String.valueOf(recMod.getX()));
		txtY.setText(String.valueOf(recMod.getY()));
		txtWidth.setText(String.valueOf(recMod.getWidth()));
		txtHeight.setText(String.valueOf(recMod.getHeight()));
		btnColor.setBackground(recMod.getColor());
		btnFillColor.setBackground(recMod.getSurfaceColor());
		fillColor = recMod.getSurfaceColor();
		outlineColor = recMod.getColor();
	}

}
