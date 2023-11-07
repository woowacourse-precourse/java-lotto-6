package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningNumTest {

    @Test
    @DisplayName("당첨 번호가 반환이 잘 되는 지 테스트")
    void getWinningNum(){
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6);
        WinningNum winningNum = new WinningNum(input);
        assertThat(winningNum.getWinningNum()).isEqualTo(input);
    }

}
