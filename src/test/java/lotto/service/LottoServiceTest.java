package lotto.service;

import static lotto.domain.Ranking.*;
import static org.assertj.core.api.Assertions.*;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        this.lottoService = new LottoService();

    }

    @Test
    @DisplayName("기능10 테스트 : generateLottoCombination는 1~45까지의 숫자 중 6개의 숫자를 생성한다.")
    void generatedLottoCombinationContainsSixNumberAndEachNumberIsInRangeBetweenOneAndFortyFive() {
        // when
        List<Integer> result = lottoService.generateLottoCombination();

        // then
        assertThat(result)
                .hasSize(6)
                .allMatch(number -> number >= 1 && number <= 45);
    }

    @Test
    @DisplayName("기능10 테스트 : generateLottoCombination로 생성된 숫자 리스트에는 중복된 값이 없다.")
    void generatedLottoCombinationDoNotHaveDuplicates() {
        // when
        List<Integer> result = lottoService.generateLottoCombination();

        // then
        assertThat(result)
                .doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("기능10 테스트 : generateLottoCombination로 생성된 숫자 리스트는 오름차순으로 정리되어 있다.")
    void generatedLottoCombinationShouldSortedByAscending() {
        // when
        List<Integer> result = lottoService.generateLottoCombination();

        // then
        assertThat(result)
                .isSorted();
    }

    @Test
    @DisplayName("기능09 테스트 : generateLotto 메서드가 Lotto 객체를 예외를 발생시키지 않고 Lotto 객체를 생성한다.")
    void generateLottoShouldReturnLottoInstanceWithOutException() {
        // when, then
        assertThatCode(() -> lottoService.generateLotto())
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("기능08 테스트 : generateLottoList 메서드가 지정된 개수만큼 Lotto 객체를 담은 리스트를 반환한다.")
    void generateLottoListMakeLottoAsManyAsCount() {
        // given
        int count = 5;

        // when
        List<Lotto> lottoList = lottoService.generateLottoList(count);

        // then
        assertThat(lottoList).hasSize(count);
    }

    @Test
    @DisplayName("기능12 테스트 : 2개의 숫자가 일치할 때 Ranking을 정확하게 반환한다.")
    void calculateCorrectRankingWhenTargetHaveTwoMatchingNumber() {
        // given
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answer = new Lotto(List.of(5, 6, 7, 8, 9, 10));
        int bonusNumber = 45;

        // when
        Ranking result = lottoService.calculateRanking(target, answer, bonusNumber);

        // then
        assertThat(result).isEqualTo(Ranking.SIXTH);
    }

    @Test
    @DisplayName("기능12 테스트 : 3개의 숫자가 일치할 때 Ranking을 정확하게 반환한다.")
    void calculateCorrectRankingWhenTargetHaveThreeMatchingNumber() {
        // given
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answer = new Lotto(List.of(4, 5, 6, 7, 8, 9));
        int bonusNumber = 45;

        // when
        Ranking result = lottoService.calculateRanking(target, answer, bonusNumber);

        // then
        assertThat(result).isEqualTo(Ranking.FIFTH);
    }

    @Test
    @DisplayName("기능12 테스트 : 4개의 숫자가 일치할 때 Ranking을 정확하게 반환한다.")
    void calculateCorrectRankingWhenTargetHaveFourMatchingNumber() {
        // given
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answer = new Lotto(List.of(3, 4, 5, 6, 7, 8));
        int bonusNumber = 45;

        // when
        Ranking result = lottoService.calculateRanking(target, answer, bonusNumber);

        // then
        assertThat(result).isEqualTo(Ranking.FORTH);
    }

    @Test
    @DisplayName("기능12 테스트 : 5개의 숫자가 일치하고 보너스 번호를 맞추지 못했을 때 Ranking을 정확하게 반환한다.")
    void calculateCorrectRankingWhenTargetHaveFiveMatchingNumberAndDoNotHaveBonusNumber() {
        // given
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answer = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        int bonusNumber = 45;

        // when
        Ranking result = lottoService.calculateRanking(target, answer, bonusNumber);

        // then
        assertThat(result).isEqualTo(THIRD);
    }

    @Test
    @DisplayName("기능12 테스트 : 5개의 숫자가 일치하고 보너스 번호를 맞추었을 때 Ranking을 정확하게 반환한다.")
    void calculateCorrectRankingWhenTargetHaveFiveMatchingNumberAndHaveBonusNumber() {
        // given
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answer = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        int bonusNumber = 1;

        // when
        Ranking result = lottoService.calculateRanking(target, answer, bonusNumber);

        // then
        assertThat(result).isEqualTo(SECOND);
    }

    @Test
    @DisplayName("기능12 테스트 : 5개의 숫자가 일치하고 보너스 번호를 맞추었을 때 Ranking을 정확하게 반환한다.")
    void calculateCorrectRankingWhenTargetHaveSixMatchingNumber() {
        // given
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answer = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;

        // when
        Ranking result = lottoService.calculateRanking(target, answer, bonusNumber);

        // then
        assertThat(result).isEqualTo(FIRST);
    }

    @Test
    @DisplayName("기능36 테스트 : Ranking에 있는 값들로 winningResult를 초기화한다.")
    void winningResultUseRakingEnumAsKey() {
        // when
        Map<Ranking, Integer> winningResult = lottoService.initWinningResult();

        // then
        assertThat(winningResult.keySet())
                .hasSize(6)
                .contains(Ranking.values());
    }

    @Test
    @DisplayName("기능36 테스트 : winningResult의 모든 원소의 value는 0으로 초기화된다.")
    void initWinningResultInitElementValuesToZero() {
        // when
        Map<Ranking, Integer> winningResult = lottoService.initWinningResult();

        // then
        for (Ranking ranking : winningResult.keySet()) {
            assertThat(winningResult.get(ranking)).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("기능11 테스트 : 로또 당첨 결과를 winningResult에 정확하게 담아둔다.")
    void storeWinningResultInHashMapCorrectly() {
        // given
        List<Lotto> lottoList = new ArrayList<>();

        lottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(List.of(2, 3, 4, 5, 6, 7)));
        lottoList.add(new Lotto(List.of(2, 3, 4, 5, 6, 8)));
        lottoList.add(new Lotto(List.of(3, 4, 5, 6, 7, 8)));
        lottoList.add(new Lotto(List.of(4, 5, 6, 7, 8, 9)));

        Lotto answer = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        Map<Ranking, Integer> winningResult = lottoService.calculateWinningResult(lottoList, answer, bonusNumber);

        // then
        assertThat(winningResult.get(FIRST)).isEqualTo(1);
        assertThat(winningResult.get(SECOND)).isEqualTo(1);
        assertThat(winningResult.get(THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("기능13 테스트 : 수익율을 정확하게 계산한다.")
    void calculateAccurateProfitRate() {
        // given
        HashMap<Ranking, Integer> winningResult = new HashMap<>();
        winningResult.put(FIRST, 0);
        winningResult.put(SECOND, 0);
        winningResult.put(THIRD, 0);
        winningResult.put(FORTH, 0);
        winningResult.put(FIFTH, 1);
        winningResult.put(SIXTH, 6);

        // when
        double result = lottoService.calculateProfitRate(winningResult);

        // then
        assertThat(result).isEqualTo(71.4);
    }

}