**Car Rental System**
Project Overview
This project is a simple Car Rental System implemented using Java and Object-Oriented Programming (OOP) principles. It allows users to rent and return cars, manage customer information, and calculate rental costs.

Features
Add Cars: Add cars to the rental system.
Add Customers: Register new customers.
Rent Cars: Rent available cars to customers.
Return Cars: Process the return of rented cars.
Calculate Rental Costs: Calculate the total rental cost based on the number of rental days.


Classes and Methods
Car
Represents a car in the rental system.

Attributes:

carId: Unique identifier for the car.
brand: Brand of the car.
model: Model of the car.
basePricePerDay: Base rental price per day.
isAvailable: Availability status of the car.
Methods:

Car(String carId, String brand, String model, double basePricePerDay): Constructor to initialize car attributes.
getCarId(): Returns the car ID.
getBrand(): Returns the car brand.
getModel(): Returns the car model.
calculatePrice(int rentalDays): Calculates the total rental price based on the number of rental days.
isAvailable(): Checks if the car is available for rent.
rent(): Marks the car as rented.
returnCar(): Marks the car as returned.
Customer
Represents a customer in the rental system.

Attributes:

customerId: Unique identifier for the customer.
name: Name of the customer.
Methods:

Customer(String customerId, String name): Constructor to initialize customer attributes.
getCustomerId(): Returns the customer ID.
getName(): Returns the customer name.
Rental
Represents a rental transaction.

Attributes:

car: The rented car.
customer: The customer who rented the car.
days: The number of rental days.
Methods:

Rental(Car car, Customer customer, int days): Constructor to initialize rental attributes.
getCar(): Returns the rented car.
getCustomer(): Returns the customer.
getDays(): Returns the number of rental days.

CarRentalSystem
Manages the car rental system operations.

Attributes:

cars: List of available cars.
customers: List of registered customers.
rentals: List of rental transactions.
Methods:

CarRentalSystem(): Constructor to initialize lists.
addCar(Car car): Adds a car to the system.
addCustomer(Customer customer): Adds a customer to the system.
rentCar(Car car, Customer customer, int days): Processes car rental.
returnCar(Car car): Processes car return.
menu(): Displays the menu and handles user input.
