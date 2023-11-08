package lotto.numbermaker;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.WinLotto;

import java.util.List;

public class ExpectedNumberMaker implements NumberMaker{

    private List<Integer> numbers;
    private Integer bonus;

    public ExpectedNumberMaker(List<Integer> numbers, Integer bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    @Override
    public List<Integer> generateNumbers() {
        return numbers;
    }
}
