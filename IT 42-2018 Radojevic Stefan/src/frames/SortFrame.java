package frames;

import java.util.Comparator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import classes.Rectangle;
import dialogs.DlgAddToStack;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.awt.event.ActionEvent;

public class SortFrame extends JFrame {

	private JPanel contentPane;
	public static DefaultListModel<String> dlmSort = new DefaultListModel<String>();
	public ArrayList<Rectangle> sortedList = new ArrayList<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrame frame = new SortFrame();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static Comparator<Rectangle> CompareAreas = new Comparator<Rectangle>() {
		
		@Override
		public int compare(Rectangle o1, Rectangle o2) {
			float rectangleArea1 = o1.getArea();
			float rectangleArea2 = o2.getArea();
			
			return Float.compare(rectangleArea1,rectangleArea2);
		}
	};

	/**
	 * Create the frame.
	 */
	public SortFrame() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setResizable(false);
		setTitle("Radojevic Stefan, IT42-2018");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane spList = new JScrollPane();
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAddToStack add = new DlgAddToStack();
				add.setLocationRelativeTo(null);
				add.setVisible(true);
				if(add.isOK) {
					dlmSort.addElement(DlgAddToStack.rec.toStringSort());
					sortedList.add(DlgAddToStack.rec);
				}
			}
		});
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sortedList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "There is nothing to sort!", "Error", JOptionPane.ERROR_MESSAGE, null);
				}
				else {
					dlmSort.clear();
					Collections.sort(sortedList,CompareAreas);
					for(Rectangle r : sortedList) {
						dlmSort.addElement(r.toStringSort());
					}
				}
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
							.addComponent(btnSort, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
						.addComponent(spList, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSort, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
						.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(spList, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JList list = new JList();
		spList.setViewportView(list);
		list.setModel(dlmSort);
		contentPane.setLayout(gl_contentPane);
	}
}
