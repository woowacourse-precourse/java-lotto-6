package lotto.domain;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoWinningNumbersTest {

    private LottoWinningNumbers lottoWinningNumbers;
    private InputStream originalSystemIn;

    @BeforeEach
    void setUp() {
        lottoWinningNumbers = new LottoWinningNumbers();
        originalSystemIn = System.in;
    }

    @Test
    @DisplayName("당첨번호 생성 테스트")
    void WinningNumbersTest() {
        String inputValues = "1,2,3,4,5,6\n";
        System.setIn(new ByteArrayInputStream(inputValues.getBytes()));

        List<Integer> winningNumbers = lottoWinningNumbers.getWinningNumbers();

        assertThat(winningNumbers).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        System.setIn(originalSystemIn);
    }

    @Test
    @DisplayName("보너스번호 테스트")
    void BonusNumberTest() {
        consoleInput("1,2,3,4,5,6", "7");
        LottoWinningNumbers winningNumbersInfo = lottoWinningNumbers.getWinningNumbersInfo();

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        assertThat(winningNumbersInfo.getBonusNumber()).isEqualTo(bonusNumber);
        assertThat(winningNumbersInfo.getWinningNumber()).isEqualTo(winningNumbers);
    }

    private void consoleInput(final String... args) {
        final byte[] buffer = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buffer));
    }
}
