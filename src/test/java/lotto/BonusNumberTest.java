package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberTest extends  TestFunc{
    private static final String ERROR_MESSAGE = "[ERROR]";
    LottoInput lottoInput = new LottoInput();
    PlayLotto playLotto = new PlayLotto();
    ExceptionCases exceptionCases = new ExceptionCases();
    @DisplayName("보너스 번호와 당첨 번호가 중복된다면 예외가 발생한다.")
    @Test
    void LottoBonusDuplicated() {
            List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
            int bonusNumber = 6;
            assertThatThrownBy(() -> {
                try {
                    exceptionCases.CheckSameWinAndBonus(winningNumbers, bonusNumber);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    throw e;
                }
            }).isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호가 1개가 아니라면 예외가 발생한다.")
    @Test
    void LottoBonusWrongSize() {
        assertSimpleTest(() -> {
            runBonusException("1,2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("보너스 번호가 1~45사이의 값이 아니라면 예외가 발생한다.")
    @Test
    void LottoBonusWrongNumber() {
        assertSimpleTest(() -> {
            runBonusException("46");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void LottoBonusWrongNumber2() {
        assertSimpleTest(() -> {
            runBonusException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("보너스 번호에 빈칸이나 문자열과 같은 옳지않은 값이 들어가면 예외가 발생한다.")
    @Test
    void LottoBonusWrongFormat() {
        assertSimpleTest(() -> {
            runBonusException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @Test
    void LottoBonusWrongFormat2() {
        assertSimpleTest(() -> {
            runBonusException(" ");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    public void runPrice() {
        lottoInput.getLottoPrice(new String[]{});
    }

    public void runWinning() {
        lottoInput.getWinningNum(new String[]{});
    }

    public void runBonus() {
        lottoInput.getBonusNum(new String[]{});
    }
}
