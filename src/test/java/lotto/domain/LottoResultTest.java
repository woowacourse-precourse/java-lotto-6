package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
    @MethodSource("providePlayerLotto")
    @DisplayName("적절한_결과_생성_확인_테스트")
    void createCorrectResultTest(Lotto matchedLotto, LottoRanking ranking){
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

    private static Stream<Arguments> providePlayerLotto(){
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