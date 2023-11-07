package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.entry;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 구입 금액을 바탕으로 로또 발행 횟수를 계산한다.")
    @Test
    void calculateIssueCountByPurchaseAmount() {
        int purchaseAmount = 10000;
        assertSimpleTest(() -> {
            int issueCount = Lotto.calculateIssueCount(purchaseAmount);
            assertThat(issueCount).isEqualTo(10);
        });
    }

    @DisplayName("로또 발행 횟수만큼 로또를 발행한다.")
    @Test
    void issueLottoByIssueCount() {
        int issueCount = 10;
        assertSimpleTest(() -> {
            List<Lotto> lottos = Lotto.issueLotto(issueCount);
            assertThat(lottos).isNotEmpty();
        });
    }

    @DisplayName("당첨 번호와 보너스 번호를 바탕으로 당첨 여부를 확인한다.")
    @Test
    void checkWinLotto() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        assertSimpleTest(() -> {
            Map<Rank, Integer> lottoResult = Lotto.isWin(lottos, winNumbers, bonusNumber);
            assertThat(lottoResult)
                    .contains(entry(Rank.THREE, 0))
                    .contains(entry(Rank.FOUR, 0))
                    .contains(entry(Rank.FIVE, 0))
                    .contains(entry(Rank.BONUS, 0))
                    .contains(entry(Rank.SIX, 1));
        });
    }

    @DisplayName("발행된 로또 번호와 입력받은 당첨 번호를 비교한다.")
    @Test
    void compareIssueNumbersAndWinNumbers() {
        List<Integer> issueNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertSimpleTest(() -> {
            int matchCount = Lotto.compareMatch(issueNumbers, winNumbers);
            assertThat(matchCount).isEqualTo(6);
        });
    }

    @DisplayName("당첨 번호와 5개가 일치한 로또 번호를 입력받은 보너스 번호와 비교한다.")
    @Test
    void compareFiveMatchIssueNumbersAndBonusNumber() {
        List<Integer> issueNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;
        assertSimpleTest(() -> {
            boolean isMatch = Lotto.compareBonus(issueNumbers, bonusNumber);
            assertThat(isMatch).isEqualTo(true);
        });
    }

    @DisplayName("로또 결과를 저장하기 전 기본값으로 초기화한다.")
    @Test
    void initializeLottoResultByDefaultValue() {
        Map<Rank, Integer> lottoResult = new HashMap<>();
        assertSimpleTest(() -> {
            Lotto.setInitialValue(lottoResult);
            assertThat(lottoResult)
                    .contains(entry(Rank.THREE, 0))
                    .contains(entry(Rank.FOUR, 0))
                    .contains(entry(Rank.FIVE, 0))
                    .contains(entry(Rank.BONUS, 0))
                    .contains(entry(Rank.SIX, 0));
        });
    }

    @DisplayName("당첨 번호 일치 개수와 보너스 번호 일치 여부를 바탕으로 결과를 저장한다.")
    @Test
    void saveLottoResultByMatchCountAndMatchBonus() {
        Map<Rank, Integer> lottoResult = new HashMap<>();
        Lotto.setInitialValue(lottoResult);
        int matchCount = 6;
        boolean matchBonus = false;
        assertSimpleTest(() -> {
            Lotto.saveLottoResult(lottoResult, matchCount, matchBonus);
            assertThat(lottoResult)
                    .contains(entry(Rank.THREE, 0))
                    .contains(entry(Rank.FOUR, 0))
                    .contains(entry(Rank.FIVE, 0))
                    .contains(entry(Rank.BONUS, 0))
                    .contains(entry(Rank.SIX, 1));
        });
    }

    @DisplayName("로또 결과와 구입 금액을 바탕으로 수익률을 계산한다.")
    @Test
    void calculateReturnRateByLottoResultAndPurchaseAmount() {
        Map<Rank, Integer> lottoResult = new HashMap<>();
        int matchCount = 6;
        boolean matchBonus = false;
        Lotto.setInitialValue(lottoResult);
        Lotto.saveLottoResult(lottoResult, matchCount, matchBonus);
        int purchaseAmount = 10000;
        assertSimpleTest(() -> {
            double returnRate = Lotto.calculateReturnRate(lottoResult, purchaseAmount);
            assertThat(returnRate).isEqualTo(20000000.0);
        });
    }
}