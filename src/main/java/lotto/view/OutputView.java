package lotto.view;

import lotto.Lotto;
import lotto.model.Result;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public void printLottoTickets(List<Lotto> lottoTickets) {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(lottoTickets.size()).append("개를 구매했습니다.").append("\n");
        for (Lotto lotto : lottoTickets) {
            sb.append(lotto.getLottoNumbersToPrint()).append("\n");
        }
        System.out.println(sb);
    }

    public void printResult(HashMap<Result, Integer> resultIntegerHashMap, double score) {

        System.out.println();
        System.out.printf("""
                        3개 일치 (5,000원) - %d개
                        4개 일치 (50,000원) - %d개
                        5개 일치 (1,500,000원) - %d개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                        6개 일치 (2,000,000,000원) - %d개
                        총 수익률은 %.1f%%입니다."""
                , resultIntegerHashMap.getOrDefault(Result.FIFTH, 0)
                , resultIntegerHashMap.getOrDefault(Result.FOURTH, 0)
                , resultIntegerHashMap.getOrDefault(Result.THIRD, 0)
                , resultIntegerHashMap.getOrDefault(Result.SECOND, 0)
                , resultIntegerHashMap.getOrDefault(Result.FIRST, 0)
                , score);

    }
}
