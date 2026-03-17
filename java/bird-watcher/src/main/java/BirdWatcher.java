
class BirdWatcher {
    private final int[] birdsPerDay;
    private static final int[] LAST_WEEK_COUNT = {0, 2, 5, 3, 7, 8, 4};
    private static final int BUSY_DAY_THRESHOLD = 5;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return LAST_WEEK_COUNT;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int i : birdsPerDay) {
            if (i == 0) {
                return true;
            }
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int count = 0;
        for (int i=0; i<numberOfDays && i<birdsPerDay.length; i++) {
            count += birdsPerDay[i];
        }
        return count;
    }

    public int getBusyDays() {
        int count = 0;
        for (int i=0; i<birdsPerDay.length; i++) {
            if (birdsPerDay[i] >= BUSY_DAY_THRESHOLD) {
                count++;
            }
        }
        return count;
    }
}
