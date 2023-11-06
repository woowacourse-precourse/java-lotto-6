package lotto.vo;

import lotto.exception.LottoException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoWinningBonusNumberTest {

    @Test
    void 로또_보너스_번호_정상() {
        LottoWinningBonusNumber LottoWinningBonusNumber = new LottoWinningBonusNumber(5);
        Assertions.assertThat(LottoWinningBonusNumber.getValue()).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1, 123})
    @DisplayName("로또 보너스 번호 는 1부터 45 사이의 정수다.")
    void 로또_보너스_번호_비정상_예외(int num) {
        assertThatThrownBy(() -> new LottoWinningBonusNumber(num))
                .isInstanceOf(LottoException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자입니다.\n");
    }

    @Test
    @DisplayName("로또 보너스 번호 는 값이 같으면 동등 하다")
    void 로또_보너스_번호_동등성_비교() {
        LottoWinningBonusNumber number1 = new LottoWinningBonusNumber(5);
        LottoWinningBonusNumber number2 = new LottoWinningBonusNumber(10);
        LottoWinningBonusNumber number3 = new LottoWinningBonusNumber(5);

        assertThat(number1).isEqualTo(number3);
        assertThat(number1).isNotEqualTo(number2);
    }

    @Test
    @DisplayName("로또 보너스 번호(VO)는 값이 같으면 동등 하고, 같은 해시 코드를 가진다.")
    void 로또_보너스_번호_해시_코드_비교() {
        LottoWinningBonusNumber number1 = new LottoWinningBonusNumber(5);
        LottoWinningBonusNumber number2 = new LottoWinningBonusNumber(10);
        LottoWinningBonusNumber number3 = new LottoWinningBonusNumber(5);

        assertThat(number1).hasSameHashCodeAs(number3);
        assertThat(number1).doesNotHaveSameHashCodeAs(number2);
    }

    @Test
    @DisplayName("로또 보너스 번호(VO)는 값이 같으면 동등 하고, 같은 해시 코드를 가져도, 동일 하지 않다.")
    void 로또_보너스_번호_동일성_비교() {
        LottoWinningBonusNumber number1 = new LottoWinningBonusNumber(5);
        LottoWinningBonusNumber number2 = new LottoWinningBonusNumber(10);
        LottoWinningBonusNumber number3 = new LottoWinningBonusNumber(5);

        assertThat(number1).isNotSameAs(number3);
        assertThat(number1).isNotSameAs(number2);
    }
}