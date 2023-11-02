package lotto.service;

import lotto.domain.Lotto;
import lotto.generator.LottoNumberGenerator;

public class CreateLottoService {
	
	private static final LottoNumberGenerator GENERATOR = new LottoNumberGenerator();
		
	private Lotto generateLotto() {
		return new Lotto(GENERATOR.generate());
	}
}
