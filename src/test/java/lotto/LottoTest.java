package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.Domain.Lotto;
import lotto.Domain.LottoNumber;
import lotto.Domain.LottoResult;
import lotto.Domain.LottoReward;
import lotto.Domain.Money;
import lotto.Domain.TotalLotto;
import lotto.Util.LottoComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("로또 번호에 숫자가 아닌 값이 있다면 예외가 발생한다.")
    @Test
    void createLottoByNotNumber() {
        assertThatThrownBy(() -> new LottoNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위를 초과한 숫자가 있다면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new LottoNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 비교 테스트")
    @Test
    void compareLottoTest() {
        Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        LottoComparator lottoComparator = new LottoComparator(winLotto);
        assertThat(lottoComparator.compareLotto(userLotto)).isEqualTo(3);
    }

    @DisplayName("보너스 번호 비교 테스트")
    @Test
    void compareBonusNumberTest() {
        Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber("7");
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        LottoComparator lottoComparator = new LottoComparator(winLotto);
        assertThat(lottoComparator.compareBonusNumber(userLotto, bonusNumber)).isEqualTo(true);
    }

    @DisplayName("당첨 통계 테스트")
    @Test
    void createStatisticTest() {
        TotalLotto totalLotto = new TotalLotto(new Money("3000"));
        LottoNumber bonusNumber = new LottoNumber("7");

        // 사용자 로또 번호에서 하나를 당첨 번호로 사용한다.
        Lotto winLotto = new Lotto(totalLotto.getTotalLotto().get(0).getNumbers());
        LottoResult lottoResult = new LottoResult(winLotto);

        Map<LottoReward, Integer> lottoStatistic = lottoResult.createStatistic(totalLotto, bonusNumber);

        // 사용자 로또 번호가 곧 당첨 번호이기 때문에 6개 일치가 하나 이상 나와야 한다.
        assertThat(lottoStatistic.get(LottoReward.FIRST_PLACE)).isGreaterThanOrEqualTo(1);
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateSumOfRewardTest() {
        TotalLotto totalLotto = new TotalLotto(new Money("1000"));
        int number = 0;
        LottoNumber bonusNumber;

        // 사용자 로또 번호에서 하나를 당첨 번호로 사용한다.
        Lotto winLotto = new Lotto(totalLotto.getTotalLotto().get(0).getNumbers());

        // 중복이면 다른숫자로
        do {
            bonusNumber = new LottoNumber(++number + "");
        }
        while (winLotto.getNumbers().contains(bonusNumber.getLottoNumber()));

        LottoResult lottoResult = new LottoResult(winLotto);
        lottoResult.createStatistic(totalLotto, bonusNumber);
        String reward = lottoResult.calculateSumOfReward(new Money("1000"));
        
        // 1,000원 -> 2,000,000,000원이 됐으므로 200000000.0% 이상의 수익률을 가진다.
        assertThat(reward).isEqualTo("200000000.0");
    }
}