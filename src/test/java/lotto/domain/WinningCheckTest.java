package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningCheckTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD", "1,2,3,4,8,10:FOURTH",
            "1,2,3,8,9,10:FIFTH", "1,2,8,9,10,11:EMPTY"}, delimiter = ':')
    @DisplayName("match 메소드 작동 테스트")
    void compare(String input, RankingLotto rankingLotto) {
        String[] list = input.split(",");
        List<Integer> userLottoNum = new ArrayList<>();
        for (String string : list) {
            userLottoNum.add(Integer.parseInt(string));
        }
        Lotto user = new Lotto(userLottoNum);
        Lotto winning = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNum = 7;
        WinningCheck winningCheck = new WinningCheck(winning, bonusNum);

        assertThat(winningCheck.match(user)).isEqualTo(rankingLotto);
    }
}