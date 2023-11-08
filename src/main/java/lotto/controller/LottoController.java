package lotto.controller;

import lotto.constants.LottoConstant;
import lotto.model.Lotto;
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
    Input input;
    Output output;

    public LottoController() {
        lottos = new ArrayList<>();
        prizeNum = new ArrayList<>();
        lottoSameSize = new int [LottoConstant.LOTTO_SIZE.getConstant() + 2];
        numberGenerator = new NumberGenerator();
        input = new Input();
        output = new Output();
    }

    public void start() {
        int lottoBuyAmount = input.requestLottoBuyAmount();

        makeLotto(lottoBuyAmount);

        output.printLotteryNumber(lottos);

        prizeNum = input.requestLottoPrizeNums();
        bonusNum = input.requestBonusNums(prizeNum);

        checkWinningLotto();
        output.printLottoProfit(lottoSameSize);
    }

    public void makeLotto(int lottoBuyAmount) {
        for(int i=0;i<lottoBuyAmount;i++) {
            List<Integer> nums = numberGenerator.getLotteryRandomNumber();
            lottos.add(new Lotto(nums));
        }
    }

    public void checkWinningLotto() {
        for(Lotto lotto : lottos) {
            int index = lotto.getComparePrizeNumSameSize(prizeNum, bonusNum);
            lottoSameSize[index]++;
        }
    }
}
