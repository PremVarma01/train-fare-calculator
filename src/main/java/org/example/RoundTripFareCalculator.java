package org.example;

class RoundTripFareCalculator implements FareCalculator {
    private static final double DISCOUNT_PERCENTAGE = 0.20;
    private final FareCalculator singleTripFareCalculator;

    RoundTripFareCalculator(FareCalculator singleTripFareCalculator) {
        this.singleTripFareCalculator = singleTripFareCalculator;
    }

    @Override
    public double calculateFare(int distance) {
        double totalFare = singleTripFareCalculator.calculateFare(distance) * 2;
        return totalFare - (totalFare * DISCOUNT_PERCENTAGE);
    }
}
