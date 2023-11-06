package lotto;

import java.util.Arrays;
import lotto.domain.user.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.user.Purchase;
import lotto.domain.calculator.WinCalculator;
import lotto.domain.user.WinningNumber;
import lotto.domain.result.WonRecord;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @Disabled
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Disabled
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"500a", "천 원", "1장"})
    void createPurchaseAmountByNaN(String amount) {
        assertThatThrownBy(() -> new Purchase(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"500", "1900", "1000.4", "-1000.4"})
    void createPurchaseAmountIndivisibleBy1000(String amount) {
        assertThatThrownBy(() -> new Purchase(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
    }

    @DisplayName("구입 금액이 '-3,000'과 같은 음수이거나 0이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000", "-4000"})
    void createPurchaseAmountByNonPositiveInteger(String amount) {
        assertThatThrownBy(() -> new Purchase(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 최소 구입 금액은 1,000원입니다.");
    }

    @DisplayName("로또 번호가 정수가 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0.1", "1번", "자동", "-0.9"})
    void createWinningNumberByNonInteger(String number) {
        assertThatThrownBy(() -> new WinningNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호가 6개가 아닐 경우 예외가 발생한다.")
    @Test
    void createWinningNumberBySevenNumber() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개를 입력하셔야 합니다.");
    }

    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createWinningNumberByOutOfRange() {
        assertThatThrownBy(() -> new WinningNumber("0,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void createBonusNumberByMatchingWinningNumber() {
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");

        assertThatThrownBy(() -> new BonusNumber(winningNumber.getWinningNumber(), "3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

    @DisplayName("당첨 번호와 발행 번호가 6개 모두 일치하면 1등 count가 올라간다.")
    @Test
    void createFirstPrize() {
        List<Integer> purchaseNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinCalculator winCalculator = new WinCalculator(winningNumber, bonusNumber);
        WonRecord wonRecord = new WonRecord();

        wonRecord.recorder(winCalculator.calculate(purchaseNumber));

        assertThat(wonRecord.getFirstPrizeCount()).isEqualTo(1);
    }

    @DisplayName("당첨 번호와 발행 번호가 5개 일치하고 보너스 번호가 일치하면 2등 count가 올라간다.")
    @Test
    void createSecondPrize() {
        List<Integer> purchaseNumber = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinCalculator winCalculator = new WinCalculator(winningNumber, bonusNumber);
        WonRecord wonRecord = new WonRecord();

        wonRecord.recorder(winCalculator.calculate(purchaseNumber));

        assertThat(wonRecord.getSecondPrizeCount()).isEqualTo(1);
    }

    @DisplayName("당첨 번호와 발행 번호가 5개 일치하고 보너스 번호가 불일치하면 3등 count가 올라간다.")
    @Test
    void createThirdPrize() {
        List<Integer> purchaseNumber = Arrays.asList(1, 2, 3, 4, 5, 8);
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinCalculator winCalculator = new WinCalculator(winningNumber, bonusNumber);
        WonRecord wonRecord = new WonRecord();

        wonRecord.recorder(winCalculator.calculate(purchaseNumber));

        assertThat(wonRecord.getThirdPrizeCount()).isEqualTo(1);
    }
}