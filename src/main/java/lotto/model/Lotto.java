package lotto.model;

import java.util.List;
import lotto.utils.InputValidator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        InputValidator.checkLotto(numbers);
    }

    public void validateBonusNumber(String bonus) {
        InputValidator.checkBonusNumber(numbers, bonus);
    }

    public void showLotto() {
        System.out.println(numbers);
    }

    public int countMatchingNumber(Lotto userLotto) {
        return (int) numbers.stream().filter(userLotto::isContain).count();
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

}

