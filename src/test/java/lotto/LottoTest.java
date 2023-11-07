package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @DisplayName("로또 번호가 1부터 45 사이의 숫자인지 확인")
    @Test
    void createLottoWithNumbersInRange() {
        assertThatThrownBy(() -> new Lotto(List.of(10, 20, 30, 50, 5, 15)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1부터 45 사이의 숫자를 입력해야 합니다.");
    }

    @DisplayName("로또 번호가 오름차순으로 출력되는지 확인")
    @Test
    void printLottoInAscendingOrder() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        LottoGame lottoGame = new LottoGame();
        lottoGame.setLottoGame(1);
        Lotto lotto = new Lotto(List.of(6, 2, 4, 1, 3, 5)); // 순서가 섞인 로또 번호
        lottoGame.lottogame.add(lotto);

        lottoGame.printLotto();

        String expectedOutput = "[1, 2, 3, 4, 5, 6]";
        assertEquals(expectedOutput, outContent.toString().trim());
    }
}