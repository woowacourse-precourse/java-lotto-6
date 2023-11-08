package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.service.GeneratingLottoNumberService;

public class User {
	private int buyingLottoPrice;
	private int winningLottoPrice;
	private List<UserLottos> lottos;
	
	public User(int buyingLottoPrice) {
		this.buyingLottoPrice = buyingLottoPrice;
		this.winningLottoPrice=0;
		lottos = new ArrayList<>();
	}
	public List<UserLottos> getLottos(){
		return lottos;
	}
	public int getBuyingLottosPrice() {
		return buyingLottoPrice;
	}

}
