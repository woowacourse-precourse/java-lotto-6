package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Stream;
import lotto.model.Budget;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.LottoMachine;
import lotto.model.lotto.LottoRank;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.WinningLotto;
import lotto.model.strategy.LottoStrategy;
import lotto.model.strategy.MyLottoStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoStrategyTest {
    private Budget budget;
    private LottoTicket lottoTicket;
    private WinningLotto winningLotto;
    private LottoMachine lottoMachine;
    private BonusNumber bonusNumber;
    private LottoStrategy lottoStrategy;
    private EnumMap<LottoRank, Integer> expectedCounts;

    @BeforeEach
    void setUp() {
        budget = new Budget(1000);
        winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = new BonusNumber(7, winningLotto);
        lottoStrategy = new MyLottoStrategy();
        expectedCounts =  new EnumMap<>(LottoRank.class);
    }

    @DisplayName("6개 번호 일치 시 RANK1 출력 테스트")
    @Test
    void testRank1() {
        //given
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottoMachine = new FixedLottoMachine(testNumbers);
        lottoTicket = new LottoTicket(budget, lottoMachine);
        expectedCounts.put(LottoRank.RANK1, 1);
        //when
        EnumMap<LottoRank, Integer> actualCounts = lottoStrategy.determineRankCounts(lottoTicket, winningLotto, bonusNumber);
        //then
        assertThat(actualCounts)
                .isEqualTo(expectedCounts);
    }

    @DisplayName("5개 번호와 보너스 번호 일치 시 RANK2 출력 테스트")
    @Test
    void testRank2() {
        //given
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);
        lottoMachine = new FixedLottoMachine(testNumbers);
        lottoTicket = new LottoTicket(budget, lottoMachine);
        expectedCounts.put(LottoRank.RANK2, 1);
        //when
        EnumMap<LottoRank, Integer> actualCounts = lottoStrategy.determineRankCounts(lottoTicket, winningLotto, bonusNumber);
        //then
        assertThat(actualCounts)
                .isEqualTo(expectedCounts);
    }

    @DisplayName("5개 번호 일치 시 RANK3 출력 테스트")
    @Test
    void testRank3() {
        //given
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 4, 5, 10);
        lottoMachine = new FixedLottoMachine(testNumbers);
        lottoTicket = new LottoTicket(budget, lottoMachine);
        expectedCounts.put(LottoRank.RANK3, 1);
        //when
        EnumMap<LottoRank, Integer> actualCounts = lottoStrategy.determineRankCounts(lottoTicket, winningLotto, bonusNumber);
        //then
        assertThat(actualCounts)
                .isEqualTo(expectedCounts);
    }

    @DisplayName("4개 번호 일치 시 RANK4 출력 테스트")
    @Test
    void testRank4() {
        //given
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 4, 9, 10);
        lottoMachine = new FixedLottoMachine(testNumbers);
        lottoTicket = new LottoTicket(budget, lottoMachine);
        expectedCounts.put(LottoRank.RANK4, 1);
        //when
        EnumMap<LottoRank, Integer> actualCounts = lottoStrategy.determineRankCounts(lottoTicket, winningLotto, bonusNumber);
        //then
        assertThat(actualCounts)
                .isEqualTo(expectedCounts);
    }

    @DisplayName("3개 번호 일치 시 RANK5 출력 테스트")
    @Test
    void testRank5() {
        //given
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 8, 9, 10);
        lottoMachine = new FixedLottoMachine(testNumbers);
        lottoTicket = new LottoTicket(budget, lottoMachine);
        expectedCounts.put(LottoRank.RANK5, 1);
        //when
        EnumMap<LottoRank, Integer> actualCounts = lottoStrategy.determineRankCounts(lottoTicket, winningLotto, bonusNumber);
        //then
        assertThat(actualCounts)
                .isEqualTo(expectedCounts);
    }

    @DisplayName("2개 이하 번호 일치 시 FAIL 출력 테스트")
    @ParameterizedTest
    @MethodSource("rankNothingTestNumbers")
    void testRankFail(List<Integer> testNumbers) {
        //given
        lottoMachine = new FixedLottoMachine(testNumbers);
        lottoTicket = new LottoTicket(budget, lottoMachine);
        expectedCounts.put(LottoRank.FAIL, 1);
        //when
        EnumMap<LottoRank, Integer> actualCounts = lottoStrategy.determineRankCounts(lottoTicket, winningLotto, bonusNumber);
        //then
        assertThat(actualCounts)
                .isEqualTo(expectedCounts);
    }

    static Stream<Arguments> rankNothingTestNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 8, 9, 10, 11)),
                Arguments.of(Arrays.asList(1, 8, 9, 10, 11, 12)),
                Arguments.of(Arrays.asList(8, 9, 10, 11, 12, 13))
        );
    }
}
