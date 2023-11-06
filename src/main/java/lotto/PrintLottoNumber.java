package lotto;

import java.util.ArrayList;
import java.util.List;

import LottoRandom.LottoInput;
import lottoBuy.LottoPurchase;

public class PrintLottoNumber {
	
	private LottoPurchase purchase;
	private LottoInput input;
	private int number;
	private List<Lotto> lottolist;
	private List<Integer> lotto;
	
	
	// 로또 번호 출력 해야함
	
	public PrintLottoNumber(int number) {
		this.number = number;
	}
	

	
	
	public List<Lotto>  makeLottoList() {
		lottolist = new ArrayList<>();
		
		for(int i = 0; i < number; i++) {
			lottolist.add(makeLotto());
		}
		
		return lottolist;
	}
	
	public Lotto makeLotto() {
		input = new LottoInput();
		lotto = new ArrayList<>();
		
		lotto = input.setRandomNumber();
		System.out.println(lotto);
		
		return new Lotto(lotto);
		
		
	}
	
}
