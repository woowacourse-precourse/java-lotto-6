package lotto.service;

import static org.assertj.core.api.Assertions.*;

import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.utils.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;



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
        assertThat(result).isEqualTo(Ranking.THIRD);
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
        assertThat(result).isEqualTo(Ranking.SECOND);
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
        assertThat(result).isEqualTo(Ranking.FIRST);
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

}