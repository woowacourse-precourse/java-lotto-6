package lotto;

import lotto.domain.Bonus;
import lotto.domain.Exception;
import lotto.domain.Lotto;
import lotto.view.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Exception.NumberCheck;
import static lotto.domain.Exception.overNumber;
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
    @DisplayName("보너스 값과 6개의 로또값중 중복이 있을 경우")
    @Test
    public void BonusTest() {
        String bonus = "7";
        List<Integer> selectBonus = List.of(1, 2, 4, 5, 6, 7);
        assertThatThrownBy(() -> new Bonus(bonus, selectBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NUMBER_OVERLAP.getExceptionValue());
    }

    @DisplayName("보너스 값 유효성 검사 성공")
    @Test
    public void BonusTest2() {
        String bonus = "12";
        List<Integer> selectBonus = List.of(1, 2, 4, 5, 6, 7);
        Bonus bonusNumber = new Bonus(bonus, selectBonus);
        assertThat(bonusNumber.getBonus()).isEqualTo(12);
    }

    @Test
    @DisplayName("숫자인지 체크")
    void numberCheckTest() {
        assertThatThrownBy(() -> NumberCheck("일이이"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INPUT_TYPE_ERROR.getExceptionValue());
    }

    @Test
    @DisplayName("1~45사이의 로또 숫자가 아닌 경우")
    void overNumberTest() {
        assertThatThrownBy(() ->overNumber(55))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NUMBER_RANGE.getExceptionValue());
    }

    @DisplayName("중복값 체크")
    @Test
    void duplicationCheckBonusTest() {
        int bonus = 7;
        List<Integer> selectBonus = List.of(1, 2, 4, 5, 6, 7);
        assertThatThrownBy(() -> Exception.duplicationCheckBonus(bonus,selectBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NOT_NUMBER_OVERLAP.getExceptionValue());
    }

}