package lotto.service;

import static lotto.LottoRule.LOTTO_NUMBER_COUNT;
import static lotto.LottoRule.LOTTO_NUMBER_END;
import static lotto.LottoRule.LOTTO_NUMBER_START;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.MainNumbers;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoTicket;

public class LottoService {

    private List<Lotto> lottos;
    private MainNumbers mainNumbers;
    private BonusNumber bonusNumber;
    private WinningNumbers winningNumbers;

    public void init(int size) {
        this.lottos = new ArrayList<>();
        while (lottos.size() < size) {
            lottos.add(new Lotto(createLottoNumbers()));
        }
    }

    public void initMainNumbers(List<Integer> mainNumbers) {
        this.mainNumbers = new MainNumbers(mainNumbers);
    }

    public void initBonusNumber(int bonus) {
        this.bonusNumber = new BonusNumber(this.mainNumbers.toList(), bonus);
    }

    public void initWinningNumbers() {
        this.winningNumbers = new WinningNumbers(mainNumbers, bonusNumber);
    }

    public List<LottoTicket> tickets() {
        return lottos.stream().map(Lotto::toLottoTicket).toList();
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START.value(), LOTTO_NUMBER_END.value(),
                LOTTO_NUMBER_COUNT.value());
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }

}
