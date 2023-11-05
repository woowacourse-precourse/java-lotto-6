package lotto;

import java.util.Arrays;
import lotto.domain.Lotto;
import lotto.domain.wrapper.LottoNumber;
import lotto.utils.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또가 가진 번호들을 의도한 포멧에 맞게 반환한다.")
    @Test
    void getLottoPrintFormat() {
        // given
        Lotto lotto = new Lotto(List.of(35,20,9,8,13,5));
        // when
        String lottoPrintFormat = lotto.toString();
        // then
        assertThat(lottoPrintFormat).isEqualTo("[5, 8, 9, 13, 20, 35]");
    }

    @DisplayName("당첨 번호와 로또 번호를 비교하여 등수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6:FIRST",
            "1,2,3,4,5,7:SECOND",
            "1,2,3,4,5,8:THIRD",
            "1,2,3,4,7,8:FOURTH",
            "1,2,3,7,8,9:FIFTH",
            "1,2,7,8,9,10:NO_PRIZE"
    }, delimiter = ':')
    void getPrize(String inputNumbers, String expectedPrize) {
        // given
        List<Integer> numbers = Arrays.stream(inputNumbers.split(","))
                .map(Integer::parseInt)
                .toList();
        Lotto lotto = new Lotto(numbers);
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));
        LottoNumber bonusNumber = new LottoNumber(7);
        // when
        Prize prize = lotto.getPrize(winningLotto, bonusNumber);
        // then
        assertThat(prize.name()).isEqualTo(expectedPrize);
    }
}