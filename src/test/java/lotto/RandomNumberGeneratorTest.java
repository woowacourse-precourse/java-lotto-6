package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.exception.LottoNumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @DisplayName("1부터 45사이의 숫자를 생성하지 않으면 예외를 발생시킨다.")
    @Test
    void generate() {
        //given
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator(45,65);

        // when then
        assertThatThrownBy(randomNumberGenerator::generate)
                .isInstanceOf(LottoNumberOutOfRangeException.class);
    }
}
