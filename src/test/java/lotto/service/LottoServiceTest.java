package lotto.service;

import static lotto.domain.Ranking.*;
import static org.assertj.core.api.Assertions.*;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
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
        List<Lotto> lottoList = lottoService.generateLottoList(5);

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
    @DisplayName("기능34 테스트 : 로또 구매 결과에는 입력한 숫자값 만큼의 로또의 숫자 조합이 적혀있다.")
    void purchaseResultOutputStatementHaveLottosAsManyAsInputNumber() {
        // given
        int count = 5;

        // when
        String result = lottoService.makePurchaseResultOutputStatement(count);
        int executionCount = StringUtils.countOccurrences(result, "[");

        // then
        assertThat(result).startsWith("5개를 구매했습니다.");
        assertThat(executionCount).isEqualTo(5);
    }

    @Test
    @DisplayName("기능36 테스트 : Ranking에 있는 값들로 winningResult를 초기화한다.")
    void winningResultUseRakingEnumAsKey() {
        // when
        lottoService.initWinningResult();
        Map<Ranking, Integer> winningResult = lottoService.getWinningResult();

        // then
        assertThat(winningResult.keySet())
                .hasSize(6)
                .contains(Ranking.values());
    }

    @Test
    @DisplayName("기능36 테스트 : winningResult의 모든 원소의 value는 0으로 초기화된다.")
    void initWinningResultInitElementValuesToZero() {
        // when
        lottoService.initWinningResult();
        Map<Ranking, Integer> winningResult = lottoService.getWinningResult();

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
        lottoService.makeWinningResult(lottoList, answer, bonusNumber);
        Map<Ranking, Integer> winningResult = lottoService.getWinningResult();

        // then
        assertThat(winningResult.get(FIRST)).isEqualTo(1);
        assertThat(winningResult.get(SECOND)).isEqualTo(1);
        assertThat(winningResult.get(THIRD)).isEqualTo(1);
        assertThat(winningResult.get(FORTH)).isEqualTo(1);
        assertThat(winningResult.get(FIFTH)).isEqualTo(1);
        assertThat(winningResult.get(SIXTH)).isEqualTo(0);
    }

    @Test
    @DisplayName("기능13 테스트 : 수익율을 정확하게 계산한다.")
    void calculateAccurateProfitRate() {
        // given
        List<Lotto> lottoList = new ArrayList<>();

        Lotto answer = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        lottoList.add(new Lotto(List.of(4, 5, 6, 7, 8, 9)));
        lottoList.add(new Lotto(List.of(6, 7, 8, 9, 10, 11)));
        lottoList.add(new Lotto(List.of(6, 7, 8, 9, 10, 11)));
        lottoList.add(new Lotto(List.of(6, 7, 8, 9, 10, 11)));
        lottoList.add(new Lotto(List.of(6, 7, 8, 9, 10, 11)));
        lottoList.add(new Lotto(List.of(6, 7, 8, 9, 10, 11)));
        lottoList.add(new Lotto(List.of(6, 7, 8, 9, 10, 11)));

        lottoService.makeWinningResult(lottoList, answer, bonusNumber);

        // when
        double result = lottoService.calculateProfitRate();

        // then
        assertThat(result).isEqualTo(71.4);
    }

    @Test
    @DisplayName("기능35 테스트 : winningResultMap에 담긴 결과를 원하는 형식으로 출력문을 만들어 반환한다.")
    void makeWinningResultOutputStatementCorrectly() {
        // given
        int numberPurchase = 1000;
        List<Lotto> lottoList = lottoService.generateLottoList(numberPurchase);
        Lotto answer = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        String result = lottoService.makeWinningResultOutputStatement(lottoList, answer, bonusNumber);
        int count = StringUtils.countOccurrences(result, "일치");

        // then
        assertThat(result).containsSubsequence(LottoService.WINNING_STATISTICS, "---", "총 수익률은", "%입니다.");
        assertThat(count).isEqualTo(5 + 1);
    }

    @Test
    @DisplayName("기능35 테스트 : 로또를 하나도 구매하지 않았을 때도 결과를 제대로 반환한다.")
    void makeWinningResultOutputStatementCorrectlyWhenPurchaceZeroAmountLotto() {
        // given
        int numberPurchase = 0;
        List<Lotto> lottoList = lottoService.generateLottoList(numberPurchase);
        Lotto answer = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        String result = lottoService.makeWinningResultOutputStatement(lottoList, answer, bonusNumber);
        int count = StringUtils.countOccurrences(result, "일치");

        // then
        assertThat(result).containsSubsequence(LottoService.WINNING_STATISTICS, "---", "총 수익률은", "%입니다.");
        assertThat(count).isEqualTo(5 + 1);
    }
}