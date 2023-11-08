package lotto.module.console.output.composer;

import lotto.module.domain.LottoProfit;
import lotto.module.lotto.Lotto;
import lotto.module.result.LottoResult;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleMessageComposerTest {
    private final ConsoleMessageComposer consoleMessageComposer = ConsoleMessageComposer.newInstance();

    @Test
    void 구매한_로또_목록_출력_메시지_변환_성공_테스트() {
        // given
        String expectedPurchaseMessage = "3개를 구매했습니다.";
        String expectedLottoNumbers1 = "[7, 8, 9, 10, 11, 12]";
        String expectedLottoNumbers2 = "[1, 2, 3, 4, 5, 6]";
        String expectedLottoNumbers3 = "[14, 15, 16, 18, 19, 20]";

        Lotto lotto1 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(Arrays.asList(14, 15, 16, 18, 19, 20));
        List<Lotto> list = new ArrayList<>();
        list.add(lotto1);
        list.add(lotto2);
        list.add(lotto3);
        // when
        String message = consoleMessageComposer.generatePurchasedLottoTicketMessage(list);

        // then
        assertThat(message)
                .contains(expectedPurchaseMessage)
                .contains(expectedLottoNumbers1)
                .contains(expectedLottoNumbers2)
                .contains(expectedLottoNumbers3);
    }

    @Test
    void 로또_당첨_통계_메시지_생성_성공_테스트() {
        // given
        String expectedHeadMessage = "당첨 통계";
        String expectedDividerLine = "---";
        String expectedFifthPlateMessage = "3개 일치 (5,000원) - 0개";
        String expectedFourthPlateMessage = "4개 일치 (50,000원) - 0개";
        String expectedThirdPlateMessage = "5개 일치 (1,500,000원) - 0개";
        String expectedSecondPlateMessage = "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개";
        String expectedFirstPlateMessage = "6개 일치 (2,000,000,000원) - 0개";
        String expectedRate = "65.2%";

        LottoResult lottoResult = LottoResult.newInstance();
        LottoProfit lottoProfit = new LottoProfit(65.234);

        // when
        String lottoResultMessage = consoleMessageComposer.generateLottoResultMessage(lottoResult, lottoProfit);

        // then
        assertThat(lottoResultMessage)
                .contains(expectedHeadMessage)
                .contains(expectedDividerLine)
                .contains(expectedRate)
                .contains(expectedFifthPlateMessage)
                .contains(expectedFourthPlateMessage)
                .contains(expectedThirdPlateMessage)
                .contains(expectedSecondPlateMessage)
                .contains(expectedFirstPlateMessage);
    }

}