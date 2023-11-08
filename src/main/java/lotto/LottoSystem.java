package lotto;

import lotto.domain.event.LottoGameStart;
import lotto.domain.event.LottoMessageBroker;
import lotto.domain.event.Yieldcalculationcompleted;
import lotto.domain.event.input.BonusNumberInputRequested;
import lotto.domain.event.input.LottoInputRequested;
import lotto.domain.event.input.MoneyInputRequested;
import lotto.domain.event.output.TicketsCreated;
import lotto.domain.event.output.TicketsEvaluateCompleted;
import lotto.domain.handler.service.LottoYieldCalculatorHandler;
import lotto.domain.handler.input.LottoInputEventHandler;
import lotto.domain.handler.output.OutPutEventHandlers;
import lotto.domain.handler.service.LottoCompareHandler;
import lotto.domain.handler.service.LottoNumberGeneratorHandler;
import lotto.domain.publisher.LottoEventPublisher;
import lotto.util.LottoOutputConstant;
import lotto.util.input.LottoConsoleReader;

public class LottoSystem {

    private final LottoMessageBroker lottoMessageBroker;
    private final LottoEventPublisher publisher;

    public LottoSystem() {
        this.lottoMessageBroker = new LottoMessageBroker();
        this.publisher = new LottoEventPublisher(lottoMessageBroker);
        initSubscriptions();
    }


    private void initSubscriptions() {
        LottoInputEventHandler lottoInputEventHandler = new LottoInputEventHandler(lottoMessageBroker,
                new LottoConsoleReader());
        OutPutEventHandlers outPutEventHandlers = new OutPutEventHandlers(lottoMessageBroker);
        LottoCompareHandler lottoCompareHandler = new LottoCompareHandler(lottoMessageBroker);
        LottoNumberGeneratorHandler lottoNumberGeneratorHandler = new LottoNumberGeneratorHandler(lottoMessageBroker);
        LottoYieldCalculatorHandler lottoYieldCalculatorHandler = new LottoYieldCalculatorHandler(lottoMessageBroker);

        lottoMessageBroker.subscribe(LottoGameStart.class,
                lottoInputEventHandler::requestLottoMoney
        );
        lottoMessageBroker.subscribe(MoneyInputRequested.class,
                outPutEventHandlers::printMoneyInput,
                lottoNumberGeneratorHandler::generateLottoTickets
        );
        lottoMessageBroker.subscribe(TicketsCreated.class,
                outPutEventHandlers::printTicketCreation,
                lottoInputEventHandler::requestLottoNumbers
        );
        lottoMessageBroker.subscribe(LottoInputRequested.class,
                outPutEventHandlers::printLottoNumbersInput,
                lottoInputEventHandler::requestBonusLottoNumber
        );

        lottoMessageBroker.subscribe(BonusNumberInputRequested.class,
                lottoCompareHandler::evaluateLottoTickets);

        lottoMessageBroker.subscribe(TicketsEvaluateCompleted.class,
                lottoYieldCalculatorHandler::calculateYield);

        lottoMessageBroker.subscribe(Yieldcalculationcompleted.class,
                outPutEventHandlers::printlottoEventResult
        );
    }

    public void run() {
        publisher.publishEvent(new LottoGameStart(LottoOutputConstant.INPUT_MONEY_MESSAGE.getMessage()));
    }
}
