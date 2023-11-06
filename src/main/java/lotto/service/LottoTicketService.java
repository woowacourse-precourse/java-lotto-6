package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.collections.LottoBundle;
import lotto.model.collections.LottoPurchaseAmount;
import lotto.model.collections.LottoTicketCount;
import lotto.validator.PurchaseAmountValidator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constant.LottoConfig.*;

public class LottoTicketService {
    private final int startInclusive = LOTTO_START_NUMBER.getValue();
    private final int endInclusive = LOTTO_END_NUMBER.getValue();
    private final int count = LOTTO_COUNT_NUMBER.getValue();

    private final PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();

    public LottoPurchaseAmount parsePurchaseAmount(String userInput){
        int validatedAmount = purchaseAmountValidator.validateAndParse(userInput);
        return new LottoPurchaseAmount(validatedAmount);
    }

    public LottoTicketCount calculateTicketCount(LottoPurchaseAmount purchaseAmount) {
        int ticketCount = purchaseAmount.getAmount() / TICKET_PRICE.getValue();
        return new LottoTicketCount(ticketCount);
    }

    public Lotto createLotto() {
        return Randoms.pickUniqueNumbersInRange(startInclusive,endInclusive,count)
                .stream()
                .sorted()
                .collect(Collectors.collectingAndThen(Collectors.toList(),Lotto::new));
    }

    public LottoBundle generateLottoBundle(int ticketCount){
        List<Lotto> lottoBundle = IntStream.range(0, ticketCount)
                .mapToObj(countIndex-> createLotto())
                .toList();
        return new LottoBundle(lottoBundle);
    }
}
