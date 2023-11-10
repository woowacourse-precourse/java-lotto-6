package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.UserLotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import static lotto.domain.LottoConstant.PRICE_PER_LOTTO;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;


    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int price = purchaseLotto();
        int lottoSheets = price / PRICE_PER_LOTTO;
        outputView.printLottoQuantity(lottoSheets);

        List<Lotto> lottos = lottoService.generateLotto(lottoSheets);
        outputView.printLottoNumbers(lottos);

        List<Integer> lottoNumbers = writeUserLottoNumbers();
        int bonusNumber = writeUserBonusNumber(lottoNumbers);
        UserLotto userLotto = new UserLotto(lottoNumbers, bonusNumber);

        lottoResult(price, lottos, userLotto);
    }

    private int purchaseLotto() {
        int price = 0;
        boolean isRetry = true;

        while(isRetry) {
            try {
                price = inputView.inputLottoPrice();
                isRetry = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return price;
    }

    private List<Integer> writeUserLottoNumbers() {
        boolean isRetry = true;
        List<Integer> lottoNumbers = new ArrayList<>();

        while (isRetry) {
            try {
                lottoNumbers = inputView.inputLottoNumbers();
                isRetry = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                lottoNumbers.clear();
            }
        }
        return lottoNumbers;
    }

    private int writeUserBonusNumber(List<Integer> lottoNumbers) {
        boolean isRetry = true;
        int bonusNumber = 0;

        while (isRetry) {
            try {
                bonusNumber = inputView.inputLottoBonusNumber(lottoNumbers);
                isRetry = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    private void lottoResult(int price, List<Lotto> lottos, UserLotto userLotto) {
        EnumMap<LottoRank, Integer> lottoResult = lottoService.getLottoResult(lottos, userLotto);

        outputView.printLotteryResult(lottoResult);

        double ratio = lottoService.calculatePrizeRatio(lottoResult, price);

        outputView.printPrizeRatio(ratio);
    }
}
