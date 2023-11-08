package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Domain.Lotto;
import lotto.Domain.Result;
import lotto.Domain.User;

public class LottoGame {
    private final Output output;
    private final Utils utils = Utils.INSTANCE;

    public LottoGame(Output output) {
        this.output = output;
    }
    public void run() {
        User user;
        while (true) {
            try {
                output.printInputMoney(); //기능 6-1
                String inputMoney = Console.readLine();
                user = new User(inputMoney); //기능 2, 4
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        output.printBuyLotto(user); //기능 7

        Lotto winningLotto;
        while (true) {
            try{
                output.printInputWinningNumber(); //기능 6-2
                String WinningNumber = Console.readLine();
                winningLotto = new Lotto(utils.stringToList(WinningNumber)); //기능 1
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try{
                output.printInputBonusNumber(); //기능 6-3
                String bonusNumber = Console.readLine();
                winningLotto.setBonusNumber(bonusNumber); //기능 1
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        Result result = new Result(user, winningLotto); //기능 5
        output.printResult(result, user.getInputMoney()); //기능 8
    }
}
