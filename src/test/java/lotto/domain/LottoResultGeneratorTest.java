package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoResultGeneratorTest {
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;

    @DisplayName("당첨번호에 보너스넘버가 중복되지 않으면 정상 처리된다.")
    @Test
    void create() {
        // given
        winningNumbers = WinningNumbers.create("1,2,3,4,5,6");
        bonusNumber = BonusNumber.create("7");

        // when
        LottoResultGenerator lottoResultGenerator = LottoResultGenerator.create(winningNumbers, bonusNumber);

        // then
        assertThat(lottoResultGenerator).isNotNull();
    }

    @DisplayName("당첨번호와 보너스넘버가 중복되면 예외 발생한다.")
    @Test
    void cannotCreate_duplicate() {
        // given
        winningNumbers = WinningNumbers.create("1,2,3,4,5,6");
        bonusNumber = BonusNumber.create("1");

        // when, then
        assertThatThrownBy(() -> LottoResultGenerator.create(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랭킹을 계산한다.")
    @Test
    void calculateRanking() {
        // given
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 5, 7, 8);

        winningNumbers = WinningNumbers.create("1,2,3,4,5,6");
        bonusNumber = BonusNumber.create("7");
        LottoResultGenerator lottoResultGenerator = LottoResultGenerator.create(winningNumbers, bonusNumber);
        List<Lotto> lottos = new ArrayList<>(List.of(new Lotto(numbers1), new Lotto(numbers2), new Lotto(numbers3)));

        // when, then
        lottoResultGenerator.computePrizeFrequencies(Lottos.create(lottos));
        //winningNumbers와 파라미터로 들어온 Lottos 를 비교하여 winningRecords 필드를 업데이트
        //winningRecords : Map<Integer, Integer> 등수 : 몇개가 해당 등수인지

//        assertThat(lottoResultGenerator.getWinningRecords().get(1)).isEqualToTo(1);  //1등 1개
//        assertThat(lottoResultGenerator.getWinningRecords().get(2)).isEqualTo(1);  //2등 1개
//        assertThat(lottoResultGenerator.getWinningRecords().get(3)).isEqualTo(0);  //3등 0개
//        assertThat(lottoResultGenerator.getWinningRecords().get(4)).isEqualTo(1);  //4등 1개
//        assertThat(lottoResultGenerator.getWinningRecords().get(5)).isEqualTo(0);  //3등 0개
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateProfit() {
        // given
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 5, 7, 8);

        winningNumbers = WinningNumbers.create("1,2,3,4,5,6");
        bonusNumber = BonusNumber.create("7");
        LottoResultGenerator lottoResultGenerator = LottoResultGenerator.create(winningNumbers, bonusNumber);
        List<Lotto> lottos = new ArrayList<>(List.of(new Lotto(numbers1), new Lotto(numbers2), new Lotto(numbers3)));

        // when, then
//        lottoResultGenerator.calculatePrizeMoney();
    }
}