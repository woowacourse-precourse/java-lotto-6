package lotto.service;

import java.util.List;
import java.util.stream.Stream;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.generator.LottoNumberGenerator;

public class CreateLottoService {
	
	private static final LottoNumberGenerator GENERATOR = new LottoNumberGenerator();
	
	public List<Lotto> generateLottos(Money money){
		int tryCount = money.getTryCount();
		
		return Stream.generate(() -> generateLotto())
						.limit(tryCount)
						.toList();
	}
		
	private Lotto generateLotto() {
		return new Lotto(GENERATOR.generate());
	}
}
