class NeedForSpeed {

    private static final int NITRO_BATTERY_DRAIN = 4;
    private static final int NITRO_SPEED = 50;
    private int speedInMeters = 0;
    private int batteryDrain = 0;
    private int distanceDriven = 0;
    private int remainingBattery = 100;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speedInMeters = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return remainingBattery < batteryDrain;
    }

    public int distanceDriven() {
        return distanceDriven;
    }

    public void drive() {
        if (remainingBattery >= batteryDrain) {
            distanceDriven += speedInMeters;
            remainingBattery -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        NeedForSpeed nfs = new NeedForSpeed(NITRO_SPEED, NITRO_BATTERY_DRAIN);
        return nfs;
    }

    public int getSpeed() {
        return this.speedInMeters;
    }

    public int getBatteryDrain() {
        return this.batteryDrain;
    }
}

class RaceTrack {
    private int distance = 0;
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        return distance <= ((100/car.getBatteryDrain())*car.getSpeed());
    }
}
