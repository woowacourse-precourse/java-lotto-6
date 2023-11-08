package lotto.domain;

public class LottoPlayer {

    private int purchaseAmount;
    private Lotto[] lottos;

    public LottoPlayer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        createLottos();
    }

    private void createLottos() {
        lottos = new Lotto[purchaseAmount / LottoConfiguration.UNIT];
        for (int i = 0; i < lottos.length; i++) {
            lottos[i] = new Lotto(NumberGenerator.generateNumbers());
        }
    }
}
