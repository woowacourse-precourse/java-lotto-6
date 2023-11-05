package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.ui.TestInputReader;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningConditionTest {
    private TestInputReader testInputReader = new TestInputReader();
    private WinningCondition winningCondition = new WinningCondition(testInputReader);
    @Nested
    class inputBonusNumbers {
        @Test
        void 입력한_숫자를_입력한_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            winningCondition.inputWinningNumbers();
            testInputReader.setInput("1");
            assertThrows(IllegalArgumentException.class, ()->winningCondition.inputBonusNumbers());
        }

        @Test
        void 영어_입력의_경우() {
            testInputReader.setInput("six");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputBonusNumbers());
        }

        @Test
        void 한글_입력의_경우() {
            testInputReader.setInput("육");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputBonusNumbers());
        }

        @Test
        void 특수문자_입력의_경우() {
            testInputReader.setInput("^");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputBonusNumbers());
        }

        @Test
        void 빈값_입력의_경우() {
            testInputReader.setInput("");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputBonusNumbers());
        }
        @Test
        void 번호범위보다_작은_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            winningCondition.inputWinningNumbers();
            testInputReader.setInput("0");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputBonusNumbers());
        }

        @Test
        void 번호범위보다_큰_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            winningCondition.inputWinningNumbers();
            testInputReader.setInput("46");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputBonusNumbers());
        }

        @Test
        void 정상적인_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            winningCondition.inputWinningNumbers();
            testInputReader.setInput("7");
            winningCondition.inputBonusNumbers();

            assertThat(winningCondition.getBonusNumber().getNumber()).isEqualTo(7);
        }
    }

    @Nested
    class inputWinningNumbers {
        @Test
        void 영어_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5,six");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputWinningNumbers());
        }

        @Test
        void 한글_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5,육");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputWinningNumbers());
        }

        @Test
        void 특수문자_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5,^");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputWinningNumbers());
        }

        @Test
        void 빈값_입력의_경우() {
            testInputReader.setInput("");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputWinningNumbers());
        }

        @Test
        void 갯수보다_적은_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputWinningNumbers());
        }

        @Test
        void 갯수보다_많은_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5,6,7");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputWinningNumbers());
        }

        @Test
        void 번호범위보다_작은_입력의_경우() {
            testInputReader.setInput("0,1,2,3,4,5");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputWinningNumbers());
        }

        @Test
        void 번호범위보다_큰_입력의_경우() {
            testInputReader.setInput("46,2,3,4,5,6");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputWinningNumbers());
        }

        @Test
        void 정상적인_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            winningCondition.inputWinningNumbers();

            assertThat(winningCondition.getWinningNumber().getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
        }
    }
}