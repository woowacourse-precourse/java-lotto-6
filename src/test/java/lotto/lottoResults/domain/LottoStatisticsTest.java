package lotto.lottoResults.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStatisticsTest {

    @AfterEach
    public void closeConsoleEach() {
        Console.close();
    }

    @DisplayName("로또 당첨 통계를 출력한다.")
    @Test
    void 로또_당첨_통계_출력_당첨() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        LottoStatistics lottoStatistics = new LottoStatistics();
        for (int i = 0; i <= 6; i++) {
            lottoStatistics.incrementCount(i, 1);
        }
        lottoStatistics.incrementCount(5, 0);

        lottoStatistics.printStatistics();
        lottoStatistics.printReturnRate(7000);

        assertThat(out.toString()).contains("1개", "1개", "1개", "1개", "1개", "286,365.0%");
    }

    @DisplayName("로또 당첨 통계를 출력한다.")
    @Test
    void 로또_당첨_통계_출력_비당첨() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        LottoStatistics lottoStatistics = new LottoStatistics();
        for (int i = 0; i <= 6; i++) {
            lottoStatistics.incrementCount(1, 1);
            lottoStatistics.incrementCount(2, 1);
        }

        lottoStatistics.printStatistics();
        lottoStatistics.printReturnRate(7000);

        assertThat(out.toString()).contains("0개", "0개", "0개", "0개", "0개", "0.0%");
    }

}
