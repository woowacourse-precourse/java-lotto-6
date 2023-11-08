package model;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Lotto;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CheckLottoTest {

    private static CheckLotto checkLotto;

    private final List<Integer> ANSWER = List.of(1, 2, 3, 4, 5, 6);
    private final int BONUS = 7;

    @BeforeAll
    static void setUp() {
        checkLotto = new CheckLotto();
    }

    @DisplayName("여러 개의 랜덤 로또의 숫자 동일 개수")
    @Test
    public void checkLottoTest() {
        List<Lotto> lotto = new ArrayList<>();
        lotto.add(new Lotto(List.of(1, 12, 13, 4, 5, 16)));
        lotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 16)));
        lotto.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        assertThat(checkLotto.checkLotto(ANSWER, BONUS, lotto)).isEqualTo(new int[] {0, 0, 0, 1, 0, 1, 0, 1});
    }

    @DisplayName("숫자 동일 여부")
    @ParameterizedTest
    @CsvSource({"1, 12, 13, 4, 5, 16, 3", "1, 2, 13, 4, 5, 16, 4", "1, 2, 3, 4, 5, 16, 5", "1, 2, 3, 4, 5, 7, 7",
            "1, 2, 3, 4, 5, 6, 6"})
    public void sameNumberTest(int number1, int number2, int number3, int number4, int number5, int number6,
            int result) {
        assertThat(checkLotto.sameNumberCount(ANSWER, BONUS,
                List.of(number1, number2, number3, number4, number5, number6))).isEqualTo(result);
    }

    @DisplayName("")
    @ParameterizedTest
    @CsvSource({"5, 6, 2", "3, 6, 0"})
    public void checkBonusBallTest(int count, int bonus, int result) {
        assertThat(checkLotto.checkBonusBall(count, bonus, ANSWER)).isEqualTo(result);
    }
}