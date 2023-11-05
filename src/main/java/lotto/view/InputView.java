package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Service.LottoService;

import java.util.List;

public class InputView {
    public static Integer inputBuyMoney(){
        System.out.println("구입 금액을 입력해 주세요.");
        String buyMoney = Console.readLine();
        return Integer.parseInt(buyMoney);
    }

    public static List<Integer> inputLottoWinning(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningString = Console.readLine();

        LottoService lottoService = new LottoService();
        return lottoService.generateNumber(winningString);
    }

    public static int inputLottoBonus(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusString = Console.readLine();
        return Integer.parseInt(bonusString);
    }
}
