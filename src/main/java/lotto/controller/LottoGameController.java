package lotto.controller;

import java.util.List;
import lotto.domain.dto.LottoDto;
import lotto.domain.mapper.LottoMapper;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoPurchaseCost;
import lotto.domain.model.LottoDispenser;
import lotto.domain.model.Lottos;
import lotto.domain.LottoRandomGenerator;
import lotto.domain.Repeater;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    InputView inputView;
    OutputView outputView;
    Repeater repeater;

    public LottoGameController(InputView inputView, OutputView outputView, Repeater repeater) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.repeater = repeater;
    }

    private LottoPurchaseCost readPurchaseCost() {
        outputView.printReadCostAmountMessage();

        return repeater.repeatBeforeSuccess(() -> new LottoPurchaseCost(inputView.readCostAmount()));
    }

    private Lottos buyLottos(int amount) {
        LottoDispenser lottoDispenser = new LottoDispenser(new LottoRandomGenerator());
        Lottos lottos = lottoDispenser.dispense(amount);
        outputView.printBuyingAmountMessage(amount);

        return lottos;
    }

    private void printBoughtLottos(Lottos lottos) {
        List<Lotto> rawLottos = lottos.getElements();
        List<LottoDto> lottoDtos = LottoMapper.toDtos(rawLottos);

        outputView.printLottos(lottoDtos);
    }

    private void initGame(LottoPurchaseCost lottoPurchaseCost) {
        int lottoAmount = lottoPurchaseCost.getLottoAmount();
        Lottos lottos = buyLottos(lottoAmount);
        printBoughtLottos(lottos);
    }

    public void play() {
        LottoPurchaseCost lottoPurchaseCost = readPurchaseCost();
        initGame(lottoPurchaseCost);
    }
}
