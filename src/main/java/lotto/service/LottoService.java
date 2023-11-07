package lotto.service;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoData;
import lotto.domain.User;
import lotto.utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoService {
    private final NumberGenerator numberGenerator;

    public LottoService(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public LottoData setWinningNumbers(Lotto winningNumbers,BonusNumber bonusNumber) {
        return new LottoData(winningNumbers,bonusNumber);
    }

    public void buyLottoAll(User user) {
        int purchaseAmount = user.getPurchaseAmount();
        int lottoCount = purchaseAmount / 1000;

        IntStream.range(0, lottoCount)
                .forEach(i -> buyLottoOne(user));
    }

    private void buyLottoOne(User user) {
        Lotto lotto = generateLottoNumber();
        user.addLotto(lotto);
    }

    private Lotto generateLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>(
                numberGenerator.generateNumbers(1, 45, 6));
        return new Lotto(lottoNumbers);
    }
}
