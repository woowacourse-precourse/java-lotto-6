package lotto.model;

import lotto.utils.Validator;
import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public WinningLotto(String[] numbers, String bonusNumber) {
        Validator.DuplicateBonusNumber(numbers, bonusNumber);
        this.numbers = stringArrayToIntegerList(numbers);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }

    private List<Integer> stringArrayToIntegerList(String[] stringArray) {
        List<Integer> integerList = new ArrayList<>();
        for (String string : stringArray) {
            integerList.add(Integer.parseInt(string));
        }
        return integerList;
    }

}
