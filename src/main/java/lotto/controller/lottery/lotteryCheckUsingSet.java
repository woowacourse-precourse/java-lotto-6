package lotto.controller.lottery;

import lotto.domain.Lotto;
import lotto.lottoenum.LottoRanking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lotteryCheckUsingSet implements Lottery{
    @Override
    public LottoRanking lotteryCheck(Lotto answer,Lotto myNumbers, int bonus) {
        LottoRanking lottoRanking = LottoRanking.DEFAULT;

        Set<Integer> lottoSelf = new HashSet<>(myNumbers.getLottoDetail());
        Set<Integer> lottoAnswer = new HashSet<>(answer.getLottoDetail());
        Set<Integer> commonNum = new HashSet<>(lottoSelf);
        commonNum.retainAll(lottoAnswer);

        if(commonNum.size() == 5){
            return getSecondOrThird(bonus, answer.getLottoDetail());
        }
        return lottoRanking.findByValue(commonNum.size());
    }
    private LottoRanking getSecondOrThird(int bonus, List<Integer> answer) {
        if(answer.contains(bonus)) {
            return LottoRanking.SECOND;
        }
        return LottoRanking.THIRD;
    }
}
