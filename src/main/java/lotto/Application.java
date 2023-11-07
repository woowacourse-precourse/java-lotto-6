package lotto;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        Service service = new Service();
        OutputView outputView = new OutputView();

        Controller controller = new Controller(inputView, service, outputView);
        controller.start();
    }
}
