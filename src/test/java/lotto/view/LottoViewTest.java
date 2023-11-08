package lotto.view;

import static lotto.constant.Message.PURCHASE_AMOUNT_PROMPT;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import lotto.dto.LottoDto;
import lotto.dto.LottoPurchaseDto;
import lotto.dto.LottosDto;
import lotto.dto.ReturnRateDto;
import lotto.dto.WinningResultDto;
import lotto.model.LottoPurchaseAmount;
import lotto.template.UiTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoViewTest extends UiTest {
    LottoView lottoView;


    @BeforeEach
    void setUp() {
        lottoView = LottoView.create();
    }

    @Test
    void printMessageTest() {
        lottoView.printMessage(PURCHASE_AMOUNT_PROMPT);

        assertThat(getSystemOutput()).contains(PURCHASE_AMOUNT_PROMPT.getMessage());
    }

    @Test
    void askPurchaseAmount() {
        input("5000");
        String inputAmount = lottoView.askPurchaseAmount();

        assertThat(inputAmount).isEqualTo("5000");
    }

    @Test
    public void printPurchaseQuantity() {
        input("5000");
        LottoPurchaseAmount amount = LottoPurchaseAmount.from("5000");
        LottoPurchaseDto dto = new LottoPurchaseDto(amount.getAmount(), 5);
        lottoView.printPurchaseQuantity(dto);

        assertThat(getSystemOutput())
                .contains("5개를 구매했습니다");
    }

    @Test
    public void printLottoNumbers() {
        List<LottoDto> lottoDtos = List.of(new LottoDto(List.of(1, 2, 3, 4, 5, 6)));
        lottoView.printLottoNumbers(new LottosDto(lottoDtos));
        assertThat(getSystemOutput())
                .contains("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void askWinningNumber() {
        input("1,2,3,4,5");

        String inputWinningNumber = lottoView.askWinningNumber();

        assertThat(inputWinningNumber).isEqualTo("1,2,3,4,5");
    }

    @Test
    public void askBonusNumber() {
        input("9");

        String inputBonusNumber = lottoView.askBonusNumber();

        assertThat(inputBonusNumber).isEqualTo("9");
    }

    @Test
    void printWinningCase() {
        WinningResultDto winningResultDto = new WinningResultDto(1, 2, 3, 4, 5);
        lottoView.printWinningResult(winningResultDto);

        assertThat(getSystemOutput())
                .contains("""
                        3개 일치 (5,000원) - 5개
                        4개 일치 (50,000원) - 4개
                        5개 일치 (1,500,000원) - 3개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - 2개
                        6개 일치 (2,000,000,000원) - 1개
                        """.trim());
    }

    @Test
    void printReturnRateMessage() {
        double returnRate = 48.5;
        ReturnRateDto returnRateDto = new ReturnRateDto(BigDecimal.valueOf(returnRate));
        lottoView.printReturnRateMessage(returnRateDto);

        assertThat(getSystemOutput())
                .contains("총 수익률은 48.5%입니다.");
    }
}