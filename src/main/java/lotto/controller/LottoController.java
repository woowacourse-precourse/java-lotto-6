package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.NumberGenerator;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoController {
    ArrayList<Lotto> lottos;
    NumberGenerator numberGenerator;
    Input input;
    Output output;

    public LottoController() {
        lottos = new ArrayList<>();
        numberGenerator = new NumberGenerator();
        input = new Input();
        output = new Output();
    }

    public void start() {
        int lottoBuyAmount = input.requestLottoBuyAmount();
        makeLotto(lottoBuyAmount);
        output.printLotteryNumber(lottos);
        List<Integer> lottoPrizeNums = input.requestLottoPrizeNums();
        input.requestBonusNums(lottoPrizeNums);
    }

    public void makeLotto(int lottoBuyAmount) {
        for(int i=0;i<lottoBuyAmount;i++) {
            List<Integer> nums = numberGenerator.getLotteryRandomNumber();
            lottos.add(new Lotto(nums));
        }
    }
}
