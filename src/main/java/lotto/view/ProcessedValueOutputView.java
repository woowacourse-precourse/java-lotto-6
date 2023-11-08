package lotto.view;

import static lotto.model.constant.IntegerSymbolicConstantEnum.END_OF_WINNING_CASE_COUNT;
import static lotto.model.constant.IntegerSymbolicConstantEnum.INDEX_PIVOT_STEP;
import static lotto.model.constant.IntegerSymbolicConstantEnum.START_OF_COUNT;
import static lotto.model.constant.StringSymbolicConstantEnum.CHANGE_LINE;
import static lotto.model.constant.StringSymbolicConstantEnum.END_STRING_FOR_PURCHASE_AMOUNT;
import static lotto.model.constant.StringSymbolicConstantEnum.TITLE_OF_LOTTO_WINNING_STATUS;

import java.util.List;
import lotto.model.constant.LottoWinningCase;
import lotto.model.lotto.LottoTicket;
import lotto.model.lotto.LottoWinningStatus;

public class ProcessedValueOutputView {
	public void printLottoPurchaseMoney(Integer lottoPurchaseMoney) {
		System.out.println(lottoPurchaseMoney + CHANGE_LINE.getValue());
	}
	public void printCreatedLottoTicketList(List<LottoTicket> lottoTicketList, Integer lottoTicketPurchaseAmount) {
		System.out.println(lottoTicketPurchaseAmount + END_STRING_FOR_PURCHASE_AMOUNT.getValue());
		for (LottoTicket lottoTicket : lottoTicketList){
			System.out.println(lottoTicket.getTicketNumbers());
		}
		System.out.print(CHANGE_LINE.getValue());
	}


	public void printLottoWinningStatus(LottoWinningStatus lottoWinningStatus) {
		System.out.print(CHANGE_LINE.getValue());
		System.out.println(TITLE_OF_LOTTO_WINNING_STATUS.getValue());
		List<Integer> lottoWinningCaseCountList = lottoWinningStatus.getLottoWinningCaseCountList();
		LottoWinningCase[] lottoWinningCaselist = LottoWinningCase.values();
		int startIndexPoint = START_OF_COUNT.getValue() + INDEX_PIVOT_STEP.getValue();
		Integer endIndexPoint = END_OF_WINNING_CASE_COUNT.getValue();
		for (int index = startIndexPoint; index < endIndexPoint; index++){
			System.out.print(lottoWinningCaselist[index].getDescribingString());
			System.out.println(lottoWinningCaseCountList.get(index) + "개");
		}
		System.out.println("총 수익률은 " + lottoWinningStatus.getLottoWinningProfit() + "%입니다.");
	}
}
