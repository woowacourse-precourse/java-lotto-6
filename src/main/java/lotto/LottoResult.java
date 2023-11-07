package lotto;

import java.util.List;
import java.util.ArrayList;
public class LottoResult {
	private static final int WIN_SECOND_PRIZE = 7;
	private static final int LOTTO_LENGTH = 6;
	private final LottoShop lottoShop;
	private List<Integer> lottoResult;

	public LottoResult(LottoShop lottoShop) {
		this.lottoShop = lottoShop;
	}

	public void getResult() {
		ArrayList<Lotto> lottos = lottoShop.getLottos();
		for(Lotto lotto : lottos) {
			this.lottoResult.add(verifyLotto(lotto.getNumbers()));
		}
	}

	private int verifyLotto(List<Integer> lotto){
		List<Integer> winningNumbers = lottoShop.getWinningNumbers();
		int bonusNumber = lottoShop.getBonusNumber();
		int numberOfHits = 0;
		for (int number: lotto) {
			if(winningNumbers.contains(number)){
				numberOfHits++;
			}
		}
		if(numberOfHits == LOTTO_LENGTH - 1) {
			if(lotto.contains(bonusNumber)) {
				return WIN_SECOND_PRIZE;
			}
		}
		return numberOfHits;
	}



}
