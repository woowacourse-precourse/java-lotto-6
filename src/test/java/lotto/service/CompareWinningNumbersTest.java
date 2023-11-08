package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import lotto.Lotto;
import lotto.readUserInput.WinningNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompareWinningNumbersTest {
    private Lotto lotto;
    private CompareWinningNumbers compareWinningNumbers;
    private WinningNumbers winningNumbers;

    @BeforeEach
    void beforeSetUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        compareWinningNumbers = new CompareWinningNumbers(lotto);
        winningNumbers = new WinningNumbers();
    }

    @AfterEach
    void afterEach() {
        WinningNumbers.numbers.clear();
        Console.close();
    }

    @Test
    void 숫자6개가맞는경우확인() {
        String inputNumbers = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(inputNumbers.getBytes()));
        winningNumbers.read();
        Assertions.assertThat(compareWinningNumbers.winningCount()).isEqualTo(CompareCount.SIX_MATCH.getCount());
    }

    @Test
    void 숫자5개가맞는경우확인() {
        String inputNumbers = "1,2,3,4,5,10";
        System.setIn(new ByteArrayInputStream(inputNumbers.getBytes()));
        winningNumbers.read();
        Assertions.assertThat(compareWinningNumbers.winningCount()).isEqualTo(CompareCount.FIVE_MATCH.getCount());
    }

    @Test
    void 숫자4개가맞는경우확인() {
        String inputNumbers = "1,2,3,4,40,41";
        System.setIn(new ByteArrayInputStream(inputNumbers.getBytes()));
        winningNumbers.read();
        Assertions.assertThat(compareWinningNumbers.winningCount()).isEqualTo(CompareCount.FOUR_MATCH.getCount());
    }

    @Test
    void 숫자3개가맞는경우확인1() {
        String inputNumbers = "1,2,3,10,11,12";
        System.setIn(new ByteArrayInputStream(inputNumbers.getBytes()));
        winningNumbers.read();
        Assertions.assertThat(compareWinningNumbers.winningCount()).isEqualTo(CompareCount.THREE_MATCH.getCount());
    }

    @Test
    void 숫자3개가맞는경우확인2() {
        String inputNumbers = "10,3,11,1,12,2";
        System.setIn(new ByteArrayInputStream(inputNumbers.getBytes()));
        winningNumbers.read();
        Assertions.assertThat(compareWinningNumbers.winningCount()).isEqualTo(CompareCount.THREE_MATCH.getCount());
    }
}