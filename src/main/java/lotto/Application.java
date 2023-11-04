package lotto;

public class Application {
    public static void main(String[] args) {
        Screen.printPurchasingAmount();
        Game game = new Game(Screen.inputPurchasingAmount() / 1000);
        Screen.printAllLottos(game.getLottos());
    }
}
