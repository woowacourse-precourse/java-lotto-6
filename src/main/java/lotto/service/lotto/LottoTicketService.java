package lotto.service.lotto;

import lotto.model.Lotto;
import lotto.model.LottoBundle;
import lotto.model.LottoPurchaseAmount;
import lotto.model.LottoTicketCount;
import lotto.service.lotto.generator.AutoTicketGenerator;
import lotto.view.input.validator.PurchaseAmountValidator;

import java.util.List;
import java.util.stream.IntStream;

import static lotto.constant.LottoConfig.*;
import static lotto.view.input.parser.numberParser.parseInteger;

public class LottoTicketService {
    private final int DEFAULT_COUNT = 0;
    private final PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
    private final AutoTicketGenerator autoTicketGenerator = new AutoTicketGenerator();

    public LottoPurchaseAmount parsePurchaseAmount(String userInput) {
        purchaseAmountValidator.validate(userInput);
        int validatedAmount = parseInteger(userInput);
        return new LottoPurchaseAmount(validatedAmount);
    }

    public LottoTicketCount calculateTicketCount(LottoPurchaseAmount purchaseAmount) {
        int ticketCount = purchaseAmount.amount() / TICKET_PRICE.getValue();
        return new LottoTicketCount(ticketCount);
    }

    public LottoBundle generateLottoBundle(int ticketCount) {
        List<Lotto> lottoBundle = IntStream.range(DEFAULT_COUNT, ticketCount)
                .mapToObj(countIndex -> autoTicketGenerator.createLotto())
                .toList();
        return new LottoBundle(lottoBundle);
    }
}
