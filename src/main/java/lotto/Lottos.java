package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.ui.Output;
import lotto.ui.SystemMessage;

public class Lottos {

	private final List<Lotto> lottos;

	public static Lottos of(List<Lotto> lottos) {
		return new Lottos(lottos);
	}

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public void print() {
		Output.output(() -> SystemMessage.buyLottoCount(lottos.size()));
		for (Lotto lotto : lottos) {
			lotto.printNumbers();
		}
	}

	public LottoResults matchLotto(Lotto answerLotto, Integer bonusNumber) {
		return LottoResults.of(
				lottos
						.stream()
						.map(lotto -> lotto.match(answerLotto, bonusNumber))
						.collect(Collectors.toList()));
	}
}
