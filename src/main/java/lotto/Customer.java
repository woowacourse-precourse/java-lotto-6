package lotto;

import java.util.List;

public class Customer {
	int price;
	List<Lotto> lottoList;

	Customer(int price, List<Lotto> lottoList) {

	}

	List<Lotto> getLottoList() {
		return lottoList;
	}

	int getPrice() {
		return price;
	}
}
