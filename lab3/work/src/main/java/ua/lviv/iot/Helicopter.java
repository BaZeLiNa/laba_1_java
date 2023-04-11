package ua.lviv.iot;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class Helicopter extends AerialVehicle {
    private int id = 100;
    private String model;
    private int currentAltitude;
    private int maxAltitude;
    private int fuelCapacity;
    private int currentFuel;
    private int fuelConsumptionInLitersPerHour;
    private int maxWeaponWeight;
    private int maxCargoWeight;

    public Helicopter(String manufacturer, int maxSpeed, EngineType engineType, int id, String model,
                      int currentAltitude, int maxAltitude, int fuelCapacity, int currentFuel,
                      int fuelConsumptionInLitersPerHour, int maxWeaponWeight, int maxCargoWeight) {
        super(manufacturer, maxSpeed, engineType);
        this.id = id;
        this.model = model;
        this.currentAltitude = currentAltitude;
        this.maxAltitude = maxAltitude;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = currentFuel;
        this.fuelConsumptionInLitersPerHour = fuelConsumptionInLitersPerHour;
        this.maxWeaponWeight = maxWeaponWeight;
        this.maxCargoWeight = maxCargoWeight;
    }

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


    @Override
    public int getMaxFlyingDistance() {
        return ((fuelCapacity / fuelConsumptionInLitersPerHour) * maxSpeed);
    }

    @Override
    public int getMaxDeliveryWeight() {
        return maxCargoWeight + maxWeaponWeight;
    }
}
