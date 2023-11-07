package lotto;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StartLottoTest {
    private static StartLotto test;
    private static List<Lotto> testLottoList;
    private static int testPurchasePrice;
    private static Lotto testWinningNumbers;
    private static int testBonusNumber;

    @DisplayName("테스트할 StartLotto 객체 먼저 생성")
    @BeforeEach
    void init() {
        List<Lotto> testLottoList = new ArrayList<Lotto>();
        testLottoList.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        testLottoList.add(new Lotto(List.of(1, 3, 4, 6, 12, 20)));
        testLottoList.add(new Lotto(List.of(2, 3, 4, 5, 6, 45)));
        int testPurchasePrice = 3000;
        Lotto testWinningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int testBonusNumber = 45;
        test = new StartLotto(testLottoList, testPurchasePrice, testWinningNumbers, testBonusNumber);
    }

    @DisplayName("구입 금액이 숫자 형식이 아니라면 예외가 발생한다.")
    @Test
    void checkPurchasePriceNotNumberFormat() {
        assertThatThrownBy(() -> {
            String input = "10dkfk";
            test.checkPurchasePrice(input);
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("올바른 숫자 형식이 아닙니다. 숫자를 입력해주세요.");
    }

    @DisplayName("구입 금액이 1000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void checkPurchasePriceNot1000wonUnit() {
        assertThatThrownBy(() -> {
            String input = "101";
            test.checkPurchasePrice(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입금액은 1000원 단위입니다. 다시 입력해주세요.");
    }

    @DisplayName("당첨 번호는 쉼표로 구분된다.")
    @Test
    void checkWinningNumberSplit() {
        assertThatCode(() -> {
            String input = "1,2, 3,  4, 5,6";
            test.checkWinningNumbers(input);
        }).doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호가 숫자가 아니라면 예외가 발생한다.")
    @Test
    void checkBonusNumberNotNumberFormat() {
        assertThatThrownBy(() -> {
            String input = "ten";
            test.checkBonusNumber(input);
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("올바른 숫자 형식이 아닙니다. 숫자를 입력해주세요.");
    }

    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아니라면 예외가 발생한다.")
    @Test
    void checkBonusNumberOutOfRange() {
        assertThatThrownBy(() -> {
            String input = "-20";
            test.checkBonusNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1 ~ 45 사이의 값을 가집니다.");
    }

    @DisplayName("보너스 번호와 당첨 번호 사이에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void checkBonusNumberIsDuplicatedNumber() {
        assertThatThrownBy(() -> {
            String winningNumbers = "1,2,3,4,5,6";
            String input = "3";
            test.checkWinningNumbers(winningNumbers);
            test.checkBonusNumber(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호와 당첨 번호에는 서로 중복되는 숫자가 없습니다. 다시 입력해주세요.");
    }

    @DisplayName("각 로또 별 당첨 현황과 갯수 테스트")
    @Test
    void checkFillPriceHistoryMap() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        test.fillPriceHistoryMap();
        test.printPriceHistory();

        assertThat((out.toString())).contains(
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개");
    }

    @DisplayName("총 수익률 계산 테스트")
    @Test
    void checkCalcEarningRate() {
        test.fillPriceHistoryMap();
        double testEarningRate = test.calcEarningRate();
        assertThat(testEarningRate).isEqualTo(6.76683333E7);
    }
}
