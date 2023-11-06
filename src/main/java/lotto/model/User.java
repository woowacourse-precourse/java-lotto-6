package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.LottoConstant;
import lotto.constant.NumberConstant;

public class User {
    private final List<Integer> numbers;
    private final int bonus;

    public User(List<Integer> numbers, int bonus){
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public int getRightCount(List<Integer> lottoNumbers){
        int combineSize = getNumbersAddLotto(lottoNumbers).size();
        return NumberConstant.DOUBLE_LOTTO_RANGE - combineSize;
    }

    private Set<Integer> getNumbersAddLotto(List<Integer> lottoNumbers){
        Set<Integer> sNumbers = new HashSet<>(numbers);
        sNumbers.addAll(lottoNumbers);
        return sNumbers;
    }

    private boolean isRightBonus(List<Integer> lottoNumbers){
        return lottoNumbers.contains(bonus);
    }
}
