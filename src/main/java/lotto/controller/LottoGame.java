package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final int MIN = 1;
    private final int MAX = 45;
    private final int LOTTO_SIZE = 6;
    private final int THOUSAND = 1000;
    private final OutputView outputView = new OutputView();
    private final InputMoney inputMoney = new InputMoney();
    private final BonusNumber bonusNumber = new BonusNumber();
    private final List<Lotto> totalLotto = new ArrayList<>();
    private final TotalResult totalResult = new TotalResult();

    public void run() {
        int initMoney = inputMoney.save();
        countLotto(initMoney / THOUSAND);
        WinningNumbers winningNumbers = makeWinningNumbers();
        int bonusNumber = selectBonusNumber(winningNumbers);
        totalResult.print(initMoney, totalLotto, winningNumbers, bonusNumber);
    }

    private int selectBonusNumber(WinningNumbers winningNumbers) {
        return bonusNumber.add(winningNumbers);
    }

    private WinningNumbers makeWinningNumbers() {
        outputView.winningNumbers();
        return WinningNumbers.from();
    }

    private void countLotto(int lottoPaper) {
        outputView.count(lottoPaper);

        for (int index = 0; index < lottoPaper; index++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN, MAX, LOTTO_SIZE);
            List<Integer> sortNumbers = new ArrayList<>(numbers);
            Lotto lotto = new Lotto(sortNumbers);
            totalLotto.add(lotto);

        }
        outputView.printTotalLotto(totalLotto);
    }
}

