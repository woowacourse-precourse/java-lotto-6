package view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import model.enums.LottoWinResults;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutPutViewTest {
    private static OutputView outputView;
    private static ByteArrayOutputStream outputMessage;
    @BeforeAll
    static void beforeAll() {
        outputView = new OutputView();
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }
    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @DisplayName("로또 번호묶음 메세지 출력 테스트")
    @Test
    void printLottoNumsTest() {
        final ArrayList<Integer> WinStatistics = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        outputView.printLottoNums(WinStatistics);
        assertThat(outputMessage.toString()).contains("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("당첨 통계 메세지 출력 테스트")
    @Test
    void printWinStatisticTest() {
        final Map<String, Integer> winResults = new HashMap<>();
        winResults.put(LottoWinResults.LOTTO_3SAME.getMessage() ,1);
        winResults.put(LottoWinResults.LOTTO_4SAME.getMessage() ,2);
        winResults.put(LottoWinResults.LOTTO_5SAME.getMessage() ,3);
        winResults.put(LottoWinResults.LOTTO_5SAME_BONUS.getMessage() ,4);
        winResults.put(LottoWinResults.LOTTO_6SAME.getMessage() ,5);

        outputView.printWinStatistic(winResults);
        assertThat(outputMessage.toString()).contains("당첨 통계\n---",
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 2개\n",
                "5개 일치 (1,500,000원) - 3개\n",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 4개\n",
                "6개 일치 (2,000,000,000원) - 5개");
    }
}
