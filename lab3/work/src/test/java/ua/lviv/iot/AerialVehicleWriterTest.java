package ua.lviv.iot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.modules.AerialVehicle;
import ua.lviv.iot.modules.Drone;
import ua.lviv.iot.modules.EngineType;
import ua.lviv.iot.modules.Fighter;
import ua.lviv.iot.writer.AerialVehicleWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AerialVehicleWriterTest {
    Path expectedFile;
    Path testFile;
    private final String EXPECTED_PATH = "C:\\Java_lab\\work\\expected.csv";
    private final String TEST_PATH = "C:\\Java_lab\\work\\test.csv";
    AerialVehicleWriter writer = new AerialVehicleWriter();
    List<AerialVehicle> listOfAerialVehicle;

    @BeforeEach
    public void creation() throws IOException {
        listOfAerialVehicle = new ArrayList<>();
        Drone drone = new Drone("DJI", 50, EngineType.Electric, 5000, 4, 100, 200);
        Fighter fighter = new Fighter("F-14", 1300, EngineType.GasTurbine, 600, 400, 150, 350);
        listOfAerialVehicle.add(drone);
        listOfAerialVehicle.add(fighter);
        expectedFile = new File(EXPECTED_PATH).toPath();
        testFile = new File(TEST_PATH).toPath();
    }


    @Test
    public void nullListTest() throws IOException {
        assertNull(writer.writeToCsv(null, TEST_PATH));
        assertTrue(new File(TEST_PATH).exists());
    }
    @Test
    public void finalFileTest() throws IOException {
        writer.writeToCsv(listOfAerialVehicle, TEST_PATH);
        try (FileWriter writer = new FileWriter(EXPECTED_PATH)) {
            for (AerialVehicle aerialVehicle : listOfAerialVehicle) {
                String headers = aerialVehicle.getHeaders();
                writer.write(headers);
                String csvRow = aerialVehicle.toCSV();
                writer.write(csvRow);
            }
        }
        assertEquals(-1L, Files.mismatch(expectedFile, testFile));
    }
    @Test
    public void changeFileTest() throws IOException {
    FileWriter testWriter = new FileWriter(TEST_PATH);
    testWriter.write("something went wrong");
    testWriter.close();
    finalFileTest();
    }


}