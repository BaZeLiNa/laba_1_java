package ua.lviv.iot.modules;

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
    public static final String HEADERS = "batteryCapacityIn_mAh, chargeConsumpingPerMinuteInPercentage, maxWeaponWeightInGrams, maxCargoWeightInGrams, maxBatteryCapacityInPercentage";
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
    @Override
    public String toCSV(){
        return super.toCSV() + ", " + batteryCapacityIn_mAh + ", " + chargeConsumpingPerMinuteInPercentage + ", " + maxWeaponWeightInGrams + ", " + maxCargoWeightInGrams + ", " + maxBatteryCapacityInPercentage + "\n";
    }
    @Override
    public String getHeaders(){
        return super.getHeaders() + ", " + HEADERS + "\n";
    }
    @Override
    public int getMaxFlyingDistance() {
        return (int) (maxSpeed * (maxBatteryCapacityInPercentage / chargeConsumpingPerMinuteInPercentage));
    }

    @Override
    public int getMaxDeliveryWeight() {
        return maxCargoWeightInGrams + maxWeaponWeightInGrams;
    }

}