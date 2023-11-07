package lotto.model;

import lotto.model.Lotto;

public class WinningLotto { // 당첨 번호 + 보너스 넘버
	
	private final Lotto winningNumber;
	private final int bonusNumber;
	
	public WinningLotto(Lotto winningNumber, int bonusNumber) { 
		this.winningNumber = winningNumber;
		this.bonusNumber = bonusNumber;
	}
	
	public Rating matchLotto(Lotto lotto) { //당첨 매치
		int matchCount = lotto.match(winningNumber);
		boolean isContainBonus = lotto.containNumber(bonusNumber);
		
		return Rating.rating(matchCount, isContainBonus);
	}
}
