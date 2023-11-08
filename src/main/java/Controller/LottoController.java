package Controller;

import java.util.ArrayList;
import java.util.List;

import LottoNumber.LottoInput;
import LottoNumber.LottoWinningNumbersInput;
import Ranking.RankPrize;
import lotto.Lotto;
import lotto.PrintLottoNumber;
import lottoBuy.LottoPurchase;

public class LottoController {
	private LottoPurchase purchase;
	private LottoInput input;
	private int number;
	private List<Lotto> lotto;
	private List<Integer> lottonumber;
	private PrintLottoNumber printnumber;
	private LottoWinningNumbersInput winning;
	private RankPrize rank;

	public LottoController() {
		purchase = new LottoPurchase();
		lottoCount();
		printnumber = new PrintLottoNumber(number);

	}

	public void lottoCount() {
		purchase.numberaCount();
		number = purchase.getNumber();
		purchase.printButLotto();
	}

	public List<Integer> randomLottoNumbers() {
		lottonumber = input.setRandomNumber();
		return lottonumber;
	}

	public void start() {
		lotto = printnumber.makeLottoList();
	}

	public void printBuyResult() {
		purchase.printButLotto();
	}

	public void rankCreation() {
		List<Integer> winningNumbers = winning.inputLottoWinningNumbers();
		int bonusnumber = winning.bonusNumber();

		rank = new RankPrize(winningNumbers, lotto, bonusnumber);

		rank.LotteryCale();
		rank.TotalProfitCal(purchase);
		System.out.println();
		rank.winningStatisticsOp();

	}

	public void run() {
		start();
		System.out.println();
		rankCreation();

	}

}
