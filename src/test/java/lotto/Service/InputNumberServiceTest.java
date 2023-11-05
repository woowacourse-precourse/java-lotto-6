package lotto.Service;

import static camp.nextstep.edu.missionutils.Console.close;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.List;
import lotto.dto.WinnerAndBonusNumber;
import lotto.validation.BonusNumberValidator;
import lotto.validation.PurchasePriceValidator;
import lotto.validation.WinnerNumberValidator;
import lotto.view.input.InputView;
import lotto.view.input.Template.InputValidatorTemplate;
import lotto.view.output.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputNumberServiceTest {
    private final InputView inputView;
    private final OutputView outputView;
    public final InputNumberService inputNumberService;

    InputNumberServiceTest() {
        inputView = new InputView(new PurchasePriceValidator(),
                new WinnerNumberValidator(),
                new BonusNumberValidator(),
                new InputValidatorTemplate());
        outputView = new OutputView();
        inputNumberService = new InputNumberService(inputView, outputView);
    }

    @BeforeEach
    void setUp() {
        close();
    }

    @DisplayName("당첨 번호 & 보너스 번호 입력 테스트")
    @Test
    void inputWinnerAndBonusNumberTest() {
        String input = "1,2,3,4,5,6\n7";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        //when
        WinnerAndBonusNumber winnerAndBonusNumber = inputNumberService.input();

        //then
        assertEquals(winnerAndBonusNumber.getWinnerNumber().getWinnerNumbers(), List.of(1, 2, 3, 4, 5, 6));
        assertEquals(winnerAndBonusNumber.getBonusNumber().getBonusNumber(), 7);
    }
}