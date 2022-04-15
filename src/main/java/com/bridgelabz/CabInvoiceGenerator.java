package com.bridgelabz;

public class CabInvoiceGenerator {
    private final int COST_PER_KM = 10;
    private final int COST_PER_MINUTE = 1;
    public int MIN_FARE = 5;
    double totalFare;

    public double CalculateFare(double distance, int time) {

        totalFare = COST_PER_KM * distance + COST_PER_MINUTE * time;
        if(totalFare < MIN_FARE)
            totalFare = MIN_FARE;
        return totalFare;
    }

    public double CalculateFare(Rides[] rides) {
        double totalFare = 0.0;
        for (Rides ride : rides)
            totalFare = totalFare + this.CalculateFare(ride.distance, ride.time);

        return totalFare;
    }
}