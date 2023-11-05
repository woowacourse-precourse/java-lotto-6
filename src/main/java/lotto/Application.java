package lotto;

public class Application {
    public static void main(String[] args) {
        Screen.printAskingPurchasingAmountMessage();
        Lottos lottos = buyLottos();
        Screen.printAllLottos(lottos.getLottos());
        Screen.printAskingWinningNumbersMessage();
        Lotto winningNumber = selectLottoWinningNumber();

    }

    private static Lottos buyLottos() {
        try {
            return new Lottos(Screen.inputPurchasingAmount());
        }
        catch (IllegalArgumentException exception) {
            Screen.printErrorMessage(exception.getMessage());
        }
        return buyLottos();
    }

    private static Lotto selectLottoWinningNumber() {
        try {
            return new Lotto(Screen.inputWinningNumbers());
        }
        catch (IllegalArgumentException exception) {
            Screen.printErrorMessage(exception.getMessage());
        }
        return selectLottoWinningNumber();
    }
}
