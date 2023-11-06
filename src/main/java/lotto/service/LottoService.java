package lotto.service;

import static lotto.constant.LottoConstants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

public class LottoService {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoService(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> createLottos(int lottoPurchaseAmount) {
        int lottoCount = calculateLottoCount(lottoPurchaseAmount);
        return Stream.generate(LottoGenerator::generatorLotto)
                .limit(lottoCount)
                .collect(Collectors.toList());
    }

    public int checkLotto(Lotto lotto) {
        return winningNumbers.compareNumbers(lotto);
    }

    public boolean checkBonusNumber(Lotto lotto) {
        return lotto.compareNumber(bonusNumber);
    }

    private int calculateLottoCount(int lottoPurchaseAmount) {
        return lottoPurchaseAmount / LOTTO_PRICE;
    }
}
