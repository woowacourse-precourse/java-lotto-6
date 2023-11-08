package lotto.DomainTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Domain.LottoSystem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoSystemTest {
    @DisplayName("(예외처리) 6개의 숫자를 입력했는가?")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "1,2,3", "1,2", "1"})
    void storeLottoWinningNumberTest_숫자개수(String lottoPurchaseAmount) {
        LottoSystem lottoSystem = new LottoSystem();
        assertThatThrownBy(() -> lottoSystem.storeLottoWinningNumber(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6자리여야 합니다.");
        ;
    }

    @DisplayName("(예외처리) 로또 번호가 1~45의 범위를 가지는가?")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,66", "-1,2,3,4,5,6"})
    void storeLottoWinningNumberTest_범위체크(String lottoPurchaseAmount) {
        LottoSystem lottoSystem = new LottoSystem();
        assertThatThrownBy(() -> lottoSystem.storeLottoWinningNumber(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("(예외처리) 6개의 숫자가 서로 다른가?")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,2,2,4,5", "1,2,3,4,4,4"})
    void storeLottoWinningNumberTest_중복체크(String lottoPurchaseAmount) {
        LottoSystem lottoSystem = new LottoSystem();
        assertThatThrownBy(() -> lottoSystem.storeLottoWinningNumber(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 각 자리수는 서로 달라야합니다.");
    }
}
