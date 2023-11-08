package lotto.domain.service;

import lotto.domain.model.Bonus;
import lotto.domain.model.Lotto;
import lotto.domain.model.Result;

import java.util.List;

public class LottoService {
    public Result checkLotto(Lotto generatedLotto, Lotto lotto, Bonus bonus) {
        int count = 0;
        List<Integer> generatedNumbers = generatedLotto.getNumbers();
        List<Integer> numbers = lotto.getNumbers();
        count = matchGeneratedNumbersAndNumbers(count, generatedNumbers, numbers);
        if (count != 6) {
            count = matchGeneratedNumbersAndBonusNumber(count, generatedNumbers, bonus);
            if (count == 6) {
                return new Result(count, true);
            }
        }
        return new Result(count, false);
    }

    private int matchGeneratedNumbersAndNumbers(int count, List<Integer> generatedNumbers, List<Integer> numbers) {
        for (Integer generatedNumber : generatedNumbers) {
            count = matchGeneratedNumberAndNumber(count, numbers, generatedNumber);
        }
        return count;
    }

    private int matchGeneratedNumbersAndBonusNumber(int count, List<Integer> generatedNumbers, Bonus bonus) {
        Integer number = bonus.getNumber();
        for (Integer generatedNumber : generatedNumbers) {
            if (generatedNumber.equals(number)) {
                count++;
                break;
            }
        }
        return count;
    }

    private int matchGeneratedNumberAndNumber(int count, List<Integer> numbers, Integer generatedNumber) {
        for (Integer number : numbers) {
            if (generatedNumber.equals(number)) {
                count++;
            }
        }
        return count;
    }
}
