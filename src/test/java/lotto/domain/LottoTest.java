package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void newLotto() {
        assertThatCode(Lotto::new).doesNotThrowAnyException();
        assertThatCode(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("중복된 수가 있는 로또 예외 처리")
    void Given_DuplicatedNumberLotto_When_Then_ThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 1, 1, 1, 1))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 1, 1, 1, 1))).hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("6개의 수로 이루어진 로또가 아님에 대한 예외 처리")
    void Given_InvalidLengthLotto_When_Then_ThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 1))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 1, 1))).hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("유효 범위의 수를 갖는 로또에 대한 예외 처리")
    void Given_InvalidRangeLotto_When_Then_ThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> new Lotto(List.of(-1, 46, 3, 4, 5, 6))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(-1, 46, 3, 4, 5, 6))).hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("문자열에서 로또로 형변환이 문제 없이 잘 되는지 확인")
    @ValueSource(strings = {"1,2,3,4,5,6", "45,44,43,42,41,40", "1,45,2,44,3,43"})
    void Given_StringNumber_When_ChangedToLotto_Then_ValueIsSame(String input) {
        // given
        // when
        Lotto lotto = Lotto.toLotto(input);
        int ret = 0;
        for (Integer x : new ArrayList<>(Arrays.asList(input.split(","))).stream()
                .map(Integer::valueOf)
                .toList()) {
            if (lotto.contains(x)) {
                ret++;
            }
        }
        // then
        assertThat(ret).isEqualTo(6);
    }


    @Test
    @DisplayName("두 로또의 수의 비교가 제대로 이루어지는지 확인")
    void Given_TwoSameLotto_When_Compare_Then_MatchedNumberIsSix() {
        //Given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // When
        int matchedNumber = lotto1.compare(lotto2);
        // Then
        assertThat(matchedNumber).isEqualTo(6);
    }

    @Test
    @DisplayName("로또가 수들을 제대로 반환하는지 확인")
    void Given_DefinedList_When_UseGetNumbers_Then_ListNumberAndLottoNumberIsSame() {
        //Given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(list);
        //When
        List<Integer> numbers = lotto.getNumbers();
        //Then
        assertThat(list).isEqualTo(numbers);
    }

    @Test
    @DisplayName("로또가 수가 포함 되어 있는지 제대로 확인하는지 확인")
    void Given_DefinedList_When_UseContains_Then_NumberNotInListReturnsFalse() {
        //Given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(list);
        //When
        boolean isThere = lotto.contains(45);
        //Then
        assertThat(isThere).isEqualTo(false);
    }
}