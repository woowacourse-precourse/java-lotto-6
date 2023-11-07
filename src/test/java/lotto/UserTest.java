package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("구입 금액이 1,000원 단위로 나누어 떨어지지 않은 경우 예외 처리를 한다.")
    @Test
    void createUserByNotThousandUnitInputAmount() {
        assertSimpleTest(() -> {
            runException("1230");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("구입 금액에 숫자 이외에 문자가 포함되어 있으면 예외 처리를 한다.")
    @Test
    void createUserByNoNumberInputAmount() {
        assertSimpleTest(() -> {
            runException("1500jjjj");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6,7", "8");
            assertThat(output()).contains("[ERROR] 당첨 번호를 입력하는 데 에러가 발생하였습니다.");
        });
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,2", "8");
            assertThat(output()).contains("[ERROR] 당첨 번호를 입력하는 데 에러가 발생하였습니다.");
        });
    }

    @DisplayName("당첨 번호에 45초과 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverNumber() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,46", "8");
            assertThat(output()).contains("[ERROR] 당첨 번호를 입력하는 데 에러가 발생하였습니다.");
        });
    }

    @DisplayName("당첨 번호에 1미만 숫자가 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByUnderNumber() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,0", "8");
            assertThat(output()).contains("[ERROR] 당첨 번호를 입력하는 데 에러가 발생하였습니다.");
        });
    }

    @DisplayName("보너스 번호에 46초과 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverInputNumber() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "46");
            assertThat(output()).contains("[ERROR] 보너스 번호를 입력하는 데 에러가 발생하였습니다. 현재 보너스 번호 : " + "46");
        });
    }

    @DisplayName("보너스 번호에 1미만 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByUnderInputNumber() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "0");
            assertThat(output()).contains("[ERROR] 보너스 번호를 입력하는 데 에러가 발생하였습니다. 현재 보너스 번호 : " + "0");
        });
    }

    @DisplayName("보너스 번호에 당첨 번호와 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createBonusNumberByWinningDuplicatedInputNumber() {
        assertSimpleTest(() -> {
            runException("8000", "1,2,3,4,5,6", "6");
            assertThat(output()).contains("[ERROR] 보너스 번호를 입력하는 데 에러가 발생하였습니다. 현재 보너스 번호 : " + "6");
        });
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
