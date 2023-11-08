package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.common.constants.LottoRank;
import lotto.controller.dto.input.BonusBallDto;
import lotto.controller.dto.input.LottoPurchaseAmountDto;
import lotto.controller.dto.input.WinningLottoNumbersDto;
import lotto.controller.dto.output.PurchasedLottosDto;
import lotto.controller.dto.output.WinningLottoResultDto;
import lotto.mock.MockReader;
import lotto.mock.MockWriter;
import lotto.model.lotto.Lotto;
import lotto.view.constants.Message;
import lotto.view.constants.MessageFormatter;
import org.junit.jupiter.api.Test;

class LottoViewTest {
    private static final String LINE_SEPARATOR = MessageFormatter.LINE_SEPARATOR.value;

    private final MockReader reader = new MockReader();
    private final MockWriter writer = new MockWriter();
    private final LottoView lottoView = new LottoView(reader, writer);

    @Test
    void 로또구입금액_입력_테스트() {
        //given
        String amount = "20000";
        reader.setInput(amount);
        //when
        LottoPurchaseAmountDto lottoPurchaseAmountDto = lottoView.inputLottoPurchaseAmount();
        //then
        assertThat(writer.getOutput()).isEqualTo(
                Message.INPUT_LOTTO_PURCHASE_AMOUNT.getValue() + LINE_SEPARATOR);
        assertThat(lottoPurchaseAmountDto.purchaseAmount()).isEqualTo(amount);
    }

    @Test
    void 구매로또_출력_테스트() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(6, 10, 16, 34, 35, 43)));
        PurchasedLottosDto purchasedLottosDto = new PurchasedLottosDto(lottos);
        //when
        lottoView.showPurchasedLottos(purchasedLottosDto);
        //then
        String expected = """
                                
                2개를 구매했습니다.
                [1, 2, 3, 4, 5, 6]
                [6, 10, 16, 34, 35, 43]    
                """;
        assertThat(writer.getOutput()).isEqualTo(expected);
    }

    @Test
    void 당첨로또번호_입력_테스트() {
        //given
        String winningLottoNumbers = "1,2,3,4,5,6";
        reader.setInput(winningLottoNumbers);
        //when
        WinningLottoNumbersDto winningLottoNumbersDto = lottoView.inputWinningLottoNumbers();
        //then
        assertThat(writer.getOutput()).isEqualTo(
                LINE_SEPARATOR + Message.INPUT_WINNING_LOTTO_NUMBERS.getValue() + LINE_SEPARATOR);
        assertThat(winningLottoNumbersDto.winningLottoNumbers()).isEqualTo(winningLottoNumbers);
    }

    @Test
    void 보너스볼번호_입력_테스트() {
        //given
        String bonusBallNumber = "6";
        reader.setInput(bonusBallNumber);
        //when
        BonusBallDto bonusBallDto = lottoView.inputBonusBallNumber();
        //then
        assertThat(writer.getOutput()).isEqualTo(
                LINE_SEPARATOR + Message.INPUT_BONUS_BALL_NUMBER.getValue() + LINE_SEPARATOR);
        assertThat(bonusBallDto.bonusBall()).isEqualTo(bonusBallNumber);
    }

    @Test
    void 로또당첨결과_출력_테스트() {
        //given
        List<LottoRank> winningResult = List.of(LottoRank.FIFTH);
        float profitRate = 62.5f;
        WinningLottoResultDto winningLottoResultDto = new WinningLottoResultDto(winningResult, profitRate);
        //when
        lottoView.showWinningLottoResult(winningLottoResultDto);
        //then
        String expected = """
                                
                당첨 통계
                ---
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 62.5%입니다.
                """;
        assertThat(writer.getOutput()).isEqualTo(expected);
    }

    @Test
    void 에러메시지_출력_테스트() {
        //given
        String error = "유효하지 않은 입력입니다.";
        //when
        lottoView.showError(error);
        //then
        assertThat(writer.getOutput()).isEqualTo("[ERROR] " + error + LINE_SEPARATOR);
    }
}