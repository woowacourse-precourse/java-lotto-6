package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.Player;
import lotto.domain.Result;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static Player player;
    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private Result result;
    private int lottoCount;

    public void run() {
        getLotto();
        setWinning();
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

}
