package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningInfoTest {


    @Test
    void 당첨_번호_사이즈_6아닌_경우_예외_처리(){

        assertThatThrownBy(() ->
                new WinningInfo().saveWinningNumbers(List.of(1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_1미만_경우_예외_처리(){

        assertThatThrownBy(() ->
                new WinningInfo().saveWinningNumbers(List.of(1,2,3,4,5,0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_45초과_경우_예외_처리(){

        assertThatThrownBy(() ->
                new WinningInfo().saveWinningNumbers(List.of(1,2,3,4,5,46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_중복_경우_예외_처리(){

        assertThatThrownBy(() ->
                new WinningInfo().saveWinningNumbers(List.of(1,2,3,4,5,5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_1미만_경우_예외_처리(){

        WinningInfo winningInfo = new WinningInfo();
        winningInfo.saveWinningNumbers(List.of(1,2,3,4,5,6));

        assertThatThrownBy(() ->
                winningInfo.saveBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_45초과_경우_예외_처리(){

        WinningInfo winningInfo = new WinningInfo();
        winningInfo.saveWinningNumbers(List.of(1,2,3,4,5,6));

        assertThatThrownBy(() ->
                winningInfo.saveBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_중복_경우_예외_처리(){

        WinningInfo winningInfo = new WinningInfo();
        winningInfo.saveWinningNumbers(List.of(1,2,3,4,5,6));

        assertThatThrownBy(() ->
                winningInfo.saveBonusNumber(6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void saveWinningNumbersTest() {

        WinningInfo winningInfo = new WinningInfo();
        winningInfo.saveWinningNumbers(List.of(1,2,3,4,5,6));

        List<Integer> winningNumbers = winningInfo.getWinningNumbers();

        int i = 1;

        for(int winningNum : winningNumbers){

            assertThat(winningNum).isEqualTo(i++);
        }
    }

    @Test
    void saveBonusNumberTest() {

        WinningInfo winningInfo = new WinningInfo();
        winningInfo.saveWinningNumbers(List.of(1,2,3,4,5,6));
        winningInfo.saveBonusNumber(7);

        assertThat(winningInfo.getBonusNumber()).isEqualTo(7);
    }
}
