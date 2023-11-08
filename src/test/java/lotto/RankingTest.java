package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import lotto.domain.Ranking;
import org.junit.jupiter.api.Test;

class RankingTest {
    @Test
    void valueOf() {
        Ranking rank;
        assertThat(
                rank = Ranking.valueOf(5, true)
        ).isEqualTo(Ranking.SECOND);
    }

    @Test
    void printMessage() {
        Ranking rank;
        rank = Ranking.THIRD;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        rank.printMessage(1);

        String expectedOutPut = "5개 일치 (1,500,000원) - 1개" + System.lineSeparator();
        assertEquals(expectedOutPut,outContent.toString());
        System.setOut(System.out);
    }

}