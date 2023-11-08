package domain;

import static message.ErrorMessage.CANT_DUPLICATE_NUMBER;
import static message.ErrorMessage.LOTTO_COUNT_LIMIT;
import static message.ErrorMessage.LOTTO_NUMBER_RANGE;
import static view.InputView.inputWinningLottoNumber;

import java.util.List;
import java.util.regex.Pattern;

public class Lotto {
    private static final Pattern lotto = Pattern.compile("[1-9]|[1-3][0-9]|4[0-5]");
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validate(numbers);
    }

    private List<Integer> validate(List<Integer> numbers) {
        if (!validateSize(numbers) || !validateDuplicate(numbers) || !validateRange(numbers)) {
            return validate(inputWinningLottoNumber());
        }
        return numbers;
    }

    private boolean validateSize(List<Integer> numbers) {
        try {
            if (numbers.size() != LOTTO_SIZE) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(LOTTO_COUNT_LIMIT.getErrorMessage());
            return false;
        }
        return true;
    }

    private boolean validateDuplicate(List<Integer> numbers) {
        try {
            if (numbers.size() != numbers.stream().distinct().count()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(CANT_DUPLICATE_NUMBER.getErrorMessage());
            return false;
        }
        return true;
    }

    private boolean validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!validateRangeByNumber(number)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateRangeByNumber(Integer number) {
        try {
            if (!lotto.matcher(Integer.toString(number)).matches()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(LOTTO_NUMBER_RANGE.getErrorMessage());
            return false;
        }
        return true;
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }


    public static void outputLotto(Lotto lotto) {
        System.out.println(lotto.numbers.toString());
    }


    public static int getMatchCounts(Lotto lotto, Lotto winningLotto) {
        long matchCount = lotto.numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();

        return Long.valueOf(matchCount).intValue();
    }

}
