//package lotto.domain;
//
//import lotto.domain.lotto.WinningNumber;
//import lotto.domain.lotto.WinningNumbers;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//public class WinningNumbersTest {
//
//    WinningNumbers winningNumbers;
//
//    @BeforeEach
//    void setUp() {
//        winningNumbers = new WinningNumbers();
//    }
//
//    @Test
//    void 당첨번호_생성시_잘_만들어지는지_확인() {
//        String winningNormalNumbers = "1, 2, 3, 4, 5, 6";
//
//        winningNumbers.generateWinningNormalNumbers(winningNormalNumbers);
//
//        List<Integer> expected = List.of(1,2,3,4,5,6);
//
//        List<WinningNumber> winningNormalNumber = winningNumbers.getWinningNormalNumbers();
//        for(int i = 0; i<winningNormalNumber.size(); i++) {
//            WinningNumber winningNumber = winningNormalNumber.get(i);
//            assertThat(winningNumber.getNumber())
//                    .isEqualTo(expected.get(i));
//        }
//    }
//
//    @Test
//    void 당첨번호_생성_시_중복이_있으면_예외를_던지는지_확인() {
//        String inputNumbers = "1, 2, 3, 2, 5, 6";
//        assertThatThrownBy(() -> winningNumbers.generateWinningNormalNumbers(inputNumbers))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("중복 x");
//    }
//
//    @Test
//    void 보너스_숫자_잘_생성되는지_확인() {
//        String inputNumbers = "1, 2, 3, 4, 5, 6";
//        String inputNumber = "7";
//
//        Integer expected = 7;
//
//        winningNumbers.generateWinningNormalNumbers(inputNumbers);
//        winningNumbers.generateBonusNumber(inputNumber);
//
//        WinningNumber bonusNumber = winningNumbers.getBonusNumber();
//        assertThat(bonusNumber.getNumber())
//                .isEqualTo(expected);
//    }
//
//    @Test
//    void 보너스_숫자가_당첨번호와_중복되면_예외_던지는지_확인() {
//        String inputNumbers = "1, 2, 3, 4, 5, 6";
//        String inputNumber = "3";
//
//        winningNumbers.generateWinningNormalNumbers(inputNumbers);
//        assertThatThrownBy(() -> winningNumbers.generateBonusNumber(inputNumber))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("중복 x");
//    }
//
//    @Test
//    void 당첨_숫자_개수가_6개_초과인_경우_예외를_던지는지_확인() {
//        String inputNumbers = "1, 2, 3, 4, 5, 6, 7";
//
//        assertThatThrownBy(() -> winningNumbers.generateWinningNormalNumbers(inputNumbers))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("당첨 숫자 개수는 6개");
//
//    }
//
//    @Test
//    void 당첨_숫자_개수가_6개_미만인_경우_예외를_던지는지_확인() {
//        String inputNumbers = "1, 2, 3, 4, 5";
//
//        assertThatThrownBy(() -> winningNumbers.generateWinningNormalNumbers(inputNumbers))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("당첨 숫자 개수는 6개");
//
//    }
//
//
//}
