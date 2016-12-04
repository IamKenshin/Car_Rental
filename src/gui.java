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
import javax.swing.JComboBox;

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
	//private JButton customer_modify_button;
	private JTextField car_year_text;
	private JTextField car_make_text;
	private JTextField car_model_text;
	private JTextField car_mileage_text;
	private JTextField car_condition_text;
	private JTextField car_status_text;
	private JTextField car_id_text;
	private JTextField car_price_text;
	private JTextField car_type_text;
	private JButton car_view_button;
	
			

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
				String licenceNumber = customer_licNum_text.getText();
				String ccNumber = customer_ccNum_text.getText();
				String customerStatus = "Reservation"; 				//customer is going to be reservation status in the beginning
				Customer customer = new Customer(fName, lName, age, licenceNumber, ccNumber, customerStatus);
				int customerId = dao.addCustomer(customer);
				customer_id_text.setText(String.valueOf(customerId));
				
				JOptionPane.showMessageDialog(null, fName + lName + age);
			}
		});
		
		JButton customer_modify_button = new JButton("Modify");
		customer_modify_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				String fName, lName, licenceNumber, ccNumber, customerStatus=null;
				int age = 0, customerId;
				
				fName = customer_fName_text.getText();
				lName = customer_lName_text.getText();
				age = Integer.parseInt(customer_age_text.getText());
				licenceNumber = customer_licNum_text.getText();
				ccNumber = customer_ccNum_text.getText();
				customerId = Integer.parseInt(customer_id_text.getText());
			
				Customer newCustomer = new Customer(fName, lName, age, licenceNumber, ccNumber, customerStatus);
				dao.updateCustomer(customerId, newCustomer);
				
				JOptionPane.showMessageDialog(null, fName + lName + age);
			}
		});
		customer_add_button.setBounds(10, 249, 74, 23);
		frame.getContentPane().add(customer_add_button);
		
		customer_modify_button.setBounds(174, 249, 62, 23);
		frame.getContentPane().add(customer_modify_button);
		customer_modify_button.setEnabled(false);
		
		customer_fName_text = new JTextField();
		customer_fName_text.setBounds(106, 32, 130, 20);
		frame.getContentPane().add(customer_fName_text);
		customer_fName_text.setColumns(10);
		
		customer_lName_text = new JTextField();
		customer_lName_text.setBounds(106, 63, 130, 20);
		frame.getContentPane().add(customer_lName_text);
		customer_lName_text.setColumns(10);
		
		customer_age_text = new JTextField();
		customer_age_text.setBounds(106, 94, 130, 20);
		frame.getContentPane().add(customer_age_text);
		customer_age_text.setColumns(10);
		
		customer_licNum_text = new JTextField();
		customer_licNum_text.setBounds(106, 125, 130, 20);
		frame.getContentPane().add(customer_licNum_text);
		customer_licNum_text.setColumns(10);
		
		customer_ccNum_text = new JTextField();
		customer_ccNum_text.setBounds(106, 156, 130, 20);
		frame.getContentPane().add(customer_ccNum_text);
		customer_ccNum_text.setColumns(10);
		
		customer_status_text = new JTextField();
		customer_status_text.setText("Reservation");
		customer_status_text.setBounds(106, 186, 130, 20);
		frame.getContentPane().add(customer_status_text);
		customer_status_text.setColumns(10);
		customer_status_text.setEditable(false);
		
		customer_id_text = new JTextField();
		customer_id_text.setBounds(106, 217, 130, 20);
		frame.getContentPane().add(customer_id_text);
		customer_id_text.setColumns(10);
		
		JLabel customer_status_label = new JLabel("Status");
		customer_status_label.setBounds(23, 189, 213, 14);
		frame.getContentPane().add(customer_status_label);
		
		JLabel customer_fName_label = new JLabel("First Name");
		customer_fName_label.setBounds(23, 35, 213, 14);
		frame.getContentPane().add(customer_fName_label);
		
		JLabel customer_lName_label = new JLabel("Last Name");
		customer_lName_label.setBounds(23, 66, 213, 14);
		frame.getContentPane().add(customer_lName_label);
		
		customer_age_label = new JLabel("Age");
		customer_age_label.setBounds(23, 97, 213, 14);
		frame.getContentPane().add(customer_age_label);
		
		customer_licNum_label = new JLabel("Licence");
		customer_licNum_label.setBounds(23, 128, 213, 14);
		frame.getContentPane().add(customer_licNum_label);
		
		customer_ccNum_label = new JLabel("CC Number");
		customer_ccNum_label.setBounds(23, 159, 213, 14);
		frame.getContentPane().add(customer_ccNum_label);
		
		customer_id_label = new JLabel("ID");
		customer_id_label.setBounds(23, 220, 213, 14);
		frame.getContentPane().add(customer_id_label);		
		
		JLabel customer_label = new JLabel("Customer");
		customer_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		customer_label.setBounds(63, 7, 173, 14);
		frame.getContentPane().add(customer_label);
		
		JLabel lblCar = new JLabel("Car");
		lblCar.setBounds(379, 8, 74, 14);
		frame.getContentPane().add(lblCar);
		
		JLabel car_year_label = new JLabel("Year");
		car_year_label.setBounds(275, 35, 186, 14);
		frame.getContentPane().add(car_year_label);
		
		JLabel car_make_label = new JLabel("Make");
		car_make_label.setBounds(275, 66, 186, 14);
		frame.getContentPane().add(car_make_label);
		
		JLabel car_model_label = new JLabel("Model");
		car_model_label.setBounds(275, 97, 186, 14);
		frame.getContentPane().add(car_model_label);
		
		JLabel car_mileage_label = new JLabel("Mileage");
		car_mileage_label.setBounds(275, 128, 186, 14);
		frame.getContentPane().add(car_mileage_label);
		
		JLabel car_condition_label = new JLabel("Condition");
		car_condition_label.setBounds(275, 162, 186, 14);
		frame.getContentPane().add(car_condition_label);
		
		JLabel car_status_label = new JLabel("Status");
		car_status_label.setBounds(275, 189, 186, 14);
		frame.getContentPane().add(car_status_label);
		
		JLabel car_id_label = new JLabel("ID");
		car_id_label.setBounds(275, 223, 186, 14);
		frame.getContentPane().add(car_id_label);
		
		JLabel car_price_label = new JLabel("Price");
		car_price_label.setBounds(275, 253, 186, 14);
		frame.getContentPane().add(car_price_label);
		
		JLabel car_type_label = new JLabel("Type");
		car_type_label.setBounds(275, 284, 186, 14);
		frame.getContentPane().add(car_type_label);
		
		car_year_text = new JTextField();
		car_year_text.setBounds(339, 32, 122, 20);
		frame.getContentPane().add(car_year_text);
		car_year_text.setColumns(10);
		
		car_make_text = new JTextField();
		car_make_text.setBounds(339, 63, 122, 20);
		frame.getContentPane().add(car_make_text);
		car_make_text.setColumns(10);
		
		car_model_text = new JTextField();
		car_model_text.setBounds(339, 94, 122, 20);
		frame.getContentPane().add(car_model_text);
		car_model_text.setColumns(10);
		
		car_mileage_text = new JTextField();
		car_mileage_text.setBounds(339, 125, 122, 20);
		frame.getContentPane().add(car_mileage_text);
		car_mileage_text.setColumns(10);
		
		car_condition_text = new JTextField();
		car_condition_text.setBounds(339, 156, 122, 20);
		frame.getContentPane().add(car_condition_text);
		car_condition_text.setColumns(10);
		
		car_status_text = new JTextField();
		car_status_text.setText("On Hand");
		car_status_text.setBounds(339, 186, 122, 20);
		frame.getContentPane().add(car_status_text);
		car_status_text.setColumns(10);
		car_status_text.setEditable(false);
		
		car_id_text = new JTextField();
		car_id_text.setBounds(339, 217, 122, 20);
		frame.getContentPane().add(car_id_text);
		car_id_text.setColumns(10);
		
		car_price_text = new JTextField();
		car_price_text.setBounds(339, 250, 122, 20);
		frame.getContentPane().add(car_price_text);
		car_year_text.setColumns(10);
		
		car_type_text = new JTextField();
		car_type_text.setBounds(339, 281, 122, 20);
		frame.getContentPane().add(car_type_text);
		car_type_text.setColumns(10);
		
		JButton car_add_button = new JButton("Add");
		car_add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Car c = new Car(0, car_make_text.getText(), car_model_text.getText(), Integer.parseInt(car_year_text.getText()), Integer.parseInt(car_mileage_text.getText()), car_condition_text.getText(), car_type_text.getText(), Integer.parseInt(car_price_text.getText()), car_status_text.getText());
				car_id_text.setText(String.valueOf(dao.addCar(c)));
				
				JOptionPane.showMessageDialog(null, car_make_text.getText() + car_model_text.getText() + Integer.parseInt(car_year_text.getText()) + " added.");
			}
		});
		car_add_button.setBounds(275, 320, 62, 23);
		frame.getContentPane().add(car_add_button);
		
		JButton car_modify_button = new JButton("Mod");
		car_modify_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Car c = new Car(0, car_make_text.getText(), car_model_text.getText(), Integer.parseInt(car_year_text.getText()), Integer.parseInt(car_mileage_text.getText()), car_condition_text.getText(), car_type_text.getText(), Integer.parseInt(car_price_text.getText()), car_status_text.getText());
				dao.updateCar(Integer.parseInt(car_id_text.getText()), c);
				
				JOptionPane.showMessageDialog(null, "Car " + car_id_text.getText() + " modified.");

			}
		});
		car_modify_button.setBounds(399, 320, 62, 23);
		frame.getContentPane().add(car_modify_button);
		car_modify_button.setEnabled(false);
		
		JButton customer_view_button = new JButton("View");
		customer_view_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				int customerID = Integer.parseInt(customer_id_text.getText());
				Customer customer = dao.searchCustomer(customerID);

				customer_fName_text.setText(customer.getFname());
				customer_lName_text.setText(customer.getLname());
				customer_age_text.setText(String.valueOf(customer.getAge()));
				customer_licNum_text.setText(customer.getLicenceNumber());
				customer_ccNum_text.setText(customer.getCcNumber());
				
				customer_id_text.setEditable(false);
				customer_modify_button.setEnabled(true);
			}
		});
		customer_view_button.setBounds(94, 249, 70, 23);
		frame.getContentPane().add(customer_view_button);
		
		car_view_button = new JButton("View");
		car_view_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				int carId = Integer.parseInt(car_id_text.getText());
				Car car = dao.searchCar(carId);
				
				car_year_text.setText(String.valueOf(car.getYear()));
				car_make_text.setText(car.getMake());
				car_model_text.setText(car.getModel());
				car_mileage_text.setText(String.valueOf(car.getMileage()));
				car_condition_text.setText(car.getCondition());
				car_price_text.setText(String.valueOf(car.getPrice()));
				car_type_text.setText(car.getType());
				
				car_id_text.setEditable(false);
				car_modify_button.setEnabled(true);
			}
		});
		car_view_button.setBounds(337, 320, 62, 23);
		frame.getContentPane().add(car_view_button);
		
	}
}
