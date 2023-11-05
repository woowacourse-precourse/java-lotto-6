package lotto.view.input;

import static camp.nextstep.edu.missionutils.Console.close;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.List;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchasePriceValidator;
import lotto.validation.WinnerNumberValidator;
import lotto.view.input.Template.InputValidatorTemplate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private final InputView inputView;
    private final PurchasePriceValidator purchasePriceValidator;
    private final WinnerNumberValidator winnerNumberValidator;
    private final BonusNumberValidator bonusNumberValidator;
    private final InputValidatorTemplate template;

    InputViewTest() {
        purchasePriceValidator = new PurchasePriceValidator();
        winnerNumberValidator = new WinnerNumberValidator();
        bonusNumberValidator = new BonusNumberValidator();
        template = new InputValidatorTemplate();
        inputView = new InputView(purchasePriceValidator, winnerNumberValidator, bonusNumberValidator, template);
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
        int purchasePrice = inputView.inputPurchasePrice();

        //then
        assertEquals(purchasePrice, Integer.parseInt(input));
    }

    @DisplayName("당첨 번호 입력 테스트")
    @Test
    void purchasePriceValidateTest() {
        //given
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        List<Integer> winnerNumber = inputView.inputWinnerNumber();

        //then
        assertEquals(winnerNumber, List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호 입력 테스트")
    @Test
    void inputBonusNumberTest() {
        //given
        String input = "7";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        //when
        int purchasePrice = inputView.inputBonusNumber();

        //then
        assertEquals(purchasePrice, Integer.parseInt(input));
    }
}