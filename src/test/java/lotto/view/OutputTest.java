package lotto.view;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JInternalFrame;
import lotto.controller.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @DisplayName("로또 구매 입력 테스트")
    @Test
    void printPromptForPurchaseAmountTest() {
        // when
        Output.printPromptForPurchaseAmount();
        // then
        assertThat(outputMessage.toString()).isEqualTo("구입금액을 입력해 주세요.\n");
    }

    @DisplayName("로또 구매 내역 출력 테스트")
    @Test
    void printPurchasedDetailsTest() {
        // given
        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        List<Lotto> lottos = new ArrayList<>(List.of(lotto1, lotto2));
        // when
        Output.printPurchasedDetails(lottos);
        // then
        assertThat(outputMessage.toString()).isEqualTo("\n2개를 구매했습니다.\n"
                + "[8, 21, 23, 41, 42, 43]\n"
                + "[3, 5, 11, 16, 32, 38]\n");
    }

    @DisplayName("로또 당첨 번호 입력 테스트")
    @Test
    void printPromptForWinningNumbersTest() {
        // when
        Output.printPromptForWinningNumbers();
        // then
        assertThat(outputMessage.toString()).isEqualTo("\n당첨 번호를 입력해 주세요.\n");
    }

    @DisplayName("로또 보너스 번호 입력 테스트")
    @Test
    void printPromptForBonusNumberTest() {
        // when
        Output.printPromptForBonusNumber();
        // then
        assertThat(outputMessage.toString()).isEqualTo("\n보너스 번호를 입력해 주세요.\n");
    }

    @DisplayName("로또 당첨 통계 출력 테스트")
    @Test
    void printWinningStatisticsTest() {
        // given
        List<Integer> rewards = new ArrayList<>();
        rewards.add(5000);
        rewards.add(50000);
        rewards.add(1500000);
        rewards.add(30000000);
        rewards.add(2000000000);
        List<Integer> counts = new ArrayList<>(List.of(1, 0, 0, 0, 0));
        double earningRate = 62.5;
        // when
        Output.printWinningStatistics(rewards, counts, earningRate);
        // then
        assertThat(outputMessage.toString()).isEqualTo("\n당첨 통계\n"
                + "---\n"
                + "3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 0개\n"
                + "총 수익률은 62.5%입니다.\n");
    }
}