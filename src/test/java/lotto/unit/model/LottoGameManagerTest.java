package lotto.unit.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.LottoGameManager;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameManagerTest {

    private static LottoGameManager createLottoGameManager() {
        return new LottoGameManager();
    }

    @Nested
    class 로또_구입_금액_입력_시 {

        @ParameterizedTest
        @ValueSource(strings = {"1", "10", "100", "0", "00", "000"})
        void 천원으로_나누어_떨어지지_않으면_예외를_발생시킨다(String inputLottoCost) {
            assertThatThrownBy(() -> createLottoGameManager().createLottoBucket(inputLottoCost))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class 당첨번호_입력_시 {

        @ParameterizedTest
        @ValueSource(strings = {"1,2,a,b,3,4", "-1,1.23,4,5,6,7"})
        void 정수가_아니면_예외를_발생시킨다(String inputWinningNumbers) {
            assertThatThrownBy(
                    () -> createLottoGameManager().createWinningLotto(inputWinningNumbers)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,0,3,4,5", "1,2,46,3,4,5"})
        void 로또_번호_범위에_없으면_예외를_발생시킨다(String inputWinningNumbers) {
            assertThatThrownBy(
                    () -> createLottoGameManager().createWinningLotto(inputWinningNumbers)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
        void 개수가_적거나_초과하면_예외를_발생시킨다(String inputWinningNumbers) {
            assertThatThrownBy(
                    () -> createLottoGameManager().createWinningLotto(inputWinningNumbers)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,1,5", "7,7,7,7,7,7"})
        void 중복되는_번호가_있으면_예외를_발생시킨다(String inputWinningNumbers) {
            assertThatThrownBy(
                    () -> createLottoGameManager().createWinningLotto(inputWinningNumbers)
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class 보너스_번호_입력_시 {

        @ParameterizedTest
        @ValueSource(strings = {"0", "46"})
        void 로또_번호_범위에_없으면_예외를_발생시킨다(String inputBonusNumber) {
            assertThatThrownBy(
                    () -> createLottoGameManager().parsingBonusNumber(inputBonusNumber)
            ).isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
        void 당첨_번호와_중복되는_번호가_있으면_예외를_발생시킨다(String inputBonusNumber) {
            String inputWinningNumbers = "1,2,3,4,5,6";
            LottoGameManager lottoGameManager = createLottoGameManager();
            lottoGameManager.createWinningLotto(inputWinningNumbers);

            assertThatThrownBy(
                    () -> lottoGameManager.parsingBonusNumber(inputBonusNumber)
            ).isInstanceOf(IllegalArgumentException.class);
        }
    }
}