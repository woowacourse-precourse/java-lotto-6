package lotto.exception;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoExceptionTest {
    private LottoException lottoException;

    @BeforeEach
    public void setup() {
        lottoException = new LottoException(); // 필드 초기화
    }

    @Test
    @DisplayName("비정상적인 구입 금액 입력 테스트")
    void purchaseAmountCheckMainFalseTest() {
        Assertions.assertThat(lottoException.purchaseAmountCheckMain("100")).isFalse();
    }

    @Test
    @DisplayName("로또번호나 보너스 번호에 숫자가 아닌 문자가 있을경우 테스트")
    void checkNumberFalseTest() {
        Assertions.assertThat(lottoException.checkNumber("q")).isFalse();
    }
}