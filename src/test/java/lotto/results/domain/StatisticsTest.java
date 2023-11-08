package lotto.results.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.checker.domain.Checker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatisticsTest {

    @AfterEach
    public void closeConsoleEach() {
        Console.close();
    }

    @DisplayName("로또 당첨 통계를 출력한다.")
    @Test
    void 로또_당첨_통계_출력_당첨() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Checker checker = new Checker();
        Statistics statistics = new Statistics();
        for (int i = 0; i <= 6; i++) {
            statistics.incrementCount(checker.convertRank(i, 1));
        }
        statistics.incrementCount(checker.convertRank(5, 0));

        statistics.printStatistics();
        statistics.printReturnRate(7000);

        assertThat(out.toString()).contains("1개", "1개", "1개", "1개", "1개", "28,636,500.0%");
    }

    @DisplayName("로또 당첨 통계를 출력한다.")
    @Test
    void 로또_당첨_통계_출력_비당첨() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Checker checker = new Checker();
        Statistics statistics = new Statistics();
        statistics.incrementCount(checker.convertRank(2, 1));

        statistics.printStatistics();
        statistics.printReturnRate(7000);

        assertThat(out.toString()).contains("0개", "0개", "0개", "0개", "0개", "0.0%");
    }

}
