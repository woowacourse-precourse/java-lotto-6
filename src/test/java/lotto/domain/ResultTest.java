package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class ResultTest {
    private static final Integer PERCENTAGE = 100;
    private static final Integer FIX_MONEY_FOR_TEST = 8000;
    private static final Integer FIRST_PRIZE = LottoRanking.FIRST.getWinningMoney();
    private static final Integer SECOND_PRIZE = LottoRanking.SECOND.getWinningMoney();
    private static final Integer THIRD_PRIZE = LottoRanking.THIRD.getWinningMoney();
    private static final Integer FORTH_PRIZE = LottoRanking.FORTH.getWinningMoney();
    private static final Integer FIFTH_PRIZE = LottoRanking.FIFTH.getWinningMoney();

    private Lotto winningLotto;
    private Bonus bonus;

    @BeforeEach
    void initializer(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        winningLotto = new Lotto(numbers);
        bonus = new Bonus(numbers, 7);
    }

    @ParameterizedTest
    @MethodSource("provideEachRankingLotto")
    @DisplayName("결과에 맞는 올바른 이익률을 출력해야 한다.")
    void getProfitRate(Lotto matchedLotto, LottoRanking ranking) {
        // given
        List<Lotto> playerLotto = new ArrayList<>();
        playerLotto.add(matchedLotto);
        Map<LottoRanking, Integer> results = LottoResult.getResults(winningLotto,playerLotto,bonus);
        Money money = new Money(FIX_MONEY_FOR_TEST);
        Double operand = PERCENTAGE.doubleValue()*ranking.getWinningMoney();
        String expectedProfitRate = "0.0";
        if(!ranking.equals(LottoRanking.OTHER)){
            expectedProfitRate = String.format("%.1f",operand/FIX_MONEY_FOR_TEST);
        }
        // when
        Result result = new Result(results, money);
        String profitRate = String.format("%.1f",result.getProfitRate());
        // then
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }

    private static Stream<Arguments> provideEachRankingLotto(){
        return Stream.of(
                Arguments.of(new Lotto(List.of(1,9,10,11,12,13)), LottoRanking.OTHER), // 1개 일치
                Arguments.of(new Lotto(List.of(1,2,10,11,12,13)), LottoRanking.OTHER), // 2개 일치
                Arguments.of(new Lotto(List.of(1,2,3,11,12,13)), LottoRanking.FIFTH), // 3개 일치
                Arguments.of(new Lotto(List.of(1,2,3,4,12,13)), LottoRanking.FORTH), // 4개 일치
                Arguments.of(new Lotto(List.of(1,2,3,4,5,13)), LottoRanking.THIRD), // 5개 일치, 보너스 번호 X
                Arguments.of(new Lotto(List.of(1,2,3,4,5,7)), LottoRanking.SECOND), // 5개 일치, 보너스 번호 O
                Arguments.of(new Lotto(List.of(1,2,3,4,5,6)), LottoRanking.FIRST) // 6개 일치
        );
    }
}