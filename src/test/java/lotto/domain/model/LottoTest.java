package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

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
    @DisplayName("로또 번호 중 1~45의 범위에 속하지 않는 숫자가 존재하면 예외가 발생한다.")
    @Test
    void createLottoByOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 47, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("발행된 로또 번호를 정렬하여 보여준다.")
    @Test
    void showLottoNumbers() {
        System.setOut(new PrintStream(outContent));

        Lotto lotto = new Lotto(List.of(1, 2, 3, 5, 4, 6));
        lotto.showNumbers();

        assertThat(outContent.toString().trim()).isEqualTo("[1, 2, 3, 4, 5, 6]");

        System.setOut(originalOut);
    }

    @DisplayName("발행된 로또가 당첨 번호와 보너스 번호를 받아서 등수를 반환한다")
    @ParameterizedTest
    @CsvSource({
            "1,2,3,4,5,6, FIRST",
            "1,2,3,4,5,7, SECOND",
            "1,2,3,4,5,8, THIRD",
            "1,2,3,4,8,7, FOURTH",
            "1,2,3,9,8,7, FIFTH",
            "1,2,10,9,8,7, NONE"
    })
    void calculateRank(int num1, int num2, int num3, int num4, int num5, int num6, String expectedRank) {
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        Lotto lotto = new Lotto(Arrays.asList(num1, num2, num3, num4, num5, num6));

        assertThat(lotto.calculateRank(winningNumber, bonusNumber))
                .isEqualTo(expectedRank);
    }
}