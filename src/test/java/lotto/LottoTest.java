package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import view.InputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

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
    void 로또_입력_예외_테스트() {
        assertThatThrownBy(() -> InputView.makeLottoList("1,2,3,4,5,a"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("보너스_번호_중복_테스트")
    void 보너스_번호_예외_테스트(int bonusNumber) {
        List<Integer> lotto = InputView.makeLottoList("1,2,3,4,5,6");
        assertThatThrownBy(() -> InputView.duplicationCheck(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(ints = {49, -1, 0})
    @DisplayName("보너스_번호_범위_테스트")
    void 보너스_번호_범위_테스트(int bonusNumber) {
        assertThatThrownBy(() -> InputView.rangeCheck(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,1,2,3,4,5", "1,29,49,2,3,6"})
    @DisplayName("복권 생성 테스트")
    void 복권_생성_테스트(String number) {
        String[] numbers = number.split(",");
        List<Integer> lotto = new ArrayList<>();

        for (String num : numbers) {
            lotto.add(Integer.parseInt(num));
        }

        assertThatThrownBy(() -> new Lotto(lotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_종합_테스트() {
        int count = 8;
        List<Lotto> lottos = InputView.generateLotto(count);

        for (Lotto lotto : lottos) {
            Set<Integer> testLotto = new HashSet<>(lotto.getLottoNumbers());
            assertThat(lotto.getLottoNumbers().size()).isEqualTo(testLotto.size());
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,5,8:THIRD", "1,2,3,4,8,9:FOURTH",
            "1,2,3,8,9,10:FIFTH", "1,7,8,9,10,11:LOSE"}, delimiter = ':')
    void 당첨_등수_확인(String input, Rank rank) {
        String[] data = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String number : data) {
            numbers.add(Integer.parseInt(number));
        }

        Lotto lotto = new Lotto(numbers);
        Lotto winner = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningLotto result = new WinningLotto(winner, bonusNumber);

        assertThat(result.getRank(lotto)).isEqualTo(rank);
    }
}