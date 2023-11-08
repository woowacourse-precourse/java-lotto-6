package lotto.domain.lotto.issue;

import java.util.List;
import java.util.stream.LongStream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGroup;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoPrice;
import lotto.domain.lotto.LottoPurchaseAmount;
import lotto.domain.lotto.lottery.LotteryMachine;

public class LottoIssue {
    private final LotteryMachine<LottoNumber> lotteryMachine;

    public LottoIssue(final LotteryMachine<LottoNumber> lotteryMachine) {
        this.lotteryMachine = lotteryMachine;
    }

    public LottoGroup issue(
            final LottoPurchaseAmount amount,
            final LottoPrice lottoPrice
    ) {
        final long issueAmount = amount.getAmount() / lottoPrice.getPrice();

        final List<Lotto> lottos = LongStream.rangeClosed(1, issueAmount)
                .mapToObj(notUsed -> new Lotto(lotteryMachine.generate()))
                .toList();

        return new LottoGroup(lottos);
    }
}
