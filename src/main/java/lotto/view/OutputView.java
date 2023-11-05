package lotto.view;

import static lotto.constants.MessageConstants.ARE;
import static lotto.constants.MessageConstants.BUY_A_FEW;
import static lotto.constants.MessageConstants.COINCIDE3;
import static lotto.constants.MessageConstants.COINCIDE4;
import static lotto.constants.MessageConstants.COINCIDE5;
import static lotto.constants.MessageConstants.COINCIDE5_NOT_BONUS;
import static lotto.constants.MessageConstants.COINCIDE6;
import static lotto.constants.MessageConstants.DOTTED_LINE;
import static lotto.constants.MessageConstants.NUMBER;
import static lotto.constants.MessageConstants.TOTAL_RATE_OF_RETURN;
import static lotto.constants.MessageConstants.WINNING_STATISTICS;

import java.util.Collections;
import java.util.List;

import lotto.domain.Automatic;
import lotto.domain.Rank;

public class OutputView {

	public static List<List<Integer>> buyLotto(int lottoCount) {

		System.out.println(lottoCount + BUY_A_FEW);
		List<List<Integer>> lottoIssuance = Automatic.issuance(lottoCount);
		for (List<Integer> lottoNumber : lottoIssuance) {
			Collections.sort(lottoNumber);
			System.out.println(lottoNumber);
		}
		System.out.println();
		return lottoIssuance;
	}

	public static void totalRateOfReturn(List<Rank> lottoRanks, double profit) {
		System.out.println(WINNING_STATISTICS);
		System.out.println(DOTTED_LINE);
		System.out.println(COINCIDE3 + Collections.frequency(lottoRanks, Rank.RANK_5) + NUMBER);
		System.out.println(COINCIDE4 + Collections.frequency(lottoRanks, Rank.RANK_4) + NUMBER);
		System.out.println(COINCIDE5 + Collections.frequency(lottoRanks, Rank.RANK_3) + NUMBER);
		System.out.println(COINCIDE5_NOT_BONUS + Collections.frequency(lottoRanks, Rank.RANK_2) + NUMBER);
		System.out.println(COINCIDE6 + Collections.frequency(lottoRanks, Rank.RANK_1) + NUMBER);
		System.out.println(TOTAL_RATE_OF_RETURN + profit + "%" + ARE);

	}

}
