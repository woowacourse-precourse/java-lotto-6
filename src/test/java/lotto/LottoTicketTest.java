package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {
    @Test
    @ParameterizedTest
    @ValueSource(strings = {"d", "12d", "__", "*"})
    void 입력값_숫자_아닌값_예외처리_테스트(String input) {
        assertThatThrownBy(() -> new LottoTicket(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
