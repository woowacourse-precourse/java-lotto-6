package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Numbers 클래스")
class NumbersTest {

    @DisplayName("List<Integer>를 List<Numbers>로 변환할 수 있다")
    @Test
    void transferListOfIntegerToListOfNumbers() {
        List<Number> numbers = List.of(new Number(1), new Number(2), new Number(3), new Number(4),
            new Number(5), new Number(6));
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(numbers, Numbers.createNumbersList(integers));
    }
}