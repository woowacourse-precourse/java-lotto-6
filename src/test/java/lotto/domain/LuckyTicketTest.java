package lotto.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.collections.LotteryResultCollection;
import lotto.domain.collections.UserTicketCollection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LuckyTicketTest {

    private PrintStream standardOut;
    private OutputStream captor;


    @BeforeEach
    public void beforeEach() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @Test
    public void luckyTicketMatchTest() {
        List<Integer> luckyNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto luckyLotto = new Lotto(luckyNumbers);
        LuckyTicket luckyTicket = LuckyTicket.of(luckyLotto, 7);

        Lotto userLotto1 = new Lotto(List.of(10, 11, 12, 13, 14, 15)); // 0개 일치
        Lotto userLotto2 = new Lotto(List.of(2, 3, 4, 15, 16, 17)); // 3개 일치

        UserTicketCollection ticket1 = UserTicketCollection.of(List.of(userLotto1));
        UserTicketCollection ticket2 = UserTicketCollection.of(List.of(userLotto2));

        LotteryResultCollection lotteryResult1 = luckyTicket.matchWith(ticket1);
        LotteryResultCollection lotteryResult2 = luckyTicket.matchWith(ticket2);

        lotteryResult1.printResults();
        lotteryResult2.printResults();

        assertThat(output()).contains(
            "3개 일치 (5,000원) - 0개",
            "4개 일치 (50,000원) - 0개",
            "5개 일치 (1,500,000원) - 0개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
            "6개 일치 (2,000,000,000원) - 0개",
            "총 수익률은 0.0%입니다."
        );

        assertThat(output()).contains(
            "3개 일치 (5,000원) - 1개",
            "4개 일치 (50,000원) - 0개",
            "5개 일치 (1,500,000원) - 0개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
            "6개 일치 (2,000,000,000원) - 0개",
            "총 수익률은 500.0%입니다."
        );
    }

    private String output() {
        return captor.toString().trim();
    }

}