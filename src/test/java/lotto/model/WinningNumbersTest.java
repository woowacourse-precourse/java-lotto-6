package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.model.WinningNumbers.createWinningNumbers;
import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest {

    private WinningNumbers winningNumbers;

    @BeforeEach
    public void setup() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        winningNumbers = createWinningNumbers(lotto, bonusNumber);

    }

    @ParameterizedTest
    @CsvSource(value = {"1:flase", "2:false", "3:false", "4:false", "5:true"}, delimiter = ':')
    @DisplayName("matchCount 5 일치하는지 테스트")
    public void isSameBonusNumberConditionTest(int matchNumberCount, boolean estimate) {
        boolean flag = winningNumbers.isSameBonusNumberCondition(matchNumberCount);
        assertThat(flag).isEqualTo(estimate);
    }

    @Test
    @DisplayName("bonusNumber true false 확인")
    public void checkExistBonusNumber() {
        int matchNumberCount = 5;
        Lotto containsBonusNumber = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto onlyFiveEqualLotto = new Lotto(List.of(2, 3, 4, 5, 6, 8));

        boolean second = winningNumbers.checkExistBonusNumber(containsBonusNumber, matchNumberCount);
        boolean third = winningNumbers.checkExistBonusNumber(onlyFiveEqualLotto, matchNumberCount);

        assertThat(second).isTrue();
        assertThat(third).isFalse();

    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST",
            "2,3,4,5,6,7:SECOND",
            "2,3,4,5,6,8:THIRD",
            "1,2,3,4,10,11:FOURTH",
            "1,2,3,10,11,12:FIFTH",
            "1,2,10,11,12,13:PASS"}
            , delimiter = ':')
    @DisplayName("순위를 체크한다.")
    public void determineRankTest(String lottoNumbers, Rank estimate) {

        List<Integer> numbers = Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lotto lotto = new Lotto(numbers);

        Rank rank = winningNumbers.determineRank(lotto);
        assertThat(rank).isEqualTo(estimate);

    }


}