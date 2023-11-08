package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoCheckerTest {

    @DisplayName("로또 하나가 있으면 Ranking을 알려준다.")
    @ParameterizedTest
    @CsvSource(value = {"'1,2,3,4,5,6', FIRST_PLACE", "'1,2,3,4,5,7', FIRST_PLACE", "'1,2,3,4,7,8', SECOND_PLACE",
            "'1,2,3,4,5,8', THIRD_PLACE", "'1,2,3,4,8,9', FOURTH_PLACE", "'1,2,3,8,9,10', FIFTH_PLACE"})
    void checkOneLotto(String numbersCsv, Ranking expected) {

        LottoChecker lottoChecker = new LottoChecker(List.of(1, 2, 3, 4, 5, 6), 7);

        List<Integer> numbers = getNumbers(numbersCsv);
        Lotto lotto = new Lotto(numbers);

        Ranking ranking = lottoChecker.checkOneLotto(lotto);

        assertThat(ranking).isEqualTo(expected);
    }

    private static List<Integer> getNumbers(String numbersCsv) {
        List<Integer> numbers = Arrays.stream(numbersCsv.split(","))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return numbers;
    }
}
