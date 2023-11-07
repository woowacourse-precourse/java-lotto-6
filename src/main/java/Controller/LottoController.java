package Controller;

import java.util.ArrayList;
import java.util.List;

import LottoNumber.LottoInput;
import LottoNumber.LottoWinningNumbersInput;
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



	public void run() {
		start();
		System.out.println();
		winning.inputLottoWinningNumbers();
		winning.bonusNumber();
		
		

	}

}
