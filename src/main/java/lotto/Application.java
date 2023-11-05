package lotto;

public class Application {
    public static void main(String[] args) {
        Screen.printAskingPurchasingAmountMessage();
        Lottos lottos = makeLottos();
        Screen.printAllLottos(lottos.getLottos());
    }

    private static Lottos makeLottos() {
        try {
            return new Lottos(Screen.inputPurchasingAmount());
        }
        catch (IllegalArgumentException exception) {
            Screen.printErrorMessage(exception.getMessage());
        }
        return makeLottos();
    }
}
