package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private int purchaseAmount;
    private List<Lotto> lottos = new ArrayList<>();

    public Player(int purchaseAmount) {
        // 구입 금액 검증
        this.purchaseAmount = purchaseAmount;
        generateLottos();
    }

    public int getNumberOfPurchases() {
        return purchaseAmount / LOTTO_PRICE;
    }

    private void generateLottos() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        int numberOfPurchases = getNumberOfPurchases();

        for (int i = 0; i < numberOfPurchases; i++)
            lottos.add(new Lotto(lottoNumberGenerator.generateLottoNumbers()));

    }

    public double calculateRateOfReturn(int totalPrizeMoney) {
        return ((double) totalPrizeMoney / (double) purchaseAmount) * PERCENTAGE;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
