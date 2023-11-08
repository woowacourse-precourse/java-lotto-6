package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    MatchNumber matchNumber = new MatchNumber("1,2,3,4,5,6");

    @DisplayName("입력 값이 숫자 형태가 아닐 시 예외 처리")
    @Test
    void isNumericDataType(){
        assertThatThrownBy(() -> new BonusNumber("a",matchNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자 형식에 맞지 않습니다.");
    }

    @DisplayName("중복된 숫자가 있는 경우 예외 발생")
    @Test
    void createForDuplicateNumber(){
        assertThatThrownBy(()->new BonusNumber("6",matchNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 리스트에 중복된 숫자가 있습니다.");
    }

    @DisplayName("1에서 45사이의 숫자가 나오지 않으면 예외 발생")
    @Test
    void outBoundRangeLottoNumber(){
        assertThatThrownBy(()->new BonusNumber("50",matchNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("보너스 숫자가 잘 생성되었는지 테스트")
    @Test
    void createBonusNumber() {
        assertSimpleTest(() -> {
            BonusNumber bonusNumber = new BonusNumber("7",matchNumber);
            assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
        });
    }
}
