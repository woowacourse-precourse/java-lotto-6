package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Lottos {

	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public String getFormattedLottoNumbers() {
		StringJoiner lottoNumbersJoiner = new StringJoiner(System.lineSeparator());

		for (Lotto lotto : lottos) {
			lottoNumbersJoiner.add(lotto.printNumbers());
		}

		return lottoNumbersJoiner.toString();
	}

	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}

	public int getSize() {
		return lottos.size();
	}
}