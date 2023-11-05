package lotto;

import lotto.lottoenum.LottoRanking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public LottoRanking lotteryCheck(List<Integer> answer, int bonus){
        LottoRanking lottoRanking = LottoRanking.DEFAULT;

        Set<Integer> lottoSelf = new HashSet<>(numbers);
        Set<Integer> lottoAnswer = new HashSet<>(answer);
        Set<Integer> commonNum = new HashSet<>(lottoSelf);
        commonNum.retainAll(lottoAnswer);

        if(commonNum.size() == 5){
            return getSecondOrThird(bonus, answer);
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
