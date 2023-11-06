package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Constants;

public class InputView {

    public Integer enterPriceToBuy() {
        System.out.println(Constants.enterPriceToBuyMessage);
        String priceToBuy = Console.readLine();
        System.out.println();
        return Integer.parseInt(priceToBuy);
    }
    public int enterBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }

    public String enterWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String getWinningNumbers = Console.readLine();
        return getWinningNumbers;
    }
}
