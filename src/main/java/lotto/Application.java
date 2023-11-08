package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Ui ui = new Ui();

        Controller controller = new Controller(ui);
        controller.run();

    }
}
