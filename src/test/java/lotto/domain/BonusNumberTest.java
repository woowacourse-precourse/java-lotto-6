package lotto.domain;

import java.util.List;
import lotto.model.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class BonusNumberTest {
    @DisplayName("보너스숫자 로또 번호에 미포함 실패 테스트")
    @Test
    void compareBonusNumber_NoContainsBonusNumber_False() {

        //given
        BonusNumber bonusNumber = new BonusNumber(7);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        //when
        Boolean bonusNumberCheck = bonusNumber.compareBonusNumber(numbers);
        //then
        assertThat(bonusNumberCheck).isFalse();

    }

    @DisplayName("보너스숫자 로또 번호에 포함 성공 테스트")
    @Test
    void compareBonusNumber_ContainsBonusNumber_Success() {

        //given
        BonusNumber bonusNumber = new BonusNumber(7);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 7);
        //when
        Boolean bonusNumberCheck = bonusNumber.compareBonusNumber(numbers);
        //then
        assertThat(bonusNumberCheck).isTrue();

    }


}
