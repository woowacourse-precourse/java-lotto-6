package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoWinningNumbersTest {

    @Test
    @DisplayName("입력받은 당첨 번호가 6개보다 많으면 예외가 발생한다.")
    public void 당첨_번호_6개보다_많은_경우() throws Exception {
        //given
        String winningNumbersString = "1,2,3,4,5,6,7";

        //when
        List<Integer> winningNumbers = convertToIntegerList(winningNumbersString);

        //then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(winningNumbers));
    }

    @Test
    @DisplayName("입력받은 당첨 번호가 6개보다 적으면 예외가 발생한다.")
    public void 당첨_번호_6개보다_적은_경우() throws Exception {
        //given
        String winningNumbersString = "1,2,3,4,5";

        //when
        List<Integer> winningNumbers = convertToIntegerList(winningNumbersString);

        //then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(winningNumbers));
    }

    @Test
    @DisplayName("입력받은 당첨 번호의 범위가 1 ~ 45가 아니면 예외가 발생한다.")
    public void 당첨_번호_범위() throws Exception {
        //given
        String winningNumberZeroString = "0,1,2,3,4,5";
        String winningNumberOverString = "1,2,3,4,5,46";

        //when
        List<Integer> winningNumberZero = convertToIntegerList(winningNumberZeroString);
        List<Integer> winningNumberOver = convertToIntegerList(winningNumberOverString);

        //then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(winningNumberZero));
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(winningNumberOver));
    }

    @Test
    @DisplayName("입력받은 당첨 범위에 중복이 있을 경우 예외가 발생한다.")
    public void 당첨_번호_중복() throws Exception {
        //given
        String winnerNumberDuplicateString = "1,1,2,3,4,5";

        //when
        List<Integer> winningNumberDuplicate = convertToIntegerList(winnerNumberDuplicateString);

        //then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(winningNumberDuplicate));
    }


    private List<Integer> convertToIntegerList(String numbersString) {
        // Todo: 나중에 WinningNumberService에서 구현할 예정 이때, 정수가 아닌 입력에 대한 예외 처리
        return Arrays.stream(numbersString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
