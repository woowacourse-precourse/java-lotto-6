package lotto.dto;

import java.util.List;
import lotto.domain.Winning;

public class WinningDto {
	Winning winning;
	
	public WinningDto(List<Integer> winning) {
		this.winning = new Winning(winning);
	}
	
	public void setBonus(int n) {
		winning.setBonus(n);
	}
	
	public List<Integer> getCheckLotto() {
		return winning.checkLotto();
	}
}