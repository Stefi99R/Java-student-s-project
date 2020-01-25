package dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class DlgDrawRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtwidth;
	private JTextField txtHeight;
	private boolean isOK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDrawRectangle dialog = new DlgDrawRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDrawRectangle() {
		setTitle("Draw rectangle");
		setBounds(100, 100, 318, 238);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setModal(true);
		setLocationRelativeTo(null);
		JLabel lblWidth = new JLabel("Width:");
		
		JLabel lblHeight = new JLabel("Height:");
		
		setTxtwidth(new JTextField());
		getTxtwidth().setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWidth)
						.addComponent(lblHeight))
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(getTxtwidth(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(getTxtwidth(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Draw a rectangle");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean number = true;
						try {
							validate(getTxtwidth().getText(),txtHeight.getText());
						} catch(NumberFormatException n) {
							number = false;
						}
					if(getTxtwidth().getText().trim().isEmpty() || txtHeight.getText().trim().isEmpty()) {
						isOK = false;
						getToolkit().beep();
						JOptionPane.showMessageDialog(null, "Some fields are empty!", "Error", JOptionPane.ERROR_MESSAGE, null);
					} else if(number == false) {
						JOptionPane.showMessageDialog(null, "Invalid data type inserted!", "Error", JOptionPane.ERROR_MESSAGE, null);
						getToolkit().beep();
						isOK = false;
					} else if(Float.parseFloat(getTxtwidth().getText()) < 0 ||
					Float.parseFloat(txtHeight.getText()) < 0 ) {
						JOptionPane.showMessageDialog(null, "Width and height cannot be negative", "Error", JOptionPane.ERROR_MESSAGE, null);
						getToolkit().beep();
						isOK = false;
					} else {
						isOK = true;
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
	public void validate(String width, String height) {
		String exp = "^(([1-9])([0-9]+)?((\\.)?)([0-9]+)?)$";
        if(!width.matches(exp) || !height.matches(exp)){  
        	throw new NumberFormatException();
        }
	}
	

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	public boolean isOK() {
		return isOK;
	}

	public void setOK(boolean isOK) {
		this.isOK = isOK;
	}

	public JTextField getTxtwidth() {
		return txtwidth;
	}

	public void setTxtwidth(JTextField txtwidth) {
		this.txtwidth = txtwidth;
	}
	
}
