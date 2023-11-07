package lotto;

import lotto.domain.Lotto;
import lotto.exception.InputException;
import lotto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    final InputException inputException = new InputException();
    final LottoService lottoService = new LottoService();

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

    @DisplayName("로또 번호가 1과 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void createLottoNotBetweenRange() {
        assertThatThrownBy(() -> new Lotto(List.of(10,20,30,40,50,60)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액만큼 로또를 생성한다.")
    @Test
    void createLottoByAmount() {
        assertThat(lottoService.makeLottoList(7000).size()).isEqualTo(7);
    }
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void inputAmountWithInvalidUnit() {
        assertThatThrownBy(() -> inputException.validateUnit("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다.")
    @Test
    void inputAmountWithLetter() {
        assertThatThrownBy(()-> inputException.validateInputNumber("안녕"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Nested
    @DisplayName("보너스 번호 테스트")
    class BonusNumber {
        @DisplayName("보너스 번호가 당첨 번호와 중복이면 예외가 발생한다.")
        @Test
        void createBonusByDuplicatedNumber() {
            assertThatThrownBy(()-> inputException.validateDuplicateBonus("1",new Lotto(List.of(1,2,3,4,5,6))))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @DisplayName("보너스 번호가 1과 45 사이의 숫자가 아니면 예외가 발생한다.")
        @Test
        void createBonusNotBetweenRange() {
            assertThatThrownBy(() -> inputException.validateBonusRange("46"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
        @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
        @Test
        void createBonusByLetter() {
            assertThatThrownBy(() -> inputException.validateInputNumber("ab"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
    @Nested
    @DisplayName("당첨 번호 테스트")
    class WinningNumber {

        @DisplayName("당첨 번호가 숫자와 쉼표로 구성되어있지 않으면 예외가 발생한다.")
        @Test
        void createWinningNumberByDuplicateNumber() {
            assertThatThrownBy(() -> inputException.validateInputWinningNumber("1 2 3 4 5 6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}