package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Lottos {

	private static final String DELIMITER = System.lineSeparator();

	private List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public String printLottoNumbers() {
		StringJoiner strJoiner = new StringJoiner(DELIMITER);

		for (Lotto lotto : lottos) {
			strJoiner.add(lotto.printNumbers());
		}

		return strJoiner.toString();
	}

	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}
}
