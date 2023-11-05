package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.exception.ErrorMessage.*;
import static lotto.exception.InputNumberException.*;
import static lotto.exception.LottoNumberException.*;
import static lotto.util.NumberConstant.*;

public class WinningLotto {
    private final List<Integer> numbers;
    private Integer bonusNumber;

    public WinningLotto(List<String> input) {
        inputValidate(input);
        this.numbers = input.stream()
                .map(Integer::valueOf)
                .toList();
        lottoValidate(numbers);
    }

    public void plusBonusNumber(List<String> bonus) {
        inputValidate(bonus);
        Integer number = Integer.parseInt(bonus.get(0));
        numberDuplicateValidate(number);
        this.bonusNumber = number;
    }

    private void numberDuplicateValidate(Integer number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ERROR.getMessage() + BONUS_DUPLICATE.getMessage());
        }
    }

    public List<Rank> judgeLottoGame(List<Lotto> allLotto) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lotto : allLotto) {
            List<Integer> target = lotto.getLottoNumbers();
            Integer countNum = countWinningNumber(target);

            if (checkBonus(countNum, target)) {
                countNum = SECOND_NUMBER_NUM;
            }
            ranks.add(Rank.resultRank(countNum));
        }
        return ranks;
    }

    private Integer countWinningNumber(List<Integer> target) {
        int count = 0;

        for (Integer num : target) {
            if (numbers.contains(num)) {
                count += 1;
            }
        }
        return count;
    }

    private boolean checkBonus(Integer countNum, List<Integer> target) {
        return countNum.equals(THIRD_NUMBER_NUM) && target.contains(bonusNumber);
    }
}
