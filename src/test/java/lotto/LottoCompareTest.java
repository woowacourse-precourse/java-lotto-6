package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import lotto.model.Lotto;
import lotto.model.LottoCompare;
import lotto.model.LottoMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class LottoCompareTest {
    @DisplayName("보너스 번호 확인")
    @Test
    void getBonusTest(){
        LottoCompare lottoCompare = new LottoCompare();
        lottoCompare.setWinningNumbers(Arrays.asList(1,2,3,4,5,6));
        lottoCompare.setBonusNumber(7);

        assertThat(lottoCompare.getBonusNumber())
                .isEqualTo(7);

    }

    @DisplayName("당첨 번호 확인")
    @Test
    void getWinnigTest(){
        LottoCompare lottoCompare = new LottoCompare();
        lottoCompare.setWinningNumbers(Arrays.asList(1,2,3,4,5,6));
        lottoCompare.setBonusNumber(7);

        assertThat(lottoCompare.getWinningNumbers())
                .contains(1,2,3,4,5,6);

    }

    @DisplayName("보너스 비교 성공")
    @Test
    void bonusCompareTest(){
        Lotto lotto = new Lotto(Arrays.asList(4,5,6,7,8,9));
        LottoCompare lottoCompare = new LottoCompare();
        lottoCompare.setWinningNumbers(Arrays.asList(1,2,3,4,5,6));
        lottoCompare.setBonusNumber(7);

        assertThat(lottoCompare.bonusCompare(lotto))
                .isTrue();
    }

    @DisplayName("보너스 비교 실패")
    @Test
    void bonusCompareFailTest(){
        Lotto lotto = new Lotto(Arrays.asList(4,5,6,7,8,9));
        LottoCompare lottoCompare = new LottoCompare();
        lottoCompare.setWinningNumbers(Arrays.asList(1,2,3,4,5,6));
        lottoCompare.setBonusNumber(20);

        assertThat(lottoCompare.bonusCompare(lotto))
                .isFalse();
    }

    @DisplayName("당첨번호 비교")
    @Test
    void winnigCompareTest(){
        Lotto lotto = new Lotto(Arrays.asList(4,5,6,7,8,9));
        LottoCompare lottoCompare = new LottoCompare();
        lottoCompare.setWinningNumbers(Arrays.asList(1,2,3,4,5,6));
        lottoCompare.setBonusNumber(7);

        assertThat(lottoCompare.winningCompare(lotto))
                .isEqualTo(3);
    }


}
