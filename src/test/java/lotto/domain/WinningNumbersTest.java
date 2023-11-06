package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.WinningNumbers.*;
import static lotto.service.LottoService.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
    @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우에 대한 예외 테스트")
    void bonusNumberAlreadyExistsExceptionTest() {
        //given

        //when

        //then
        assertThatThrownBy(() -> validateBonusNumber(lotto, String.valueOf(bonusNumber)));
    }

    @Test
    @DisplayName("보너스 번호가 1 이상 45 이하가 아닐 경우에 대한 예외 테스트")
    void bonusNumberOutOfRangeExceptionTest() {
        //given

        //when
        bonusNumber = 47;

        //then
        assertThatThrownBy(() -> validateNumberOutOfRange(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호에 숫자 외의 값이 들어갔는지 확인하는 예외 테스트")
    void bonusNumberIsNotNumberExceptionTest() {
        //given
        String input = "1x";

        //when

        //then
        assertThatThrownBy(() -> WinningNumbers.validateNumbersType(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호를 포함한 당첨을 확인하는 기능 테스트")
    void secondRankWithBonusNumberTest(){
        //given
        List<Integer> winningLotto = List.of(1,2,3,4,5,6);
        List<Integer> userLotto = List.of(2,3,4,5,6,7);

        //when
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(winningLotto), bonusNumber);
        matchLottoTicket(winningNumbers, new Lotto(userLotto));

        //then
        assertEquals(1, Rank.SECOND.getWinningAmount());
    }
}
