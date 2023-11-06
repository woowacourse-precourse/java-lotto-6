package lotto.domain;

import lotto.model.domain.Lotto;
import lotto.model.domain.WinningNum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class WinningNumTest {

    @DisplayName("당첨 번호 확인 테스트")
    @Test
    public void getWinningNumTest() {
        // given
        ArrayList<Integer> winningNumList =  new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        WinningNum winningNum = new WinningNum(winningNumList);

        // when, then
        assertThat(winningNum.getWinningnum()).isEqualTo(winningNumList);
    }

}
