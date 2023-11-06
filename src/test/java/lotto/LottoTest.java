package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @DisplayName("로또 번호가 1부터 45사이에 있지 않은 경우 예외가 발생한다.")
    @Test
    void createLottoByNotIntRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 47, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_숫자_생성() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Set<Integer> noDuplicateNumbers = new HashSet<>(lottoNumbers);

        Lotto lotto = new Lotto(lottoNumbers);
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(noDuplicateNumbers.size());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD", "1,2,3,4,8,9:FOURTH",
            "1,2,3,8,9,10:FIFTH", "1,7,8,9,10,11:LOSE"}, delimiter = ':')
    @DisplayName("test")
    void 당첨_등수_확인(String input, Rank rank) {
        String[] data = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for(String number : data) {
            numbers.add(Integer.parseInt(number));
        }

        Lotto lotto = new Lotto(numbers);
        Lotto winner = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningLotto result = new WinningLotto(winner, bonusNumber);

        assertThat(result.getRank(lotto)).isEqualTo(rank);
    }
}