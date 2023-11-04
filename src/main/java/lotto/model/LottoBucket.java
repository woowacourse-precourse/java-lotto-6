package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoBucket {
    private final int lottoAmount;
    private final List<Lotto> lottoBucket;

    public LottoBucket(int lottoAmount) {
        this.lottoAmount = lottoAmount;
        this.lottoBucket = createLottoBucket();
    }

    private List<Lotto> createLottoBucket() {
        List<Lotto> lottoBucket = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottoBucket.add(LottoCreator.createAutoLotto());
        }
        return lottoBucket;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    public Lotto getLotto(int index) {
        validateLottoIndex(index);
        return lottoBucket.get(index);
    }

    private void validateLottoIndex(int index) {
        if (index < 0 || index >= lottoAmount) {
            throw new ArrayIndexOutOfBoundsException("LottoBucketIndexOutOfBoundsException");
        }
    }
}
