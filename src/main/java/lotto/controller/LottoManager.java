package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.BonusNumber;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Money;
import lotto.model.WinLotto;
import lotto.model.WinNumbers;
import lotto.view.InputView;
import lotto.view.OutPutView;

public class LottoManager {


    public void startLottoApplication() {
        Customer customer = new Customer();
        customer.buyLotto(receiveMoney());

        OutPutView.printLottoCount(customer.getLottoCount());
        OutPutView.printLottos(customer.getLottosString());

        WinLotto winLotto = issueWinLotto();

        customer.matchLotto(winLotto);
        OutPutView.printMatchResult(customer.getMatchResult());
        OutPutView.printReturnRate(customer.calculateReturnRate());
    }


    private Money receiveMoney() {
        Money money = null;
        do {
            OutPutView.printBuyTicket();
            money = Money.createMoney(InputView.readLine());
        } while (money == null);
        return money;
    }

    private WinLotto issueWinLotto() {
        WinNumbers winNumbers = receiveWinNumbers();
        BonusNumber bonusNumber = null;
        WinLotto winLotto = null;
        while (winLotto == null) {
            bonusNumber = receiveBonusNumber();
            winLotto = WinLotto.issueWinLotto(winNumbers, bonusNumber);
        }
        return winLotto;
    }

    private WinNumbers receiveWinNumbers() {
        WinNumbers winNumbers = null;
        while (winNumbers == null) {
            OutPutView.printEnterWinNumber();
            String numbers = InputView.readLine();
            winNumbers = WinNumbers.createWinNumbers(StringToList(numbers));
        }
        return winNumbers;
    }

    private BonusNumber receiveBonusNumber() {
        BonusNumber bonusNumber = null;
        while (bonusNumber == null) {
            OutPutView.printBonusNumber();
            String number = InputView.readLine();
            bonusNumber = BonusNumber.createBonusNumber(Integer.parseInt(number));
        }
        return bonusNumber;
    }

    private List<Integer> StringToList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
