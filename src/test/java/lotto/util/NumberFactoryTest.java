package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("NumberFactory 테스트")
public class NumberFactoryTest {
    private final int lottoLength = 6;
    private NumberFactory numberFactory = new LottoNumberFactory();
    @Test
    @DisplayName("getNumbers() method 테스트")
    public void getNumbersTest() {
        // given
        List<Integer> numbers = numberFactory.getNumbers();

        // when - then
        assertAll(
                () -> assertThat(numbers.size()).isEqualTo(lottoLength),
                () -> assertThat(numbers).doesNotContainNull(),
                () -> assertThat(numbers).doesNotHaveDuplicates()
        );
    }
}