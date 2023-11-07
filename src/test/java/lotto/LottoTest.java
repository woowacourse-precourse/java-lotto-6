package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.constant.GameConstant;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 모두 일치하는 경우 매치 결과는 6이다.")
    @Test
    void matchAll(){
        assertMatch(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1, 2, 3, 4, 5, 6), 7, 6, 0);
    }

    @DisplayName("당첨 번호가 5개 일치하는 경우 매치 결과는 5이다.")
    @Test
    void matchFive(){
        assertMatch(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1, 2, 3, 4, 5, 8), 7, 5, 0);
    }
    @DisplayName("당첨 번호가 4개 일치하고 보너스 번호가 1개 일치하는 경우 매치 결과는 4이다.")
    @Test
    void matchFour(){
        assertMatch(Arrays.asList(1,2,3,4,5,6), Arrays.asList(11, 2, 3, 4, 5, 8), 6, 4, 1);
    }

    @DisplayName("당첨 번호가 3개 일치하는 경우 매치 결과는 3이다.")
    @Test
    void matchThree(){
        assertMatch(Arrays.asList(1,2,3,4,5,6), Arrays.asList(11, 12, 3, 4, 5, 8), 7, 3, 0);
    }
    @DisplayName("당첨 번호가 2개 일치하고 보너스 번호가 1개 일치하는 경우 매치 결과는 2이다.")
    @Test
    void matchTwo(){
        assertMatch(Arrays.asList(1,2,3,4,5,6), Arrays.asList(11, 12, 13, 4, 5, 8), 6, 2, 1);
    }
    @DisplayName("당첨 번호가 1개 일치하는 경우 매치 결과는 1이다.")
    @Test
    void matchOne(){
        assertMatch(Arrays.asList(1,2,3,4,5,6), Arrays.asList(11, 12, 13, 14, 5, 8), 7, 1, 0);
    }

    private static void assertMatch(List<Integer> lotto, List<Integer> luckyNumbers, int bonusNumber, int luckyCount, int bonusCount) {
        Map<String, Integer> result = new Lotto(lotto).match(luckyNumbers, bonusNumber);
        Map<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put(GameConstant.LUCKY_NUMBERS, luckyCount);
        expectedResult.put(GameConstant.BONUS_NUMBER, bonusCount);

        Assertions.assertThat(result).isEqualTo(expectedResult);
    }
}