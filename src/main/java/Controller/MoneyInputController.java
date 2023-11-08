package Controller;

import Util.CheckInteger;
import Util.CheckNull;
import Util.CheckString;
import Util.Convert;
import View.MoneyInputErrorText;
import View.InputView;
import camp.nextstep.edu.missionutils.Console;
import Domain.lotto.LottoPrice;

public class MoneyInputController {
    InputView view;

    public MoneyInputController(InputView view){
        this.view = view;
    }


    public Integer getMoneyFromConsole(){
        String str; //console에서 받은 string 저장
        Integer ret; //str에서 converted된 Integer 저장

        view.introduceMoneyInput();
        str = Console.readLine();
        CheckNull.check(str, MoneyInputErrorText.nullInserted());
        CheckString.checkEmptyString(str, MoneyInputErrorText.emptyString());
        ret = Convert.convertStringToInteger(str, MoneyInputErrorText.notConvertedToInt(str));
        CheckInteger.checkNumMultipleOfDivider(ret, LottoPrice.nomal.getValue(), MoneyInputErrorText.notMultipleOfThousand());
        CheckInteger.notZero(ret, MoneyInputErrorText.zeroInserted());
        return ret;
    }

    public Integer RecursiveGetMoneyFromConsole(){
        try {
            return getMoneyFromConsole();
        }
        catch (IllegalArgumentException e){
            return RecursiveGetMoneyFromConsole();
        }
    }
}
