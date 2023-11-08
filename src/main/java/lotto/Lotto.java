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

    // TODO: 추가 기능 구현
    public int countCollectNumbers(List<Integer> collectNumbers) {
        List<Integer> myNumbers = numbers;

        myNumbers.retainAll(collectNumbers);

        return myNumbers.size();
    }

    public int getFirst(int collectCount, int bonusNumber) {
        if (collectCount == 6) {
            return 0;
        }

        return getSecondAndThird(collectCount, bonusNumber);
    }

    public int getSecondAndThird(int collectCount, int bonusNumber) {
        if (collectCount == 5) {
            if (numbers.contains(bonusNumber)) {
                return 1;
            }

            return 2;
        }

        return getFourth(collectCount);
    }

    public int getFourth(int collectCount) {
        if (collectCount == 4) {
            return 3;
        }

        return getFifth(collectCount);
    }

    public int getFifth(int collectCount) {
        if (collectCount == 3) {
            return 4;
        }

        return getNone();
    }

    public int getNone() {

        return 5;
    }
}
