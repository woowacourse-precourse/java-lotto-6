package lotto.validation.winningnumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.validation.ValidationCondition;

public class WinningLottoDuplicateCondition extends ValidationCondition {

    private final int winningLottoSize;
    private static final String EXCEPTION_MSG = "우승 번호의 숫자가 중복됩니다. 다시확인해주세요";


    public WinningLottoDuplicateCondition(int winningLottoSize) {
        this.winningLottoSize = winningLottoSize;
    }

    @Override
    protected void validateCondition(Object obj) {
        Set<Integer> lottoSet = new HashSet<>((List<Integer>) obj);

        if (lottoSet.size() != winningLottoSize) {
            throw new IllegalArgumentException(ERROR_MSG + EXCEPTION_MSG);
        }
    }

    @Override
    protected boolean isObjectOf(Object obj) {
        return obj instanceof List;
    }
}
