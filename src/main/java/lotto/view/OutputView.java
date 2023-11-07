package lotto.view;

import lotto.model.Lotto;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printException(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    public void printLottoTicket(List<Lotto> lottoTicket) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoTicket.size()));
        for (Lotto lotto : lottoTicket) {
            System.out.println(printLottoDetail(lotto));
        }
    }

    private String printLottoDetail(Lotto lotto) {
        String lottoDetail = "[";
        lottoDetail += String.join(", ", lotto.getLottoNumbers().stream()
                .map(lottoNumber -> Integer.toString(lottoNumber.getNumber()))
                .toList());
        lottoDetail += "]";
        return lottoDetail;
    }

    public void printWinningStatus(Map<Rank, Integer> winningStatus) {
        System.out.println("당첨 통계" + System.lineSeparator() + "---");
        for (Rank rank : Rank.getShownRank()) {
            System.out.println(String.format(rank.getMessage(), winningStatus.get(rank)));
        }
    }
}
