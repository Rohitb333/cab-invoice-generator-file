package com.bridgelabz;

public class PrimiumRides {

        public static final PrimiumRides PREMIUM = null;
        public static PrimiumRides Normal;

        private final double costPerKm;
        private final double costPerMin;
        private final double minFare;

        PrimiumRides(double costPerKm, double costPerMin, double minFare){
                this.costPerKm=costPerKm;
                this.costPerMin=costPerMin;
                this.minFare=minFare;
        }

        public double calcCostOfCabRide(Rides ride) {
                double rideCost = ride.distance * costPerKm + ride.time * costPerMin;
                return rideCost;
        }
}
