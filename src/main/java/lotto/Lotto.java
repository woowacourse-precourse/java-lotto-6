package lotto;

import java.util.List;

public class Lotto {
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

    public List<Integer> findMatches(List<Integer> winningNumbers, int bonusNumber) {

        int matchNumberCount = 0;
        int bonusNumberMatchCheck = 0;

        for (int winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                matchNumberCount++;
            }
        }
        if (numbers.contains(bonusNumber)) {
            bonusNumberMatchCheck = 1;
        }
        return List.of(matchNumberCount, bonusNumberMatchCheck);
    }

    public void printNumbers() {
        System.out.print("[" + numbers.get(0));
        for (int i = 1; i < numbers.size(); i++) {
            System.out.print(", " + numbers.get(i));
        }
        System.out.println("]");
    }
}
