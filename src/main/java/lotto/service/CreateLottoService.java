package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import lotto.domain.AnswerLotto;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.generator.LottoNumberGenerator;

public class CreateLottoService {
	
	private static final String DELIMITER = ",";
	
	private static final LottoNumberGenerator GENERATOR = new LottoNumberGenerator();
	
	public List<Lotto> generateLottos(Money money){
		int buyedCount = money.getBuyedCount();
		
		return Stream.generate(() -> generateLotto())
						.limit(buyedCount)
						.toList();
	}

	private Lotto generateLotto() {
		return new Lotto(GENERATOR.generate());
	}

	public AnswerLotto createAnswerLotto(String inputValue, int bonusNumber) {
		String[] separatedNumbers = inputValue.split(DELIMITER);
		List<Integer> numbers = convertStringArrToCollection(separatedNumbers);

		return new AnswerLotto(numbers, bonusNumber);
	}

	private List<Integer> convertStringArrToCollection(String[] separatedNumbers) {
		return Arrays.stream(separatedNumbers).map(Integer::new)
						.toList();
	}

}
