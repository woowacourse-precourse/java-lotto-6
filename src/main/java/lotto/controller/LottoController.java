package lotto.controller;

import lotto.dto.Lotto;
import lotto.dto.Lottos;
import lotto.dto.Money;
import lotto.service.CalculateProfit;
import lotto.service.CreateLottoList;
import lotto.service.FindBingo;
import lotto.view.InputBonusNumber;
import lotto.view.InputNumber;
import lotto.view.InputUserMoney;

import java.util.List;

import static lotto.view.OutputLottos.printLottos;
import static lotto.view.OutputPercent.printPercent;
import static lotto.view.OutputResult.printResult;
import static lotto.view.OutputTicketNum.printTicketNum;

public class LottoController {

    public void start(){
        Money money = getUserMoney();
        int ticket = money.ticket();

        Lottos lottos = makeLottoList(ticket);
        printTicketNum(ticket);
        printLottos(lottos);

        Lotto userLotto = getUserNumber();
        int bonusNum = getBonusNumber();

        makeBingo(lottos, userLotto, bonusNum);
        printResult();
        printPercent(calculate(ticket));
    }

    public Money getUserMoney(){
        InputUserMoney inputUserMoney = new InputUserMoney();
        Integer money = inputUserMoney.getInput();
        return new Money(money);
    }

    public Lotto getUserNumber(){
        InputNumber inputUserNumber = new InputNumber();
        List<Integer> userNumber = inputUserNumber.getInput();
        return new Lotto(userNumber);
    }

    public int getBonusNumber(){
        InputBonusNumber inputBonusNumber = new InputBonusNumber();
        return inputBonusNumber.getInput();
    }

    public Lottos makeLottoList(int ticket) {
        CreateLottoList lottoList = new CreateLottoList();
        return new Lottos(lottoList.createLottoList(ticket));
    }

    public void makeBingo(Lottos lottos, Lotto userLotto, int bonusNum){
        FindBingo findBingo = new FindBingo();
        findBingo.findBingos(lottos,userLotto,bonusNum);
    }

    private double calculate(int ticket) {
        CalculateProfit calculateProfit = new CalculateProfit();
        calculateProfit.calcProfit();
        return calculateProfit.calcProfitPercent(ticket);
    }

}
