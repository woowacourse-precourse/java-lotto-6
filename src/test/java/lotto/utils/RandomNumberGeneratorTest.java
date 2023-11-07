package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @DisplayName("랜덤 번호 생성 유효성 검사 - 100회 반복")
    @RepeatedTest(100)
    void create_ShouldGenerateNumbersWithinRange() {
        int startNumber = 1;
        int endNumber = 45;
        int ticketSize = 6;

        List<Integer> numbers = RandomNumberGenerator.create();

        assertThat(numbers)
                .hasSize(ticketSize)
                .doesNotHaveDuplicates()
                .isSorted();

        assertThat(numbers).allMatch(number -> number >= startNumber && number <= endNumber);
    }
}
