package lotto;

public class LottoGame {
    Input input = new Input();
    int purchaseAmount = 0;

    public void playLottoGame() {
        purchaseAmount = input.inputPurchaseAmount();
    }
}
