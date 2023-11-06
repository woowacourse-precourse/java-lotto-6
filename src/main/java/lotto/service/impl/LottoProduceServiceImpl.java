package lotto.service.impl;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.adapter.IoAdapter;
import lotto.domain.Lotto;
import lotto.domain.Wallet;
import lotto.message.LottoMessage;
import lotto.service.LottoProduceService;
import lotto.service.SortService;
import lotto.utils.ValueUnit;
import lotto.vo.Money;

public class LottoProduceServiceImpl implements LottoProduceService {

    private final SortService sortService;
    private final IoAdapter ioAdapter;

    public LottoProduceServiceImpl(SortService sortService, IoAdapter ioAdapter) {
        this.sortService = sortService;
        this.ioAdapter = ioAdapter;
    }

    @Override
    public Wallet produceLotto(Money money) {
        ValueUnit startCount = ValueUnit.START_COUNT;
        int count = startCount.getValue();
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
        ValueUnit startNumber = ValueUnit.START_NUMBER;
        ValueUnit endNumber = ValueUnit.END_NUMBER;
        ValueUnit lottoNumbers = ValueUnit.LOTTO_NUMBERS;
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startNumber.getValue(), endNumber.getValue(),
                lottoNumbers.getValue());
        List<Integer> sortedLotto = sortService.sortLottoAsc(numbers);
        ioAdapter.printLotto(sortedLotto);
        return sortedLotto;
    }
}
