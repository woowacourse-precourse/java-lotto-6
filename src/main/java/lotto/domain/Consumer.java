package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Consumer {
    private final Lotto userNumbers;
    private final int bonusNumber;

    public Consumer(List<Integer> userNumber, int bonusNumber) {
        this.userNumbers = new Lotto(userNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getUserNumbers() {
        return userNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Consumer consumer = (Consumer) o;
        return bonusNumber == consumer.bonusNumber && Objects.equals(userNumbers, consumer.userNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userNumbers, bonusNumber);
    }
}
