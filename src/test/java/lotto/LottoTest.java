package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.exception.UserInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

class LottoTest {

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개 이하로 입력해 주세요.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(UserInputException.class)
                .hasMessage("[ERROR] 중복된 숫자가 포함 되어 있습니다.");
    }

    @Test
    void 로또_번호가_45이상일경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 55, 5)))
                .isInstanceOf(UserInputException.class)
                .hasMessage("[ERROR] 1~45 이하 숫자를 입력해 주세요.");
    }

    @ParameterizedTest
    @ArgumentsSource(LottoArgumentsProvider.class)
    void 로또_번호랑_매치되는_숫자의_합계를_리턴한다(List<Integer> lottoNumbers, List<Integer> lottoValue, int expected) {
        Lotto lotto = new Lotto(lottoNumbers);
        int result = lotto.matchLottoCount(lottoValue);
        assertThat(result).isEqualTo(expected);
    }

    static class LottoArgumentsProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            List<Arguments> arguments = new ArrayList<>();
            arguments.add(arguments(List.of(1, 2, 34, 3, 5, 7), List.of(1, 2, 34, 5, 7, 8), 5));
            arguments.add(arguments(List.of(1, 2, 34, 3, 5, 7), List.of(1, 2, 34, 5, 23, 8), 4));
            return arguments.stream();
        }
    }


    @Test
    void 로또_번호중_보너스_번호랑_일치하면_True를_반환_한다() {
        Lotto lotto = new Lotto(List.of(2, 3, 33, 35, 12, 5));
        boolean isTrue = lotto.isBonusMatch(3);
        assertThat(isTrue).isTrue();
    }
}