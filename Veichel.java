package video_player;

public class Veichel {
	/*
	 * for question no. (a)-- i need to implement the interface with two classes name Car and Plane.
	 and veichel class as base class.

	 For that I need to override those methods.
	 */
	    public static void main(String[] args) {
	        Car car = new Car();
	        car.drive();
	        Plane plane = new Plane();
	        plane.fly();

	        VeichelFactory VeichelFactory = new VeichelFactory();
	        Car car1 = (Car) VeichelFactory.getVehicle("car");
	        car1.drive();
	        Plane plane1 = (Plane) VeichelFactory.getVehicle("plane");
	        plane1.fly();
	    }
	}


	interface veichel {
	    int num_of_wheels();

	    int num_of_passengers();

	    boolean has_gas();
	}

	class Car implements veichel {
	    @Override
	    public int num_of_wheels() {
	        // TODO Auto-generated method stub
	        return 4;
	    }

	    @Override
	    public int num_of_passengers() {
	        // TODO Auto-generated method stub
	        return 5;
	    }

	    @Override
	    public boolean has_gas() {
	        // TODO Auto-generated method stub
	        return true;
	    }

	    void drive() {
	        System.out.println("Running...");
	    }
	}

	class Plane implements veichel {
	    @Override
	    public int num_of_wheels() {
	        // TODO Auto-generated method stub
	        return 18;
	    }

	    @Override
	    public int num_of_passengers() {
	        // TODO Auto-generated method stub
	        return 350;
	    }

	    @Override
	    public boolean has_gas() {
	        // TODO Auto-generated method stub
	        return true;
	    }

	    void fly() {
	        System.out.println("plane is Flying");
	    }
	}

	/*
	 * for question no. (b) -- i will use Factory method design pattern.
	 */

	class VeichelFactory {
	    public veichel getVehicle(String vehicleType) {
	        if (vehicleType == null) {
	            return null;
	        }
	        if (vehicleType.equalsIgnoreCase("plane")) {
	            return new Plane();

	        } else if (vehicleType.equalsIgnoreCase("car")) {
	            return new Car();

	        }
	        return null;
	    }
	}
