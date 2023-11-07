package view;

import camp.nextstep.edu.missionutils.Console;
import constant.Constants;

public class InputView {

    public Integer enterPriceToBuy() {
        System.out.println(Constants.ENTER_PRICE_TO_BUY_MESSAGE);
        String priceToBuy = Console.readLine();
        for (int i = 0; i < priceToBuy.length(); i++) {
            if (priceToBuy.charAt(i) < '0' || priceToBuy.charAt(i) > '9'){
                throw new IllegalArgumentException("[ERROR] 숫자만 입력이 가능합니다.");
            }
        }
        System.out.println();
        int moneyToBuyLotto = Integer.parseInt(priceToBuy);
        if (moneyToBuyLotto % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또는 1000원 단위로 구매할 수 있습니다. 1000의 배수를 입력해주세요");
        }
    }
    public int enterBonusNumber() {
        System.out.println();
        System.out.println(Constants.ENTER_BONUS_NUMBER_MESSAGE);
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }

    public String enterWinningNumber() {
        System.out.println();
        System.out.println(Constants.ENTER_WINNING_NUMBER_MESSAGE);
        String getWinningNumbers = Console.readLine();
        return getWinningNumbers;
    }
}
