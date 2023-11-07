package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.lottomachine.LottoMachine;

public class Number implements Comparable<Number>{
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final List<Number> numbers = new ArrayList<>();
    private final int number;


    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.add(new Number(i));
        }
    }

    private Number(int number) {
        validate(number);
        this.number = number;
    }

    public static Number of(int number) {
        validate(number);
        return numbers.get(number - 1);
    }

    private static void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Number o) {
        return number - o.getNumber();
    }
}
