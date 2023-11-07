package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoWinningNumbersTest {

    private LottoWinningNumbers lottoWinningNumbers;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        lottoWinningNumbers = new LottoWinningNumbers();
    }

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    @DisplayName("당첨번호 생성 테스트")
    void WinningNumbersTest() {
        String inputValues = "1,2,3,4,5,6\n";
        System.setIn(new ByteArrayInputStream(inputValues.getBytes()));

        List<Integer> winningNumbers = lottoWinningNumbers.inputWinningNumbers();

        assertThat(winningNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("입력한 당첨번호 중 중복되는 번호가 있을경우 재입력 받는다.")
    void WinningNumbersDuplicateTest() {
        consoleInput("1,2,3,4,5,5", "1,2,3,4,5,6");

        List<Integer> winningNumbers = lottoWinningNumbers.inputWinningNumbers();

        assertThat(winningNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("보너스번호 테스트")
    void BonusNumberTest() {
        consoleInput("1,2,3,4,5,6", "7");
        LottoWinningNumbers winningNumbersInfo = lottoWinningNumbers.getWinningNumbersInfo();
        BonusNumber bonusNumber = new BonusNumber(winningNumbersInfo);

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int number = 7;

        assertThat(bonusNumber.getNumber()).isEqualTo(number);
        assertThat(winningNumbersInfo.getWinningNumber()).isEqualTo(winningNumbers);
    }

    @Test
    @DisplayName("당첨번호에 보너스번호와 중복된 번호가있으면 재입력을 한다.")
    void createBonusNumberDuplicateWithWinningNumbers() {
        consoleInput("1,2,3,4,5,6", "5", "7");
        LottoWinningNumbers winningNumbersInfo = lottoWinningNumbers.getWinningNumbersInfo();
        BonusNumber bonusNumber = new BonusNumber(winningNumbersInfo);

        int number = 7;

        assertThat(bonusNumber.getNumber()).isEqualTo(number);
    }

    @Test
    @DisplayName("잘못된 값을 입력시 재 입력한다.")
    void createBonusNumberIncorrectValue() {
        consoleInput("1,2,3,4,5,6", "tt", "7");
        LottoWinningNumbers winningNumbersInfo = lottoWinningNumbers.getWinningNumbersInfo();
        BonusNumber bonusNumber = new BonusNumber(winningNumbersInfo);

        int number = 7;

        assertThat(bonusNumber.getNumber()).isEqualTo(number);
    }

    @Test
    @DisplayName("1~45의 값이 아니면 재입력받는다.")
    void createBonusNumberRangeOver() {
        consoleInput("1,2,3,4,5,6", "47", "7");
        LottoWinningNumbers winningNumbersInfo = lottoWinningNumbers.getWinningNumbersInfo();
        BonusNumber bonusNumber = new BonusNumber(winningNumbersInfo);

        int number = 7;

        assertThat(bonusNumber.getNumber()).isEqualTo(number);
    }

    private void consoleInput(final String... args) {
        final byte[] buffer = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buffer));
    }
}
