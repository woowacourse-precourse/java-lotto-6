package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("로또 번호가 1~45가 아니면 예외가 발생한다.")
    @Test
    void createLottoByNumberRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값이 정수가 아니면 예외가 발생한다.")
    @Test
    void createLottoByIsInteger() {
        String input = "ABC";
        assertThatThrownBy(() -> Application.isInteger(input)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("보너스 숫자가 기존 로또 번호와 중복되면 예외가 발생한다.")
    @Test
    void createLottoByBonusNumber(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        assertThatThrownBy(() -> lotto.bonusNumber(6)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("금액은 1000단위가 아니면 예외가 발생한다.")
    @Test
    void createLottoByMoneyvaildate(){
        assertThatThrownBy(() -> new LottoPick(800)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("금액은 양수 값이 아니면 예외가 발생한다.")
    @Test
    void createLottoByMoneyvaildateAmniotic(){
        assertThatThrownBy(() -> new LottoPick(-1000)).isInstanceOf(RuntimeException.class);
    }
}