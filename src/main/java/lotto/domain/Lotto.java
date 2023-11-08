package lotto.domain;

import static lotto.constants.ErrorMessage.DUPLICATED_NUMBER_MESSAGE;
import static lotto.constants.ErrorMessage.INVALID_INPUT_LENGTH_FORMAT;
import static lotto.constants.ErrorMessage.NUMBER_NOT_IN_RANGE_FORMAT;
import static lotto.constants.Common.LOTTO_TICKET_LENGTH;
import static lotto.constants.Common.MAXIMUM_LOTTO_NUMBER;
import static lotto.constants.Common.MINIMUM_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private boolean checkNumberInRange(int number) {
        return MINIMUM_LOTTO_NUMBER <= number && number <= MAXIMUM_LOTTO_NUMBER;
    }

    private boolean checkContainsDuplicatedNumber(List<Integer> inputSequence) {
        HashSet<Integer> checkDuplicate = new HashSet<>(inputSequence);
        return checkDuplicate.size() != LOTTO_TICKET_LENGTH;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(String.format(INVALID_INPUT_LENGTH_FORMAT, LOTTO_TICKET_LENGTH));
        }
        if (checkContainsDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_MESSAGE);
        }
        for (int number : numbers) {
            if (!checkNumberInRange(number)) {
                throw new IllegalArgumentException(String.format(NUMBER_NOT_IN_RANGE_FORMAT,
                    MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER));
            }
        }

    }

    public void printNumbers() {
        System.out.println(this.numbers);
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    public int countWinningNumber(Lotto winningTicket) {
        int sameCount = 0;
        for (int number : this.numbers) {
            if (winningTicket.contains(number)) {
                sameCount++;
            }
        }
        return sameCount;
    }
}
