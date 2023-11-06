package lotto;

public class LottoController {
    private Player player;

    public void execute() {
        settingPlayer();
    }

    private void settingPlayer() {
        this.player = initPlayer();
    }

    private Player initPlayer() {
        while (true) {
            try {
                int purchaseAmount = PromptHandler.inputPurchaseAmount();
                return Player.initialize(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
