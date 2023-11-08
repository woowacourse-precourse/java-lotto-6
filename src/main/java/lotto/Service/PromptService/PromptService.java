package lotto.Service.PromptService;


import java.util.List;
import lotto.Model.BonusNumber.BonusNumber;
import lotto.Model.PurchaseAmount.PurchaseAmount;
import lotto.Model.WinningNumber.WinningNumber;
import lotto.View.InputView.InputView;
import lotto.util.TypeConverter.UserPromptConverter;


public class PromptService {
    private final InputView Prompt = new InputView();
    private final UserPromptConverter Converter = new UserPromptConverter();

    public PurchaseAmount getPurchaseAmount() {
        while (true) {
            try {
                Integer convertedAmount = Converter.convertingStringToInteger(Prompt.getLottoPurchaseAmount());
                return new PurchaseAmount(convertedAmount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public WinningNumber getLottoWinningNumber() {
        while (true) {
            try {
                List<Integer> convertedWinningNumber = Converter.convertingStringToListInteger(
                        Prompt.getLottoWinningNumber());
                return new WinningNumber(convertedWinningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public BonusNumber getLottoBonusNumber() {
        while (true) {
            try {
                return new BonusNumber(Converter.convertingStringToInteger(Prompt.getLottoBonusNumber()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
