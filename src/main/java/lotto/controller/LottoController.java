package lotto.controller;

import static lotto.view.View.requestMoney;
import static lotto.view.View.printMessage;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import lotto.constant.Message;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Money;
import lotto.model.LottoStore;
import lotto.validator.ValidateObject;
import lotto.view.View;

public class LottoController {
    public void run(){
        try{
            start();
        }catch(IllegalArgumentException e){
            NumberFormatException exception = new NumberFormatException("[ERROR] 잘못된 값입니다.");
            exception.setStackTrace(new StackTraceElement[0]);
            throw exception;
        }
    }
    private void start() {
        LottoStore lottoStore = new LottoStore();   // 랭킹 출력

        Customer customer = buyLottoAndGetNumbers();
        int boughtLottoCount = customer.getLottoCount();
        lottoStore.setLottoSales(boughtLottoCount);
        printMessage(boughtLottoCount + Message.PURCHASED_LOTTO_COUNT_MESSAGE.getMessage());
        customer.showLottos();  // 로또 생성후 출력

        printMessage(Message.INPUT_WINNING_NUMBER.getMessage());
        Lotto winningLotto = inputWinningNumber();  // 로또 생성

        printMessage(Message.INPUT_BONUS_NUMBER.getMessage());
        int bonusNumber = inputBonusNumber();
        ValidateObject.validateBonusNumber(winningLotto, bonusNumber);  // 보너스 넘버

        printMessage(Message.RESULT_MESSAGE.getMessage());
        View.seperateLine();


        List<Integer> lottoRank = lottoStore.rankLottos(customer.getLottos(), winningLotto, bonusNumber);
        lottoStore.setTotalWinningMoney(lottoRank);

        View.printLottoRank(lottoRank);
        View.printMessage(
                "총 수익률은 "+
                lottoStore.calculateRateOfReturn().toString()+"%입니다.");
    }

    private Customer buyLottoAndGetNumbers() {
        Money money;
        while(true) {
            try {
                printMessage(Message.INPUT_BUDGET.getMessage());    // 시작 메시지
                money = new Money(requestMoney());
                break;

            } catch (NumberFormatException e) {
                System.out.println("[ERROR]");
                Console.readLine();
            }
        }
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
