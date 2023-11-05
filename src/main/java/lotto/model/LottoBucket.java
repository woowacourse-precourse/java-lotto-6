package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputMessage;

public class LottoBucket {
    private static final int SHOWN_LOTTO_BUCKET_INITIAL_LENGTH = 2;
    private final int lottoAmount;
    private final List<Lotto> lottoBucket;

    public LottoBucket(int lottoAmount) {
        this.lottoAmount = lottoAmount;
        this.lottoBucket = createLottoBucket();
    }

    private List<Lotto> createLottoBucket() {
        List<Lotto> lottoBucket = new ArrayList<>();
        for (int i = 0; i < lottoAmount; i++) {
            lottoBucket.add(LottoCreator.createRandomLotto());
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
        StringBuilder shownLottoBucket = new StringBuilder(SHOWN_LOTTO_BUCKET_INITIAL_LENGTH + lottoAmount);
        shownLottoBucket.setLength(0);
        shownLottoBucket.append(lottoAmount).append(OutputMessage.RESPONSE_PURCHASED_LOTTO_AMOUNT.message())
                .append("\n");
        for (Lotto lotto : lottoBucket) {
            shownLottoBucket.append(lotto.showNumbers()).append("\n");
        }
        return shownLottoBucket.toString();
    }
}
