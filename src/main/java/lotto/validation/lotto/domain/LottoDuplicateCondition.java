package lotto.validation.lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.validation.ValidationCondition;

public class LottoDuplicateCondition extends ValidationCondition {
    private static final String EXCEPTION_MSG = "LottoDuplicate 중복되는 번호가 있습니다.";
    private int lottoSize;

    public LottoDuplicateCondition(int lottoSize) {
        this.lottoSize = lottoSize;
    }

    @Override
    protected void validateCondition(Object obj) {
        List<Integer> lotto = (List<Integer>) obj;
        Set<Integer> stringSet = new HashSet<Integer>(lotto);

        if (stringSet.size() != lottoSize) {
            throw new IllegalArgumentException(ERROR_MSG + EXCEPTION_MSG);
        }
    }

    @Override
    protected boolean isObjectOf(Object obj) {
        return obj instanceof List;
    }

}
