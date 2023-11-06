package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.WinningNumbers.*;
import static org.assertj.core.api.Assertions.*;

public class WinningNumbersTest {

    private Lotto lotto;
    private int bonusNumber;

    @BeforeEach
    void makeWinningNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 6; ++i) {
            numbers.add(i);
        }
        lotto = new Lotto(numbers);
        bonusNumber = 4;
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우에 대한 테스트")
    void bonusNumberIsInWinningNumbers() {
        //given

        //when

        //then
        assertThatThrownBy(() -> validateBonusNumber(lotto, String.valueOf(bonusNumber)));
    }

    @Test
    @DisplayName("보너스 번호가 1 이상 45 이하가 아닐 경우에 대한 테스트")
    void bonusNumberOutOfRangeTest() {
        //given

        //when
        bonusNumber = 47;

        //then
        assertThatThrownBy(() -> validateNumberOutOfRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 숫자 외의 값이 들어갔는지 확인하는 테스트")
    void bonusNumberIsNotNumberTest(){
        //given
        String input = "1x";

        assertThatThrownBy(() -> WinningNumbers.validateNumbersType(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
