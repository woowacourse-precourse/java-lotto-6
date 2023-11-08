package lotto.Service.PromptService;

import lotto.View.InputView.InputView;
import lotto.util.TypeConverter.UserPromptConverter;

public class PromptService {
    public Integer GetPurchaseAmount(){
        InputView amount = new InputView();
        UserPromptConverter StrToInt = new UserPromptConverter();
        return StrToInt.convertingStrintoInteger(amount.getLottoPurchaseAmount());
    }

    public Integer getLottoWinningNumber


}
