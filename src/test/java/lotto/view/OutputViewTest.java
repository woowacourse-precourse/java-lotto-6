package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.TestConstant;
import lotto.constant.LottoRank;
import lotto.dto.LottoDto;
import lotto.dto.LottoReceiptDto;
import lotto.dto.LottoResultDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputViewTest {
    private final OutputView outputView = TestConstant.testLottoConfig.outputView();

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @DisplayName("로또 영수증을 출력한다. - 일반 케이스")
    @Test
    void printLottoReceiptDtoWhenNormalCase() {
        LottoDto lottoDto = new LottoDto(TestConstant.normalNumbers);
        LottoReceiptDto lottoReceiptDto = new LottoReceiptDto(1, List.of(lottoDto));

        outputView.printLottoReceipt(lottoReceiptDto);

        assertThat(output()).contains(
                "1개를 구매했습니다.",
                "[1, 2, 3, 4, 5, 6]"
        );
    }

    @DisplayName("로또 추첨 결과를 출력한다. - 정상 케이스")
    @Test
    void printLottoResultWhenNormalCase() {
        Map<LottoRank, Integer> result = new HashMap<>();
        Arrays.stream(LottoRank.values())
                .forEach((lottoRank -> result.put(lottoRank, 1)));
        LottoResultDto lottoResultDto = new LottoResultDto(1000000.49D, result);

        outputView.printLottoResult(lottoResultDto);

        assertThat(output()).contains(
                "3개 일치 (5,000원) - 1개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 1개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
                "6개 일치 (2,000,000,000원) - 1개",
                "총 수익률은 1,000,000.5% 입니다."
        );
    }

    private String output() {
        return captor.toString().trim();
    }

    @AfterEach
    void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }
}
