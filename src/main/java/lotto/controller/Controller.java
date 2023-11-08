package lotto.controller;

import lotto.model.*;

import lotto.view.InputView;
import lotto.view.OutputView;


import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public static int NumberOfLotto;

    public Controller(InputView inputView, OutputView outputView) {
        //exception?
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void StartLotto() {//하나의 기능만 가지도록 해야한다 -> 메서드 호출만?
        try {
            MyLottoNumbers myLottoNumbers = buyLotto();
            LottoDraw lottoDraw = drawLottoNumber();
            totalResult(myLottoNumbers, lottoDraw);

        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException();
        }
    }

    private MyLottoNumbers buyLotto() {
            NumberOfLotto = CalculateNumberOfLotto.InputCost(inputView.inputCost()).getCalculateNumberOfLotto();
            MyLottoNumbers myLottoNumbers = MyLottoNumbers.generateLottoList(NumberOfLotto);
            outputView.printNumberOfLotto(NumberOfLotto);
            outputView.printMyNumbers(myLottoNumbers);

            return myLottoNumbers;

    }
    private LottoDraw drawLottoNumber() {
        Lotto winningNumbers = new Lotto(inputView.inputOriginalNumber());
        Bonus bonusNumbers = new Bonus(inputView.inputBonus());
        LottoDraw lottoDraw = LottoDraw.by(winningNumbers, bonusNumbers);
        return lottoDraw;
    }
    private void totalResult(MyLottoNumbers myLottoNumbers, LottoDraw lottoDraw){

        WinningResult winningResult = new WinningResult();
        List<Integer> results = winningResult.calculateResults(myLottoNumbers, lottoDraw);

        outputView.printDrawResult(results);
        long totalRevenue = winningResult.calculateRevenue(results);
        double totalRevenueRate = (double)totalRevenue/(NumberOfLotto * 10);
        outputView.printRevenueResult(totalRevenueRate);
    }






}
