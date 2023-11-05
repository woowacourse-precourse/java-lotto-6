package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.controller.dto.input.BonusBallDto;
import lotto.controller.dto.input.LottoPurchaseAmountDto;
import lotto.controller.dto.input.WinningLottoNumbersDto;
import lotto.controller.dto.output.PurchasedLottosDto;
import lotto.mock.MockReader;
import lotto.mock.MockWriter;
import lotto.view.constants.LottoMessage;
import org.junit.jupiter.api.Test;

class LottoViewTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

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
                LottoMessage.INPUT_LOTTO_PURCHASE_AMOUNT.getMessage() + LINE_SEPARATOR);
        assertThat(lottoPurchaseAmountDto.purchaseAmount()).isEqualTo(amount);
    }

    @Test
    void 구매로또_출력_테스트() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(6, 10, 16, 34, 35, 43)));
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
                LottoMessage.INPUT_WINNING_LOTTO_NUMBERS.getMessage() + LINE_SEPARATOR);
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
                LottoMessage.INPUT_BONUS_BALL_NUMBER.getMessage() + LINE_SEPARATOR);
        assertThat(bonusBallDto.bonusBall()).isEqualTo(bonusBallNumber);
    }
}