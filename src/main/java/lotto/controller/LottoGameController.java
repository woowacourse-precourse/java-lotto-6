package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.StringTokenizer;
import lotto.model.Lotties;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoService = new LottoService();
    }

    public void start() {
        int money = inputView.getPrice();
        Lotties purchasedLotties = lottoService.buyLotties(money);
        outputView.printPurchasedLotties(purchasedLotties.getLotties());

        String winningNumbers = inputView.getWinningNumbers();
        Lotto winningLotto = lottoService.convertLottoNumbers(winningNumbers);
        int bonusNumber = inputView.getBonusNumber();
        lottoService.validateBonusNumber(bonusNumber);

        EnumMap<Rank, Integer> rankCounts = lottoService.getWinningStatistics(purchasedLotties, winningLotto, bonusNumber);
        outputView.printWinningStatistics(rankCounts);

        double profitability =lottoService.getProfitability(rankCounts, money);
        outputView.printProfitability(profitability);
    }




}
