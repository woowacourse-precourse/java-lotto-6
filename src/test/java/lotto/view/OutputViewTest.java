package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.Lotto;
import lotto.Lottos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void Lotto를_잘출력해주는지() {
        //given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));
        //when
        lottos.getLottoList();
        //then
        assertEquals("[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]", outputStreamCaptor.toString().trim());
    }

    @Test
    void 당첨_통계를_잘출력해주는지() {
        //given
        OutputView outputView = new OutputView();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 8, 9, 20));
        Lotto lotto2 = new Lotto(List.of(5, 6, 3, 10, 11, 12));
        //when
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));
        outputView.printWinningStatistic(lottos.getWinningStatistics(List.of(1, 2, 3, 4, 5, 6), 7));
        // then
        assertEquals("3개 일치 (5,000원) - 2개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 0개", outputStreamCaptor.toString().trim());

    }
}
