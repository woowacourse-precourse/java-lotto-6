package lotto.controller;

import lotto.model.CorrectLotto;
import lotto.model.CountLotto;
import lotto.model.MakeLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import javax.swing.*;
import java.util.List;

public class PlayLotto {
    public static void playLotto() {
        Integer initialMoney = Integer.parseInt(InputView.askPrice());
        Integer countLotto = CountLotto.countLotto(initialMoney);
        OutputView.printCount(countLotto);
        List<List<Integer>> myLotto = MakeLotto.makeLotto(countLotto);
        OutputView.printLotto(myLotto);
        List<Integer> correctLotto = CorrectLotto.correctLotto();
        Integer bonusNumber = InputView.askBonus();

    }

}
