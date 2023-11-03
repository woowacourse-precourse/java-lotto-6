package lotto.dto;

import java.util.List;
import lotto.domain.Winning;

public class WinningDto {
	Winning winning;
	
	public WinningDto(List<Integer> winning) {
		this.winning = new Winning(winning);
	}
}