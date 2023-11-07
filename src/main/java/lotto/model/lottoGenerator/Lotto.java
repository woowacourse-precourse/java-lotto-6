package lotto.model.lottoGenerator;
import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {

    }
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}