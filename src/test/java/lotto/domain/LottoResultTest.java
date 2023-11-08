package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class LottoResultTest {
    private static Lotto winningLotto;
    private static Bonus bonus;

    @BeforeAll
    public static void initializer(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        winningLotto = new Lotto(numbers);
        bonus = new Bonus(numbers, 7);
    }

    @ParameterizedTest
    @MethodSource("provideEachRankingLotto")
    @DisplayName("오직_하나의_당첨_로또에_대한_적절한_결과_생성_확인_테스트")
    void onlyRanking_createCorrectResultTest(Lotto matchedLotto, LottoRanking ranking){
        // given
        List<Lotto> playerLotto = new ArrayList<>();
        playerLotto.add(matchedLotto);
        Boolean isCorrectResult = true;
        // when
        Map<LottoRanking, Integer> results = LottoResult.getResults(winningLotto,playerLotto,bonus);
        for(Map.Entry<LottoRanking, Integer> entry: results.entrySet()){
            LottoRanking lottoRanking = entry.getKey();
            int count = entry.getValue();
            if(count == 1 && !(lottoRanking.equals(ranking))){
                isCorrectResult = false;
                break;
            }
        }
        // then
        assertThat(isCorrectResult).isEqualTo(true);
    }

    @ParameterizedTest
    @MethodSource("provideEachRankingLotto")
    @DisplayName("여러_당첨된_로또에_대한_적절한_결과_생성_확인_테스트")
    void various_createCorrectResultTest(Lotto matchedLotto, LottoRanking ranking) {
        // given
        List<Lotto> playerLotto = new ArrayList<>();
        playerLotto.add(matchedLotto);
        playerLotto.add(new Lotto(List.of(1,2,3,9,10,11))); // 적절한 개수를 출력하는지 확인을 위한 FIFTH 순위의 로또 하나 추가
        Map<LottoRanking, Integer> expectedResults = new HashMap<>();
        for(LottoRanking lottoRanking : LottoRanking.values()){ // initializing hashmap
            expectedResults.put(lottoRanking, 0);
        }
        expectedResults.put(ranking, expectedResults.get(ranking)+1);
        expectedResults.put(LottoRanking.FIFTH, expectedResults.get(LottoRanking.FIFTH)+1);
        // when
        Map<LottoRanking, Integer> results = LottoResult.getResults(winningLotto,playerLotto,bonus);
        // then
        assertThat(results).isEqualTo(expectedResults);
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