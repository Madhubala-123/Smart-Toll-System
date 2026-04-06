import java.util.*;

class Vehicle {
    String number;
    ArrayList<Journey> journeys = new ArrayList<>();

    Vehicle(String number) {
        this.number = number;
    }
}

class Journey {
    String type;
    String start;
    String destination;
    int toll;

    Journey(String type, String start, String destination, int toll) {
        this.type = type;
        this.start = start;
        this.destination = destination;
        this.toll = toll;
    }
}