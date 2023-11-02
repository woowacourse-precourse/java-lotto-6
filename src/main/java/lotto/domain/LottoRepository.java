package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class LottoRepository {

	private static final String DELIMITER = System.lineSeparator();

	private static List<Lotto> lottoRepository = new ArrayList<>();

	private LottoRepository() {
		throw new AssertionError();
	}

	public static List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottoRepository);
	}

	public static String printLottoNumbers() {
		StringJoiner strJoiner = new StringJoiner(DELIMITER);

		for (Lotto lotto : lottoRepository) {
			strJoiner.add(lotto.printNumbers());
		}

		return strJoiner.toString();
	}

	public static void addLotto(Lotto lotto) {
		lottoRepository.add(lotto);
	}

	public static void addAllLotto(List<Lotto> lottos) {
		lottos.forEach(LottoRepository::addLotto);
	}

	public static void deleteAll() {
		lottoRepository.clear();
	}
}
