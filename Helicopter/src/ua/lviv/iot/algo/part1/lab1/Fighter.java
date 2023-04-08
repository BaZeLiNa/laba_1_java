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
public class Fighter extends AerialVehicle {
    private int maxWeaponWeight;
    private int fuelCapacity;
    private int fuelConsumptionInLitersPerHour;
    private int currentFuel;

    public Fighter(String manufacturer, int maxSpeed, EngineType engineType, int maxWeaponWeight, int fuelCapacity,
                   int fuelConsumptionInLitersPerHour, int currentFuel) {
        super(manufacturer, maxSpeed, engineType);
        this.maxWeaponWeight = maxWeaponWeight;
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumptionInLitersPerHour = fuelConsumptionInLitersPerHour;
        this.currentFuel = currentFuel;
    }

    public void refuel(int fuel) {
        if ((this.currentFuel + fuel) <= this.fuelCapacity) {
            this.currentFuel += fuel;
        } else {
            this.currentFuel = this.fuelCapacity;
        }
    }

    public boolean fuelDumping(int distanceToBase) {
        int fuelRequired = (distanceToBase / maxSpeed) * fuelConsumptionInLitersPerHour;
        if (fuelRequired > currentFuel) {
            this.currentFuel = fuelRequired;
            return true;
        } else return false;
    }

    @Override
    protected int getMaxFlyingDistance() {
        return ((fuelCapacity / fuelConsumptionInLitersPerHour) * maxSpeed);
    }

    @Override
    protected int getMaxDeliveryWeight() {
        return maxWeaponWeight;
    }
}
