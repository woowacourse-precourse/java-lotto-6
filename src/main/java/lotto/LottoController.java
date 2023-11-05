package lotto;

public class LottoController {
    private final Communicator communicator;

    public LottoController(Communicator communicator) {
        this.communicator = communicator;
    }

    public void run() {
        try {
            communicator.instructBuy();
        } catch (IllegalArgumentException exception) {
            communicator.printException(exception);
            run();
        }
    }
}
