package lotto.numbermaker;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.WinLotto;

import java.util.List;

public class ExpectedNumberMaker implements NumberMaker{

    private List<Integer> numbers;

    public ExpectedNumberMaker(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generateNumbers() {
        return numbers;
    }
}
