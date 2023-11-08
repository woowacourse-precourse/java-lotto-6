package lotto.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoExceptionTest {
    private LottoException lottoException = new LottoException();

    @Test
    void 사용자가_입력한_당첨번호가_쉼표로_구분되어_있지_않은_경우_예외를_발생한다() {
        assertThatThrownBy(() -> lottoException.validateStringSplited("1 2 3 4 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}