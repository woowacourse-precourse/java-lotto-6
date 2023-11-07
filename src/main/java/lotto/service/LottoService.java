package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.util.Converter;
import lotto.util.RandomNumberGenerator;

public class LottoService {
    private PurchaseAmount purchaseAmount;
    private Lottos lottos = new Lottos();
    private Lotto winningLotto;
    private WinningNumbers winningNumbers;
    private LottoResult lottoResult;

    public void initPurchaseAmount(String inputMoney) {
        this.purchaseAmount = new PurchaseAmount(Converter.stringToInt(inputMoney));
    }

    public void purchaseLotto() {
        IntStream.range(0, purchaseAmount.getMaxLottoCountForBudget())
                .forEach(i -> lottos.addLotto(RandomNumberGenerator.createUniqueNumbers()));
    }

    public List<LottoDto> getLottoDtos() {
        return lottos.toDto();
    }

    public void initWinningLotto(List<String> inputNumbers) {
        this.winningLotto = new Lotto(Converter.stringListToIntegers(inputNumbers));
    }

    public void initWinningNumbers(String inputBonusNumber) {
        this.winningNumbers = new WinningNumbers(winningLotto, Converter.stringToInt(inputBonusNumber));
    }

    public void compareNumbers() {
        lottoResult = new LottoResult(lottos.compareLotto(winningNumbers));
    }

    public LottoResultDto getLottoResultDto() {
        return lottoResult.getLottoResultDto();
    }

    public double getProfitRate() {
        return lottoResult.caculateProfitRate();
    }

}
