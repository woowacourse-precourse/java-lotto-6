package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.MessageConstants.*;

import lotto.validator.PlayerValidator;
import lotto.validator.LottoValidator;

public class LottoController {
    private static Player player;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private Result result;
    private int lottoCount;

    public void run() {
        startLotto();
        setWinning();
        setLottoResult(lottoList, result, lottoCount);
    }

    public void startLotto() {
        try {
            lottoCount = setAmount();
            OutputView.printLottoAmount(lottoCount);
            lottoList = setLottoList(lottoCount);

        } catch (IllegalArgumentException e) {
            System.out.println(ERROR + e.getMessage());
            startLotto();
        }
    }

    public void setWinning() {
        try {
            result = setLottoNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR + e.getMessage());
            setWinning();
        }
    }

    public int setAmount() {
        String imputAmount = InputView.getMoneyAmount();
        int amount = PlayerValidator.validateAmount(imputAmount);
        player = new Player(amount);
        return player.calculateLottoCount();
    }

    public Result setLottoNumber() {
        Lotto lotto = new Lotto(InputView.getLottoNumber());
        List<Integer> lottoNumber = lotto.getLottoNumbers();
        int bonus = InputView.getBonusNumber();
        LottoValidator.validate_all(lottoNumber);
        LottoValidator.validateBonusNumber(lottoNumber, bonus);
        result = new Result(new Lotto(lottoNumber), bonus);
        return result;
    }


    private static List<Lotto> setLottoList(int lottoCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(setLotto());
        }
        return lottoList;
    }

    private static Lotto setLotto() {
        LottoNumber LottoNumber = new LottoNumber();
        lotto = new ArrayList<>();
        lotto = LottoNumber.setLottoNumber();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private void setLottoResult(List<Lotto> lottoList, Result winningLotto, int amount) {
        Map<Ranking, Integer> result = setRank();
        Ranking rank;
        OutputView.printResult();
        for (int i = 0; i < lottoList.size(); i++) {
            rank = winningLotto.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        OutputView.printRANKING(result);
        OutputView.printEarningRate(result, amount);
    }

    private Map<Ranking, Integer> setRank() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();
        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        return result;
    }

}