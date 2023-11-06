package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    public void 로또번호_객체생성_정상문자값() {
        // Given
        String input = "1";

        // When
        LottoNumber result = LottoNumber.create(input);

        // Then
        assertTrue(result.isSameAmount(1));
    }

    @Test
    public void 로또번호_객체생성_정상정수값() {
        // Given
        int input = 5;

        // When
        LottoNumber result = LottoNumber.create(input);

        // Then
        assertTrue(result.isSameAmount(5));
    }
}
