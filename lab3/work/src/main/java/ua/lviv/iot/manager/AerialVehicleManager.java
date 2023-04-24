package ua.lviv.iot.manager;

import lombok.*;
import ua.lviv.iot.modules.*;
import ua.lviv.iot.writer.AerialVehicleWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class AerialVehicleManager {
    private List<AerialVehicle> aerialVehicles = new ArrayList<>();

    public void addAerialVehicle(AerialVehicle aerialVehicle) {
        this.aerialVehicles.add(aerialVehicle);
    }

    public List<AerialVehicle> findSpeedGreaterThan(int speed) {
        return aerialVehicles.stream()
                .filter(AerialVehicle -> AerialVehicle.getMaxSpeed() <= speed)
                .collect(Collectors.toList());
    }

    public List<AerialVehicle> findByEngineType(EngineType engineType) {
        return aerialVehicles.stream()
                .filter(AerialVehicle -> AerialVehicle.getEngineType() == engineType)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        AerialVehicleManager aerialVehicleManager = new AerialVehicleManager();
        aerialVehicleManager.addAerialVehicle(new Helicopter("Boeing", 120, EngineType.Piston, 200, "CH-47", 0, 3000, 600, 560, 35, 600, 500));
        aerialVehicleManager.addAerialVehicle(new Helicopter("Bell", 150, EngineType.Piston, 300, "UH-1", 1200, 2200, 500, 300, 40, 400, 300));
        aerialVehicleManager.addAerialVehicle(new Drone("DJI", 50, EngineType.Electric, 5000, 4, 100, 200));
        aerialVehicleManager.addAerialVehicle(new Drone("DJI 2", 30, EngineType.Electric, 6000, 2, 0, 500));
        aerialVehicleManager.addAerialVehicle(new Fighter("F-14", 1300, EngineType.GasTurbine, 600, 400, 150, 350));
        aerialVehicleManager.addAerialVehicle(new Fighter("F-16", 1500, EngineType.GasTurbine, 700, 600, 140, 600));
        aerialVehicleManager.addAerialVehicle(new PassengarePlane("Boeing 747", 800, EngineType.GasTurbine, 25000, 10000, 40000, 400, 25000));
        aerialVehicleManager.addAerialVehicle(new PassengarePlane("Boeing 737", 700, EngineType.GasTurbine, 20000, 15000, 30000, 500, 28000));
        for (var aerialVehicle : aerialVehicleManager.aerialVehicles) {
            System.out.println(aerialVehicle);
        }
        System.out.println("\n\nAerial vehicle faster than 200 km/h:");
        var vehiclesSpeedGreaterThan = aerialVehicleManager.findSpeedGreaterThan(200);
        vehiclesSpeedGreaterThan.stream().forEach(System.out::println);

        System.out.println("\n\nElectric aerial vehicle:");
        var electricAerialVehicle = aerialVehicleManager.findByEngineType(EngineType.Electric);
        electricAerialVehicle.stream().forEach(System.out::println);

        List<AerialVehicle> aerialVehicles = aerialVehicleManager.aerialVehicles;
        AerialVehicleWriter aerialVehicleWriter = new AerialVehicleWriter();
        aerialVehicleWriter.writeToCsv(aerialVehicles,"aerialVehicles.csv");
    }
}


