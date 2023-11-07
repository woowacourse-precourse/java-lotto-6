package lotto;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    private static final int MATCHED_NUMBER_COUNT=1;
    List<Integer> lottoWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
    int bonusNumber = 7;

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6),Prize.SIX_MATCH),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7),Prize.FIVE_MATCH_WITH_BONUS),
                Arguments.of(List.of(1, 2, 3, 4, 5, 8),Prize.FIVE_MATCH),
                Arguments.of(List.of(1, 2, 3, 4, 8, 9),Prize.FOUR_MATCH),
                Arguments.of(List.of(1, 2, 3, 8, 9, 10),Prize.THREE_MATCH)
        );
    }
    @DisplayName("구매한 로또와 당첨번호 [1,2,3,4,5,6] 비교")
    @ParameterizedTest(name = "구매한 번호가 {0}이면 {1}입니다.")
    @MethodSource("generateData")
    void compareLottoNumbersAndPrize(List<Integer> numbers, Prize prize){

        //given
        Result result = new Result();
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(numbers));

        //when
        result.recordLottoResults(lottoTickets, lottoWinningNumbers, bonusNumber);

        //then
        assertThat(MATCHED_NUMBER_COUNT).isEqualTo(result.getResult().get(prize));

    }
}
