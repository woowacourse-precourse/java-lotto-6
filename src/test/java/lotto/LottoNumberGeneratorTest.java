package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberGeneratorTest {
    private static final int START = 1;
    private static final int END = 45;
    private static final int SIZE = 6;

    @DisplayName("숫자 생성기가 1~45 사이 정수 6개를 생성하는지 확인한다.")
    @Test
    public void createNumbers_test() {
        // given

        // when

        // then
        assertThat(LottoNumberGenerator.createNumbers()).hasSize(SIZE)
                .allMatch(number -> number >= START && number <= END);
    }
}
