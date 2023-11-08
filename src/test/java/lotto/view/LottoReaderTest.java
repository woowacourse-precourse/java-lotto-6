package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoReaderTest {

    @DisplayName("올바른 값을 입력받을 때까지 지속해서 입력받는다.")
    @Test
    void readTest() {

        // given
        LottoReader lottoReader = new LottoReader();
        List<Integer> inputs = List.of(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = inputs.iterator();

        // when
        int expectedValue = 100;
        Integer result = lottoReader.read(() -> {
            if (iterator.next() != 5) {
                throw new IllegalArgumentException("Error Message!");
            }
            return expectedValue;
        });

        // then
        assertThat(result).isEqualTo(expectedValue);
    }
}