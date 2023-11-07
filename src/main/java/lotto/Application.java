package lotto;

public class Application {
    public static void main(String[] args) {
        LottoSimulator simulator = new LottoSimulator();
        try {
            simulator.run();
        } catch (IllegalArgumentException exception) {
            String message = exception.getMessage();
            System.out.println("[ERROR] " + message);
        }
    }
}
