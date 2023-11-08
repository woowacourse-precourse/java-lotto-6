package lotto.view;

import lotto.constant.LottoRanking;
import lotto.domain.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoOutputViewTest {
    private ByteArrayOutputStream capture;
    private PrintStream old;
    private LottoOutputView outputView;

    @BeforeEach
    void setUp() {
        capture = new ByteArrayOutputStream();
        old = System.out;
        System.setOut(new PrintStream(capture));
        outputView = new LottoOutputView();
    }

    @AfterEach
    void restore() {
        System.setOut(old);
    }

    @Test
    void printBuyingPriceInputRequest_테스트() {
        outputView.printBuyingPriceInputRequest();
        assertEquals("구입금액을 입력해 주세요.", capture.toString().trim());
    }

    @Test
    void printBoughtResult_테스트() {
        Lotto input = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        outputView.printBoughtResult(List.of(input));

        assertThat(capture.toString()).contains(
                "1개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]"
        );
    }

    @Test
    void printAnswerInputRequest_테스트() {
        outputView.printAnswerInputRequest();
        assertEquals("당첨 번호를 입력해 주세요.", capture.toString().trim());
    }

    @Test
    void printBonusInputRequest_테스트() {
        outputView.printBonusInputRequest();
        assertEquals("보너스 번호를 입력해 주세요.", capture.toString().trim());
    }

    @Test
    void printLottoResult_테스트() {
        Map<LottoRanking, Integer> input = new HashMap<>();
        input.put(LottoRanking.FIRST, 0);
        input.put(LottoRanking.SECOND, 1);
        input.put(LottoRanking.THIRD, 2);
        input.put(LottoRanking.FOURTH, 3);
        input.put(LottoRanking.FIFTH, 4);

        outputView.printLottoResult(input);
        assertThat(capture.toString()).contains(
                "3개 일치 (5,000원) - 4개",
                "4개 일치 (50,000원) - 3개",
                "5개 일치 (1,500,000원) - 2개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 0개"
        );
    }

    @Test
    void printProfit_테스트() {
        int inputBefore = 1000;
        int inputAfter = 1555;

        outputView.printProfit(inputBefore, inputAfter);
        assertEquals("총 수익률은 155.5%입니다.", capture.toString().trim());
    }
}
