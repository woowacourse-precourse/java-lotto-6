package lotto.service;

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

    private Lotto generateLotto() {
        List<Integer> lottoNumbers = RandomNumberGenerator.generateNotDuplicatedRandomNumbersOrderByAsc();
        return new Lotto(lottoNumbers);
    }
}
