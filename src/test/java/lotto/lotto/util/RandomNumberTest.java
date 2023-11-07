package lotto.lotto.util;

import lotto.util.RandomNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class RandomNumberTest {
    @DisplayName("무작위 숫자가 6개 생성되어야 한다.")
    @Test
    void createRandomNumberSizeSix() {
        List<Integer> numbers = RandomNumber.generateLotteryNumber();

        Assertions.assertEquals(numbers.size(), 6);
    }

    @DisplayName("무작위 숫자의 범위는 1부터 45까지이다.")
    @Test
    void createRandomNumberBound() {
        List<Integer> numbers = RandomNumber.generateLotteryNumber();

        long nonBoundedCount = numbers.stream().filter(number -> number < 1 || number > 45).count();
        Assertions.assertEquals(nonBoundedCount, 0);
    }

    @DisplayName("무작위 숫자는 고유해야 한다.")
    @Test
    void createRandomNumberUnique() {
        List<Integer> numbers = RandomNumber.generateLotteryNumber();

        long uniqueCount = numbers.stream().distinct().count();
        Assertions.assertEquals(uniqueCount, numbers.size());
    }
}
