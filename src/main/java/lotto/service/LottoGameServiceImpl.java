package lotto.service;

import lotto.computation.WinningComputer;
import lotto.domain.*;
import lotto.utility.FormatConverter;
import lotto.utility.RandomNumberGenerator;
import lotto.utility.TypeConverter;

import java.util.List;

public class LottoGameServiceImpl implements LottoGameService {
    @Override
    public PurchaseAmount parsePurchaseAmount(String purchaseAmountInput) {
        int purchaseAmount = TypeConverter.convertStringToInt(purchaseAmountInput);
        return new PurchaseAmount(purchaseAmount);
    }

    @Override
    public LottoCount computeLottoCount(PurchaseAmount purchaseAmount) {
        return LottoCount.from(purchaseAmount.getPurchaseAmount());
    }

    @Override
    public Lottos generateLottos(LottoCount lottoCount) {
        Lottos lottos = new Lottos();

        for (int i = 0; i < lottoCount.getLottoCount(); i++) {
            Lotto lotto = generateLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    @Override
    public WinningNumbers parseWinningNumbers(String winningNumbersInput) {
        List<Integer> winningNumbers = FormatConverter.toIntegerListFromStringWithComma(winningNumbersInput);
        return WinningNumbers.of(winningNumbers);
    }

    @Override
    public BonusNumber parseBonusNumber(String bonusNumberInput) {
        return new BonusNumber(TypeConverter.convertStringToInt(bonusNumberInput));
    }

    @Override
    public Winnings countMatchingNumbers(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        Winnings winnings = new Winnings();

        for (int i = 0; i < lottos.size(); i++) {
            Winning winning = WinningComputer.computeMatchCount(lottos.get(i).getNumbers(), winningNumbers);

            if (winning.isFive()) {
                winning = WinningComputer.computeMatchCount(lottos.get(i).getNumbers(), bonusNumber);
            }

            winnings.add(winning);
        }

        return winnings;
    }

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = RandomNumberGenerator.generateNotDuplicatedRandomNumbersOrderByAsc();
        return new Lotto(lottoNumbers);
    }
}
