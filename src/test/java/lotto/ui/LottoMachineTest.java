package lotto.ui;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.Lotto;
import lotto.WinningNumber;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {
    private final TestInputReader testInputReader = new TestInputReader();
    private final LottoMachine lottoMachine = new LottoMachine(testInputReader);

    @Nested
    class inputWinningNumbers {
        @Test
        void 영어_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5,six");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.inputWinningNumbers());
        }

        @Test
        void 한글_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5,육");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.inputWinningNumbers());
        }

        @Test
        void 특수문자_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5,^");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.inputWinningNumbers());
        }

        @Test
        void 빈값_입력의_경우() {
            testInputReader.setInput("");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.inputWinningNumbers());
        }

        @Test
        void 갯수보다_적은_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.inputWinningNumbers());
        }

        @Test
        void 갯수보다_많은_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5,6,7");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.inputWinningNumbers());
        }

        @Test
        void 번호범위보다_작은_입력의_경우() {
            testInputReader.setInput("0,1,2,3,4,5");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.inputWinningNumbers());
        }

        @Test
        void 번호범위보다_큰_입력의_경우() {
            testInputReader.setInput("46,2,3,4,5,6");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.inputWinningNumbers());
        }

        @Test
        void 정상적인_입력의_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            WinningNumber winningNumber = lottoMachine.inputWinningNumbers();

            assertThat(winningNumber.getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
        }
    }

    @Test
    void 로또_생성_갯수_테스트() {
        testInputReader.setInput("3000");
        lottoMachine.insertMoney();
        List<Lotto> lottos = lottoMachine.generateLottos();
        assertThat(lottos.size()).isEqualTo(3);
    }

    @Test
    void 로또_생성_갯수_테스트_돈이_없는_상태() {
        assertThrows(IllegalStateException.class, () -> lottoMachine.generateLottos());
    }

    @Nested
    class 사용자_구입_금액_테스트 {
        @Test
        void 영어_입력인_경우() {
            testInputReader.setInput("abc");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney());
        }

        @Test
        void 한글_입력인_경우() {
            testInputReader.setInput("오천원어치요");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney());
        }

        @Test
        void 특수문자_입력인_경우() {
            testInputReader.setInput("!@#$");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney());
        }

        @Test
        void 빈값_입력() {
            testInputReader.setInput("");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney());
        }

        @Test
        void 글자와_숫자가_혼합_입력() {
            testInputReader.setInput("abc1000");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney());
        }

        @Test
        void INT_범위_외_입력() {
            testInputReader.setInput("2147483648");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney());
        }

        @Test
        void 단위가_다른_돈_입력() {
            testInputReader.setInput("6001");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney());
        }

        @Test
        void ZERO_값_입력() {
            testInputReader.setInput("0");
            assertThrows(IllegalArgumentException.class, () -> lottoMachine.insertMoney());
        }

        @Test
        void 정상적인_돈_입력() {
            testInputReader.setInput("1000");
            lottoMachine.insertMoney();
        }
    }

}
