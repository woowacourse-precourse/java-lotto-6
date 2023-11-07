package domain;

import static util.ErrorMessage.LOTTO_NUMBER_IS_UNIQUE;
import static util.ErrorMessage.LOTTO_NUMBER_RANGE;
import static util.ErrorMessage.LOTTO_TAKE_SIX_NUMBERS;
import static util.LottoValidationValue.LOTTO_NUMBER_COUNT;
import static util.LottoValidationValue.LOTTO_NUMBER_MAXIMUM;
import static util.LottoValidationValue.LOTTO_NUMBER_MINIMUM;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = makeLottoNumbers();
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = validate(numbers);
    }

    private List<Integer> validate(List<Integer> numbers) {
        if (!checkSize(numbers)) {
            return null;
        }
        if (!checkNoDuplication(numbers)) {
            return null;
        }
        if (!checkValidNumberRange(numbers)) {
            return null;
        }
        return numbers;
    }

    private boolean checkSize(List<Integer> numbers) {
        try {
            if (numbers.size() != LOTTO_NUMBER_COUNT.get()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(LOTTO_TAKE_SIX_NUMBERS.get());
            return false;
        }
        return true;
    }

    private boolean checkNoDuplication(List<Integer> numbers) {
        try {
            if (numbers.size() != numbers.stream().distinct().count()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(LOTTO_NUMBER_IS_UNIQUE.get());
            return false;
        }
        return true;
    }

    private boolean checkValidNumberRange(List<Integer> numbers) {
        try {
            if(!checkRange(numbers)){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(LOTTO_NUMBER_RANGE.get());
            return false;
        }
        return true;
    }

    private boolean checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_NUMBER_MINIMUM.get() || number > LOTTO_NUMBER_MAXIMUM.get()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        Collections.sort(this.numbers);
        return this.numbers.toString();
    }

    private List<Integer> makeLottoNumbers() {
        return new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MINIMUM.get(), LOTTO_NUMBER_MAXIMUM.get(),
                LOTTO_NUMBER_COUNT.get()));
    }

    public boolean isValid() {
        return this.numbers != null;
    }

    public boolean contain(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    public int equalNumbersCount(Lotto winningNumber) {
        int count = 0;
        for (int num : this.numbers) {
            if (winningNumber.contain(num)) {
                count++;
            }
        }
        return count;
    }
}
