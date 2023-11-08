package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TotalWinningResultTest {

    private TotalWinningResult totalWinningResult;

    @BeforeEach
    void init() {
        totalWinningResult = new TotalWinningResult();
    }

    @DisplayName("로또와 당첨번호가 주어지면, 일치하는 숫자의 개수를 반환한다.")
    @Test
    void getMatchNumbersTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        Method getMatchNumbers = TotalWinningResult.class.getDeclaredMethod("getMatchNumbers", Lotto.class, Lotto.class);
        getMatchNumbers.setAccessible(true);

        //when
        int matchCount = (int) getMatchNumbers.invoke(totalWinningResult, lotto, winningNumbers);

        //then
        assertThat(matchCount).isEqualTo(6);
    }

    @DisplayName("로또와 보너스 번호가 주어지면, 보너스 번호의 포함 여부를 반환한다.")
    @Test
    void isMatchBonusNumberTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber1 = 1;
        int bonusNumber2 = 7;

        Method isMatchBonusNumber = TotalWinningResult.class.getDeclaredMethod("isMatchBonusNumber", Lotto.class, int.class);
        isMatchBonusNumber.setAccessible(true);

        //when
        boolean isMatch1 = (boolean) isMatchBonusNumber.invoke(totalWinningResult, lotto, bonusNumber1);
        boolean isMatch2 = (boolean) isMatchBonusNumber.invoke(totalWinningResult, lotto, bonusNumber2);

        //then
        assertTrue(isMatch1);
        assertFalse(isMatch2);
    }

}