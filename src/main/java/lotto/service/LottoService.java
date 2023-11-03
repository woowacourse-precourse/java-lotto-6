package lotto.service;

import java.util.List;

import lotto.calculator.LottoCalculator;
import lotto.domain.AnswerLotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.generator.LottosGenerator;

public class LottoService {

	private static final LottosGenerator GENERATOR = new LottosGenerator();
	private static final LottoCalculator calculator = new LottoCalculator();
	private static final String DELIMITER = System.lineSeparator();

	public Lottos createLottos() {
		return new Lottos(GENERATOR.generate());
	}

	public void setMoney(Money money) {
		GENERATOR.setMoney(money);
	}

	public AnswerLotto createAnswerLotto(List<Integer> numbers, int bonusNumber) {
		return new AnswerLotto(numbers, bonusNumber);
	}

	
}
