package lotto.Model;

import java.util.ArrayList;
import java.util.List;
import lotto.Controller.Exceptable;

public class Lotto {
    private final List<Integer> numbers;
    private Exceptable exceptable = new Exceptable();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        exceptable.validate6Nums(numbers);
        exceptable.validateDuplicateLottos(numbers);
        for (int num: numbers){
            exceptable.validate1to45(num);
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

}
