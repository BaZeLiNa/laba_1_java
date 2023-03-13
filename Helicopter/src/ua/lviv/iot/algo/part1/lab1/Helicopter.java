package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Helicopter {
    private int id = 100;
    private String model;
    private int currentAltitude;
    private int maxAltitude;
    private int fuelCapacity;
    private int currentFuel;

    public void takeOff() {
        this.currentAltitude = 100;
    }

    private static Helicopter instance = new Helicopter();

    public static Helicopter getInstance() {
        return instance;
    }

    public void ascend(int altitude) {
        if (this.currentAltitude + altitude <= maxAltitude) {
            this.currentAltitude += altitude;
        }
    }

    public void descend(int altitude) {
        if ((this.currentAltitude - altitude) >= 0) {
            this.currentAltitude -= altitude;
        } else {
            this.currentAltitude = 0;
        }
    }

    public void refuel(int fuel) {
        if ((this.currentFuel + fuel) <= this.fuelCapacity) {
            this.currentFuel += fuel;
        } else {
            this.currentFuel = this.fuelCapacity;
        }
    }

    public static void main(String[] args) {
        Helicopter[] helicopters = {
                new Helicopter(),
                new Helicopter(200, "MI-24", 0, 800, 200, 50),
                Helicopter.getInstance(),
                Helicopter.getInstance()
        };

        for (Helicopter helicopter : helicopters) {
            System.out.println(helicopter.toString());
        }
    }
}
