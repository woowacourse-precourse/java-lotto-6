package lotto.util;

public class Logger {
        public static void info(String message) {
                System.out.println(message);
        }

        public static void error(String message) {
                System.out.println("[ERROR] " + message);
        }
}
