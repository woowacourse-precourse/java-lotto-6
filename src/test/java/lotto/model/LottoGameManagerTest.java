package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.common.config.UserRule;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameManagerTest {
    private final LottoGameManager lottoGameManager = new LottoGameManager();

    @Nested
    class 로또_구입_금액_입력_시 {
        @ValueSource(strings = {" ", "", "\n", "\r", "\t"})
        @ParameterizedTest
        void 비었거나_공백이라면_예외를_발생시킨다(String inputLottoCost) {
            assertThatThrownBy(() -> lottoGameManager.parsingLottoCost(inputLottoCost))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ValueSource(strings = {"1.23", "-1000", "테스트"})
        @ParameterizedTest
        void 정수가_아니면_예외를_발생시킨다(String inputLottoCost) {
            assertThatThrownBy(() -> lottoGameManager.parsingLottoCost(inputLottoCost))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ValueSource(strings = {"1", "10", "100", "0", "00", "000"})
        @ParameterizedTest
        void 천원으로_나누어_떨어지지_않으면_예외를_발생시킨다(String inputLottoCost) {
            assertThatThrownBy(() -> lottoGameManager.parsingLottoCost(inputLottoCost))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class 당첨번호_입력_시 {

        @ValueSource(strings = {"1,2,3,4,5,6", "1,2,3,4,5,6,"})
        @ParameterizedTest
        void 쉼표를_기준으로_분리한다(String inputWinningNumbers) {
            List<String> winningNumber = List.of(inputWinningNumbers.split(UserRule.WINING_NUMBERS_SEPARATOR.value()));

            assertThat(lottoGameManager.splitWinningNumbers(inputWinningNumbers)).isEqualTo(winningNumber);
        }

        @ValueSource(strings = {" ", "", "\n", "\r", "\t", " , ,,", " , 1,,2"})
        @ParameterizedTest
        void 비었거나_공백이라면_예외를_발생시킨다(String inputWinningNumbers) {
            assertThatThrownBy(() -> lottoGameManager.parsingWinningNumbers(inputWinningNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ValueSource(strings = {"1,2,a,b,3,4", "-1,1.23,4,5,6,7"})
        @ParameterizedTest
        void 정수가_아니면_예외를_발생시킨다(String inputWinningNumbers) {
            assertThatThrownBy(() -> lottoGameManager.parsingWinningNumbers(inputWinningNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ValueSource(strings = {"1,2,0,3,4,5", "1,2,46,3,4,5"})
        @ParameterizedTest
        void 범위에_없으면_예외를_발생시킨다(String inputWinningNumbers) {
            assertThatThrownBy(() -> lottoGameManager.parsingWinningNumbers(inputWinningNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
        @ParameterizedTest
        void 개수가_적거나_초과하면_예외를_발생시킨다(String inputWinningNumbers) {
            assertThatThrownBy(() -> lottoGameManager.createWinningLotto(inputWinningNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ValueSource(strings = {"1,2,3,4,1,5", "7,7,7,7,7,7"})
        @ParameterizedTest
        void 중복되는_번호가_있으면_예외를_발생시킨다(String inputWinningNumbers) {
            assertThatThrownBy(() -> lottoGameManager.createWinningLotto(inputWinningNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}