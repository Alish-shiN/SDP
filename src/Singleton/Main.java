package Singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("First log message");
        logger.log("Second log message");
    }
}
