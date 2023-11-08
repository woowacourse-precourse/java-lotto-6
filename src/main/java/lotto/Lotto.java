package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.Validator.LottoValidator;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> ret = new ArrayList<Integer>(numbers);
        ret.sort(null);
        return ret;
    }

    public int getHowManySameNumbers(Lotto compare) {
        int count = 0;
        for (int number = 0; number < numbers.size(); number++) {
            if (compare.getSortedNumbers().contains(numbers.get(number))) {
                count++;
            }
        }
        return count;
    }

    public boolean hasBonus(Lotto compare, int bonus) {
        List<Integer> compares = compare.getSortedNumbers();
        for (int number :
                compares) {
            if (this.numbers.contains(number)) {
                continue;
            }
            if (number == bonus) {
                return true;
            }
        }
        return false;
    }

}
