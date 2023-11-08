package lotto.controller;


import lotto.parser.ParserLotto;
import lotto.domain.GenerateLotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.OutputMoney;
import lotto.view.Request;

public class Lottogame {
    public void start(){
        Money money = getLottoMoney();
        Integer count = money.countMoney();
        OutputMoney.resultMoney(count);

        Lottos lottos = getLottos(money, count);

    }

    private Money getLottoMoney(){
        Request request = new Request();
        int money = ParserLotto.lottoParser(request.requestNubmer());
        return new Money(money);
    }

    private Lottos getLottos(Money money, int count) {
        GenerateLotto lottoGenerator = new GenerateLotto();
        return new Lottos(lottoGenerator.generateLottoGroup(count));
    }
}
