package lotto.model;

import java.util.List;
import lotto.model.varargs.VarArgsMaker;

public class Lotto implements VarArgsMaker {
    public static final String LOTTO_PRINT_FORMAT = "[%d, %d, %d, %d, %d, %d]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString(){
        return String.format(LOTTO_PRINT_FORMAT, this.numbers.toArray());
    }

    @Override
    public Object[] varArgs() {
        return numbers.toArray(Object[]::new);
    }
}
