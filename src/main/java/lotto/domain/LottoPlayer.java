package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoPlayer {

    private int purchaseAmount, count, profit;
    private Lotto[] lottos;

    public LottoPlayer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.count = purchaseAmount / LottoConfiguration.UNIT;
        this.profit = 0;
        createLottos();
    }

    private void createLottos() {
        lottos = new Lotto[count];
        for (int i = 0; i < lottos.length; i++) {
            System.out.println("생성 시작");
            lottos[i] = new Lotto(Randoms.pickUniqueNumbersInRange(LottoConfiguration.NUMBER_RANGE_START, LottoConfiguration.NUMBER_RANGE_END, LottoConfiguration.NUMBERS_SIZE));
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getCount() {
        return count;
    }

    public Lotto[] getLottos() {
        return lottos;
    }

    public int getProfit() {
        return profit;
    }

    public void addProfit(int profit) {
        this.profit +=profit;
    }
}
