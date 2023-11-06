package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoAnswer {
    public final List<Integer> numbers = new ArrayList<>();
    private static final int MAX_NUMBERS = 6;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public LottoAnswer(String input) {
        parseInteger(input);
        checkLength(input);
        isInRange(input);
    }

    private void isInRange(String input) {
        String[] parts = input.split(",");
        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num < MIN_VALUE || num > MAX_VALUE) {
                throw new IllegalArgumentException("로또 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void checkLength(String input) {
        String[] parts = input.split(",");
        if (parts.length != MAX_NUMBERS) {
            throw new IllegalArgumentException("로또 번호는 6개 입력해야 합니다.");
        }
    }

    private void parseInteger(String input) {
        String[] parts = input.split(",");

        for (String part : parts) {
            try {
                int num = Integer.parseInt(part);
                numbers.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("올바른 당첨 번호를 입력해주세요.");
            }
        }
    }
}
