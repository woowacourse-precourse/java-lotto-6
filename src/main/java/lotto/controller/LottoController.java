package lotto.controller;

import lotto.domain.Constants;
import lotto.domain.Ranking;
import lotto.service.LottoService;
import lotto.domain.Lotto;
import lotto.service.UserService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;
    private final UserService userService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService, UserService userService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
        this.userService = userService;
    }

    public void run() {
        Integer price = getPrice();

        ArrayList<Lotto> lottos = getLottos(price);

        Lotto winningLotto = getWinningLotto();
        Integer bonusNumber = getBonusNumber(winningLotto);

        HashMap<Ranking, Integer> winningStatic = getWinningStatic(lottos, winningLotto, bonusNumber);

        getRateOfReturn(price, winningStatic);
    }

    private Integer getPrice() {
        while (true) {
            try {
                String price = inputView.getPrice();

                return userService.getPrice(price);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private ArrayList<Lotto> getLottos(Integer price) {
        ArrayList<Lotto> lottos = lottoService.getLottos(price, Constants.MIN_LOTTO_NUM, Constants.MAX_LOTTO_NUM);
        outputView.printLottos(lottoService.getLottoList(lottos), lottos.size());

        return lottos;
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                String winningNumber = inputView.getWinningNumber();

                return userService.getWinningLotto(winningNumber);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private Integer getBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String bonusNumber = inputView.getBonusNumber();

                return userService.getBonusNumber(bonusNumber, winningLotto);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private HashMap<Ranking, Integer> getWinningStatic(ArrayList<Lotto> lottos, Lotto winningLotto, Integer bonusNumber) {
        HashMap<Ranking, Integer> winningStatic = lottoService.getWinningStatic(lottos, winningLotto, bonusNumber);
        outputView.printWinningStatic(lottoService.makeWinningStaticResult(winningStatic));

        return winningStatic;
    }

    private Double getRateOfReturn(Integer price, HashMap<Ranking, Integer> winningStatic) {
        Double rateOfReturn = lottoService.getRateOfReturn(price, winningStatic);
        outputView.printRateOfReturn(rateOfReturn);

        return rateOfReturn;
    }
}
