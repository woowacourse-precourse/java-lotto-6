package lotto.controller;


import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;

public class InputController {
    public static String scanBudget() {
        System.out.println(InputView.enterBudgetMessage());
        String userInput = Console.readLine();
        // TO DO: 사용자 입력 검증해야 함
        return userInput;
    }

    public static String scanWinningLottoTicket() {
        System.out.println(InputView.enterWinningLottoTicket());
        String userInput = Console.readLine();
        // TO DO: 사용자 입력 검증해야 함
        return userInput;
    }

    public static String scanBonusNumber() {
        System.out.println(InputView.enterBonusNumber());
        String userInput = Console.readLine();
        // TO DO: 사용자 입력 검증해야 함
        return userInput;
    }
}
