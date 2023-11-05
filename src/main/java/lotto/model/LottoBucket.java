package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.common.config.LottoGameRule;

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
        return lottoBucket.get(index);
    }

    public String showLottoBucket() {
        StringBuilder shownLottoBucket = new StringBuilder(lottoAmount * LottoGameRule.LOTTO_NUMBERS_SIZE.constant());
        for (Lotto lotto : lottoBucket) {
            shownLottoBucket.append(lotto.showNumbers()).append("\n");
        }
        return shownLottoBucket.toString();
    }
}
