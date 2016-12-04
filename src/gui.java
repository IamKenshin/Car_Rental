import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class gui {

	private JFrame frame;
	private JTextField customer_fName_text;
	private JTextField customer_lName_text;
	private JTextField customer_age_text;
	private JTextField customer_licNum_text;
	private JTextField customer_ccNum_text;
	private JTextField customer_status_text;
	private JTextField customer_id_text;
	private JLabel customer_age_label;
	private JLabel customer_licNum_label;
	private JLabel customer_ccNum_label;
	private JLabel customer_id_label;
	private JButton customer_modify_button;
	private JTextField car_year_text;
	private JTextField car_make_text;
	private JTextField car_model_text;
	private JTextField car_mileage_text;
	private JTextField car_condition_text;
	private JTextField car_status_text;
	private JTextField car_id_text;
	
			

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		DataAccess dao = new DataAccess();
		frame = new JFrame();
		frame.setBounds(100, 100, 727, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton customer_add_button = new JButton("Add");
		customer_add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fName = customer_fName_text.getText();
				String lName = customer_lName_text.getText();
				int age = Integer.parseInt(customer_age_text.getText());
				String licenceNumber = customer_licNum_label.getText();
				String ccNumber = customer_ccNum_label.getText();
				String customerStatus = "Reservation"; 				//customer is going to be reservation status in the beginning
				Customer customer = new Customer(fName, lName, age, licenceNumber, ccNumber, customerStatus);
				int customerId = dao.addCustomer(customer);
				customer_id_text.setText(String.valueOf(customerId));
				
				JOptionPane.showMessageDialog(null, fName + lName + age);
//				int customerId, age;
//				String fName, lName, licenceNumber, ccNumber, customerStatus;
				//JOptionPane.showMessageDialog(null, "Customer Successfully added!");
			}
		});
		customer_add_button.setBounds(23, 249, 73, 23);
		frame.getContentPane().add(customer_add_button);
		
		customer_fName_text = new JTextField();
		customer_fName_text.setBounds(106, 32, 86, 20);
		frame.getContentPane().add(customer_fName_text);
		customer_fName_text.setColumns(10);
		
		customer_lName_text = new JTextField();
		customer_lName_text.setBounds(106, 63, 86, 20);
		frame.getContentPane().add(customer_lName_text);
		customer_lName_text.setColumns(10);
		
		customer_age_text = new JTextField();
		customer_age_text.setBounds(106, 94, 86, 20);
		frame.getContentPane().add(customer_age_text);
		customer_age_text.setColumns(10);
		
		customer_licNum_text = new JTextField();
		customer_licNum_text.setBounds(106, 125, 86, 20);
		frame.getContentPane().add(customer_licNum_text);
		customer_licNum_text.setColumns(10);
		
		customer_ccNum_text = new JTextField();
		customer_ccNum_text.setBounds(106, 156, 86, 20);
		frame.getContentPane().add(customer_ccNum_text);
		customer_ccNum_text.setColumns(10);
		
		customer_status_text = new JTextField();
		customer_status_text.setText("Reservation");
		customer_status_text.setBounds(106, 186, 86, 20);
		frame.getContentPane().add(customer_status_text);
		customer_status_text.setColumns(10);
		customer_status_text.setEditable(false);
		
		customer_id_text = new JTextField();
		customer_id_text.setBounds(106, 217, 86, 20);
		frame.getContentPane().add(customer_id_text);
		customer_id_text.setColumns(10);
		
		JLabel customer_status_label = new JLabel("Status");
		customer_status_label.setBounds(23, 189, 46, 14);
		frame.getContentPane().add(customer_status_label);
		
		JLabel customer_fName_label = new JLabel("First Name");
		customer_fName_label.setBounds(23, 35, 73, 14);
		frame.getContentPane().add(customer_fName_label);
		
		JLabel customer_lName_label = new JLabel("Last Name");
		customer_lName_label.setBounds(23, 66, 73, 14);
		frame.getContentPane().add(customer_lName_label);
		
		customer_age_label = new JLabel("Age");
		customer_age_label.setBounds(23, 97, 46, 14);
		frame.getContentPane().add(customer_age_label);
		
		customer_licNum_label = new JLabel("Licence");
		customer_licNum_label.setBounds(23, 128, 65, 14);
		frame.getContentPane().add(customer_licNum_label);
		
		customer_ccNum_label = new JLabel("CC Number");
		customer_ccNum_label.setBounds(23, 159, 73, 14);
		frame.getContentPane().add(customer_ccNum_label);
		
		customer_id_label = new JLabel("ID");
		customer_id_label.setBounds(23, 220, 46, 14);
		frame.getContentPane().add(customer_id_label);
		
		customer_modify_button = new JButton("Modify");
		customer_modify_button.setBounds(103, 249, 89, 23);
		frame.getContentPane().add(customer_modify_button);
		
		JLabel customer_label = new JLabel("Customer");
		customer_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		customer_label.setBounds(63, 7, 113, 14);
		frame.getContentPane().add(customer_label);
		
		JLabel lblCar = new JLabel("Car");
		lblCar.setBounds(327, 8, 46, 14);
		frame.getContentPane().add(lblCar);
		
		JLabel car_year_label = new JLabel("Year");
		car_year_label.setBounds(223, 35, 46, 14);
		frame.getContentPane().add(car_year_label);
		
		JLabel car_make_label = new JLabel("Make");
		car_make_label.setBounds(223, 66, 46, 14);
		frame.getContentPane().add(car_make_label);
		
		JLabel car_model_label = new JLabel("Model");
		car_model_label.setBounds(223, 97, 46, 14);
		frame.getContentPane().add(car_model_label);
		
		JLabel car_mileage_label = new JLabel("Mileage");
		car_mileage_label.setBounds(223, 128, 46, 14);
		frame.getContentPane().add(car_mileage_label);
		
		JLabel car_condition_label = new JLabel("Condition");
		car_condition_label.setBounds(223, 162, 46, 14);
		frame.getContentPane().add(car_condition_label);
		
		JLabel car_status_label = new JLabel("Status");
		car_status_label.setBounds(223, 189, 46, 14);
		frame.getContentPane().add(car_status_label);
		
		JLabel car_id_label = new JLabel("ID");
		car_id_label.setBounds(223, 223, 46, 14);
		frame.getContentPane().add(car_id_label);
		
		car_year_text = new JTextField();
		car_year_text.setBounds(287, 32, 86, 20);
		frame.getContentPane().add(car_year_text);
		car_year_text.setColumns(10);
		
		car_make_text = new JTextField();
		car_make_text.setBounds(287, 63, 86, 20);
		frame.getContentPane().add(car_make_text);
		car_make_text.setColumns(10);
		
		car_model_text = new JTextField();
		car_model_text.setBounds(287, 94, 86, 20);
		frame.getContentPane().add(car_model_text);
		car_model_text.setColumns(10);
		
		car_mileage_text = new JTextField();
		car_mileage_text.setBounds(287, 125, 86, 20);
		frame.getContentPane().add(car_mileage_text);
		car_mileage_text.setColumns(10);
		
		car_condition_text = new JTextField();
		car_condition_text.setBounds(287, 156, 86, 20);
		frame.getContentPane().add(car_condition_text);
		car_condition_text.setColumns(10);
		
		car_status_text = new JTextField();
		car_status_text.setText("On Hand");
		car_status_text.setBounds(287, 186, 86, 20);
		frame.getContentPane().add(car_status_text);
		car_status_text.setColumns(10);
		car_status_text.setEditable(false);
		
		car_id_text = new JTextField();
		car_id_text.setBounds(287, 217, 86, 20);
		frame.getContentPane().add(car_id_text);
		car_id_text.setColumns(10);
		
		JButton car_add_button = new JButton("Add");
		car_add_button.setBounds(223, 249, 57, 23);
		frame.getContentPane().add(car_add_button);
		
		JButton car_modify_button = new JButton("Modify");
		car_modify_button.setBounds(297, 249, 76, 23);
		frame.getContentPane().add(car_modify_button);
		
	}
}
