public class Main {

    final static int TOY_WORK_COMPLETION_TIME = 2000;

    public static void main(String[] args) {

        ToggleSwitchToy toggleSwitchToy = new ToggleSwitchToy();
        Thread userThread = new Thread(toggleSwitchToy::switchOn, "User");
        Thread toyThread = new Thread(toggleSwitchToy::switchOff, "Toy");

        toyThread.start();
        userThread.start();

        try {
            userThread.join();
            Thread.sleep(TOY_WORK_COMPLETION_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!userThread.isAlive()) {
            toyThread.interrupt();
        }
    }
}
