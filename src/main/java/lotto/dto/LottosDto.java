package lotto.dto;

import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.Lotto;

public class LottosDto {
	Lottos lottos;
	
	public LottosDto(int n) {
		lottos = new Lottos(n);
	}
	
	public List<Lotto> getLottos() {
		return lottos.getLottos();
	}
}