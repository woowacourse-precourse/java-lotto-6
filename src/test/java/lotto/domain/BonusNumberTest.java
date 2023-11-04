package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @ParameterizedTest(name = "입력 값 : {0}")
    @ValueSource(ints = {46, 47, 48, 49, 50})
    @DisplayName("범위 밖의 보너스 번호 입력을 하면 예외가 발생한다.")
    void 범위_밖_보너스_번호_입력_테스트(int bonusNumber) {
        //when, then
        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 45사이의");
    }

    @ParameterizedTest(name = "로또번호 : {0}, 보너스번호 : {1}, 기대 값 : {2}")
    @MethodSource("generateLottoAndBonusNumber")
    @DisplayName("로또에 보너스 번호 포함하는지 판별한다.")
    void 보너스_번호_포함_테스트(List<Integer> lottoNumber, int bonus, boolean expected) {
        //given
        Lotto lotto = new Lotto(lottoNumber);
        BonusNumber bonusNumber = new BonusNumber(bonus);

        //when
        boolean actual = bonusNumber.hasBonus(lotto);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> generateLottoAndBonusNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6, true),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 15, false),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 4, true),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 23, false)
        );
    }

}
