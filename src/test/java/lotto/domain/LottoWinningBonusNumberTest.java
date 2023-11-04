package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningBonusNumberTest {
    @Test
    @DisplayName("입력받은 보너스 번호의 범위가 1 ~ 45가 아니면 예외가 발생한다.")
    public void 보너스_번호_범위() throws Exception {
        //given
        String winningBonusNumberZeroString = "0";
        String winningBonusNumberOverString = "46";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        int winningBonusNumberZero = convertToInteger(winningBonusNumberZeroString);
        int winningBonusNumberOver = convertToInteger(winningBonusNumberOverString);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoWinningBonusNumber(winningBonusNumberZero, winningNumbers);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new LottoWinningBonusNumber(winningBonusNumberOver, winningNumbers);
        });

    }

    @Test
    @DisplayName("입력받은 보너스 번호가 이미 당첨 번호에 있는 경우 예외가 발생한다.")
    public void 보너스_번호_중복() throws Exception {
        //given
        String winningBonusNumberDuplicateString = "1";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        int winningBonusNumberDuplicate = convertToInteger(winningBonusNumberDuplicateString);

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoWinningBonusNumber(winningBonusNumberDuplicate, winningNumbers);
        });
    }


    private int convertToInteger(String winningBonusNumberString) {
        //todo: service에서 처리할 로직, 정수에 대한 입력이 아닐 경우 예외 처리
        try {
            int bonusNumber = Integer.parseInt(winningBonusNumberString);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력되어야 합니다.");
        }
    }

}
