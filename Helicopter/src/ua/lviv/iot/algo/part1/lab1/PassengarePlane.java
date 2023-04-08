package ua.lviv.iot.algo.part1.lab1;

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
public class PassengarePlane extends AerialVehicle {
    private int maxCargoWeight;
    private int maxPassengersWeight;
    private int fuelCapacity;
    private int fuelConsumptionInLitersPerHour;
    private int currentFuel;

    public PassengarePlane(String manufacturer, int maxSpeed, EngineType engineType,
                           int maxCargoWeight, int maxPassengersWeight, int fuelCapacity,
                           int fuelConsumptionInLitersPerHour, int currentFuel) {
        super(manufacturer, maxSpeed, engineType);
        this.maxCargoWeight = maxCargoWeight;
        this.maxPassengersWeight = maxPassengersWeight;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumptionInLitersPerHour = fuelConsumptionInLitersPerHour;
        this.currentFuel = currentFuel;
    }

    public boolean fuelDumping(int distanceToBase) {
        int fuelRequired = (distanceToBase / maxSpeed) * fuelConsumptionInLitersPerHour;
        if (fuelRequired > currentFuel) {
            this.currentFuel = fuelRequired;
            return true;
        } else return false;
    }

    public int remainingDistance() {
        return ((currentFuel / fuelConsumptionInLitersPerHour) * maxSpeed);
    }

    @Override
    protected int getMaxFlyingDistance() {
        return ((fuelCapacity / fuelConsumptionInLitersPerHour) * maxSpeed);
    }

    @Override
    protected int getMaxDeliveryWeight() {
        return maxPassengersWeight + maxCargoWeight;
    }
}
