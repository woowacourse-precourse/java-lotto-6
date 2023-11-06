package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Money;
import lotto.model.WinLotto;
import lotto.view.InputView;
import lotto.view.OutPutView;

public class LottoManager {


    public void startLottoApplication() {
        Customer customer = new Customer();
        customer.buyLotto(receiveMoney());
        OutPutView.printLottoCount(customer.getLottoCount());
        OutPutView.printLottos(customer.getLottosString());
        WinLotto winLotto = issueWinLotto();

    }


    private Money receiveMoney() {
        OutPutView.printBuyTicket();
        return new Money(InputView.readLine());
    }

    private WinLotto issueWinLotto() {
        OutPutView.printEnterWinNumber();
        String numbers = InputView.readLine();
        OutPutView.printBonusNumber();
        return new WinLotto(StringToList(numbers), Integer.parseInt(Console.readLine()));
    }

    private List<Integer> StringToList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
