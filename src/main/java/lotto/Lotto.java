package lotto;

import lotto.View.ExceptionView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
public class Lotto {
    private final List<Integer> numbers;

    private List<List<Integer>> lottos;
    private String amount;
    private int bonus;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplication(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionView.sizeException();
            throw new IllegalArgumentException();
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
    public int getBonus() {
        return bonus;
    }
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public List<List<Integer>> getLottos() {
        return lottos;
    }
    public void setLottos(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    private void duplication(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>();
        for (Integer number : numbers) {
            if (!numberSet.add(number)) {
                ExceptionView.overlapException();
                throw new IllegalArgumentException();
            }
        }
    }
    // TODO: 추가 기능 구현
}
