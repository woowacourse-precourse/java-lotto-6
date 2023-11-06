package lotto.dto.response;

import java.util.List;

public class WinningResult {

	private List<Integer> result;

	public WinningResult(List<Integer> result) {
		this.result = result;
	}

	public List<Integer> getResult() {
		return result;
	}
}
