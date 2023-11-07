package lotto;

public class LottoGame {
    Input input = new Input();
    int purchasePrice = 0;

    public void playLottoGame() {
        purchasePrice = input.inputPurchasePrice();
    }
}
