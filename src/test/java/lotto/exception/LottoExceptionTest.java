package lotto.exception;


import java.util.List;
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
        Assertions.assertThat(lottoException.numberCheck("q")).isFalse();
    }

    @Test
    @DisplayName("로또번호가 6자리인지 확인하는 테스트")
    void checkNumberLengthTest() {
        Assertions.assertThat(lottoException.numberLengthCheckMain(List.of(1, 2, 3, 4, 5, 6))).isTrue();
    }

    @Test
    @DisplayName("로또 번호가 1부터 45 까지의 숫자로 구성했는지 테스트")
    void lottoRangeCheckTest() {
        Assertions.assertThat(lottoException.lottoRangeCheckMain(46)).isFalse();
    }
}