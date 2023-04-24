package ua.lviv.iot.writer;

import ua.lviv.iot.modules.AerialVehicle;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AerialVehicleWriter {
    public List<AerialVehicle> writeToCsv(List<AerialVehicle> aerialVehicles, String fileName) throws IOException {
        if(aerialVehicles == null) return null;
        try (FileWriter writer = new FileWriter(fileName)) {
            for (AerialVehicle aerialVehicle : aerialVehicles) {
                String headers = aerialVehicle.getHeaders();
                writer.write(headers);
                String csvRow = aerialVehicle.toCSV();
                writer.write(csvRow);
            }
            System.out.println("Data is written to the file " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file " + fileName + ": " + e.getMessage());
        }
        return aerialVehicles;
    }


}
