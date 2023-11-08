package lotto.dto.response;

import java.util.List;

public class WinningResult {

	private List<Integer> result;

	private Double rateReturn;

	public WinningResult(List<Integer> result, Double rateReturn) {
		this.result = result;
		this.rateReturn = rateReturn;
	}

	public List<Integer> getResult() {
		return result;
	}

	public Double getRateReturn() {
		return rateReturn;
	}
}
