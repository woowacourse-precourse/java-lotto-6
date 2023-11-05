package lotto.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputTest {

    private static ByteArrayOutputStream outputMessage;


    protected void systemIn(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    protected String getOutput(){
        return outputMessage.toString();
    }
    @BeforeEach
    void setUpStreams(){
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams(){
        System.setOut(System.out);
    }

    @Test
    @DisplayName("금액 입력 메세지 출력")
    void printWinningStatistics(){
        List<Integer> winningStatistics = new ArrayList<>(List.of(0,0,0,0,1));
        String expectedMessage = "당첨 통계\n"
                + "---\n"
                + "3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 0개\n";

        systemIn(expectedMessage);
        Output.printWinningStatistics(winningStatistics);

        assertThat(getOutput().contains(expectedMessage));    }

    @Test
    @DisplayName("총 수익률 출력")
    void printTotalReturn(){
        double totalReturn = 62.5;
        String expectedMessage ="총 수익률은 62.5%입니다.\n";
        systemIn(expectedMessage);
        Output.printTotalReturn(totalReturn);

        assertThat(getOutput().contains(expectedMessage));
    }
}
