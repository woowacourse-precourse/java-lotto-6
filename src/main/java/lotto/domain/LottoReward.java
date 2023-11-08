package lotto.domain;

public class LottoReward {
    private final LottoStatistic lottoStatistic;

    public LottoReward(LottoStatistic lottoStatistic) {
        this.lottoStatistic = lottoStatistic;
    }

    private int getReward(LottoResult lottoResult) {
        return RewardConfiguration.getReward(lottoResult);
    }

    public int claim() {
        return lottoStatistic.getLottoStatistic().entrySet().stream()
                .mapToInt(entry -> (int) (getReward(entry.getKey()) * entry.getValue()))
                .sum();
    }
}
