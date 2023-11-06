package lotto.application.output;

import static java.util.stream.Collectors.toList;
import static lotto.resource.TextResourceProvider.LOTTO_NUMBERS_TEXT_FORMAT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.MyApplicationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[Application] 구입로또에 대한 출력에 관한 테스트")
public class Application_PurchasedLotteryTest extends MyApplicationTest {
    @Test
    void 각_로또_번호가_LottoNumbersFormat으로_출력된다() {
        runWithValidArguments();

        assertThat(outputs())
                .filteredOn(LOTTO_NUMBERS_TEXT_FORMAT::matches)
                .hasSizeGreaterThan(0);
    }

    @Test
    void 각_로또_번호가_오름차순으로_출력된다() {
        runWithValidArguments();

        assertThat(outputs())
                .filteredOn(LOTTO_NUMBERS_TEXT_FORMAT::matches)
                .hasSizeGreaterThan(0)
                .map(text -> convertToLottoNumbers(text))
                .allMatch(numbers -> areInAscendingOrder(numbers));
    }

    @Test
    void 각_로또의_번호는_중복되지_않는_6개의_숫자로_이루어져_있다() {
        runWithValidArguments();

        assertThat(outputs())
                .filteredOn(LOTTO_NUMBERS_TEXT_FORMAT::matches)
                .hasSizeGreaterThan(0)
                .map(text -> convertToLottoNumbers(text))
                .allMatch(numbers -> areUniqueSixNumbers(numbers));
    }

    @Test
    void 각_로또의_숫자는_1부터_45사이의_숫자이다() {
        runWithValidArguments();

        assertThat(outputs())
                .filteredOn(LOTTO_NUMBERS_TEXT_FORMAT::matches)
                .hasSizeGreaterThan(0)
                .map(text -> convertToLottoNumbers(text))
                .allMatch(numbers -> areInRangeOf(numbers, 1, 46));
    }

    private static List<Integer> convertToLottoNumbers(String text) {

        return LOTTO_NUMBERS_TEXT_FORMAT.parse(text)
                .stream()
                .map(Integer::parseInt)
                .collect(toList());
    }

    private static boolean areInAscendingOrder(List<Integer> numbers) {
        if (numbers.size() == 0) {
            return false;
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean areUniqueSixNumbers(List<Integer> numbers) {
        if (numbers.size() == 0) {
            return false;
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            uniqueNumbers.add(number);
        }
        return uniqueNumbers.size() == 6;
    }

    private static boolean areInRangeOf(List<Integer> numbers, int startInclusive, int endExclusive) {
        for (Integer number : numbers) {
            if (number < startInclusive || number >= endExclusive) {
                return false;
            }
        }

        return true;
    }

    private static void runWithValidArguments() {
        run("1000", "1,2,3,4,5,6", "7");
    }

}
