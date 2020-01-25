package modifyDialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Donut;
import classes.Point;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DlgDonutModify extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtOuter;
	private JTextField txtInner;
	private Color fillColor;
	private Color outlineColor;
	private Donut donutMod;
	private JButton btnOutlineColor;
	private JButton btnFillColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonutModify dialog = new DlgDonutModify();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonutModify() {
		setTitle("Modify donut");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblCenterX = new JLabel("Center - X coordinate:");
		JLabel lblCenterY = new JLabel("Center - Y coordinate:");
		JLabel lblOuterRadius = new JLabel("Outer radius:");
		JLabel lblInnerRadius = new JLabel("Inner radius:");
		txtX = new JTextField();
		txtX.setColumns(10);
		txtY = new JTextField();
		txtY.setColumns(10);
		txtOuter = new JTextField();
		txtOuter.setColumns(10);
		txtInner = new JTextField();
		txtInner.setColumns(10);
		btnOutlineColor = new JButton("Outline color");
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outlineColor = JColorChooser.showDialog(null, "Choose outline color", donutMod.getColor());
				if(outlineColor == null) outlineColor = donutMod.getColor();
				btnOutlineColor.setBackground(outlineColor);
			}
		});
		
		btnFillColor = new JButton("Fill color");
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillColor = JColorChooser.showDialog(null, "Choose fill color", donutMod.getSurfaceColor());
				if(fillColor == null) fillColor = donutMod.getSurfaceColor();
				btnFillColor.setBackground(fillColor);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCenterX)
						.addComponent(lblCenterY)
						.addComponent(lblOuterRadius)
						.addComponent(lblInnerRadius))
					.addGap(39)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnOutlineColor, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtOuter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtInner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
							.addComponent(btnFillColor, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblCenterX)
									.addGap(27)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCenterY)
										.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(26)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblOuterRadius)
										.addComponent(txtOuter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(29)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblInnerRadius)
										.addComponent(txtInner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(32)
							.addComponent(btnOutlineColor, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(btnFillColor, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
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
						 if(Integer.parseInt(txtOuter.getText()) < 1 || (Integer.parseInt(txtInner.getText())) < 1) {
							JOptionPane.showMessageDialog(null, "Neither outer, nor inner radius cannot be less than 1!", "Error", JOptionPane.ERROR_MESSAGE, null);
							return;
						 }
						 try {
								validate(txtX.getText(),txtY.getText(),txtOuter.getText(),txtInner.getText());
							} catch(NumberFormatException exce) {
								JOptionPane.showMessageDialog(null, "Invalid data type inserted!", "Error", JOptionPane.ERROR_MESSAGE, null);
								return;
							}
						 if(txtX.getText().trim().equals("") || txtY.getText().trim().equals("") || txtOuter.getText().trim().equals("") || txtInner.getText().trim().equals("")) {
							JOptionPane.showMessageDialog(null, "All fields must be filled in!", "Error", JOptionPane.ERROR_MESSAGE, null);
							return;
						 } else if(Integer.parseInt(txtOuter.getText()) < (Integer.parseInt(txtInner.getText()))) {
							JOptionPane.showMessageDialog(null, "Inner radius cannot be greater than the outer radius!", "Error", JOptionPane.ERROR_MESSAGE, null);
							return;
						 } else {
							int x = Integer.parseInt(txtX.getText());
							int y = Integer.parseInt(txtY.getText());
							int innerRadius = Integer.parseInt(txtInner.getText());
							int outerRadius = Integer.parseInt(txtOuter.getText());
							
							donutMod.setCenter(new Point(x,y));
							donutMod.setRadius(outerRadius);
							donutMod.setInnerRadius(innerRadius);
							donutMod.setColor(outlineColor);
							donutMod.setSurfaceColor(fillColor);
							dispose();
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
	public void fillTheFields(Donut donutToModify) {
		this.donutMod = donutToModify;
		txtX.setText(String.valueOf(donutMod.getCenter().getX()));
		txtY.setText(String.valueOf(donutMod.getCenter().getY()));
		txtOuter.setText(String.valueOf(donutMod.getRadius()));
		txtInner.setText(String.valueOf(donutMod.getInnerRadius()));
		btnOutlineColor.setBackground(donutMod.getColor());
		btnFillColor.setBackground(donutMod.getSurfaceColor());
		outlineColor = donutMod.getColor();
		fillColor = donutMod.getSurfaceColor();
	}
	public void validate(String x, String y, String radius, String innerRadius) {
		String exp1 = "^(([1-9]{1})([0-9]+)?)$";
		String exp2 = "^(([+-])?([1-9]{1})([0-9]+)?)$";
        if(!x.matches(exp2) || !y.matches(exp2) || !radius.matches(exp1) || !innerRadius.matches(exp1)){
        	throw new NumberFormatException();
        }
	}

}
