package lotto.Service.PromptService;

import lotto.Model.BonusNumber.BonusNumber;
import lotto.Model.PurchaseAmount.PurchaseAmount;
import lotto.Model.WinningNumber.WinningNumber;
import lotto.View.InputView.InputView;
import lotto.util.TypeConverter.UserPromptConverter;

public class PromptService {
    private final InputView Prompt = new InputView();
    private final  UserPromptConverter Converter = new UserPromptConverter();

    public PurchaseAmount getPurchaseAmount(){
        return new PurchaseAmount(Converter.convertingStringToInteger(Prompt.getLottoPurchaseAmount()));
    }

    public WinningNumber getLottoWinningNumber() {
        return new WinningNumber(Converter.convertingStringToListInteger(Prompt.getLottoWinningNumber()));
    }

    public BonusNumber getLottoBonusNumber() {
        return new BonusNumber(Converter.convertingStringToInteger(Prompt.getLottoBonusNumber()));
    }


}
