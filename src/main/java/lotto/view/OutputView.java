package lotto.view;

import static lotto.constant.LottoConstant.*;
import static lotto.view.constant.OutputConstant.*;

import java.util.List;

import lotto.constant.Grade;
import lotto.domain.Lotto;

public class OutputView {
	public void printLottos(List<Lotto> lottos) {
		StringBuilder sb = new StringBuilder();
		for (Lotto lotto : lottos) {
			sb.append(lotto).append("\n");
		}
		System.out.println(sb);
	}

	public void printResult(int[] rankCounts) {
		StringBuilder sb = new StringBuilder();
		sb.append(WINNING_RESULT.getValue()).append("\n");
		for (int rank = MAX_RANK.getValue(); rank >= MIN_RANK.getValue(); rank--) {
			Grade grade = Grade.getGradeByRank(rank);
			sb.append(grade.getMatchCount()).append("개 일치 (")
				.append(grade.getPrize()).append("원) - ")
				.append(rankCounts[rank]).append("개").append("\n");
		}
		System.out.print(sb);
	}

	public void printStatistics(String profitRate) {
		System.out.println("총 수익률은 " + profitRate + "%입니다.");
	}
}
