package lotto.service;

import lotto.global.util.Constants;
import lotto.model.Lotto;
import lotto.repository.LottoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoService {
	private final LottoRepository lottoRepository;

	public LottoService(LottoRepository lottoRepository) {
		this.lottoRepository = lottoRepository;
	}

	public List<Lotto> getLottos() {
		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < Constants.LOTTO_COUNT.value; i++) {
			lottos.add(lottoRepository.createLotto());
		}

		return lottos;
	}

	public int getResult(Lotto lotto, List<Integer> numbers, int bonusNumber) {
		int result = lotto.getMatchResult(numbers);

		if (result == 5 && lotto.isBonusMatch(bonusNumber)) {
			return 7;
		}

		return result;
	}

	public double calculateReturnRate(Map<Integer, Integer> results, int price) {
		return (results.keySet()
					   .stream()
					   .mapToDouble(this::getMoney)
					   .sum() / price) * 100;
	}

	private int getMoney(int matchCount) {
		if (matchCount == 3) return 5000;
		if (matchCount == 4) return 50000;
		if (matchCount == 5) return 1500000;
		if (matchCount == 7) return 30000000;
		if (matchCount == 6) return 2000000000;
		return 0;
	}
}