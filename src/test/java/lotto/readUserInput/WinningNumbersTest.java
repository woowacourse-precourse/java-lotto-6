package lotto.readUserInput;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    @BeforeEach
    void beforeSetUp() {
        winningNumbers = new WinningNumbers();
    }

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    void 당첨번호입력() {
        String numbers = "1,2,3,4,5,6";
        List<Integer> winning = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.setIn(new ByteArrayInputStream(numbers.getBytes()));
        winningNumbers.read();
        Assertions.assertThat(WinningNumbers.numbers).isEqualTo(winning);
    }
}