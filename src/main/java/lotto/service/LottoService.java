package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoTicket;
import lotto.model.PurchaseAmount;
import lotto.util.Converter;
import lotto.util.RandomNumberGenerator;

public class LottoService {
    private PurchaseAmount purchaseAmount;
    private LottoTicket lottoTicket = new LottoTicket();
    private Lotto winningLotto;

    public void initPurchaseAmount(String inputMoney) {
        this.purchaseAmount = new PurchaseAmount(Converter.stringToInt(inputMoney));
    }

    public void purchaseLotto() {
        IntStream.range(0, purchaseAmount.getMaxLottoCountForBudget())
                .forEach(i -> lottoTicket.addLotto(RandomNumberGenerator.createUniqueNumbers()));
    }

    public List<LottoDto> getLottoDtos() {
        return lottoTicket.toDto();
    }

    public void initWinningLotto(List<String> inputNumbers) {
        this.winningLotto = new Lotto(Converter.stringListToIntegers(inputNumbers));
    }

}
