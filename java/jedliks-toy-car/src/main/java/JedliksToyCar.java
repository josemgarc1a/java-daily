public class JedliksToyCar {

    private static final String DISTANCE_DRIVEN_MESSAGE = "Driven %s meters";
    private static final String REMAINING_BATTERY = "Battery at %d%%";
    private static final String EMPTY_BATTERY = "Battery empty";

    private int battery = 100;
    private int distanceDriven=0;

    public static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    public String distanceDisplay() {
        return DISTANCE_DRIVEN_MESSAGE.formatted(distanceDriven);
    }

    public String batteryDisplay() {
        if (battery<=0) {return EMPTY_BATTERY;}
        return REMAINING_BATTERY.formatted(battery);
    }

    public void drive() {
        if(battery>0) {
            distanceDriven+=20;
            battery--;
        }
        
    }
}
