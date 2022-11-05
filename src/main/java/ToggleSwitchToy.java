public class ToggleSwitchToy {
    private final static int NUMBER_OF_SWITCHING_ON = 5;
    private final static int TIME_BETWEEN_SWITCHING_ON = 3000;
    private final static int TIME_OF_SWITCHING_OFF = 1500;
    private volatile boolean toggleSwitch;

    public void switchOn() {
        int i = NUMBER_OF_SWITCHING_ON;
        while (i != 0) {
            if (!toggleSwitch) {
                System.out.printf("%s switched on the toggle switch! Current position: %s\n",
                        Thread.currentThread().getName(), toggleSwitch = true);
                i--;
                try {
                    Thread.sleep(TIME_BETWEEN_SWITCHING_ON);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void switchOff() {
        while (!Thread.currentThread().isInterrupted()) {
            if (toggleSwitch) {
                try {
                    Thread.sleep(TIME_OF_SWITCHING_OFF);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("%s switched off the toggle switch! Current position: %s\n",
                        Thread.currentThread().getName(), toggleSwitch = false);
            }
        }
    }
}
