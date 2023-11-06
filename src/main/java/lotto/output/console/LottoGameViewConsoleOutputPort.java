package lotto.output.console;

import lotto.common.LottoException;
import lotto.domain.LottoGrade;
import lotto.domain.LottoTicket;
import lotto.output.LottoGameViewOutputPort;

import java.util.List;
import java.util.Map;

public class LottoGameViewConsoleOutputPort implements LottoGameViewOutputPort {
    @Override
    public void printExceptionMessage(LottoException e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    @Override
    public void printGeneratedLottoList(LottoTicket lottoTicket) {
        for (List<Integer> lottoNumber : lottoTicket.getLottoNumbers()) {
            System.out.println(lottoNumber);
        }
    }

    @Override
    public void printLottoResult(Map<LottoGrade, Integer> lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<LottoGrade> lottoGrades = List.of(
                LottoGrade.FIFTH,
                LottoGrade.FOURTH,
                LottoGrade.THIRD,
                LottoGrade.SECOND,
                LottoGrade.FIRST
        );

        for (LottoGrade lottoGrade : lottoGrades) {
            System.out.println(makeLottoGradeLabel(lottoGrade, lottoStatistics));
        }
    }

    private String makeLottoGradeLabel(LottoGrade lottoGrade, Map<LottoGrade, Integer> lottoStatistics) {
        int count = lottoStatistics.getOrDefault(lottoGrade, 0);
        return lottoGrade.getMatchLabel() + " - " + count + "개";
    }

    @Override
    public void printLottoProfitRate(String lottoProfit) {
        System.out.println("총 수익률은 " + lottoProfit + "%입니다.");
    }
}
