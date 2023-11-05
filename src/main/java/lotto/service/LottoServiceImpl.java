package lotto.service;

import static java.util.Collections.nCopies;
import static lotto.constant.LottoConstant.MAX_SCORE;

import java.util.ArrayList;
import java.util.List;
import lotto.StringConverter;
import lotto.constant.PrizeConstant;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.MyLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoServiceImpl implements LottoService{
    private final static int INIT = 0;
    private final static int PERCENT = 10;

    @Override
    public int payMoney() {
        InputView inputView = new InputView();
        Cost cost = new Cost(inputView.inputBuyingCost());

        return cost.getQuantity();
    }
    @Override
    public List<List<Integer>> getMyLotto(int quantity) {
        List<List<Integer>> myLottoNumbers = new MyLotto(quantity).getMyLottoNumbers();

        OutputView outputView = new OutputView();
        outputView.printLotto(quantity, myLottoNumbers);

        return myLottoNumbers;
    }

    @Override
    public List<Integer> getResult(List<List<Integer>> myLottoNumbers, WinningLotto winningLotto) {
        List<Integer> statistics = new ArrayList<>(nCopies(MAX_SCORE.getValue() + 1, INIT));

        for (List<Integer> myLottoNumber : myLottoNumbers) {
            int score = winningLotto.getScore(myLottoNumber);
            statistics.set(score, statistics.get(score) + 1);
        }

        return statistics;
    }

    @Override
    public WinningLotto settingWinningLotto() {
        StringConverter stringConverter = new StringConverter();
        InputView inputView = new InputView();

        List<Integer> winningNumbers = stringConverter.convertToIntegerList(inputView.inputWinningNumbers());
        Lotto winningLottoNumbers = new Lotto(winningNumbers);
        int bonusNumber = inputView.inputBonusNumber();

        return new WinningLotto(winningLottoNumbers, bonusNumber);
    }

    @Override
    public float getProfitability(List<Integer> result, int quantity) {
        int totalReward = 0;
        for(int i = 0; i<result.size(); i++){
            int reward = PrizeConstant.getRewardByScore(i);
            int count = result.get(i);
            totalReward += reward * count;
        }

       return (float)totalReward/(quantity*PERCENT);
    }

}
