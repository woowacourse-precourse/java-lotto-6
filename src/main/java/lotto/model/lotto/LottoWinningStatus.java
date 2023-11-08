package lotto.model.lotto;

import java.util.List;

public class LottoWinningStatus {
	private List<Integer> lottoWinningCaseCountList;
	private Double lottoWinningProfit;
	public List<Integer> getLottoWinningCaseCountList() {
		return lottoWinningCaseCountList;
	}
	public void setLottoWinningCaseCountList(List<Integer> winningCaseCountList) {
		this.lottoWinningCaseCountList = winningCaseCountList;
	}
	public Double getLottoWinningProfit() {
		return lottoWinningProfit;
	}

	public void setLottoWinningProfit(Double lottoWinningProfit) {
		this.lottoWinningProfit = lottoWinningProfit;
	}
}
