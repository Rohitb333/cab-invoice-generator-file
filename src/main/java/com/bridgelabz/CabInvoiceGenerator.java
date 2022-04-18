package com.bridgelabz;

public class CabInvoiceGenerator {

    RideRepository rideRepository = new RideRepository();
    private final int costPerKm = 10;
    private final int costPerMin = 1;
    public int minFare = 5;
    double totalFare;

    public double calculateFare(double distance, int time) {

        totalFare = costPerKm * distance + costPerMin * time;
        if(totalFare < minFare)
            totalFare = minFare;
        return totalFare;
    }

    public double calculateFare(Rides[] rides) {
        double totalFare = 0.0;
        for (Rides ride : rides)
            totalFare = totalFare + this.calculateFare(ride.distance, ride.time);

        return totalFare;
    }

    public int numberOfRides(Rides[] rides) {
        return rides.length;
    }

    public double calculateAverageFarePerRide(Rides[] rides) {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double totalFare = cabInvoiceGenerator.calculateFare(rides);
        double numberOfRides = rides.length;
        double averageFare = totalFare/numberOfRides;
        return averageFare;
    }

    public double getRidesDetails(String userID) {
        return this.calculateFare(rideRepository.getRides(userID));
    }

    public void addRides(String userID, Rides[] rides) {
        rideRepository.addRides(userID, rides);
    }
}
