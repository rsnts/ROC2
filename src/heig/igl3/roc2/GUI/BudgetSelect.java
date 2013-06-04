package heig.igl3.roc2.GUI;

import heig.igl3.roc2.Business.BudgetListItem;
import heig.igl3.roc2.Business.Utilisateur;
import heig.igl3.roc2.Data.Roc2DB;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

public class BudgetSelect extends JDialog implements ActionListener{
	
	private JButton btSubmit, btCancel;
    private JPanel panel;
    private JLabel lblBudgets;
    private Utilisateur user;
    private ArrayList<BudgetListItem> budgetList = new ArrayList<BudgetListItem>();
    private DefaultListModel<BudgetListItem> listModel;
    private JList<BudgetListItem> guiBudgetList;
    public BudgetListItem budgetListItem;
    
    public BudgetSelect(JFrame frame, boolean modal, Utilisateur user) {
    	super(frame, modal);
    	this.user = user;

    	budgetList = Roc2DB.getBudgetList(user.id);
    	
    	listModel = new DefaultListModel<BudgetListItem>();
    	for(BudgetListItem item : budgetList) {
    		listModel.addElement(item);
    	}
    	
    	guiBudgetList = new JList<BudgetListItem>(listModel);
    	guiBudgetList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	JScrollPane listScroller = new JScrollPane(guiBudgetList);
    	
    	lblBudgets = new JLabel();
    	lblBudgets.setText("Choisir un budget: ");

    	btSubmit=new JButton("Ouvrir");
    	btCancel=new JButton ("Quitter");
    	
    	KeyAdapter actionClavier = new KeyAdapter(){
    		@Override
            public void keyPressed(KeyEvent e){
    			int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER)
                    btSubmit.doClick();
                else if (key == KeyEvent.VK_ESCAPE)
                    btCancel.doClick();
    		}
    	};
    	
    	
    	
    	//userPassword.addKeyListener(actionClavier);
    	listScroller.addKeyListener(actionClavier);
    	
    	panel=new JPanel(new GridLayout(1,1));
    	
    	add(lblBudgets, BorderLayout.NORTH);
        add(listScroller, BorderLayout.CENTER);
        panel.add(btCancel);
        panel.add(btSubmit);
        add(panel, BorderLayout.SOUTH);
    	
        //add(panel,BorderLayout.CENTER);
        btSubmit.addActionListener(this);
        btCancel.addActionListener(this);
        setTitle("ROC2");
        
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btCancel)
			System.exit(0);
		this.budgetListItem = listModel.get(guiBudgetList.getSelectedIndex());
        setVisible(false);
	}

}