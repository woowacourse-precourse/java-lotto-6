package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoWithBonus;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoServiceTest {
    private static Stream<Arguments> userLottoAndGeneratedLotto() {
        return Stream.of(
                Arguments.of(convertToNumbers(1, 2, 3, 4, 5, 6), 10,
                        convertToNumbers(1, 2, 3, 4, 5, 6), 6),

                Arguments.of(convertToNumbers(1, 2, 3, 4, 5, 6), 10,
                        convertToNumbers(1, 2, 3, 4, 5, 45), 5),

                Arguments.of(convertToNumbers(1, 2, 3, 4, 5, 6), 10,
                        convertToNumbers(1, 2, 3, 4, 44, 45), 4),

                Arguments.of(convertToNumbers(1, 2, 3, 4, 5, 6), 10,
                        convertToNumbers(1, 2, 3, 43, 44, 45), 3),

                Arguments.of(convertToNumbers(1, 2, 3, 4, 5, 6), 10,
                        convertToNumbers(1, 2, 42, 43, 44, 45), 2),

                Arguments.of(convertToNumbers(1, 2, 3, 4, 5, 6), 10,
                        convertToNumbers(1, 41, 42, 43, 44, 45), 1),

                Arguments.of(convertToNumbers(1, 2, 3, 4, 5, 6), 10,
                        convertToNumbers(40, 41, 42, 43, 44, 45), 0)
        );
    }

    private static List<Integer> convertToNumbers(Integer... values) {
        return Arrays.stream(values)
                .toList();
    }

    @ParameterizedTest(name = "사용자 로또 : {0}  |  사용자 보너스 : {1}  |  생성된 로또 번호 : {2}  |  결과 : {3}")
    @MethodSource("userLottoAndGeneratedLotto")
    void 비교하기(List<Integer> userLotto, int userBonus, List<Integer> generatedLotto, int result) {
        LottoWithBonus user = LottoWithBonus.of(
                Lotto.from(userLotto), Bonus.from(userBonus)
        );
        Lotto lotto = Lotto.from(generatedLotto);

        int sameNumberCount = user.findSameNumberCount(lotto);

        assertThat(sameNumberCount).isEqualTo(result);
    }
}
