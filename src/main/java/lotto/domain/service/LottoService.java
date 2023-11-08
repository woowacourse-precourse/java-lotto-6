package lotto.domain.service;

import lotto.domain.model.Bonus;
import lotto.domain.model.Lotto;
import lotto.domain.model.Receipt;
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

    public Receipt calculateLottoRate(int price, List<Result> results) {
        int profit = 0;
        Receipt receipt = new Receipt();
        List<Integer> counts = receipt.getCounts();
        for (Result result : results) {
            int count = result.getCount();
            boolean isIncludeBonus = result.getIsIncludeBonus();
            if (count == 3) {
                profit += 5000;
                counts.set(0, counts.get(0) + 1);
            } else if (count == 4) {
                profit += 50000;
                counts.set(1, counts.get(1) + 1);
            } else if (count == 5) {
                profit += 1500000;
                counts.set(2, counts.get(2) + 1);
            } else if (count == 6) {
                if (isIncludeBonus) {
                    profit += 30000000;
                    counts.set(3, counts.get(3) + 1);
                } else {
                    profit += 2000000000;
                    counts.set(4, counts.get(4) + 1);
                }
            }
        }
        double rate = Math.round(((double) profit / price) * 1000) / 10.0;
        receipt.setRate(rate);
        return receipt;
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
