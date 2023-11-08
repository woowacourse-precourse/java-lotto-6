package lotto.controller;

import lotto.constants.LottoConstant;
import lotto.model.Lotto;
import lotto.model.LottoResultCalculator;
import lotto.model.NumberGenerator;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    ArrayList<Lotto> lottos;
    ArrayList<Integer> prizeNum;
    int bonusNum;
    int [] lottoSameSize;
    NumberGenerator numberGenerator;
    LottoResultCalculator calculator;
    Input input;
    Output output;

    public LottoController() {
        lottos = new ArrayList<>();
        prizeNum = new ArrayList<>();
        numberGenerator = new NumberGenerator();
        calculator = new LottoResultCalculator();
        input = new Input();
        output = new Output();
    }

    public void start() {
        int buyPrice = input.requestLottoBuyAmount();
        int lottoBuyAmount = buyPrice / LottoConstant.LOTTO_PRICE.getConstant();

        makeLotto(lottoBuyAmount);
        output.printLotteryNumber(lottos);

        prizeNum = input.requestLottoPrizeNums();
        bonusNum = input.requestBonusNums(prizeNum);

        lottoSameSize = calculator.getWinningLottoSameSize(lottos, prizeNum, bonusNum);
        output.printLottoProfit(lottoSameSize);

        double earningsRate = calculator.getEarningsRate(buyPrice);
        output.printEarningRate(earningsRate);
    }

    public void makeLotto(int lottoBuyAmount) {
        for(int i=0;i<lottoBuyAmount;i++) {
            List<Integer> nums = numberGenerator.getLotteryRandomNumber();
            lottos.add(new Lotto(nums));
        }
    }
}
