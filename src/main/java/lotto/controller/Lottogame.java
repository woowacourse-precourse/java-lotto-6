package lotto.controller;


import static lotto.view.OutputLottolist.printLottoList;

import lotto.parser.ParserLotto;
import lotto.domain.GenerateLotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.OutputMoney;
import lotto.view.OutputView;
import lotto.view.Request;

public class Lottogame {
    public void start(){
        Money money = getLottoMoney();
        int count = money.countMoney();
        OutputMoney.resultMoney(count);

        Lottos lottos = getLottos(money);
        printLottoList(lottos);

        OutputView.ASK_INPUT_NUMBER.getMessage();
    }

    private Money getLottoMoney(){
        Request request = new Request();
        int money = ParserLotto.lottoParser(request.requestNubmer());
        return new Money(money);
    }

    private Lottos getLottos(Money money) {
        GenerateLotto lottoGenerator = new GenerateLotto();
        return new Lottos(lottoGenerator.generateLottoGroup(money.countMoney()));
    }
}
