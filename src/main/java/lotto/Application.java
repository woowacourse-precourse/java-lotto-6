package lotto;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(Configuration.lottoFactory());

        controller.run();
    }
}
