package lotto.domain;

public class LottoPlayer {

    private int purchaseAmount, count;
    private Lotto[] lottos;

    public LottoPlayer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        count = purchaseAmount / LottoConfiguration.UNIT;
        System.out.println("count = " + count);
        createLottos();
    }

    private void createLottos() {
        lottos = new Lotto[count];
        for (int i = 0; i < lottos.length; i++) {
            lottos[i] = new Lotto(NumberGenerator.generateNumbers());
        }
    }

    public int getCount() {
        return count;
    }

    public Lotto[] getLottos() {
        return lottos;
    }
}
