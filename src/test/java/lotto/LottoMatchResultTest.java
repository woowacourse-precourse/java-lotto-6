package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMatchResult;
import lotto.model.WinnerJudge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMatchResultTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD", "1,2,3,4,7,8:FOURTH",
            "1,2,3,7,8,9:FIFTH", "1,2,7,8,9,10:MISS"}, delimiter = ':')
    @DisplayName("로또 번호와 당첨번호를 입력하여 등수가 맞게 나오는지 확인")
    void compare(String input, WinnerJudge winnerJudge) {
        String[] playerNumber = input.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < playerNumber.length; i++) {
            lottoNumbers.add(Integer.parseInt(playerNumber[i]));
        }
        Lotto boughtNumbers = new Lotto(lottoNumbers);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonus = 7;
        LottoMatchResult lottoMatchResult = new LottoMatchResult(lotto, bonus);
        assertThat(lottoMatchResult.match(boughtNumbers)).isEqualTo(winnerJudge);
    }
}
