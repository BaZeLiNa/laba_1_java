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
@ToString
public abstract class AerialVehicle {
    protected String manufacturer;
    protected int maxSpeed;
    protected EngineType engineType;

    protected abstract int getMaxFlyingDistance();

    protected abstract int getMaxDeliveryWeight();
}