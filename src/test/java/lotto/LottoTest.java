package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
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

    @DisplayName("로또 번호에 맞지 않는 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByInvalidNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("로또 번호 출력확인")
    @Test
    void printNumbersTest() {
        Lotto lotto = new Lotto(List.of(1,3,5,7,9,11));
        System.setOut(new PrintStream(outputStreamCaptor));
        lotto.printNumbers();
        String output = outputStreamCaptor.toString().trim();
        String expectedOutput = "[1, 3, 5, 7, 9, 11]";
        assertEquals(expectedOutput, output);
        System.setOut(System.out);
    }

    // 아래에 추가 테스트 작성 가능
}