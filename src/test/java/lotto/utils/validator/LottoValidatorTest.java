package lotto.utils.validator;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidatorTest {
    @Test
    @DisplayName("정상적인 로또 일 경우")
    void 정상적인_로또_일_경우() throws Exception {
        //given
        Lotto correctLotto = getCorrectLotto();
        //when then
        assertThatCode(() -> LottoValidator.valid(correctLotto.getNumbers()))
                .doesNotThrowAnyException();
    }
    @Test
    @DisplayName("여섯개가 아닌 경우")
    void 여섯개가_아닌_경우() throws Exception {
        //given
        List<Integer> numbers = getNotFullList();
        //when then
        assertThatThrownBy(() -> LottoValidator.valid(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("중복값이 있는 경우")
    void 중복값이_있는_경우() throws Exception {
        //given
        List<Integer> numbers = getDuplicateList();
        //when then
        assertThatThrownBy(() -> LottoValidator.valid(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
    private static Lotto getCorrectLotto() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }
    private static List<Integer> getDuplicateList() {
        return List.of(1, 2, 3, 4, 5);
    }
    private static List<Integer> getNotFullList() {
        return List.of(1, 2, 3, 4, 5);
    }
}