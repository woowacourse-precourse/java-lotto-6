package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private static Player player;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private Result result;
    private int lottoCount;

    public void run() {
        getLotto();
        setWinning();
        lottoResult(lottoList, result, lottoCount);
    }

    public void getLotto() {
        try {
            lottoCount = inputPlayerAmount();
            OutputView.printLottoAmount(lottoCount);
            lottoList = setLottoList(lottoCount);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+ e.getMessage());
            getLotto();
        }
    }

    public void setWinning() {
        try {
            result = inputLottoNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+ e.getMessage());
            setWinning();
        }
    }

    public int inputPlayerAmount() {
        player = new Player(InputView.inputPlayerAmount());
        return player.calculateLottoCount();
    }

    public Result inputLottoNumber() {
        Lotto lotto = new Lotto(InputView.inputLottoNumber());
        List<Integer> lottoNumber = lotto.getLottoNumbers();

        int bonus = InputView.inputBonusNumber();
        lotto.validateBonusNumber(lottoNumber, bonus);
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
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        lotto = new ArrayList<>();
        lotto = lottoNumberGenerator.setLottoNumber();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

    private void lottoResult(List<Lotto> lottoList, Result winningLotto, int amount) {
        Map<Ranking, Integer> result = setResult();
        Ranking rank;

        OutputView.printResult();
        for (int i = 0; i < lottoList.size(); i++) {
            rank = winningLotto.match(lottoList.get(i));
            result.put(rank, result.get(rank) + 1);
        }
        printResult(result);
    }

    private void printResult(Map<Ranking, Integer> result) {
        for (int i = Ranking.values().length - 1; i >= 0; i --) {
            Ranking.values()[i].printMessage(result.get(Ranking.values()[i]));
        }
    }

    private Map<Ranking, Integer> setResult() {
        Map<Ranking, Integer> result = new LinkedHashMap<>();
        for (Ranking rank : Ranking.values()) {
            result.put(rank, 0);
        }
        return result;
    }

}
