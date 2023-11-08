package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.PirzeResult;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoController {
    Input input = new Input();
    Output output = new Output();
    LottoGenerator lottoGenerator = new LottoGenerator();
    PirzeResult pirzeResult = new PirzeResult();
    public void start() {
        Money money = new Money(input.inputMoney());
        int ticket = money.getTicket();
        Lottos lottos = getLottos(ticket);
        output.printLottoTicketAmount(ticket);
        output.printLottos(lottos);
        List<Integer> winningNubmers = input.inputWinningNumbers();

        input.inputWinningNumbers();
    }

    public Lottos getLottos(int ticket){
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.generateLottos(ticket));
    }



}
