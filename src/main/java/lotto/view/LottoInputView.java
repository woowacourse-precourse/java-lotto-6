package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constant.LottoMessage;
import lotto.view.common.CommonView;
public class LottoInputView extends CommonView{
    public static String requestInputPrice(){
        printConstantMessage(LottoMessage.REQUEST_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String requestInputWinningNumbers(){
        printConstantMessage(LottoMessage.REQUEST_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String requestInputBonusNumber(){
        printWhiteSpace();
        printConstantMessage(LottoMessage.REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
}
