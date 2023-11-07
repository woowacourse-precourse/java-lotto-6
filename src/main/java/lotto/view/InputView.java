package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.MoneyToBuy;
import lotto.model.WinningLotto;

public class InputView {
    private static final String errorPrefix = "[ERROR] ";

    private void printError(Exception e) {
        System.out.println(errorPrefix + e.getMessage());
    }

    public MoneyToBuy requestMoneyToBuy() {
        try {
            System.out.println(OutputMessage.REQUEST_MONEY_TO_BUY.getMessage());
            String string = Console.readLine();
            return new MoneyToBuy(Integer.parseInt(string));
        } catch (IllegalArgumentException e) {
            this.printError(e);
            return requestMoneyToBuy();
        }
    }

    public WinningLotto requestWinningLotto() {
        WinningLotto winningLotto = requestSixNumbers();
        requestBonusNumber(winningLotto);
        return winningLotto;
    }

    private WinningLotto requestSixNumbers() {
        try {
            System.out.println(OutputMessage.REQUEST_WINNING_NUMBERS.getMessage());
            String inputString = Console.readLine();
            String[] winningLottoNumbers = inputString.split(",");
            return new WinningLotto(convertStringArrToList(winningLottoNumbers));
        } catch (IllegalArgumentException e) {
            this.printError(e);
            return requestSixNumbers();
        }
    }

    private void requestBonusNumber(WinningLotto winningLotto) {
        try {
            System.out.println(OutputMessage.REQUEST_BONUS_NUMBER.getMessage());
            String bonusNumber = Console.readLine();
            winningLotto.setBonusNumber(Integer.parseInt(bonusNumber));
        } catch (IllegalArgumentException e) {
            this.printError(e);
            requestBonusNumber(winningLotto);
        }
    }

    private List<Integer> convertStringArrToList(String[] string) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(string).toList().forEach(str -> {
            list.add(Integer.parseInt(str));
        });

        return list;
    }
}
