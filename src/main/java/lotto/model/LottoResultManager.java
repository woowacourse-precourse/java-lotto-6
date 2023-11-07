package lotto.model;

import java.util.List;

public class LottoProfit {
    //enum은 == 으로 비교!

    private List<Lotto> lottos;
    private JudgePolicy lottoJudgePolicy;
    private List<String> lottoResults;

    public LottoProfit(List<Lotto> lottos, LottoJudgePolicy lottoJudgePolicy) {
        this.lottos = lottos;
        this.lottoJudgePolicy = lottoJudgePolicy;
    }

}
