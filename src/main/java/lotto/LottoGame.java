package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private List<Lotto> lottos;
    private MoneyToBuy moneyToBuy;
    private WinningLotto winningLotto;

    public LottoGame() {
    }

    public void run() {
        requestMoneyToBuy();
        requestWinningLotto();
    }

    private void requestMoneyToBuy() {
        System.out.println(OutputMessage.REQUEST_MONEY_TO_BUY.getMessage());
        String string = Console.readLine();
        moneyToBuy = new MoneyToBuy(Integer.parseInt(string));
    }

    private void requestWinningLotto() {
        System.out.println(OutputMessage.REQUEST_WINNING_NUMBERS.getMessage());
        String winningLottoNumbers = Console.readLine();

        System.out.println(OutputMessage.REQUEST_BONUS_NUMBER.getMessage());
        String bonusNumber = Console.readLine();

        winningLotto = new WinningLotto(convertStringToList(winningLottoNumbers), Integer.parseInt(bonusNumber));
    }

    private List<Integer> convertStringToList(String string) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(string.split(",")).toList().forEach(str -> {
            list.add(Integer.parseInt(str));
        });

        return list;
    }
}
