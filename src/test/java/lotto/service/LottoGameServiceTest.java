package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.EnumMap;
import java.util.List;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameServiceTest {
    LottoGameService lottoGameService;
    @BeforeEach
    void setUp() {
        lottoGameService = new LottoGameService();
    }

    @DisplayName("로또 구입 금액이 숫자가 아닌 문자가 포함될 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000a", " ", "20a0", "aA"})
    void containLottoPurchaseAmountNonDigit(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoGameService.validatePurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 0원일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "00", "000"})
    void inputZeroValue(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoGameService.validatePurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입 금액이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "2500", "500"})
    void createPurchaseAmountNotDividedByThousand(String lottoPurchaseAmount) {
        assertThatThrownBy(() -> lottoGameService.validatePurchaseAmount(lottoPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 쉼표로 구분된 숫자 6개가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "1,2,3,4,5,6,", "1"})
    void createNotLottoFormat(String lottoNumbers) {
        assertThatThrownBy(() -> lottoGameService.validateInputNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 1~45사이의 번호가 아닌 숫자를 포함할 경우 예외가 발생한다.")
    @Test
    void createLottoNumbersByWrongRange() {
        List<Integer> lottoNumbers = List.of(0, 1, 2, 3, 4, 5);
        assertThatThrownBy(() -> lottoGameService.validateWinningNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복된 숫자를 포함할 경우 예외가 발생한다.")
    @Test
    void ContainDuplicateDigits() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 5);
        assertThatThrownBy(() -> lottoGameService.validateWinningNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 아닌 문자일 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", " ", "25c"})
    void createBonusNumberNonDigit(String bonusNumber) {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> lottoGameService.validateBonusNumber(bonusNumber, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1~45사이의 숫자가 아닐 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void createBonusNumberByWrongRange(String bonusNumber) {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> lottoGameService.validateBonusNumber(bonusNumber, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함될 때 예외가 발생한다.")
    @Test
    void createBonusNumberByWrongRange() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        String bonusNumber = String.valueOf(lottoNumbers.get(0));
        assertThatThrownBy(() -> lottoGameService.validateBonusNumber(bonusNumber, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}