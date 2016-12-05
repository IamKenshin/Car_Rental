import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JComboBox;
import org.eclipse.wb.swing.FocusTraversalOnArray;

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
	private JButton car_modify_button;
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
	private JTextField res_cust_text;
	private JTextField res_agency_text;
	private JTextField res_start_text;
	private JTextField res_end_text;
	private JTextField res_total_text;
	private JTextField res_id_text;
	
	private JTextField ren_contractID_text;
	private JTextField ren_customerID_text;
	private JTextField ren_carID_text;
	private JTextField ren_agencyID_text;
	private JTextField ren_insurance_text;
	private JTextField ren_insurance_price_text;
	private JTextField ren_start_text;
	private JTextField ren_end_text;
	private JTextField ren_status_text;
	private JTextField ren_total_text;

	private JLabel ren_contract_label;
	private JLabel ren_customer_label;
	private JLabel ren_car_label;
	private JLabel ren_agency_label;
	private JLabel ren_insurance_label;
	private JLabel ren_insurance_price_label;
	private JLabel ren_start_label;
	private JLabel ren_end_label;
	private JLabel ren_total_label;
	private JLabel ren_status_label;
	
			

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
		frame.setBounds(100, 100, 932, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*
		 * 
		 * 
		 * Customer Textfields
		 * 
		 * 
		 */	
		customer_fName_text = new JTextField();
		customer_fName_text.setBounds(106, 32, 71, 20);
		frame.getContentPane().add(customer_fName_text);
		customer_fName_text.setColumns(10);
		
		customer_lName_text = new JTextField();
		customer_lName_text.setBounds(106, 63, 71, 20);
		frame.getContentPane().add(customer_lName_text);
		customer_lName_text.setColumns(10);
		
		customer_age_text = new JTextField();
		customer_age_text.setBounds(106, 94, 71, 20);
		frame.getContentPane().add(customer_age_text);
		customer_age_text.setColumns(10);
		
		customer_licNum_text = new JTextField();
		customer_licNum_text.setBounds(106, 125, 71, 20);
		frame.getContentPane().add(customer_licNum_text);
		customer_licNum_text.setColumns(10);
		
		customer_ccNum_text = new JTextField();
		customer_ccNum_text.setBounds(106, 156, 71, 20);
		frame.getContentPane().add(customer_ccNum_text);
		customer_ccNum_text.setColumns(10);
		
		customer_status_text = new JTextField();
		customer_status_text.setText("Reservation");
		customer_status_text.setBounds(106, 186, 71, 20);
		frame.getContentPane().add(customer_status_text);
		customer_status_text.setColumns(10);
		customer_status_text.setEditable(false);
		
		customer_id_text = new JTextField();
		customer_id_text.setBounds(106, 217, 71, 20);
		frame.getContentPane().add(customer_id_text);
		customer_id_text.setColumns(10);
		
		JLabel customer_status_label = new JLabel("Status");
		customer_status_label.setBounds(23, 189, 154, 14);
		frame.getContentPane().add(customer_status_label);
		
		JLabel customer_fName_label = new JLabel("First Name");
		customer_fName_label.setBounds(23, 35, 154, 14);
		frame.getContentPane().add(customer_fName_label);
		
		JLabel customer_lName_label = new JLabel("Last Name");
		customer_lName_label.setBounds(23, 66, 154, 14);
		frame.getContentPane().add(customer_lName_label);
		
		customer_age_label = new JLabel("Age");
		customer_age_label.setBounds(23, 97, 154, 14);
		frame.getContentPane().add(customer_age_label);
		
		customer_licNum_label = new JLabel("Licence");
		customer_licNum_label.setBounds(23, 128, 154, 14);
		frame.getContentPane().add(customer_licNum_label);
		
		customer_ccNum_label = new JLabel("CC Number");
		customer_ccNum_label.setBounds(23, 159, 154, 14);
		frame.getContentPane().add(customer_ccNum_label);
		
		customer_id_label = new JLabel("ID");
		customer_id_label.setBounds(23, 220, 154, 14);
		frame.getContentPane().add(customer_id_label);		
		
		JLabel customer_label = new JLabel("Customer");
		customer_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		customer_label.setBounds(63, 7, 85, 14);
		frame.getContentPane().add(customer_label);
		
		JButton customer_add_button = new JButton("Add");
		customer_add_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
				
				customer_fName_text.setText("");
				customer_lName_text.setText("");
				customer_age_text.setText("");
				customer_licNum_text.setText("");
				customer_ccNum_text.setText("");
				customer_id_text.setText("");
				
				customer_id_text.setEditable(true);
				customer_modify_button.setEnabled(false);
			}
		});
		
		JButton customer_modify_button = new JButton("Mod");
		customer_modify_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
				
				customer_id_text.setEditable(true);
				customer_modify_button.setEnabled(false);
				
				JOptionPane.showMessageDialog(null, "Updated Customer");
			}
		});
		customer_add_button.setBounds(10, 249, 60, 23);
		frame.getContentPane().add(customer_add_button);
		
		customer_modify_button.setBounds(144, 249, 65, 23);
		frame.getContentPane().add(customer_modify_button);
		customer_modify_button.setEnabled(false);
		
		JButton customer_view_button = new JButton("View");
		customer_view_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		customer_view_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				int customerID = Integer.parseInt(customer_id_text.getText());
				Customer customer = dao.searchCustomer(customerID);
				if (customer != null){
					customer_fName_text.setText(customer.getFname());
					customer_lName_text.setText(customer.getLname());
					customer_age_text.setText(String.valueOf(customer.getAge()));
					customer_licNum_text.setText(customer.getLicenceNumber());
					customer_ccNum_text.setText(customer.getCcNumber());
					customer_status_text.setText(customer.getStatus());
					customer_id_text.setEditable(false);
					customer_modify_button.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Customer not found!");
				}


			}
		});
		customer_view_button.setBounds(72, 249, 70, 23);
		frame.getContentPane().add(customer_view_button);
		
		/*
		 * 
		 * 
		 * Car Textfields
		 * 
		 * 
		 */	
		
		JLabel car_label = new JLabel("Car");
		car_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		car_label.setBounds(257, 8, 74, 14);
		frame.getContentPane().add(car_label);
		
		JLabel car_year_label = new JLabel("Year");
		car_year_label.setBounds(221, 35, 132, 14);
		frame.getContentPane().add(car_year_label);
		
		JLabel car_make_label = new JLabel("Make");
		car_make_label.setBounds(221, 66, 132, 14);
		frame.getContentPane().add(car_make_label);
		
		JLabel car_model_label = new JLabel("Model");
		car_model_label.setBounds(221, 97, 132, 14);
		frame.getContentPane().add(car_model_label);
		
		JLabel car_mileage_label = new JLabel("Mileage");
		car_mileage_label.setBounds(221, 128, 132, 14);
		frame.getContentPane().add(car_mileage_label);
		
		JLabel car_condition_label = new JLabel("Condition");
		car_condition_label.setBounds(221, 162, 132, 14);
		frame.getContentPane().add(car_condition_label);
		
		JLabel car_status_label = new JLabel("Status");
		car_status_label.setBounds(221, 189, 132, 14);
		frame.getContentPane().add(car_status_label);
		
		JLabel car_id_label = new JLabel("ID");
		car_id_label.setBounds(221, 223, 132, 14);
		frame.getContentPane().add(car_id_label);
		
		JLabel car_price_label = new JLabel("Price");
		car_price_label.setBounds(221, 253, 132, 14);
		frame.getContentPane().add(car_price_label);
		
		JLabel car_type_label = new JLabel("Type");
		car_type_label.setBounds(221, 284, 132, 14);
		frame.getContentPane().add(car_type_label);
		
		car_year_text = new JTextField();
		car_year_text.setBounds(285, 32, 68, 20);
		frame.getContentPane().add(car_year_text);
		car_year_text.setColumns(10);
		
		car_make_text = new JTextField();
		car_make_text.setBounds(285, 63, 68, 20);
		frame.getContentPane().add(car_make_text);
		car_make_text.setColumns(10);
		
		car_model_text = new JTextField();
		car_model_text.setBounds(285, 94, 68, 20);
		frame.getContentPane().add(car_model_text);
		car_model_text.setColumns(10);
		
		car_mileage_text = new JTextField();
		car_mileage_text.setBounds(285, 125, 68, 20);
		frame.getContentPane().add(car_mileage_text);
		car_mileage_text.setColumns(10);
		
		car_condition_text = new JTextField();
		car_condition_text.setBounds(285, 156, 68, 20);
		frame.getContentPane().add(car_condition_text);
		car_condition_text.setColumns(10);
		
		car_status_text = new JTextField();
		car_status_text.setText("On Hand");
		car_status_text.setBounds(285, 186, 68, 20);
		frame.getContentPane().add(car_status_text);
		car_status_text.setColumns(10);
		car_status_text.setEditable(false);
		
		car_id_text = new JTextField();
		car_id_text.setBounds(285, 217, 68, 20);
		frame.getContentPane().add(car_id_text);
		car_id_text.setColumns(10);
		
		car_price_text = new JTextField();
		car_price_text.setBounds(285, 250, 68, 20);
		frame.getContentPane().add(car_price_text);
		car_year_text.setColumns(10);
		
		car_type_text = new JTextField();
		car_type_text.setBounds(285, 281, 68, 20);
		frame.getContentPane().add(car_type_text);
		car_type_text.setColumns(10);
		
		JButton car_add_button = new JButton("Add");
		car_add_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		car_add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Car c = new Car(0, car_make_text.getText(), car_model_text.getText(), Integer.parseInt(car_year_text.getText()), Integer.parseInt(car_mileage_text.getText()), car_condition_text.getText(), car_type_text.getText(), Integer.parseInt(car_price_text.getText()), car_status_text.getText());
				car_id_text.setText(String.valueOf(dao.addCar(c)));
				
				JOptionPane.showMessageDialog(null, car_make_text.getText() + car_model_text.getText() + Integer.parseInt(car_year_text.getText()) + " added.");
				
				car_year_text.setText("");
				car_make_text.setText("");
				car_model_text.setText("");
				car_mileage_text.setText("");
				car_condition_text.setText("");
				car_id_text.setText("");
				car_price_text.setText("");
				car_type_text.setText("");
				
				car_id_text.setEditable(true);
				car_modify_button.setEnabled(false);
				
			}
		});
		car_add_button.setBounds(221, 320, 55, 23);
		frame.getContentPane().add(car_add_button);
		
		car_modify_button = new JButton("Mod");
		car_modify_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		car_modify_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Car c = new Car(0, car_make_text.getText(), car_model_text.getText(), Integer.parseInt(car_year_text.getText()), Integer.parseInt(car_mileage_text.getText()), car_condition_text.getText(), car_type_text.getText(), Integer.parseInt(car_price_text.getText()), car_status_text.getText());
				dao.updateCar(Integer.parseInt(car_id_text.getText()), c);
				
				JOptionPane.showMessageDialog(null, "Car " + car_id_text.getText() + " modified.");
				car_id_text.setEditable(true);
				car_modify_button.setEnabled(false);

			}
		});
		car_modify_button.setBounds(330, 320, 60, 23);
		frame.getContentPane().add(car_modify_button);
		car_modify_button.setEnabled(false);
		
		
		car_view_button = new JButton("View");
		car_view_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		car_view_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				int carId = Integer.parseInt(car_id_text.getText());
				Car car = dao.searchCar(carId);
				if (car != null){
					car_year_text.setText(String.valueOf(car.getYear()));
					car_make_text.setText(car.getMake());
					car_model_text.setText(car.getModel());
					car_mileage_text.setText(String.valueOf(car.getMileage()));
					car_status_text.setText(car.getStatus());
					car_condition_text.setText(car.getCondition());
					car_price_text.setText(String.valueOf(car.getPrice()));
					car_type_text.setText(car.getType());
					
					car_id_text.setEditable(false);
					car_modify_button.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Car not found!");
				}

			}
		});
		car_view_button.setBounds(275, 320, 60, 23);
		frame.getContentPane().add(car_view_button);
		
		
		/*
		 * 
		 * 
		 * Reservation Textfields
		 * 
		 * 
		 */	
		JLabel res_cust_label = new JLabel("Customer");
		res_cust_label.setBounds(404, 35, 46, 14);
		frame.getContentPane().add(res_cust_label);
		
		JLabel res_agency_label = new JLabel("Agency");
		res_agency_label.setBounds(404, 66, 46, 14);
		frame.getContentPane().add(res_agency_label);
		
		JLabel res_start_label = new JLabel("Start");
		res_start_label.setBounds(404, 97, 46, 14);
		frame.getContentPane().add(res_start_label);
		
		JLabel res_end_label = new JLabel("End");
		res_end_label.setBounds(404, 128, 46, 14);
		frame.getContentPane().add(res_end_label);
		
		JLabel res_total_label = new JLabel("Total Days");
		res_total_label.setBounds(404, 159, 55, 14);
		frame.getContentPane().add(res_total_label);
		
		JLabel res_id_label = new JLabel("ID");
		res_id_label.setBounds(404, 189, 46, 14);
		frame.getContentPane().add(res_id_label);
		
		res_cust_text = new JTextField();
		res_cust_text.setBounds(470, 32, 68, 20);
		frame.getContentPane().add(res_cust_text);
		res_cust_text.setColumns(10);
		
		res_agency_text = new JTextField();
		res_agency_text.setBounds(470, 63, 68, 20);
		frame.getContentPane().add(res_agency_text);
		res_agency_text.setColumns(10);
		
		res_start_text = new JTextField();
		res_start_text.setBounds(470, 94, 68, 20);
		frame.getContentPane().add(res_start_text);
		res_start_text.setColumns(10);
		
		res_end_text = new JTextField();
		res_end_text.setBounds(470, 125, 68, 20);
		frame.getContentPane().add(res_end_text);
		res_end_text.setColumns(10);
		
		res_total_text = new JTextField();
		res_total_text.setBounds(470, 156, 68, 20);
		frame.getContentPane().add(res_total_text);
		res_total_text.setColumns(10);
		res_total_text.setEditable(false);
		
		res_id_text = new JTextField();
		res_id_text.setBounds(470, 186, 68, 20);
		frame.getContentPane().add(res_id_text);
		res_id_text.setColumns(10);
		
		JButton res_add_button = new JButton("Add");
		res_add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int customerId, agencyId, totalDays, reservationId;
				LocalDate startDate, endDate;
				
				customerId = Integer.parseInt(res_cust_text.getText());
				agencyId = Integer.parseInt(res_agency_text.getText());
				startDate = LocalDate.parse(res_start_text.getText());
				endDate = LocalDate.parse(res_end_text.getText());
				totalDays = (int) (endDate.toEpochDay() - startDate.toEpochDay());
				Dates dates = new Dates(startDate, endDate, totalDays);
				
				Reservation res = new Reservation(0, customerId, agencyId, dates);
				
				reservationId = dao.addReservation(res);
				res_total_text.setText(String.valueOf(totalDays));
				res_id_text.setText(String.valueOf(reservationId));
				
			}
		});
		
		res_add_button.setBounds(404, 223, 65, 23);
		frame.getContentPane().add(res_add_button);
		res_add_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JButton res_cancel_button = new JButton("Cancel");
		res_cancel_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		res_cancel_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reservationNumber = Integer.valueOf(res_id_text.getText());
				dao.cancelReservation(reservationNumber);
				JOptionPane.showMessageDialog(null, "Reservation Cancelled!");
				
			}
		});
		res_cancel_button.setBounds(404, 249, 65, 23);
		frame.getContentPane().add(res_cancel_button);
		res_cancel_button.setEnabled(false);
		
		JButton res_modify_button = new JButton("Mod");
		res_modify_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int customerId, agencyId, totalDays;
				LocalDate startDate, endDate;
				int reservationNumber = Integer.parseInt(res_id_text.getText());
				
				customerId = Integer.parseInt(res_cust_text.getText());
				agencyId = Integer.parseInt(res_agency_text.getText());
				startDate = LocalDate.parse(res_start_text.getText());
				endDate = LocalDate.parse(res_end_text.getText());
				totalDays = (int) (endDate.toEpochDay() - startDate.toEpochDay());
				Dates dates = new Dates(startDate, endDate, totalDays);
				
				Reservation newRes = new Reservation(reservationNumber, customerId, agencyId, dates);
				dao.updateReservation(reservationNumber, newRes);
				
				JOptionPane.showMessageDialog(null, "Updated Reservation");
			}
		});
		res_modify_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		res_modify_button.setBounds(479, 249, 60, 23);
		frame.getContentPane().add(res_modify_button);
		res_modify_button.setEnabled(false);
		
		JButton res_view_button = new JButton("View");
		res_view_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reservationId = Integer.parseInt(res_id_text.getText());
				Reservation res = dao.searchReservation(reservationId);
				if (res != null){
					res_cust_text.setText(String.valueOf(res.getCustomerId()));
					res_agency_text.setText(String.valueOf(res.getAgencyId()));
					res_start_text.setText(res.getStartDate().toString());
					res_end_text.setText(res.getEndDate().toString());
					res_total_text.setText(String.valueOf(res.getTotalDays()));
					res_id_text.setText(String.valueOf(res.getReservationNumber()));
					
					Customer customer = dao.searchCustomer(res.getCustomerId());
					
					customer_fName_text.setText(customer.getFname());
					customer_lName_text.setText(customer.getLname());
					customer_age_text.setText(String.valueOf(customer.getAge()));
					customer_licNum_text.setText(customer.getLicenceNumber());
					customer_ccNum_text.setText(customer.getCcNumber());
					customer_id_text.setText(String.valueOf(customer.getCustomerId()));
					
					res_id_text.setEditable(false);
					customer_id_text.setEditable(false);
					res_modify_button.setEnabled(true);
					res_cancel_button.setEnabled(true);
				} else
					JOptionPane.showMessageDialog(null, "Reservation not found!");
				
			}
		});
		res_view_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		res_view_button.setBounds(480, 223, 60, 23);
		frame.getContentPane().add(res_view_button);
		
		/*
		 * 
		 * 
		 * Rental Textfields
		 * 
		 * 
		 */	
		
		ren_contractID_text = new JTextField();
		ren_contractID_text.setBounds(700, 32, 68, 20);
		frame.getContentPane().add(ren_contractID_text);
		ren_contractID_text.setColumns(10);
		
		ren_customerID_text= new JTextField();
		ren_customerID_text.setBounds(700, 63, 68, 20);
		frame.getContentPane().add(		ren_customerID_text);
		ren_customerID_text.setColumns(10);
		
		ren_carID_text= new JTextField();
		ren_carID_text.setBounds(700, 94, 68, 20);
		frame.getContentPane().add(ren_carID_text);
		ren_carID_text.setColumns(10);
		
		ren_agencyID_text= new JTextField();
		ren_agencyID_text.setBounds(700, 125, 68, 20);
		frame.getContentPane().add(ren_agencyID_text);
		ren_agencyID_text.setColumns(10);
		
		ren_insurance_text= new JTextField();
		ren_insurance_text.setBounds(700, 156, 68, 20);
		frame.getContentPane().add(ren_insurance_text);
		ren_insurance_text.setColumns(10);
		
		ren_insurance_price_text= new JTextField();
		ren_insurance_price_text.setBounds(700, 187, 68, 20);
		frame.getContentPane().add(ren_insurance_price_text);
		ren_insurance_price_text.setColumns(10);
		
		ren_start_text= new JTextField();
		ren_start_text.setBounds(700, 217, 68, 20);
		frame.getContentPane().add(ren_start_text);
		ren_start_text.setColumns(10);
		
		ren_end_text= new JTextField();
		ren_end_text.setBounds(700, 250, 68, 20);
		frame.getContentPane().add(ren_end_text);
		ren_end_text.setColumns(10);
		
		ren_status_text= new JTextField();
		ren_status_text.setBounds(700, 280, 68, 20);
		frame.getContentPane().add(ren_status_text);
		ren_status_text.setColumns(10);
		
		ren_total_text= new JTextField();
		ren_total_text.setBounds(700, 311, 68, 20);
		frame.getContentPane().add(ren_total_text);
		ren_total_text.setColumns(10);
		
		ren_contract_label = new JLabel("Contract#");
		ren_contract_label.setBounds(600, 35, 132, 14);
		frame.getContentPane().add(ren_contract_label);
		
		ren_customer_label= new JLabel("Customer#");
		ren_customer_label.setBounds(600, 66, 132, 14);
		frame.getContentPane().add(ren_customer_label);
		
		ren_car_label= new JLabel("Car#");
		ren_car_label.setBounds(600, 97, 132, 14);
		frame.getContentPane().add(ren_car_label);
		
		ren_agency_label= new JLabel("Agency#");
		ren_agency_label.setBounds(600, 128, 132, 14);
		frame.getContentPane().add(ren_agency_label);
		
		ren_insurance_label= new JLabel("Insurance");
		ren_insurance_label.setBounds(600, 159, 132, 14);
		frame.getContentPane().add(ren_insurance_label);
		
		ren_insurance_price_label= new JLabel("Insurance $");
		ren_insurance_price_label.setBounds(600, 190, 132, 14);
		frame.getContentPane().add(ren_insurance_price_label);
		
		ren_start_label= new JLabel("Start Date");
		ren_start_label.setBounds(600, 221, 132, 14);
		frame.getContentPane().add(ren_start_label);
		
		ren_end_label= new JLabel("End Date");
		ren_end_label.setBounds(600, 252, 132, 14);
		frame.getContentPane().add(ren_end_label);
		
		ren_total_label= new JLabel("Total Price $");
		ren_total_label.setBounds(600, 317, 132, 14);
		frame.getContentPane().add(ren_total_label);
		
		ren_status_label= new JLabel("Rental Status");
		ren_status_label.setBounds(600, 286, 132, 14);
		frame.getContentPane().add(ren_status_label);
		
		JButton rental_add_button = new JButton("Add");
		rental_add_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		rental_add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int customer = Integer.parseInt(ren_customerID_text.getText());
				int car = Integer.parseInt(ren_carID_text.getText());
				int agency = Integer.parseInt(ren_agencyID_text.getText());
				String insurance = ren_insurance_text.getText();
				int insPrice = Integer.parseInt(ren_insurance_price_text.getText());
				LocalDate startDate = LocalDate.parse(ren_start_text.getText());
				LocalDate endDate = LocalDate.parse(ren_end_text.getText());
				String status = ren_total_text.getText();
				
				Car c = dao.searchCar(car);
				int totalDays = (int) (endDate.toEpochDay() - startDate.toEpochDay());
				
				Dates d = new Dates(startDate, endDate, totalDays);
				
				int totalPrice = (c.getPrice() * totalDays);
				int underageFee = 30;
				DataAccess dao = new DataAccess();
				
				if (dao.under25(customer))
				{
					totalPrice = totalPrice + underageFee;
				}
				Rental rental = new Rental(customer, c, agency, insurance, insPrice, d, totalPrice, status);
				
				if (insurance.equals("Yes"))
				{
					totalPrice = totalPrice + insPrice;
				}
				rental.setTotalPrice(totalPrice);
				
				int rentalID = dao.rentalCheckOut(rental, c, d);
				ren_contractID_text.setText(String.valueOf(rentalID));
				
				ren_total_text.setText(dao.searchRental(rentalID).getStatus());
				ren_status_text.setText(String.valueOf(totalPrice));
				JOptionPane.showMessageDialog(null, "Rental Contract Number: " + rentalID + ". Total Price is " + totalPrice);
				
				ren_contractID_text.setEditable(true);
				//ren_modify_button.setEnabled(false); //not implemented yet
			}
		});
		
		rental_add_button.setBounds(600, 356, 55, 23);
		frame.getContentPane().add(rental_add_button);
		
		JButton rental_view_button = new JButton("View");
		rental_view_button.setFont(new Font("Tahoma", Font.PLAIN, 10));
		rental_view_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!ren_contractID_text.getText().isEmpty()){				
					int contract = Integer.parseInt(ren_contractID_text.getText());
					Rental r = dao.searchRental(contract);
					if(r != null) {
						ren_customerID_text.setText(String.valueOf(r.getCustomerId()));
						ren_carID_text.setText(String.valueOf(r.getCarId()));
						ren_agencyID_text.setText(String.valueOf(r.getAgencyId()));
						ren_insurance_text.setText(r.getInsurance());
						ren_insurance_price_text.setText(String.valueOf(r.getInsurancePrice()));
						ren_start_text.setText(r.getStartDate().toString());
						ren_end_text.setText(r.getEndDate().toString());
						ren_status_text.setText(r.getStatus());
						ren_total_text.setText(String.valueOf(r.getTotalPrice()));
						
						Customer cust = dao.searchCustomer(r.getCustomerId());
						Car car = dao.searchCar(r.getCarId());
						
						customer_fName_text.setText(cust.getFname());
						customer_lName_text.setText(cust.getLname());
						customer_age_text.setText(String.valueOf(cust.getAge()));
						customer_licNum_text.setText(cust.getLicenceNumber());
						customer_ccNum_text.setText(cust.getCcNumber());
						customer_id_text.setText(String.valueOf(cust.getCustomerId()));
						customer_add_button.setEnabled(false);
						
						car_year_text.setText(String.valueOf(car.getYear()));
						car_make_text.setText(car.getMake());
						car_model_text.setText(car.getModel());
						car_mileage_text.setText(String.valueOf(car.getMileage()));
						car_condition_text.setText(car.getCondition());
						car_id_text.setText(String.valueOf(car.getCarId()));
						car_price_text.setText(String.valueOf(car.getPrice()));
						car_type_text.setText(car.getType());
						car_add_button.setEnabled(false);
					}	else 
						JOptionPane.showMessageDialog(null, "Rental Contract not found!");
				}	else
					JOptionPane.showMessageDialog(null, "Not a valid contract number");
			}
		});
		
		rental_view_button.setBounds(665, 356, 55, 23);
		frame.getContentPane().add(rental_view_button);		
		
		JLabel res_label = new JLabel("Reservation");
		res_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		res_label.setBounds(425, 7, 98, 14);
		frame.getContentPane().add(res_label);
		
		JLabel ren_label = new JLabel("Rental");
		ren_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		ren_label.setBounds(660, 8, 55, 14);
		frame.getContentPane().add(ren_label);

		
		
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{customer_fName_text, customer_lName_text, customer_age_text, customer_licNum_text, customer_ccNum_text, customer_status_text, customer_id_text, customer_add_button, customer_view_button, customer_status_label, customer_modify_button, car_year_text, car_make_text, car_model_text, car_mileage_text, car_condition_text, car_status_text, car_id_text, car_price_text, car_type_text, car_add_button, car_view_button, car_modify_button, res_cust_text, res_agency_text, res_start_text, res_end_text, res_total_text, res_id_text, res_add_button, res_view_button, res_cancel_button, res_modify_button, ren_contractID_text, ren_customerID_text, ren_carID_text, ren_agencyID_text, ren_insurance_text, ren_insurance_price_text, ren_start_text, ren_end_text, ren_status_text, ren_total_text, rental_add_button, rental_view_button, customer_fName_label, customer_lName_label, customer_age_label, customer_licNum_label, customer_ccNum_label, customer_id_label, customer_label, ren_contract_label, ren_customer_label, ren_car_label, ren_agency_label, ren_insurance_label, ren_insurance_price_label, ren_start_label, ren_end_label, ren_total_label, ren_status_label, car_label, car_year_label, car_make_label, car_model_label, car_mileage_label, car_condition_label, car_status_label, car_id_label, car_price_label, car_type_label, res_cust_label, res_agency_label, res_start_label, res_end_label, res_total_label, res_id_label}));
		
	}
}
