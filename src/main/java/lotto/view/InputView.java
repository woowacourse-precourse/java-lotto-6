package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.LottoExceptions;

public class InputView {

    public String getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String[] getWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        return numbers.split(",");
    }

    public String getBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
