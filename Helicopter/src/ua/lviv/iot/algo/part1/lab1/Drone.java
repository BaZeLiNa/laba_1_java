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
public class Drone extends AerialVehicle {
    private int batteryCapacityIn_mAh;
    private double chargeConsumpingPerMinuteInPercentage;
    private int maxWeaponWeightInGrams;
    private int maxCargoWeightInGrams;
    private final int maxBatteryCapacityInPercentage = 100;

    public Drone(String manufacturer, int maxSpeed, EngineType engineType, int batteryCapacityIn_mAh,
                 double chargeConsumpingPerMinuteInPercentage,
                 int maxWeaponWeightInGrams, int maxCargoWeightInGrams) {
        super(manufacturer, maxSpeed, engineType);
        this.batteryCapacityIn_mAh = batteryCapacityIn_mAh;
        this.chargeConsumpingPerMinuteInPercentage = chargeConsumpingPerMinuteInPercentage;
        this.maxWeaponWeightInGrams = maxWeaponWeightInGrams;
        this.maxCargoWeightInGrams = maxCargoWeightInGrams;
    }

    public int getMaxFlyingDistance() {
        return (int) (maxSpeed * (maxBatteryCapacityInPercentage / chargeConsumpingPerMinuteInPercentage));
    }

    public int getMaxDeliveryWeight() {
        return maxCargoWeightInGrams + maxWeaponWeightInGrams;
    }

}