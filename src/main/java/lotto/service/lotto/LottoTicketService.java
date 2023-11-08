package lotto.service.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoBundle;
import lotto.model.LottoPurchaseAmount;
import lotto.model.LottoTicketCount;
import lotto.view.input.validator.PurchaseAmountValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constant.LottoConfig.*;
import static lotto.view.input.parser.numberParser.parseInteger;

public class LottoTicketService {
    private final int startInclusive = LOTTO_START_NUMBER.getValue();
    private final int endInclusive = LOTTO_END_NUMBER.getValue();
    private final int count = LOTTO_COUNT_NUMBER.getValue();
    private final int DEFAULT_COUNT = 0;
    private final PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();

    public LottoPurchaseAmount parsePurchaseAmount(String userInput) {
        purchaseAmountValidator.validate(userInput);
        int validatedAmount = parseInteger(userInput);
        return new LottoPurchaseAmount(validatedAmount);
    }

    public LottoTicketCount calculateTicketCount(LottoPurchaseAmount purchaseAmount) {
        int ticketCount = purchaseAmount.amount() / TICKET_PRICE.getValue();
        return new LottoTicketCount(ticketCount);
    }

    public Lotto createLotto() {
        return Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count)
                .stream()
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
    }

    public LottoBundle generateLottoBundle(int ticketCount) {
        List<Lotto> lottoBundle = IntStream.range(DEFAULT_COUNT, ticketCount)
                .mapToObj(countIndex -> createLotto())
                .toList();
        return new LottoBundle(lottoBundle);
    }
}
