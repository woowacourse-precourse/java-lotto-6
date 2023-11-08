package lotto.config;

import java.util.List;

public enum PrizePolicyConfig {
    PRIZES(List.of(
        new LottoPrize(1, LottoConfig.END_LOTTO_NUM.getNum(), false, LottoConfig.FIRST_PRIZE.getNum()),
        new LottoPrize(2, LottoConfig.END_LOTTO_NUM.getNum() - 1, true, LottoConfig.SECOND_PRIZE.getNum()),
        new LottoPrize(3, LottoConfig.END_LOTTO_NUM.getNum() - 1, false, LottoConfig.THIRD_PRIZE.getNum()),
        new LottoPrize(4, LottoConfig.END_LOTTO_NUM.getNum() - 2, false, LottoConfig.FOURTH_PRIZE.getNum()),
        new LottoPrize(5, LottoConfig.END_LOTTO_NUM.getNum() - 3, false, LottoConfig.FIFTH_PRIZE.getNum())
    ));

    private List<LottoPrize> prizes;
    private PrizePolicyConfig(List<LottoPrize> prizes) {
        this.prizes = prizes;
    }

    public List<LottoPrize> getPrizes() {
        return prizes;
    }
}
