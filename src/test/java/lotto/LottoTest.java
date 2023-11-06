package lotto;

import lotto.common.Validation;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1 이하의 숫자가 있다면 예외가 발생한다.")
    @Test
    void createLottoByUnder1() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, -5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 45 이상의 숫자가 있다면 예외가 발생한다.")
    @Test
    void createLottoByOver45() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 49)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매금액이 1000원 이하이면 예외가 발생한다.")
    @Test
    void validateInputPurchaseMoneyUnder1000() {
        String input = "500";
        Validation validation = new Validation();

        assertThatThrownBy(() -> validation.validatePurchaseMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매금액이 1000원 으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void validateInputPurchaseMoneyNotDivide1000() {
        String input = "1500";
        Validation validation = new Validation();

        assertThatThrownBy(() -> validation.validatePurchaseMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void validateInputPurchaseMoneyNotNumber() {
        String input = "d";
        Validation validation = new Validation();

        assertThatThrownBy(() -> validation.validatePurchaseMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매금액이 int 범위를 벗어나면 예외가 발생한다.")
    @Test
    void validateInputPurchaseMoneyOverRange() {
        String input = "10000000000000000";
        Validation validation = new Validation();

        assertThatThrownBy(() -> validation.validatePurchaseMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매한 로또 수량은 (입력한 금액 / 1000)개 이다.")
    @Test
    void checkBuyCount() {
        LottoService lottoService = new LottoService();
        String input = "300000";

        assertThat(lottoService.getBuyCount(Integer.parseInt(input))).isEqualTo(Integer.parseInt(input) / 1000);
    }

    @DisplayName("당첨 번호가 중복이면 예외가 발생한다.")
    @Test
    void createWinningNumsByDuplicatedNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumsByOverSize() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 7, 8), 9))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("당첨 번호에 1 이하의 숫자가 있다면 예외가 발생한다.")
    @Test
    void createWinningNumsByUnder1() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, -5), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 45 이상의 숫자가 있다면 예외가 발생한다.")
    @Test
    void createWinningNumsByOver45() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 49), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호에 이미 포함되어 있다면 예외가 발생한다.")
    @Test
    void createBonusNumDuplicatedByWinningNums() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void validateWinningNumsNotNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, Integer.parseInt("no")), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void validateBonusNumNotNumber() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), Integer.parseInt("no")))
                .isInstanceOf(IllegalArgumentException.class);
    }



}