package org.example;

import java.util.LinkedHashMap;
import java.util.Map;

class TrainFareCalculator {
    private static final Map<String, Integer> DISTANCES = new LinkedHashMap<>();

    static {
        DISTANCES.put("delhi", 0);
        DISTANCES.put("mumbai", 50);
        DISTANCES.put("lucknow", 100);
        DISTANCES.put("gujrat", 150);
        DISTANCES.put("allahabad", 200);
    }

    static double calculateOverallFare(String source, String destination, FareCalculator fareCalculator) {
        String lowerCaseSource = source.toLowerCase();
        String lowerCaseDestination = destination.toLowerCase();

        if (!DISTANCES.containsKey(lowerCaseSource) || !DISTANCES.containsKey(lowerCaseDestination)) {
            throw new FareException("Source or Destination is not found");
        }

        if (lowerCaseSource.equals(lowerCaseDestination)) {
            throw new FareException("Source and Destination cannot be the same");
        }

        int distance = Math.abs(DISTANCES.get(lowerCaseDestination) - DISTANCES.get(lowerCaseSource));
        return fareCalculator.calculateFare(distance);
    }

    public static void main(String[] args) {
        try {
            FareCalculator singleTripFareCalculator = new SingleTripFareCalculator();
            FareCalculator roundTripFareCalculator = new RoundTripFareCalculator(singleTripFareCalculator);

            System.out.println(calculateOverallFare("delhi", "allahabad", roundTripFareCalculator));
        } catch (FareException e) {
            System.out.println("Error => " + e.getMessage());
        }
    }
}

