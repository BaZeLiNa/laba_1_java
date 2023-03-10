package ua.lviv.iot.algo.part1.lab1;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Helicopter {
    private int id = 100;
    private String model;
    private int currentAltitude;
    private int maxAltitude;
    private int fuelCapacity;
    private int currentFuel;
    public void takeOff(){
        this.currentAltitude = 100;
    }
    private static Helicopter instance = new Helicopter();
    public static Helicopter getInstance(){
        return instance;
    }
    public void ascend(int altitude){
        if(this.currentAltitude + altitude <= maxAltitude){
        this.currentAltitude += altitude;
        } else {
            System.out.println("More than max altitude");
        }
    }
    public void descend(int altitude){
        if((this.currentAltitude - altitude) >= 0){
            this.currentAltitude -= altitude;
        } else {
            this.currentAltitude =  0;
        }
    }
    public void refuel(int fuel){
        if((this.currentFuel + fuel) <= this.fuelCapacity){
            this.currentFuel += fuel;
        } else {
            this.currentFuel = this.fuelCapacity;
        }
    }

    public static void main(String[] args) {
    Helicopter[] helicopters = new Helicopter[4];
    helicopters[0] = new Helicopter();
    helicopters[1] = new Helicopter (200, "MI - 24", 0, 800, 200, 50);
    helicopters[2] = Helicopter.getInstance();
    helicopters[3] = Helicopter.getInstance();
    for (int i = 0; i < helicopters.length; i++){
        System.out.println(helicopters[i]);
    }
    }
}
