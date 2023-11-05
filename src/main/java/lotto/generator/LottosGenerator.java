package lotto.generator;

import java.util.List;
import java.util.stream.Stream;

import lotto.domain.Lotto;
import lotto.domain.Money;

public final class LottosGenerator implements Generator<List<Lotto>> {

	private static final LottoNumberGenerator LOTTO_NUMBER_GENERATOR = new LottoNumberGenerator();

	private Money money;

	@Override
	public List<Lotto> generate(){
		return Stream.generate(LOTTO_NUMBER_GENERATOR::generate).limit(money.getBuyedCount())
						.map(this::toLotto)
						.toList();
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	private Lotto toLotto(List<Integer> numbers) {
		return new Lotto(numbers);
	}
}
