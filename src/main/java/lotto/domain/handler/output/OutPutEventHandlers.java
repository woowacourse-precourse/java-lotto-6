package lotto.domain.handler.output;

import java.util.List;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import lotto.domain.event.LottoMessageBroker;
import lotto.domain.event.Yieldcalculationcompleted;
import lotto.domain.event.LottoGameStart;
import lotto.domain.event.input.MoneyInputRequested;
import lotto.domain.event.output.TicketsCreated;
import lotto.domain.event.input.LottoInputRequested;
import lotto.util.LottoNumberConstants;
import lotto.util.LottoOutputConstant;

public class OutPutEventHandlers {

    private final LottoMessageBroker lottoMessageBroker;

    public OutPutEventHandlers(LottoMessageBroker lottoMessageBroker) {
        this.lottoMessageBroker = lottoMessageBroker;
    }

    public void printMoneyInput(MoneyInputRequested event) {
        System.out.println(event.money() / LottoNumberConstants.LOTTO_PRICE.getValue()
                + LottoOutputConstant.PURCHASE_MESSAGE.getMessage());
    }


    public void printTicketCreation(TicketsCreated tickets) {
        tickets.lottos().forEach(lotto -> System.out.println(lotto.numbers() + System.lineSeparator()));
        System.out.println(LottoOutputConstant.WINNING_NUMBER_MESSAGE.getMessage());


    }

    public void printLottoNumbersInput(LottoInputRequested lotto) {
        System.out.println(LottoOutputConstant.BONUS_NUMBER_MESSAGE.getMessage());
    }

    public void printlottoEventResult(Yieldcalculationcompleted yieldcalculationcompleted) {
        List<String> ranks = yieldcalculationcompleted.allRankResults();
        ranks.forEach(System.out::println);

        double profitRate = yieldcalculationcompleted.profitRate();
        System.out.printf(LottoOutputConstant.PROFIT_RATE_FORMAT.getMessage(), profitRate);

    }

}
