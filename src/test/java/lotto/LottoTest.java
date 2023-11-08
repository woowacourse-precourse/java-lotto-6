package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoPrize;
import lotto.model.NumberGenerator;
import lotto.model.WinningCombination;

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

    @ParameterizedTest
    @MethodSource("invalidCountOfLottoNumber")
    void 로또가_가져야할_로또_번호_개수가_6개_밑으면_내려가면_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 로또가_가져야할_로또_번호_개수가_6개라면_예외가_발생하지_않는다() {
        assertDoesNotThrow(
                () -> Lotto.from(List.of(1, 2, 3, 4, 5, 6))
        );
    }

    @Test
    void 로또가_중복되지_않는_로또_번호들로_이루어진다면_예외가_발생하지_않는다() {
        assertDoesNotThrow(
                () -> Lotto.from(List.of(1, 2, 3, 4, 5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("rightRangeOfNumbers")
    void 로또가_유효한_범위의_로또_번호들로_이루어지는_경우라면_예외가_발생하지_않는다(List<Integer> numbers) {
        assertDoesNotThrow(
                () -> Lotto.from(numbers)
        );
    }

    @ParameterizedTest
    @MethodSource("outRangeOfNumbers")
    void 로또는_유효한_범위의_로또_번호들로_이루어지지_않는_경우라면_예외가_발생한다(List<Integer> numbers) {
        assertThatThrownBy(() -> Lotto.from(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("invalidCountOfLottoNumber")
    void 숫자_생성기가_6개가_아닌_로또_번호들을_생성하면_로또_생성시_예외가_발생한다(List<Integer> numbers) {
        NumberGenerator numberGenerator = (min, max, size) -> numbers;

        assertThatThrownBy(() -> Lotto.create(numberGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_생성기가_6개의_로또_번호들을_생성하면_예외가_발생하지_않는다() {
        NumberGenerator numberGenerator = (min, max, size) -> List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(
                () -> Lotto.create(numberGenerator)
        );
    }

    @Test
    void 숫자_생성기가_중복된_로또_번호들을_생성하면_로또_생성시_예외가_발생한다() {
        NumberGenerator numberGenerator = (min, max, size) -> List.of(1, 2, 3, 4, 5, 5);

        assertThatThrownBy(() -> Lotto.create(numberGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_생성기가_중복되지_않는_로또_번호들을_생성하면_예외가_발생하지_않는다() {
        NumberGenerator numberGenerator = (min, max, size) -> List.of(1, 2, 3, 4, 5, 6);

        assertDoesNotThrow(
                () -> Lotto.create(numberGenerator)
        );
    }

    @ParameterizedTest
    @MethodSource("rightRangeOfNumbers")
    void 숫자_생성기가_유효한_범위의_로또_번호들을_생성하면_예외가_발생하지_않는다(List<Integer> numbers) {
        NumberGenerator numberGenerator = (min, max, size) -> numbers;

        assertDoesNotThrow(
                () -> Lotto.create(numberGenerator)
        );
    }

    @ParameterizedTest
    @MethodSource("outRangeOfNumbers")
    void 숫자_생성기는_유효한_범위의_로또_번호들을_생성하지_않으면_로또_생성시_예외가_발생한다(List<Integer> numbers) {
        NumberGenerator numberGenerator = (min, max, size) -> numbers;

        assertThatThrownBy(() -> Lotto.create(numberGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("determineLottoPrize")
    void 로또와_우승조합을_비교하여_우승상품을_찾을_수_있다(Lotto lotto, LottoPrize expectedPrize) {
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(7);
        WinningCombination winningCombination = WinningCombination.of(winningLotto, bonusNumber);

        LottoPrize actualPrize = lotto.determineLottoPrize(winningCombination);

        assertThat(actualPrize).isEqualTo(expectedPrize);
    }

    @Test
    void 로또에서_우승자번호와_보너스번호를_각각_비교하여_상품을_계산할때는_로또_안의_로또번호_순서는_상관없다() {
        Lotto lotto = Lotto.from(List.of(6, 5, 4, 3, 2, 1));
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(7);
        WinningCombination winningCombination = WinningCombination.of(winningLotto, bonusNumber);

        LottoPrize actualPrize = lotto.determineLottoPrize(winningCombination);

        assertThat(actualPrize).isEqualTo(LottoPrize.FIRST_PRIZE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, true", "2, true", "3, true", "4, true", "5, true", "6, true", "7, false"})
    void 로또가_특정_번호를_가지고_있는지_확인할_수_있다(int number, boolean expected) {
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        boolean actual = lotto.hasNumber(LottoNumber.from(number));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 외부로부터_받은_로또번호_목록이_변경되어도_로또_내부의_번호목록은_변경되지_않는다() {
        List<Integer> modifiableNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto protectedLotto = Lotto.from(modifiableNumbers);
        Lotto expectedLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        modifiableNumbers.clear();

        assertThat(protectedLotto).usingRecursiveComparison()
                .isEqualTo(expectedLotto);
    }

    @Test
    void 외부로_반환된_로또번호_목록이_변경되어도_로또_내부의_번호목록은_변경되지_않는다() {
        Lotto protectedLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        List<LottoNumber> modifiableNumbers = protectedLotto.getNumbers();
        Lotto expectedLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

        modifiableNumbers.clear();

        assertThat(protectedLotto).usingRecursiveComparison()
                .isEqualTo(expectedLotto);
    }

    private static Stream<Arguments> invalidCountOfLottoNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    private static Stream<Arguments> rightRangeOfNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(40, 41, 42, 43, 44, 45))
        );
    }

    private static Stream<Arguments> outRangeOfNumbers() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2, 44, 45, 46))
        );
    }

    private static Stream<Arguments> determineLottoPrize() {
        return Stream.of(
                Arguments.of(Lotto.from(List.of(1, 2, 3, 4, 5, 6)), LottoPrize.FIRST_PRIZE),
                Arguments.of(Lotto.from(List.of(1, 2, 3, 4, 5, 7)), LottoPrize.SECOND_PRIZE),
                Arguments.of(Lotto.from(List.of(1, 2, 3, 4, 5, 8)), LottoPrize.THIRD_PRIZE),
                Arguments.of(Lotto.from(List.of(1, 2, 3, 4, 7, 8)), LottoPrize.FOURTH_PRIZE),
                Arguments.of(Lotto.from(List.of(1, 2, 3, 7, 8, 9)), LottoPrize.FIFTH_PRIZE),
                Arguments.of(Lotto.from(List.of(1, 2, 7, 8, 9, 10)), LottoPrize.NOTHING)
        );
    }
}
