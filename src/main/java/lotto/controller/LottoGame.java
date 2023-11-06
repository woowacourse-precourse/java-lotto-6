package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final int THOUSAND = 1000;
    private final OutputView outputView = new OutputView();
    private final InputMoney inputMoney = new InputMoney();
    private final BonusNumber bonusNumber = new BonusNumber();
    private final List<Lotto> totalLotto = new ArrayList<>();
    private final TotalResult totalResult = new TotalResult();

    public void run() {
        int initMoney = inputMoney.save();
        int bonusNumber = 0;
        countLotto(initMoney /THOUSAND);
        WinningNumbers winningNumbers = makeWinningNumbers();
        bonusNumber = addBonusNumber(winningNumbers);
        totalResult.print(initMoney, totalLotto, winningNumbers, bonusNumber);
    }

    private int addBonusNumber(WinningNumbers winningNumbers) {
        return bonusNumber.add(winningNumbers);
    }


    private WinningNumbers makeWinningNumbers() {
        outputView.winningNumbers();
        return WinningNumbers.from();
    }


    private void countLotto(int lottoPaper) {
        outputView.count(lottoPaper);

        for(int i=0; i<lottoPaper; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            Lotto lotto = new Lotto(numbers);
            totalLotto.add(lotto);
        }

        outputView.printTotalLotto(totalLotto);
    }
}

