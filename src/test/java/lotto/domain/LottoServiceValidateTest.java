package lotto.domain;

import lotto.MethodSourceTest;
import lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceValidateTest extends MethodSourceTest {

    LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService(new Buyer(), new WinningLotto());
    }

    @DisplayName("구매 금액이 1,000원 이상이 아닌 경우(1개 이상 구매하지 않는 경우) 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 500, 999})
    void buyLottosInvalidPurchasesNumber(int purchaseAmount) {
        // given & when & then
        Assertions.assertThatThrownBy(() -> lottoService.buyLotto(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또는 1개 이상 구매해야 합니다.");
    }

    @DisplayName("구매 금액이 1,000원 단위가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1_001, 1_999, 10_001, 100_001})
    void buyLottosInvalidPurchaseAmount(int purchaseAmount) {
        // given & when & then
        Assertions.assertThatThrownBy(() -> lottoService.buyLotto(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또는 1,000원 단위로 구매할 수 있습니다.");
    }

    @DisplayName("당첨 번호가 6개가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateInvalidSizeLottoNumbersArguments")
    void generateWinningLottoInvalidCount(List<Integer> numbers) {
        // given & when & then
        assertThatThrownBy(() -> lottoService.generateWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개이어야 합니다.");
    }

    @DisplayName("당첨 번호에 중복되 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateDuplicateLottoNumbersArguments")
    void generateWinningLottoDuplicateNumber(List<Integer> numbers) {
        // given & when & then
        assertThatThrownBy(() -> lottoService.generateWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호들은 중복되지 않아야 합니다.");
    }

    @DisplayName("당첨 번호가 1 ~ 45 범위를 벗어난 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("generateOutOfRangeLottoNumbersArguments")
    void generateWinningLottoOutOfRangeNumber(List<Integer> numbers) {
        // given & when & then
        assertThatThrownBy(() -> lottoService.generateWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1 ~ 45 중 하나이어야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호에 존재하는 수인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void inputBonusNumberDuplicateNumber(int bonusNumber) {
        // given
        lottoService.generateWinningLotto(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        Assertions.assertThatThrownBy(() -> lottoService.inputBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호에 존재하지 않아야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호에 존재하는 수인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 500, 999})
    void inputBonusNumberOutOfRangeNumber(int bonusNumber) {
        // given
        lottoService.generateWinningLotto(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        Assertions.assertThatThrownBy(() -> lottoService.inputBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 1 ~ 45 중 하나이어야 합니다.");
    }
}
