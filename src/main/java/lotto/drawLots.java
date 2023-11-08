package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class drawLots {

	public enum Matches {
		matchThree(3, "3개 일치 (5,000원) - "),
		matchFour(4, "4개 일치 (50,000원) - "),
		matchFive(5, "5개 일치 (1,500,000원) - "),
		matchFiveAndBonus(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
		matchSix(6, "6개 일치 (2,000,000,000원) - ");

		private final int matchedNumbers;
		private final String matchResult;

		Matches(int matchedNumbers, String matchResult) {
			this.matchedNumbers = matchedNumbers;
			this.matchResult = matchResult;
		}
	}




	public static int[] generateMatchResultList(List<List<Integer>> userLottoTickets, List<Integer> convertedUserWinningNumber, int convertedUserBonusNumber) {
		int[] countTicketList = {0, 0, 0, 0, 0};

		for (List<Integer> userLottoTicket : userLottoTickets) {
			int countTicket = 0;

			for (int WinningNumber : convertedUserWinningNumber) {
				if (userLottoTicket.contains(WinningNumber)) {
					countTicket += 1;
				}
			}
			if (countTicket == 3) {
				countTicketList[0] += 1;
			} else if (countTicket == 4) {
				countTicketList[1] += 1;
			} else if (countTicket == 5) {
				if (userLottoTicket.contains(convertedUserBonusNumber)) {
					countTicketList[3] += 1;
				} else {
					countTicketList[2] += 1;
				}
			} else if (countTicket == 6) {
				countTicketList[4] += 1;
			}

		}

		System.out.println(Arrays.toString(countTicketList));

		List<String> resultDrawLotsList = new ArrayList<>();

		int idx = 0;
		for (Matches match : Matches.values()){
			String getTicket = Integer.toString(countTicketList[idx]);
			String resultDrawLots = match.matchResult + getTicket + "개";
			resultDrawLotsList.add(resultDrawLots);
			idx++;
		}

		System.out.println("당첨 통계");
		System.out.println("---");
		for (String resultDrawLot : resultDrawLotsList){
			System.out.println(resultDrawLot);
		}

		return countTicketList;
	}
}