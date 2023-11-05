package lotto;

public class Application {
    public static void main(String[] args) {
        Lottos lottos;
        Lotto winningNumber;


        Screen.printAskingPurchasingAmountMessage();
        lottos = makeLottos();
        Screen.printAllLottos(lottos.getLottos());
        Screen.printAskingWinningNumbersMessage();
        winningNumber = Screen.inputWinningNumbers();
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
