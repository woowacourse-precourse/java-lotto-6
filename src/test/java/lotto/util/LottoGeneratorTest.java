package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    @DisplayName("로또를 생성할 때 예외가 발생하지 않는다.")
    @Test
    void generateNoException() {
        // given

        // when
        ThrowingCallable target = () -> LottoGenerator.generate();

        // then
        assertThatNoException().isThrownBy(target);
    }

    @DisplayName("로또 인스턴스를 생성할 수 있다.")
    @Test
    void generateLottoInstance() {
        // given

        // when
        Object generatedObject = LottoGenerator.generate();

        // then
        assertThat(generatedObject).isInstanceOf(Lotto.class);
    }
}
