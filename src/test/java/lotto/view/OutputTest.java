package lotto.view;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OutputTest {

    private Output output;
    private static ByteArrayOutputStream outputMessage;

    public OutputTest() {
        this.output = Output.getInstance();
    }

    @BeforeEach
    void beforeEach() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void afterEach() {
        System.setOut(System.out);
    }

    @Test
    void printPurchaseAmountMessage_정상작동() {
        output.printPurchaseAmountMessage();
        assertEquals("구입금액을 입력해 주세요.\n", outputMessage.toString());
    }

    @Test
    public void printBuyingMessage_정상작동() throws Exception {
        output.printBuyingMessage(8);
        assertEquals("8개를 구매했습니다.\n", outputMessage.toString());
    }

    @Test
    void printLottoTickets_정상작동() {
        //given
        List<Lotto> tickets = new ArrayList<>();
        tickets.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        tickets.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        tickets.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));

        //when
        output.printLottoTickets(tickets);

        //then
        assertEquals("[8, 21, 23, 41, 42, 43]\n" +
                        "[3, 5, 11, 16, 32, 38]\n" +
                        "[7, 11, 16, 35, 36, 44]\n",
                outputMessage.toString());
    }


    @Test
    void printWinningNumbersMessage() {
        output.printWinningNumbersMessage();
        assertEquals("당첨 번호를 입력해 주세요.\n", outputMessage.toString());
    }

    @Test
    void printBonusNumberMessage() {
        output.printBonusNumberMessage();
        assertEquals("보너스 번호를 입력해 주세요.\n", outputMessage.toString());
    }

    @Test
    void printWinningStatistics() {
        //given
        int[] result = {0, 0, 0, 3, 4, 5, 0, 5};

        //when
        output.printWinningStatistics(result);

        //then
        assertEquals("3개 일치 (5,000원) - 3개\n" +
                        "4개 일치 (50,000원) - 4개\n" +
                        "5개 일치 (1,500,000원) - 5개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                        "6개 일치 (2,000,000,000원) - 5개\n",
                outputMessage.toString());
    }
}