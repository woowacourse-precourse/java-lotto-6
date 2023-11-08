package Controller;

import Util.CheckInteger;
import Util.CheckNull;
import Util.CheckString;
import Util.Convert;
import View.ErrorText;
import View.InputView;
import camp.nextstep.edu.missionutils.Console;
import lotto.LottoPrice;

public class MoneyInputController {
    InputView view;

    public Integer getMoneyFromConsole(){
        try {
            String str; //console에서 받은 string 저장
            Integer ret; //str에서 converted된 Integer 저장

            view.introduceMoneyInput();
            str = Console.readLine();
            CheckNull.check(str, ErrorText.nullInsertedAtInputMoney());
            CheckString.checkEmptyString(str, ErrorText.emptyStringAtInputMoney());
            ret = Convert.convertStringToInteger(str, ErrorText.notConvertedToIntAtInputMoney(str));
            CheckInteger.checkNumMultipleOfDivider(ret, LottoPrice.nomal.getValue(), ErrorText.notMultipleOfThousandAtInputMoney(ret));
            return ret;
        }
        catch (IllegalArgumentException e){
            return getMoneyFromConsole();
        }
    }
}
