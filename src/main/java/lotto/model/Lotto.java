package lotto.model;

import java.util.List;
import lotto.utils.InputValidator;
import lotto.utils.StringConvertor;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(String inputLotto) {
        List<Integer> numbers = stringToList(inputLotto);
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        InputValidator.checkLotto(numbers);
    }

    private List<Integer> stringToList(String input) {
        InputValidator.checkLottoNumberFormat(input);
        return StringConvertor.stringToList(input);
    }

    public void validateBonusNumber(String bonus) {
        InputValidator.checkBonusNumber(numbers, bonus);
    }

    public int countMatchingNumber(Lotto userLotto) {
        return (int) numbers.stream().filter(userLotto::isContain).count();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

}

