package lotto.application;

import static lotto.enums.ErrorMassage.DUPLICATE_BONUS_NUMBER;
import static lotto.enums.LottoConfig.LOTTO_COUNT;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoNumber;
import lotto.dto.LottoTicket;
import lotto.dto.WinningLotto;

public class LottoStore {
    private final LottoMachine lottoMachine;
    private final NumberGenerator numberGenerator;

    public LottoStore(final LottoMachine lottoMachine, final NumberGenerator numberGenerator) {
        this.lottoMachine = lottoMachine;
        this.numberGenerator = numberGenerator;
    }

    public LottoTicket issueLottoTicketByAuto(final LottoAmount lottoAmount) {
        final int quantity = lottoAmount.getLottoQuantity();
        List<Lotto> lottos = IntStream.range(0, quantity)
                .mapToObj(i -> numberGenerator.generateNumbers(LOTTO_COUNT.getValue()))
                .map(lottoMachine::createLotto)
                .toList();
        return new LottoTicket(lottos);
    }

    public WinningLotto issueWinningLotto(final List<Integer> numbers, final int bonusNumber) {
        Lotto lotto = lottoMachine.createLotto(numbers);
        LottoNumber bonus = lottoMachine.createLottoNumber(bonusNumber);
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMassage());
        }
        return new WinningLotto(lotto, bonus);
    }
}
