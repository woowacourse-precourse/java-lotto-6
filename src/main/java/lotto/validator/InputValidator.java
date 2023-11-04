package lotto.validator;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InputValidator {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    // 에러 체크를 사용하는 로직에서는 IllegalArgumentException이 감지되면 해당 로직을 다시 실행하도록 설계 필요

    public void validateLottoDuplication(List<Integer> numbers) {
        List<Integer> collect = numbers.stream().filter(number -> Collections.frequency(numbers, number) != 1)
                .collect(Collectors.toList());

        if (collect != null) {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void validateLottoNumberRange(List<Integer> numbers) {
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);

        if (max.get() > LOTTO_MAX_NUMBER || min.get() < LOTTO_MIN_NUMBER) {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public void validateInputType(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
        } finally {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputData(int amount, int unit) {
        try {
            validateAmount(amount, unit);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
        } finally {
            throw new IllegalArgumentException();
        }
    }


    public IllegalArgumentException validateAmount(int amount, int unit) {
        if (amount % unit != 0) {
            return new IllegalArgumentException();
        }
        return null;
    }

}
