package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.util.MatchRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoManagerTest {

    Lottos lottos = new Lottos(2);
    List<Integer> totalMatchNumbers = List.of(1,2,3,4,5,6);
    LottoManager lottoManager = new LottoManager(lottos,totalMatchNumbers);

    @DisplayName("당첨 번호와 맞는 번호가 있을 때 리스트 원소로 들어가는지 테스트")
    @Test
    void compareToMatchTest() {
        assertSimpleTest(() -> {
            Lotto lotto = new Lotto(List.of(1,4,6,7,8,9));
            assertThat(lottoManager.compareToMatch(lotto, totalMatchNumbers)).isEqualTo(List.of(1,4,6));
        });
    }

    @DisplayName("로또번호가 당첨번호와 4개만 맞을 때 '4등'이 나오는지 테스트")
    @Test
    void judgeLottoRankingTest() {
        assertSimpleTest(() -> {
            List<Integer> numberIntersection = List.of(1,4,6,7);
            int bonusNumber = 20;
            assertThat(lottoManager.judgeLottoRanking(numberIntersection, bonusNumber)
                    .getRank())
                    .isEqualTo("4등");
        });
    }

    @DisplayName("로또번호,당첨번호가 5개와 보너스번호가 맞을 때 '2등'이 나오는지 테스트")
    @Test
    void judgeSecondAndThirdRankingTest() {
        assertSimpleTest(() -> {
            List<Integer> numberIntersection = List.of(1,2,3,4,6,7);
            int bonusNumber = 7;
            assertThat(lottoManager.judgeLottoRanking(numberIntersection, bonusNumber)
                    .getRank())
                    .isEqualTo("2등");
        });
    }

    @DisplayName("구입한 로또들과 당첨번호를 매치해서 얼마나 당첨되었는지 검증 테스트")
    @Test
    void matchResultTest() {
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    Lottos lottos = new Lottos(2);
                    lottoManager.matchResult(lottos, totalMatchNumbers);
                    Map<MatchRanking, Integer> lottoResult = lottoManager.getLottoResult();
                    assertThat(lottoResult.get(MatchRanking.SECOND_PLACE)).isEqualTo(0);
                    assertThat(lottoResult.get(MatchRanking.THIRD_PLACE)).isEqualTo(0);
                    assertThat(lottoResult.get(MatchRanking.FOURTH_PLACE)).isEqualTo(1);
                    assertThat(lottoResult.get(MatchRanking.FIFTH_PLACE)).isEqualTo(0);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 1, 2, 38)
        );
    }

    @DisplayName("createLotto 테스트")
    @Test
    public void createLottoTest(){
        List<Integer> expectedNumbers = List.of(8, 21, 23, 41, 42, 43);
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    List<Integer> lotto = lottos.createLotto();
                    assertThat(lotto).isEqualTo(expectedNumbers);
                },
                List.of(8, 21, 23, 41, 42, 43)
        );
    }





}
