package lotto;

import java.util.stream.Stream;
import lotto.model.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
    @ParameterizedTest
    @MethodSource("toStringTestArgs")
    public void toStringTest(List<Integer> lottoNumbers, String lottoString) throws Exception{
        //given
        Lotto lotto = new Lotto(lottoNumbers);

        //when
        //then
        Assertions.assertThat(lotto.toString())
                .isEqualTo(lottoString);
    }

    private static Stream<Arguments> toStringTestArgs(){
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), "[1, 2, 3, 4, 5, 6]"),
                Arguments.of(List.of(1, 5, 12, 15, 21, 25), "[1, 5, 12, 15, 21, 25]"),
                Arguments.of(List.of(12, 15, 20, 25, 31, 42), "[12, 15, 20, 25, 31, 42]")
        );
    }
}