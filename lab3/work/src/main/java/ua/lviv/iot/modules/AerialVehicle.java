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
@ToString
public abstract class AerialVehicle {
    public static final String HEADERS = "manufacturer, maxSpeed, engineType";
    protected String manufacturer;
    protected int maxSpeed;
    protected EngineType engineType;
    public String toCSV(){
        return manufacturer + ", " + maxSpeed + ", " + engineType;
    }

    public String getHeaders() {
        return HEADERS;
    }

    protected abstract int getMaxFlyingDistance();

    protected abstract int getMaxDeliveryWeight();
}