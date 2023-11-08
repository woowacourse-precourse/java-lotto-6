package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningNumbersTest {

    @Test
    void 콤바기준_분리_테스트(){
        WinningNumbers winningNumbers = new WinningNumbers();
        List<Integer> splitTest = winningNumbers.splitWinningNumbersByComma("1,2,3,4,5,6");

        assertThat(splitTest).isEqualTo(List.of(1,2,3,4,5,6));
    }

}
