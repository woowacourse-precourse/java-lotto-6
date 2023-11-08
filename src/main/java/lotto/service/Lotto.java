package lotto.service;

import lotto.view.Exception_Message;

import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;

public class Lotto {
    private final List<Integer> numbers;
    private static final int min_number = 1; // 추가된 부분
    private static final int max_number = 45; // 추가된 부분

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate_range(numbers);
        validate_overlap(numbers);

        Collections.sort(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            Exception_Message.exception_check_sizes_equals_numbers_size(); // 추가된 부분
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validate_range(List<Integer> numbers) {
        for (int winning_number = 0; winning_number < numbers.size(); winning_number++) {
            if (numbers.get(winning_number) < min_number || numbers.get(winning_number) > max_number) {
                Exception_Message.exception_check_range_equals_certain_ranges();
                throw new IllegalArgumentException();
            }
        }
    }

    private void validate_overlap(List<Integer> numbers) {
        Set<Integer> check_overlap = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            check_overlap.add(numbers.get(i));
        }

        if (check_overlap.size() != 6) {
            Exception_Message.exception_check_lotto_numbers_overlap();
            throw new IllegalArgumentException();
        }
    }

    public static void validate_bonus_number(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            Exception_Message.exception_check_bonus_number_overlap();
            throw new IllegalArgumentException();
        }
    }

    public boolean check_contain_numbers(int number) {
        return numbers.contains(number);
    }

    public List<Integer> get_lotto_numbers() {
        return numbers;
    }

    public int count_match_winning_numbers(Lotto winning_numbers) {
        return (int) numbers.stream().filter(winning_numbers::check_contain_numbers).count();
    }


}
