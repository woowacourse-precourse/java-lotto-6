package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Ranking {

	public static List<Rank> correct(List<Integer> winningNumbers, int bonusNumber, List<List<Integer>> lottoTickets) {

		List<Integer> matchNumber = numberMatch(winningNumbers, lottoTickets);
		return determineRanks(matchNumber, bonusNumber, lottoTickets, winningNumbers);

	}

	private static List<Rank> determineRanks(List<Integer> matchNumbers, int bonusNumber,
			List<List<Integer>> lottoTickets, List<Integer> winningNumber) {
		List<Rank> lottoRank = new ArrayList<>();
		for (int i = 0; i < matchNumbers.size(); i++) {
			if (matchNumbers.get(i) == 6) {
				lottoRank.add(Rank.RANK_1);
			}
			if (matchNumbers.get(i) == 5) {
				if (lottoTickets.get(i).contains(bonusNumber)) {
					matchNumbers.set(i, matchNumbers.get(i) + 1);
					lottoRank.add(Rank.RANK_2);
				}
			}
			if (matchNumbers.get(i) == 5) {
				lottoRank.add(Rank.RANK_3);
			}
			if (matchNumbers.get(i) == 0 || matchNumbers.get(i) == 1 || matchNumbers.get(i) == 2) {
				lottoRank.add(Rank.NO_RANK);
			}
			if (matchNumbers.get(i) == 3) {
				lottoRank.add(Rank.RANK_5);
			}
			if (matchNumbers.get(i) == 4) {
				lottoRank.add(Rank.RANK_4);
			}
		}
		return lottoRank;
	}

	private static List<Integer> numberMatch(List<Integer> winningNumbers, List<List<Integer>> lottoTickets) {
		List<Integer> matchNumbers = new ArrayList<>();
		for (List<Integer> lottoTicket : lottoTickets) {
			int cnt = 0;
			for (int number : lottoTicket) {
				if (winningNumbers.contains(number)) {
					cnt++;
				}

			}
			matchNumbers.add(cnt);
		}
		return matchNumbers;
	}

}
