package lotto;

import lotto.domain.Lotto;
import lotto.domain.Round;
import lotto.global.util.InputManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 장 수만큼 6개의 수를 랜덤 추출한 리스트와 Lotto 객체가 생성된다.")
    @Test
    void getTotalCntFromPayment() {
        Round round = new Round();
        round.extractor(3);
    }

    @DisplayName("1000원 단위로 나누어 떨어지지 않는 금액이 입력값으로 들어오면 예외가 발생한다.")
    @Test
    void failToConvertTotalCntFromPayment() {
        String payment = "12340";  // 12340원
        assertThatThrownBy(() -> InputManager.validatePayment(payment))
                .isInstanceOf(IllegalArgumentException.class);

        String payment2 = "51001";  // 51001원
        assertThatThrownBy(() -> InputManager.validatePayment(payment2))
                .isInstanceOf(IllegalArgumentException.class);

        String payment3 = "5000";  // 5000원 (정상)
        assertThat(InputManager.validatePayment(payment3))
                .isEqualTo(5000);
    }

    @DisplayName("빈 값 또는 숫자가 아닌 타입 값이 입력값으로 들어오면 예외가 발생한다.")
    @Test
    void validateInputNumValue() {
        String emptyValue = "";
        assertThatThrownBy(() -> InputManager.validatePayment(emptyValue))
                .isInstanceOf(IllegalArgumentException.class);

        String blankValue = " ";
        assertThatThrownBy(() -> InputManager.validatePayment(blankValue))
        .isInstanceOf(IllegalArgumentException.class);

        String blankValue2 = "     ";
        assertThatThrownBy(() -> InputManager.validatePayment(blankValue2))
        .isInstanceOf(IllegalArgumentException.class);

        String nonNumericValue = "12dksd@la";
        assertThatThrownBy(() -> InputManager.validatePayment(nonNumericValue))
        .isInstanceOf(IllegalArgumentException.class);
    }
}