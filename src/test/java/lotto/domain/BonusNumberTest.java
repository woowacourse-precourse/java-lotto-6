package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("BonusNumber 도메인 테스트")
public class BonusNumberTest {

    @Test
    @DisplayName("보너스 번호로 음수 입력은 에러를 반환한다.")
    void minusNumberTest(){
        int bonusNumbmer = -1;
        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumbmer)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호는 1~45 범위 내에 있지 않으면 에러를 반환한다.")
    void inRangeTest(){
        int bonusNumber = 0;
        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber)).isInstanceOf(IllegalArgumentException.class);

        int bonusNumber2 = 46;
        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber2)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 에러를 반환한다")
    void duplicateNumberTest(){
        int bn = 2;
        List<Integer> numbers = List.of(1,2,3,4,5,6);

        BonusNumber bonusNumber = new BonusNumber(bn);
        Assertions.assertThatThrownBy(() -> bonusNumber.validateDuplicateNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
