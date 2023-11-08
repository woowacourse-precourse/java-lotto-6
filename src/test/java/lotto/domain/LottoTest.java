package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("당첨 번호 개수 조회")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7:1,2,3,4,5,6:6", "1,2,3,4,5,6:7:5,6,7,8,9,10:2"}, delimiter = ':')
    void countMainNumbers(String mainNumbers, int bonus, String numbers, int expected) {
        List<Integer> mainNums = toIntegerList(mainNumbers);
        WinningNumbers winningNumbers = new WinningNumbers(new MainNumbers(mainNums), new BonusNumber(mainNums, bonus));
        Lotto lotto = new Lotto(toIntegerList(numbers));

        assertThat(lotto.countMatchingMainNumbers(winningNumbers)).isEqualTo(expected);
    }

    @DisplayName("보너스 번호 당첨 조회")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7:1,2,3,4,5,6:false", "1,2,3,4,5,6:7:5,6,7,8,9,10:true"}, delimiter = ':')
    void checkBonusMatch(String mainNumbers, int bonus, String numbers, boolean expected) {
        List<Integer> mainNums = toIntegerList(mainNumbers);
        WinningNumbers winningNumbers = new WinningNumbers(new MainNumbers(mainNums), new BonusNumber(mainNums, bonus));
        Lotto lotto = new Lotto(toIntegerList(numbers));

        assertThat(lotto.hasBonusNumber(winningNumbers)).isEqualTo(expected);
    }

    List<Integer> toIntegerList(String value) {
        return Arrays.stream(value.split(","))
                .map(Integer::valueOf)
                .toList();
    }

}
