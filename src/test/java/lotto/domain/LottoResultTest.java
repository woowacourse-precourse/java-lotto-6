package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {

    @Test
    @DisplayName("로또번호와 당첨번호를 비교하여 일치하는 개수를 구한다.")
    void 당첨_개수_카운트_테스트() throws Exception {
        //given
        GetWinningNumbers getWinningNumbers = new GetWinningNumbers();
        Field winningNums = getWinningNumbers.getClass().getDeclaredField("winningNums");
        winningNums.setAccessible(true);
        winningNums.set(getWinningNumbers, List.of(3,4,5,6,7,8));

        LottoResult lottoResult = new LottoResult(getWinningNumbers);
        Method method = lottoResult.getClass().getDeclaredMethod("getWinningCount", List.class);
        method.setAccessible(true);

        //when
        List<Integer> inputNums = List.of(1, 2, 3, 4, 5, 6);

        //then
        int matchCount = (int) method.invoke(lottoResult, inputNums);
        assertThat(matchCount).isEqualTo(4);
    }

    @Test
    @DisplayName("당첨개수에 따른 당첨금액을 구한다.")
    void 당첨_금액_테스트() throws Exception {
        //given
        GetWinningNumbers getWinningNumbers = new GetWinningNumbers();
        LottoResult lottoResult = new LottoResult(getWinningNumbers);

        Method addCountMethod = lottoResult.getClass().getDeclaredMethod("setWinningCount", int.class);
        addCountMethod.setAccessible(true);

        Method winningAmountMethod = lottoResult.getClass().getDeclaredMethod("getTotalWinningMoney");
        winningAmountMethod.setAccessible(true);

        //when
        addCountMethod.invoke(lottoResult, 4);
        addCountMethod.invoke(lottoResult, 5);

        //then
        long totalWinningAmount = (long) winningAmountMethod.invoke(lottoResult);
        assertThat(totalWinningAmount).isEqualTo(1_550_000);
    }
}