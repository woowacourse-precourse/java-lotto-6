package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Lottos {

	private static final String NEW_LINE = System.lineSeparator();

	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public String getFormattedLottoNumbers() {
		StringJoiner lottoNumbersJoiner = new StringJoiner(NEW_LINE);

		for (Lotto lotto : lottos) {
			lottoNumbersJoiner.add(lotto.printNumbers());
		}

		return lottoNumbersJoiner.toString();
	}

	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}
	
	public int size() {
		return lottos.size();
	}
}
