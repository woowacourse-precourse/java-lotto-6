package lotto;

public class LottoController {
    private Player player;

    public void execute() {
        settingPlayer();
        player.buyLotto();
        player.outputLottoInfo();
        //TODO: 당첨번호 선정
        //TODO: 당첨 통계 출력
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
