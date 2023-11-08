package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static lotto.constants.Error.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest extends NsTest {
    @DisplayName("로또 당첨번호가 숫자 또는 콤마(,) 이외의 문자를 포함하면 예외가 발생한다.")
    @Test
    void createWinningNumbersByNonNumberComma() {
        assertSimpleTest(() -> {
            runException("15,40,+,7,19,20","1");
            assertThat(output()).contains(NON_NUMBER_COMMA.getMessage());
        });
    }
    @DisplayName("로또 당첨번호가 연속하는 콤마(,)를 포함하면 예외가 발생한다.")
    @Test
    void createWinningNumbersByContinualComma() {
        assertSimpleTest(() -> {
            runException("15,40,,7,19,20","1");
            assertThat(output()).contains(CONTINUAL_COMMA.getMessage());
        });
    }
    @DisplayName("로또 당첨번호의 맨 앞/뒤에 콤마(,)를 포함하면 예외가 발생한다.")
    @Test
    void createWinningNumbersByEdgeComma() {
        assertSimpleTest(() -> {
            runException(",15,40,7,19,20","1");
            assertThat(output()).contains(COMMA_EDGE.getMessage());
        });
    }
    @DisplayName("로또 당첨번호가 1~45 범위 외의 수를 포함하는 경우 예외가 발생한다.")
    @Test
    void createWinningNumbersByNotInRange() {
        assertSimpleTest(() -> {
            runException("15,40,7,19,20,50","1");
            assertThat(output()).contains(NOT_IN_RANGE.getMessage());
        });
    }
    @DisplayName("로또 당첨번호가 서로 중복되는 수를 포함하는 경우 예외가 발생한다.")
    @Test
    void createWinningNumbersByDuplicates() {
        assertSimpleTest(() -> {
            runException("15,40,7,19,20,19","1");
            assertThat(output()).contains(DUPLICATES.getMessage());
        });
    }
    @DisplayName("보너스 번호가 숫자 이외의 문자를 포함하면 예외가 발생한다.")
    @Test
    void createBonusNumberByNonNumber() {
        assertSimpleTest(() -> {
            runException("15,40,7,19,20,9","29,");
            assertThat(output()).contains(NON_NUMBER.getMessage());
        });
    }
    @DisplayName("보너스 번호가 1~45 범위 외의 수이면 예외가 발생한다.")
    @Test
    void createBonusNumberByNotInRange() {
        assertSimpleTest(() -> {
            runException("15,40,7,19,20,9","70");
            assertThat(output()).contains(NOT_IN_RANGE.getMessage());
        });
    }
    @DisplayName("보너스 번호가 로또 당첨번호와 중복되는 경우 예외가 발생한다..")
    @Test
    void createBonusNumberByDuplicates() {
        assertSimpleTest(() -> {
            runException("15,40,7,19,20,9","15");
            assertThat(output()).contains(DUPLICATES.getMessage());
        });
    }

    @Override
    public void runMain() {
        new WinningNumbers();
    }

}