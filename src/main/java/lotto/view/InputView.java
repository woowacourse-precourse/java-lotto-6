package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.InputConstant.BONUS_NUMBER_MESSAGE;
import static lotto.constant.InputConstant.BUYING_COST_MESSAGE;
import static lotto.constant.InputConstant.WINNING_NUMBERS_MESSAGE;


public class InputView {

    public String inputBuyingCost() {
        System.out.println(BUYING_COST_MESSAGE.getMessage());

        return readLine();
    }

    public String inputWinningNumbers(){
        System.out.println(WINNING_NUMBERS_MESSAGE.getMessage());

        return readLine();
    }

    public String inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE.getMessage());

        return readLine();
    }

}
