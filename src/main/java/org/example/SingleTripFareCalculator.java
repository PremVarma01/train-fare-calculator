package org.example;

class SingleTripFareCalculator implements FareCalculator {
    private static final int BASE_PRICE = 50;
    private static final int PER_KM_PRICE = 3;
    private static final double DISTANCE_WITH_BASE_PRICE = 100;

    @Override
    public double calculateFare(int distance) {
        if (distance > DISTANCE_WITH_BASE_PRICE) {
            return BASE_PRICE + ((distance - DISTANCE_WITH_BASE_PRICE) * PER_KM_PRICE);
        }
        return BASE_PRICE;
    }
}
