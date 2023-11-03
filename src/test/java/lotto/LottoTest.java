package lotto;

import lotto.domain.lotto.Lotto;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    // 아래에 추가 테스트 작성 가능

    @Test
    @DisplayName("번호가 중복되면 예외가 발생한다.")
    public void checkForDuplicateNumbers() {
        // given
        List<Integer> numbers = List.of(1, 3, 3, 4, 5, 6);
        // when // then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 오름차순으로 정렬되어 있지 않으면 예외가 발생한다.")
    public void validateSortedAscending() {
        // given
        List<Integer> numbers = List.of(1, 2, 4, 3, 5, 6);
        // when // then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LOTTO_NUMBERS_NOT_SORTED.getMessage());
    }

//    @Test
//    @DisplayName("로또의 번호들을 하나의 문자열로 반환할 수 있다.")
//    public void lottoNumbersAsString() {
//        // given
//        String result = "[8, 21, 23, 41, 42, 43]";
//        Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
//        // when
//        String numbersAsString = lotto.lottoNumbersAsString();
//        // then
//        assertThat(result).isEqualTo(numbersAsString);
//    }
//
//    @Test
//    @DisplayName("당첨된 로또와 비교해서 맞춘 개수를 반환할 수 있다.")
//    public void lottoMatchValue() {
//        // given
//        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
//        Lotto lotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
//        // when
//        int count = lotto.calculateLottoMatch(winningLotto);
//        // then
//        assertThat(count).isEqualTo(3);
//    }
}