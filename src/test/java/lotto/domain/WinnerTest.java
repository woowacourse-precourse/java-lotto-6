package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Ranking;
import lotto.model.Winner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinnerTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD", "1,2,3,4,8,10:FOURTH",
            "1,2,3,8,9,10:FIFTH", "1,2,8,9,10,11:NOTHING"}, delimiter = ':')
    @DisplayName("우승자 당첨 번호 일치")
    void ranking(String input, Ranking ranking) {
        List<String> str = List.of(input.split(","));
        List<Integer> lottoNumberList = new ArrayList<>();

        for (int i = 0; i < str.size(); i++) {
            String number = str.get(i);
            lottoNumberList.add(Integer.parseInt(number));
        }

        Lotto lottoAllList = new Lotto(lottoNumberList);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonus = 7;

        Winner winner = new Winner(lotto, bonus);
        assertThat(winner.winnerMatch(lottoAllList)).isEqualTo(ranking);
    }
}
