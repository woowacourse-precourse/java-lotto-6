package lotto.controller;

import static lotto.util.Constants.*;

import java.util.List;
import java.util.ArrayList;

import lotto.model.EarningResult;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	private InputView inputView;
	private OutputView outputView;

	public LottoController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void start() {
		int budget = inputView.getBudget();
		UserLotto userLotto = new UserLotto(budget);
		userLotto.purchaseLotto();
		outputView.printUserLotto(userLotto);
		List<Integer> winningNums = inputView.getWinningNums();
		WinningLotto winningLotto = new WinningLotto(winningNums);
		int bonusNum = inputView.getBonusNum(winningNums);
		winningLotto.setBonusNumber(bonusNum);
		EarningResult result = new EarningResult(budget);
		openResult(userLotto, winningLotto, result);
		result.calculateEarningRate();
		outputView.printEarningResult(result);
	}
	public void openResult(UserLotto userLotto, WinningLotto winningLotto, EarningResult result){
		List<Integer> winningNumber = winningLotto.getNumbers();
		for (int i = 0; i < userLotto.getLottoList().size(); i++) {
			List<Lotto> lotto = userLotto.getLottoList();
			List<Integer> lottoNumbers = lotto.get(i).getNumbers();
			int hitNumber = 0;
			boolean hitBonus = lottoNumbers.contains(winningLotto.getBonusNumber());
			for (int j = 0; j < lottoNumbers.size(); j++) {
				if (winningNumber.contains(lottoNumbers.get(j))){
					hitNumber++;
				}
			}
			if (hitNumber == HIT_THREE){
				result.addHitThree();
			}
			if (hitNumber == HIT_FOUR){
				result.addHitFour();
			}
			if (hitNumber == HIT_FOUR && hitBonus){
				result.addHitFiveWithBonus();
			}
			if (hitNumber == HIT_FIVE){
				result.addHitFive();
			}
			if (hitNumber == HIT_SIX){
				result.addHitSix();
			}
		}
	}
}
