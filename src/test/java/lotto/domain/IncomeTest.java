package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IncomeTest {

    @DisplayName("로또 수익률 확인")
    @Test
    void lottoResultIncomeTest() {
        List<Integer> gamePrizeIndexValues = List.of(4,4,4,4);
        Income income = new Income(gamePrizeIndexValues);

//        gamePrizeIndex 4 = 5000원
        assertThat(income.calculateIncomeRate(4000)).isEqualTo((double) 20000 / 4000 * 100);
    }

    @DisplayName("로또 수익구간별 카운트 확인")
    @Test
    void lottoResultCountTest() {
        List<Integer> gamePrizeIndexValues = List.of(0,2,2,2);
        Income income = new Income(gamePrizeIndexValues);

        assertThat(income.getCount(2)).isEqualTo(3);
    }

}
