package lotto.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.adapter.IoAdapter;
import lotto.domain.Wallet;
import lotto.message.LottoMessage;
import lotto.service.LottoProduceService;
import lotto.service.SortService;
import lotto.domain.Lotto;
import lotto.vo.Money;

public class LottoProduceServiceImpl implements LottoProduceService {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private final SortService sortService;
    private final IoAdapter ioAdapter;

    public LottoProduceServiceImpl(SortService sortService, IoAdapter ioAdapter) {
        this.sortService = sortService;
        this.ioAdapter = ioAdapter;
    }

    @Override
    public Wallet produceLotto(Money money) {
        int count = 0;
        printLottoCount(money);
        List<Lotto> lottoBundle = new ArrayList<>();
        while (!money.isLottoCountSameAsMoney(count)) {
            List<Integer> sortedLotto = makeLotto();
            Lotto lotto = new Lotto(sortedLotto);
            lottoBundle.add(lotto);
            count++;
        }
        return new Wallet(lottoBundle);
    }

    private void printLottoCount(Money money) {
        LottoMessage howManyBuyMessage = LottoMessage.HOW_MANY_BUY_LOTTO;
        String lottoCount = money.lottoExchangeCount();
        ioAdapter.printMessage(lottoCount + howManyBuyMessage.getMessage());
    }

    private List<Integer> makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_COUNT);
        List<Integer> sortedLotto = sortService.sortLottoAsc(numbers);
        ioAdapter.printLotto(sortedLotto);
        return sortedLotto;
    }
}
