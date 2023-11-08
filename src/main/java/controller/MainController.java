package controller;

import model.*;
import model.CreateLottoObjectAndAssignLottoNumbers;
import view.InputBonusNumber;
import view.InputLottoPrice;
import view.InputLotteryNumber;

import java.util.List;

import static view.OutputLottoPaperCount.printBuyLotto;
import static view.OutputLottoList.printLottoList;
import static view.OutputResult.printOutputResult;

public class MainController {

    public void start() {
        LottoPrice price = inputLottoPrice();
        printBuyLotto(price);

        LottoObjectManagement lottos = MyLottos(price);
        printLottoList(lottos);

        LotteryNumbers lotteryNumbers = getLotteryNumbers();
        WinningPriceResult winningPriceResult = new WinningPriceResult();
        calcLottoResult(winningPriceResult, lotteryNumbers, lottos);

        ReturnRate rate = getRate(price, winningPriceResult);
        printOutputResult(winningPriceResult, rate);
    }

    private LottoPrice inputLottoPrice() {
        InputLottoPrice inputPrice = new InputLottoPrice();
        int price = inputPrice.inputLottoPrice();
        return new LottoPrice(price);
    }

    private LottoObjectManagement MyLottos(LottoPrice lottoPrice) {
        CreateLottoObjectAndAssignLottoNumbers createLottoObjectAndAssignLottoNumbers = new CreateLottoObjectAndAssignLottoNumbers();
        return new LottoObjectManagement(createLottoObjectAndAssignLottoNumbers.generateMyLottoGroup(lottoPrice.lottoPaperCount()));
    }

    private LotteryNumbers getLotteryNumbers() {
        InputLotteryNumber inputLotteryNumber = new InputLotteryNumber();
        InputBonusNumber inputBonusNumber = new InputBonusNumber();

        List<Integer> lotteryNumbers = inputLotteryNumber.inputLotteryNumbers();
        Integer bonusNumber = inputBonusNumber.inputBonusNumber();

        return new LotteryNumbers(lotteryNumbers, bonusNumber);
    }

    private void calcLottoResult(WinningPriceResult winningPriceResult, LotteryNumbers lotteryNumbers, LottoObjectManagement lottoObjectManagement) {
        winningPriceResult.calcWinningPriceResult(lotteryNumbers, lottoObjectManagement);
    }

    private ReturnRate getRate(LottoPrice lottoPrice, WinningPriceResult winningPriceResult) {
        return new ReturnRate(lottoPrice, winningPriceResult);
    }
}