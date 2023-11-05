package lotto;

import lotto.application.IOService;
import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    IOService ioService = new IOService();
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("금액이 정수가 아닌 경우 검증 실패한다.")
    @Test
    void validatePurchaseAmountInteger() {
        assertThat(ioService.validatePurchaseAmount("100s0asda0")).isEqualTo(false);
        assertThat(ioService.validatePurchaseAmount("10000.000")).isEqualTo(false);
        assertThat(ioService.validatePurchaseAmount("5555,000")).isEqualTo(false);
    }
    @DisplayName("금액이 1000원보다 작은 경우 검증 실패한다.")
    @Test
    void validatePurchaseAmount1000() {
        assertThat(ioService.validatePurchaseAmount("-1000")).isEqualTo(false);
        assertThat(ioService.validatePurchaseAmount("0")).isEqualTo(false);
        assertThat(ioService.validatePurchaseAmount("999")).isEqualTo(false);
    }

    @DisplayName("금액이 1000원 단위가 아닐경우 검증 실패한다.")
    @Test
    void validatePurchaseAmountUnit() {
        assertThat(ioService.validatePurchaseAmount("5001")).isEqualTo(false);
        assertThat(ioService.validatePurchaseAmount("5010")).isEqualTo(false);
        assertThat(ioService.validatePurchaseAmount("5100")).isEqualTo(false);
    }



}