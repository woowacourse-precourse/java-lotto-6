package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GetWinningNumbersTest {

    @Test
    @DisplayName("당첨번호와 보너스 번호가 들어왔을때 그대로 보여줘야한다.")
    void 당첨번호_보너스번호_리턴테스트() {
        //given
        GetWinningNumbers getWinningNumbers = new GetWinningNumbers();

        //when
        command("1,2,3,4,5,6", "7");
        GetWinningNumbers winningNumbersInfo = getWinningNumbers.getWinningNumbersInfo();

        //then
        List<Integer> winningNums = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNum = 7;

        assertThat(winningNumbersInfo.getWinningNums()).isEqualTo(winningNums);
        assertThat(winningNumbersInfo.getBonusNum()).isEqualTo(bonusNum);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}