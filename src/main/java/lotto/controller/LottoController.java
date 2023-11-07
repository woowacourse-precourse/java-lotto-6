package lotto.controller;

import static lotto.view.View.requestMoney;
import static lotto.view.View.printMessage;

import java.util.List;
import lotto.constant.Message;
import camp.nextstep.edu.missionutils.Console;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Money;
import lotto.model.LottoStore;
import lotto.validator.ValidateObject;
import lotto.view.View;

public class LottoController {
    public void run() {
        printMessage(Message.INPUT_BUDGET.getMessage());    // 시작 메시지

        Customer customer = buyLottoAndGetNumbers();
        printMessage(customer.getLottoCount() + Message.PURCHASED_LOTTO_COUNT_MESSAGE.getMessage());
        customer.showLottos();  // 로또 생성후 출력

        printMessage(Message.INPUT_WINNING_NUMBER.getMessage());
        Lotto winningLotto = inputWinningNumber();  // 로또 생성

        printMessage(Message.INPUT_BONUS_NUMBER.getMessage());
        int bonusNumber = inputBonusNumber();
        ValidateObject.validateBonusNumber(winningLotto, bonusNumber);  // 보너스 넘버

        printMessage(Message.RESULT_MESSAGE.getMessage());
        View.seperateLine();

        LottoStore lottoStore = new LottoStore();
        List<Integer> lottoRank = lottoStore.rankLottos(customer.getLottos(), winningLotto, bonusNumber);
        View.printLottoRank(lottoRank);
    }

    private Customer buyLottoAndGetNumbers() {
        Money money = new Money(requestMoney());
        Customer customer = new Customer(money);
        customer.purchaseLotto();

        return customer;
    }

    private Lotto inputWinningNumber() {
        LottoNumber lottoNumber = new LottoNumber();
        String winningNumber = Console.readLine();
        lottoNumber.createWinningNumber(winningNumber);

        return new Lotto(lottoNumber.getLottoNumbers());
    }

    private int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
