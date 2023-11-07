package lotto.serviceTest;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.Service.ResultService;
import lotto.model.Lotto;
import lotto.model.ResultEachLotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ResultServiceTest extends NsTest{
    ResultService resultService = new ResultService();

    @DisplayName("구매한 로또와 당첨 로또를 비교하여 각 로또의 결과를 반환한다.")
    @Test
    public void 로또_비교_결과_반환() {
        // given
        List<Lotto> purchaseLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))
        );
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNum = 7;

        // when
        List<ResultEachLotto> results = resultService.compareLottosNumbers(purchaseLottos, winningLotto, bonusNum);

        // then
        Assertions.assertEquals(results.get(0).getMatchCount(), 6);
        Assertions.assertEquals(results.get(0).getMatchBonus(), 0);
        Assertions.assertEquals(results.get(1).getMatchCount(), 0);
        Assertions.assertNotEquals(results.get(1).getMatchBonus(), 1);// 일치 숫자가 5개 미만일 경우는 보너스 숫자 확인 안함
        Assertions.assertEquals(results.get(2).getMatchCount(), 5);
        Assertions.assertEquals(results.get(2).getMatchBonus(), 1);
    }

    @DisplayName("구매한 로또와 당첨 로또를 비교하여 일치하는 번호의 개수와 보너스 번호의 일치 여부를 확인한다.")
    @Test
    public void 로또_번호_비교() {
        // given
        Lotto purchaseLotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto purchaseLotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNum = 7;

        // when
        ResultEachLotto result1 = resultService.compareLottoNumbers(purchaseLotto1, winningLotto, bonusNum);
        ResultEachLotto result2 = resultService.compareLottoNumbers(purchaseLotto2, winningLotto, bonusNum);

        // then
        Assertions.assertEquals(result1.getMatchCount(), 6);
        Assertions.assertEquals(result1.getMatchBonus(), 0);
        Assertions.assertEquals(result2.getMatchCount(), 5);
        Assertions.assertEquals(result2.getMatchBonus(), 1);
    }

    @DisplayName("각 로또의 결과들을 입력받아 올바른 등수 별 개수를 반환한다.")
    @Test
    public void 로또_등수_결과_계산() {
        // given
        List<ResultEachLotto> results = Arrays.asList(
                new ResultEachLotto(6, 0), // 1등
                new ResultEachLotto(5, 1), // 2등
                new ResultEachLotto(5, 0), // 3등
                new ResultEachLotto(4, 0), // 4등
                new ResultEachLotto(3, 0), // 5등
                new ResultEachLotto(2, 0), // 등수밖
                new ResultEachLotto(6, 0), // 1등
                new ResultEachLotto(5, 1)  // 2등
        );

        // when
        List<Integer> rankingResult = resultService.calculateRankingResult(results);

        // then
        Assertions.assertEquals(rankingResult.get(1), 2); // 1등 2개
        Assertions.assertEquals(rankingResult.get(2), 2); // 2등 2개
        Assertions.assertEquals(rankingResult.get(3), 1); // 3등 1개
        Assertions.assertEquals(rankingResult.get(4), 1); // 4등 1개
        Assertions.assertEquals(rankingResult.get(5), 1); // 5등 1개
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
