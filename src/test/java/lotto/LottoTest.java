package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constants.ErrorCode;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("로또 번호를 생성한 후, 오름차순으로 정렬이 된다.")
    public void should_sortedByAscent_after_createLottoNumbers() {
        List<LottoNumber> numbers = new Lotto(List.of(7, 4, 2, 6, 3, 1)).getNumbers();

        for (int i = 0; i < numbers.size() - 1; ++i) {
            assertThat(numbers.get(i).getNumber())
                    .isLessThan(numbers.get(i + 1).getNumber());
        }
    }

    @Test
    @DisplayName("Lotto 객체를 생성할 때, 1에서 45사이의 값이 아닌 수가 들어오면 예외가 발생한다")
    public void should_throwException_when_invalidRange() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_LOTTO_RANGE.getMessage());
    }

    @Test
    @DisplayName("List numbers 안에 특정 번호가 있는지 여부를 확인할 수 있다.")
    public void should_checkThatContainCertainNumber() {
        //given
        LottoNumber lottoNumber = LottoNumber.from("2");

        //when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        boolean hasCertainNumber = lotto.hasCertainNumber(lottoNumber);

        //then
        assertThat(hasCertainNumber).isTrue();
    }

    @Test
    @DisplayName("두 Lotto 객체 간에 겹치는 숫자가 몇 개인지 계산할 수 있다.")
    public void should_calculateDuplicated_between_twoLottoInstance() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto target = new Lotto(List.of(1, 2, 3, 7, 8, 9));

        //when
        int contained = lotto.countDuplicatedNumber(target);

        //then
        assertThat(contained).isEqualTo(3);
    }
}