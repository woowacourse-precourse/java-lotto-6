package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameManagerTest {
    private LottoGameManager lottoGameManager = new LottoGameManager(new LottoPublisher());

    @ValueSource(strings = {" ", "", "\n", "\r", "\t"})
    @ParameterizedTest
    void 로또구입금액_입력_시_비었거나_공백이라면_예외를_발생시킨다(String inputLottoCost) {
        assertThatThrownBy(() -> lottoGameManager.validateLottoCost(inputLottoCost))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"1.23", "-1000", "테스트"})
    @ParameterizedTest
    void 로또구입금액_입력_시_숫자가_아니면_예외를_발생시킨다(String inputLottoCost) {
        assertThatThrownBy(() -> lottoGameManager.validateLottoCost(inputLottoCost))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"1", "10", "100", "0", "00", "000"})
    @ParameterizedTest
    void 로또구입금액_입력_시_1000원_단위로_나누어_떨어지지_않으면_예외를_발생시킨다(String inputLottoCost) {
        assertThatThrownBy(() -> lottoGameManager.validateLottoCost(inputLottoCost))
                .isInstanceOf(IllegalArgumentException.class);
    }
}