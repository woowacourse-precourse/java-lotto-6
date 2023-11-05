package lotto.convertTest;

import lotto.domain.WinningNum;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningNumTest {

    @Test
    void 당첨_번호_반환_테스트(){
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        WinningNum winningNum = new WinningNum(input);
        assertThat(winningNum.getWinningNum()).isEqualTo(input);
    }
}
