package lotto.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import lotto.view.View;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ViewTest {
    private View view;
    private ByteArrayOutputStream outputStream;
    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreSetUp(){
        System.setOut(System.out);
    }
    @Test
    void 랭킹_출력_테스트(){
        List<Integer> lottoRank = Arrays.asList(7,1,0,0,0,0);
        View.printLottoRank(lottoRank);
        String resultString = "3개 일치 (5,000원) - 1개\n"
                        + "4개 일치 (50,000원) - 0개\n"
                        + "5개 일치 (1,500,000원) - 0개\n"
                        + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                        + "6개 일치 (2,000,000,000원) - 0개\n";

        assertEquals(resultString, outputStream.toString());
    }
}
