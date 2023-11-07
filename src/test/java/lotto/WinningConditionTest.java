package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningCondition;
import lotto.dto.LottoCompareResult;
import lotto.ui.TestInputReader;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinningConditionTest {
    private final TestInputReader testInputReader = new TestInputReader();
    private final WinningCondition winningCondition = new WinningCondition(testInputReader);
    private static final LottoCompareResult resultFirst = new LottoCompareResult(6,false);
    private static final LottoCompareResult resultSecond = new LottoCompareResult(5,true);
    private static final LottoCompareResult resultThird = new LottoCompareResult(5,false);
    private static final LottoCompareResult resultFourth = new LottoCompareResult(4,false);
    private static final LottoCompareResult resultFifth = new LottoCompareResult(3,false);

    @Nested
    class compare {
        @Test
        void 모든_번호가_맞는_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            winningCondition.inputWinningNumbers();
            testInputReader.setInput("7");
            winningCondition.inputBonusNumbers();
            List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
            Lotto lotto = new Lotto(numbers);

            assertThat(winningCondition.compare(lotto)).isEqualTo(resultFirst);
        }

        @Test
        void 번호5개와_보너스_번호가_맞는_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            winningCondition.inputWinningNumbers();
            testInputReader.setInput("7");
            winningCondition.inputBonusNumbers();
            List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
            Lotto lotto = new Lotto(numbers);

            assertThat(winningCondition.compare(lotto)).isEqualTo(resultSecond);
        }

        @Test
        void 번호5개는_맞지만_보너스_번호가_틀린_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            winningCondition.inputWinningNumbers();
            testInputReader.setInput("7");
            winningCondition.inputBonusNumbers();
            List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 8));
            Lotto lotto = new Lotto(numbers);

            assertThat(winningCondition.compare(lotto)).isEqualTo(resultThird);
        }

        @Test
        void 번호4개와_보너스_번호가_맞는_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            winningCondition.inputWinningNumbers();
            testInputReader.setInput("7");
            winningCondition.inputBonusNumbers();
            List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 10, 7));
            Lotto lotto = new Lotto(numbers);

            assertThat(winningCondition.compare(lotto)).isNotEqualTo(resultFourth);
        }

        @Test
        void 번호4개는_맞고_보너스_번호가_틀린_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            winningCondition.inputWinningNumbers();
            testInputReader.setInput("7");
            winningCondition.inputBonusNumbers();
            List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 10, 11));
            Lotto lotto = new Lotto(numbers);

            assertThat(winningCondition.compare(lotto)).isEqualTo(resultFourth);
        }

        @Test
        void 번호3개와_보너스_번호가_맞는_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            winningCondition.inputWinningNumbers();
            testInputReader.setInput("7");
            winningCondition.inputBonusNumbers();
            List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 7, 10, 11));
            Lotto lotto = new Lotto(numbers);

            assertThat(winningCondition.compare(lotto)).isNotEqualTo(resultFifth);
        }

        @Test
        void 번호3개는_맞고_보너스_번호가_틀린_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            winningCondition.inputWinningNumbers();
            testInputReader.setInput("7");
            winningCondition.inputBonusNumbers();
            List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 12, 10, 11));
            Lotto lotto = new Lotto(numbers);

            assertThat(winningCondition.compare(lotto)).isEqualTo(resultFifth);
        }
    }

    @Nested
    class inputBonusNumbers {
        @Test
        void 입력한_숫자를_입력한_경우() {
            testInputReader.setInput("1,2,3,4,5,6");
            winningCondition.inputWinningNumbers();
            testInputReader.setInput("1");
            assertThrows(IllegalArgumentException.class, () -> winningCondition.inputBonusNumbers());
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

            assertThat(winningCondition.getWinningNumber().getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        }
    }
}