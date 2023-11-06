package lotto;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1미만의 값이 있으면 예외가 발생한다.")
    @Test
    void createLottoWithUnderRangeNumber(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45를 초과하는 값이 있으면 예외가 발샐한다.")
    @Test
    void createLottoWithOverRangeNumber(){
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 50, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또의 toString 메소드 반환값은 numbers 리스트의 값들을 쉼표로 구분한 문자열이여야 한다.")
    @Test
    void convertLottoToString(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        Assertions.assertThat(lotto.toString()).isEqualTo("1, 2, 3, 4, 5, 6");
    }

    @DisplayName("로또가 입력으로 주어진 보너스 값을 포함하고 있다면 참을 반환한다.")
    @Test
    void isContainsBonusNumber(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 6;
        org.junit.jupiter.api.Assertions.assertTrue(lotto.isContain(bonusNumber));
    }
}