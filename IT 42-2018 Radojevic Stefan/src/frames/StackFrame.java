package frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dialogs.DlgAddToStack;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class StackFrame extends JFrame {

	public static JPanel contentPaneStack;
	public static DefaultListModel<String> dlmStack = new DefaultListModel<String>();
	public static boolean adding = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrame frame = new StackFrame();
					frame.setLocationRelativeTo(null);
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
	public StackFrame() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		setResizable(false);
		setTitle("Radojevic Stefan, IT42-2018");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPaneStack = new JPanel();
		contentPaneStack.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPaneStack);
		JList rectangleStack = new JList();
		
		JButton btnAddToStack = new JButton("Add to stack");
		btnAddToStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAddToStack add = new DlgAddToStack();
				add.setLocationRelativeTo(null);
				adding = true;
				add.setVisible(true);
				if(add.isOK) {
					dlmStack.add(0, DlgAddToStack.rec.toStringStack());
				}
			}
		});
		
		JButton btnRemoveFromStack = new JButton("Remove from stack");
		btnRemoveFromStack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlmStack.size() == 0) {
					JOptionPane.showMessageDialog(null, "There is no data present in the list!", "Error", JOptionPane.ERROR_MESSAGE, null);
				} else {
					adding = false;
					String[] split = dlmStack.getElementAt(0).toString().split("[:|,|(|)]");
					DlgAddToStack rmv = new DlgAddToStack();
					rmv.setTitle("Remove from stack");
					rmv.setLocationRelativeTo(null);
					rmv.getTxtHeightField().setEditable(false);
					rmv.getTxtXField().setEditable(false);
					rmv.getTxtYField().setEditable(false);
					rmv.getTxtWidthField().setEditable(false);
					rmv.getTxtXField().setText(split[3]);
					rmv.getTxtYField().setText(split[4]);
					rmv.getTxtWidthField().setText(split[7]);
					rmv.getTxtHeightField().setText(split[9]);
					rmv.setVisible(true);
					if(rmv.remove) {
						dlmStack.remove(0);
					}
					adding = true;
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPaneStack = new GroupLayout(contentPaneStack);
		gl_contentPaneStack.setHorizontalGroup(
			gl_contentPaneStack.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneStack.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneStack.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPaneStack.createSequentialGroup()
							.addComponent(btnAddToStack, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
							.addComponent(btnRemoveFromStack, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPaneStack.setVerticalGroup(
			gl_contentPaneStack.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPaneStack.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPaneStack.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRemoveFromStack, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddToStack, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		
		scrollPane.setViewportView(rectangleStack);
		contentPaneStack.setLayout(gl_contentPaneStack);
		rectangleStack.setModel(dlmStack);
		
	}
}
