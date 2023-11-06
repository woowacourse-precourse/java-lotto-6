package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @DisplayName("당첨 내역 출력 테스트")
    @Test
    void checkResultDto() {
        //given
        List<LottoPrize> lottoPrizes = List.of(LottoPrize.FIFTH_PLACE, LottoPrize.THIRD_PLACE);
        Result result = Result.from(lottoPrizes);
        //when
        StringBuilder stringBuilder = new StringBuilder();
        result.forEachOrdered(lottoPrize ->
                stringBuilder.append(String.format(lottoPrize.getMessage(),
                        result.getResult(lottoPrize), System.lineSeparator())));
        //then
        assertThat(stringBuilder.toString())
                .contains(
                        "3개 일치 (5,000원) - 1개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 1개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                        "6개 일치 (2,000,000,000원) - 0개"
                );
    }
}
