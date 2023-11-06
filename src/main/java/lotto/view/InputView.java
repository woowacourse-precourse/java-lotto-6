package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.MoneyToBuy;
import lotto.model.WinningLotto;

public class InputView {

    private void printError(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public MoneyToBuy requestMoneyToBuy() {
        try {
            System.out.println(OutputMessage.REQUEST_MONEY_TO_BUY.getMessage());
            String string = Console.readLine();
            return new MoneyToBuy(Integer.parseInt(string));
        } catch (IllegalArgumentException e) {
            this.printError(e);
            requestMoneyToBuy();
        }
        return null;
    }

    public WinningLotto requestWinningLotto() {
        WinningLotto winningLotto = requestSixNumbers();
        winningLotto.setBonusNumber(requestBonusNumber());
        return winningLotto;
    }

    private WinningLotto requestSixNumbers() {
        try {
            System.out.println(OutputMessage.REQUEST_WINNING_NUMBERS.getMessage());
            String winningLottoNumbers = Console.readLine();
            return new WinningLotto(convertStringToList(winningLottoNumbers));
        } catch (IllegalArgumentException e) {
            this.printError(e);
            requestSixNumbers();
        }
        return null;
    }

    private Integer requestBonusNumber() {
        try {
            System.out.println(OutputMessage.REQUEST_BONUS_NUMBER.getMessage());
            String bonusNumber = Console.readLine();
            return Integer.parseInt(bonusNumber);
        } catch (IllegalArgumentException e) {
            this.printError(e);
            requestBonusNumber();
        }
        return null;
    }

    private List<Integer> convertStringToList(String string) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(string.split(",")).toList().forEach(str -> {
            list.add(Integer.parseInt(str));
        });

        return list;
    }
}
