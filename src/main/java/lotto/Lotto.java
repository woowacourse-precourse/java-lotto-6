package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final Bonus bonus;

    public Lotto(List<Integer>numbers) {
        this(numbers, new Bonus());
    }

    public Lotto(List<Integer> numbers, Bonus bonus) {
        validate(numbers);
        this.numbers = numbers;
        this.bonus = bonus;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDistinct(numbers);
    }

    public String toTextFormat() {
        StringBuilder sb = new StringBuilder("[");
        numbers.forEach(number -> sb.append(number)
                .append(", "));
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }

    public boolean isJackpotLotto() {
        return bonus.isJackpot() ;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자로 되어있어야 합니다.");
        }
    }

    private void validateDistinct(List<Integer> numbers) {

    }
}
