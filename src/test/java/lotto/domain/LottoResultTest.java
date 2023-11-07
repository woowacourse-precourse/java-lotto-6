package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {

    @DisplayName("로또 번호와 맞게 알맞은 값이 나오는지 체크하는 테스트")
    @Test
    void createCorrectLotto() throws Exception {
        //given
        final int threeMatchCount = 1;
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        List<Lotto> lottoNumbers = Arrays.asList(lotto);
        List<Integer> lottoWinningNumber = List.of(1,2,3,7,8,9);
        int bonusNumber = 10;
        int lottoAmount = 1;

        //when
        LottoResult lottoResult = new LottoResult(lottoNumbers, lottoWinningNumber, bonusNumber, lottoAmount);
        lottoResult.LottoPrizeResult();
        int threeMatch = lottoResult.getClass().getDeclaredMethod("lottoMatchCompare", List.class).getParameterCount();

        //then
        assertThat(threeMatch).isEqualTo(threeMatchCount);
    }

    @DisplayName("로또 번호 5개와 보너스가 맞는 경우 알맞은 값이 나오는지 체크하는 테스트")
    @Test
    void createCorrectLottoBonus() throws Exception {
        //given
        final int BonusMatchCount = 1;
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,8));
        List<Lotto> lottoNumbers = Arrays.asList(lotto);
        List<Integer> lottoWinningNumber = List.of(1,2,3,4,5,7);
        int bonusNumber = 8;
        int lottoAmount = 1;

        //when
        LottoResult lottoResult = new LottoResult(lottoNumbers, lottoWinningNumber, bonusNumber, lottoAmount);
        lottoResult.LottoPrizeResult();
        int threeMatch = lottoResult.getClass().getDeclaredMethod("lottoMatchCompare", List.class).getParameterCount();

        //then
        assertThat(threeMatch).isEqualTo(BonusMatchCount);
    }

    @DisplayName("로또 번호를 맞춘 경우 만큼 수익률이 나오는 경우 체크하는 테스트")
    @Test
    void createCorrectLottoProfit() throws Exception {
        //given
        final double profitMatch = 500.0;
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        List<Lotto> lottoNumbers = Arrays.asList(lotto);
        List<Integer> lottoWinningNumber = List.of(1,2,3,7,8,9);
        int bonusNumber = 10;
        int lottoAmount = 1;

        //when
        LottoResult lottoResult = new LottoResult(lottoNumbers, lottoWinningNumber, bonusNumber, lottoAmount);
        lottoResult.LottoPrizeResult();
        Method method = lottoResult.getClass().getDeclaredMethod("lottoProfit");
        method.setAccessible(true);
        double profit = (double) method.invoke(lottoResult);

        //then
        assertThat(profit).isEqualTo(profitMatch);
    }

}
