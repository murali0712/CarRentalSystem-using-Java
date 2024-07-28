import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car{
	private String 	carId;
	private String brand;
	private String model;
	private double basePricePerDay;
	private boolean isAvailable;
	
	public Car(String carId,String brand,String model,double basePricePerDay) {
		this.carId=carId;
		this.brand=brand;
		this.model=model;
		this.basePricePerDay=basePricePerDay;
			this.isAvailable=true;
	}
	public String getCarId() {
		return carId;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public double calculatePrice(int rentalDays) {
		return basePricePerDay*rentalDays;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void rent() {
		isAvailable= false;
	}
	public void returnCar() {
		isAvailable=true;
	}
}

class Customer{
	private String customerId;
	private String name;
	
	public Customer(String customerId,String name) {
		this.customerId=customerId;
		this.name=name;
	}
	public String getCustomerId() {
		return customerId;
	}
	public String getName() {
		return name;
	}
}

class Rental{
	private Car car;
	
	private Customer customer;
	
	private int days;
	
	public Rental(Car car,Customer customer,int days) {
		this.car=car;
		this.customer=customer;
		this.days=days;
	}
	public Car getCar() {
		return car;
	}
	public Customer getCustomer() {
		return customer;
	}
	public int getDays() {
		return days;
	}
}

class CarRentalSystem{
	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rentals;
	
	public CarRentalSystem() {
		cars= new ArrayList<>();
		customers= new ArrayList<>();
		rentals= new ArrayList<>();;
	}
	
	
	public void addCar(Car car) {
		cars.add(car);
	}
	public void addCustomer(Customer customer) {
		customers.add(customer);
	}
	
public void rentCar(Car car,Customer customer,int days) {
	if(car.isAvailable()) {
		car.rent();
		rentals.add(new Rental(car,customer,days));
		
	}
	else {
		System.out.println("Car is not available for rent");
	}
}

	public void returnCar(Car car) {
		car.returnCar();
		Rental rentalToRemove= null;
		for(Rental rent:rentals) {
			if(rent.getCar()==car) {
				rentalToRemove=  rent;
				break;
			}
		}
		if(rentalToRemove!=null) {
			rentals.remove(rentalToRemove);
			//System.out.println("Car returned Successfully");
		}
		else {
			System.out.println("Car was not rented");
		}
		
	}
	
	public void menu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("==== Car Rental System ====");
			System.out.println("1. Rent a Car");
			System.out.println("2. Return a Car");
			System.out.println("3. Exit");
			System.out.println("Enter your Choice: ");
			
			int choice=sc.nextInt();
			sc.nextLine();
			
			if(choice==1) {
				System.out.println("\n Rent a Car \n");
				System.out.println("Enter your name: ");
				String custName= sc.nextLine();
				
				System.out.println("Available Cars");
				for(Car c:cars) {
					if(c.isAvailable()) {
						System.out.println(c.getCarId()+" - "+c.getBrand()+" - "+c.getModel());
					}
				}
				
				System.out.println("Enter the Car ID you want to rent: ");
				String carId = sc.nextLine();
				
				System.out.println("Enter the number of days for rental: ");
				int rd= sc.nextInt();
				sc.nextLine();
				
				Customer cust= new Customer("CUS"+(customers.size()+1),custName);
				addCustomer(cust);
				
				Car selcar= null;
				for(Car c:cars) {
					if(c.getCarId().equals(carId) && c.isAvailable()) {
						selcar=c;
						break;
					}
				}
				if(selcar!=null) {
					double totprice= selcar.calculatePrice(rd);
					System.out.println("\n=== Rental Information===\n");
					System.out.println("Customer ID: "+cust.getCustomerId());
					System.out.println("Customer name: "+cust.getName());
					System.out.println("Car: "+selcar.getBrand()+" "+selcar.getModel());
					System.out.println("Rental Days: "+rd);
					System.out.printf("Total Price: $%.2f%n", totprice);
					
					System.out.println("\nConfirm rental (Y/N): ");
					String conf= sc.nextLine();
					
					if(conf.equalsIgnoreCase("Y")) {
						rentCar(selcar,cust,rd);
						System.out.println("\nCar rented successfully.");
					}
					else {
						System.out.println("\nRental canceled");
					}
				}
				else {
					System.out.println("\nInvalid car selection or car not available for rent.");
				}
			}
			else if(choice==2) {
				System.out.println("\n=== Rent a Car==\n");
				System.out.println("Enter the car ID you want to return: ");
				String carId= sc.nextLine();
				
				Car cartoret= null;
				for(Car c:cars) {
					if(c.getCarId().equals(carId) && !c.isAvailable()) {
						cartoret=c; break;
					}
				}
				if(cartoret!=null) {
					Customer cust=null;
					for(Rental rent:rentals) {
						if(rent.getCar()==cartoret) {
							cust= rent.getCustomer();
						}
					}
					
					if(cust!=null) {
						returnCar(cartoret);
						System.out.println("Car returned Successfully by "+cust.getName());
					}
					else {
						System.out.println("Car was not rented or rental information is missing");
					}
				}
				else {
					System.out.println("Invalid Car ID or car is not rented");
				}
			}
			else if(choice==3) 
				break;
			else {
				System.out.println("Invalid Choice. Please enter a valid option");
			}
		} 
		System.out.println("\n Thank you for choosing Car Rental System!!");
		sc.close();
	}
}

public class MainCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarRentalSystem crs= new CarRentalSystem();
		
		Car c1= new Car("C001","Toyota","Camry", 600.0);
		Car c2= new Car("C002","Honda","Accord", 700.0);
		Car c3= new Car("C003","Mahindra","Thar", 1000.0);
		crs.addCar(c1);
		crs.addCar(c2);
		crs.addCar(c3);
		
		crs.menu();
	}

}
