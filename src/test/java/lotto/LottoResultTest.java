package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultTest {
        @Test
        @DisplayName("잘못된 matchCount 입력시 오류")
        void wrong_Match_Result() {
                assertThatThrownBy(() -> LottoResult.getResult(7, false))
                        .isInstanceOf(IllegalArgumentException.class);
        }
}
