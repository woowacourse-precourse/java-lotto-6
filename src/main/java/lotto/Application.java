package lotto;

public class Application {
    public static void main(String[] args) {
        Game game = initGame();
    }

    private static Game initGame() {
        Screen.printAskingPurchasingAmountMessage();
        Game game = new Game(Screen.inputPurchasingAmount() / 1000);
        Screen.printAllLottos(game.getLottos());
        Screen.printAskingWinningNumbersMessage();
        Lotto winningLotto = Screen.inputWinningNumbers();
        Screen.printAskingBonusNumberMessage();
        game.setLottoNumbers(winningLotto, Screen.inputBonusNumber(winningLotto));
        return game;
    }
}
