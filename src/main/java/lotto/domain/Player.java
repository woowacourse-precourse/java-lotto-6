package lotto.domain;

import lotto.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENTAGE = 100;

    private static final String SMALL_PURCHASE_AMOUNT_ERROR_MESSAGE = "로또 구입금액은 1,000원 이상이어야 합니다.";
    private static final String NOT_DIVIDE_1000_ERROR_MESSAGE = "로또 구입금액은 1,000원 단위로 입력해야 합니다.";


    private int purchaseAmount;
    private List<Lotto> lottos = new ArrayList<>();

    public Player(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
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

    public void validatePurchaseAmount(int purchaseAmount) {
        validateLeast1000(purchaseAmount);
        validateDivisibleBy1000(purchaseAmount);
    }

    public void validateLeast1000(int purchaseAmount) {
        if (purchaseAmount < LOTTO_PRICE)
            throw new IllegalArgumentException(SMALL_PURCHASE_AMOUNT_ERROR_MESSAGE);
    }

    public void validateDivisibleBy1000(int purchaseAmount) {
        if ((purchaseAmount % LOTTO_PRICE) != 0)
            throw new IllegalArgumentException(NOT_DIVIDE_1000_ERROR_MESSAGE);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
