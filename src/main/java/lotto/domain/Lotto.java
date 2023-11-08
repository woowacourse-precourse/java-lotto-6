package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import lotto.constant.Condition;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = Randoms.pickUniqueNumbersInRange(Condition.MIN_DRAW_NUMBER, Condition.MAX_DRAW_NUMBER,
                Condition.SIX_WINNING_NUMBERS);
        sortNumbersAscending();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sortNumbersAscending();
    }

    private void validate(List<Integer> numbers) {
        Procedure.DRAW_WINNING_NUMBERS.checkPossibleError(numbers);
    }

    // TODO: 추가 기능 구현
    private void sortNumbersAscending(){
        Collections.sort(numbers);
    }

    public int compareLottoWithWinningNumber(Lotto WinningNumbers){
        return (int) WinningNumbers.numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public boolean compareLottoWithBonusNumber(int bonusNumber){
        return this.numbers.contains(bonusNumber);
    }

    public String seeLottoNumber(){
        return numbers.toString();
    }
}
