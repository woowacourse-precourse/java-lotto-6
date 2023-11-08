package lotto.domain;

import java.util.List;

public class Customer {

	private final List<Lotto> lottos;

	public Customer(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}
