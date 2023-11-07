package lotto.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("로또를 5 개 구매했을 때, 양식에 맞춰서 구매 개수를 출력한다.")
    @Test
    void printLottoCountResultInForm() {
        OutputView.printLottoCount(5);
        assertEquals("5개를 구매했습니다.", output.toString().trim());
    }
    
    @DisplayName("로또 하나의 번호 6개를 양식에 맞춰서 출력한다.")
    @Test
    void PrintLottoNumbersInForm() {
        OutputView.printLotto(List.of(1, 2, 3, 4, 5, 6));
        assertEquals("[1, 2, 3, 4, 5, 6]", output.toString().trim());
    }

    @DisplayName("로또 당첨 기준, 상금, 당첨 개수를 양식에 맞춰서 출력한다.")
    @Test
    void printPriceInForm() {
        OutputView.printPrice("3개 일치 ", "5,000", 1);
        assertEquals("3개 일치 (5,000원) - 1개", output.toString().trim());
    }

    @DisplayName("수익률을 소수점 2 자리를 반올림하고 양식에 맞춰서 출력한다.")
    @Test
    void printProfitInForm() {
        OutputView.printProfit(62.5F);
        assertEquals("총 수익률은 62.5%입니다.", output.toString().trim());
    }

    @DisplayName("오류 발생 메세지 발생 시 [ERROR]로 시작하여 양식에 맞춰서 출력한다.")
    @Test
    void printExceptionInform() {
        OutputView.printException("로또 번호는 6 개여야 합니다.\n");
        assertEquals("[ERROR] 로또 번호는 6 개여야 합니다.", output.toString().trim());
    }
}