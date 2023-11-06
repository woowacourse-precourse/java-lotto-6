package lotto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Result;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private int lottoCnt;

    public void run() {
        part1();
        Lotties lotties = part2();
        WinningNumber winningNumber = part3();



    }


    public void part1() {
        OutputView.printBuyInputPrice();
        int userPrice = InputView.inputUserPrice();
        lottoCnt = userPrice / 1000;
        OutputView.printBuyLottoCount(lottoCnt);
    }

    public Lotties part2(){
        Lotties lotties = LottoFactory.generateLotties(lottoCnt);
        OutputView.pritntLottos(lotties.getLottiesNumbers());
        return lotties;
    }

    public void part3(){
        OutputView.printEntertWinningNumber();
        List<Integer> numbers = InputView.inputLottoNumbers();

        OutputView.printEnterBounsNumber();
        int bonusNumber = InputView.inputBonusNumber();

    }

    public void part4(){
        
    }


}
