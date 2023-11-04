package lotto.view;

import static lotto.constants.MessageConstants.ARE; //입니다.
import static lotto.constants.MessageConstants.BUY_A_FEW;
import static lotto.constants.MessageConstants.COINCIDE3; // 3개일치
import static lotto.constants.MessageConstants.COINCIDE4;
import static lotto.constants.MessageConstants.COINCIDE5;
import static lotto.constants.MessageConstants.COINCIDE5_NOT_BONUS; //5개 일치, 보너스x
import static lotto.constants.MessageConstants.COINCIDE6;
import static lotto.constants.MessageConstants.DOTTED_LINE; //---  
import static lotto.constants.MessageConstants.NUMBER; //개
import static lotto.constants.MessageConstants.TOTAL_RATE_OF_RETURN; //총 수익률
import static lotto.constants.MessageConstants.WINNING_STATISTICS; //당첨 통계

import java.util.List;

import lotto.domain.Automatic;

public class OutputView {

	public static void buyLotto(int lottoCount) {

		System.out.println(lottoCount + BUY_A_FEW);
		List<List<Integer>> lottoIssuance = Automatic.issuance(lottoCount);
		for (List<Integer> lottoNumber : lottoIssuance) {
			System.out.println(lottoNumber);
		}

	}

	public static void totalRateOfReturn() {
		System.out.println(WINNING_STATISTICS);
		System.out.println(DOTTED_LINE);
		System.out.println(COINCIDE3 + "1" + NUMBER);
		System.out.println(COINCIDE4 + "0 " + NUMBER);
		System.out.println(COINCIDE5 + "0" + NUMBER);
		System.out.println(COINCIDE5_NOT_BONUS + "0" + NUMBER);
		System.out.println(COINCIDE6 + "0" + NUMBER);
		System.out.println(TOTAL_RATE_OF_RETURN + "62.5%" + ARE);

	}
}
