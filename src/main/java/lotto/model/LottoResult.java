package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.constant.Prize;

public class LottoResult {

    private final List<Prize> prizes = new ArrayList<>();
    private Integer totalMoney = 0;

    public LottoResult() {}

    public LottoResult(Prize prize) {
        prizes.add(prize);
        totalMoney += prize.getReward();
    }

    public LottoResult addResult(LottoResult lottoResult) {
        this.prizes.addAll(lottoResult.prizes);
        this.totalMoney += lottoResult.totalMoney;

        return this;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public Integer getPrizeCount(Prize prize) {
        return Collections.frequency(prizes, prize);
    }
}
