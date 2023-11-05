package lotto.Service;

import static camp.nextstep.edu.missionutils.Console.close;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import lotto.model.PurchasePrice;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchasePriceValidator;
import lotto.validation.WinnerNumberValidator;
import lotto.view.input.InputView;
import lotto.view.input.Template.InputValidatorTemplate;
import lotto.view.output.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputPurchasePriceServiceTest {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputPurchasePriceService inputPurchasePriceService;

    InputPurchasePriceServiceTest() {
        inputView = new InputView(new PurchasePriceValidator(),
                new WinnerNumberValidator(),
                new BonusNumberValidator(),
                new InputValidatorTemplate());
        outputView = new OutputView();
        inputPurchasePriceService = new InputPurchasePriceService(inputView, outputView);
    }

    @BeforeEach
    void setUp() {
        close();
    }

    @DisplayName("구입 금액 입력 테스트")
    @Test
    void inputPurchasePriceTest() {
        //given
        String input = "8000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        PurchasePrice purchasePrice = inputPurchasePriceService.inputPurchasePrice();

        //then
        assertEquals(purchasePrice.getPurchasePrice(), 8000);
    }
}