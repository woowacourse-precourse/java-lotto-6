package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.win.Rank;

public class LottoView {

    public void printLotto(List<Lotto> lottoTickets) {
        int amount = lottoTickets.size();
        String printMessage = String.format("%d개를 구매했습니다.", amount);
        System.out.println(printMessage);

        lottoTickets.stream()
                .map(Lotto::toString)
                .forEach(System.out::println);
    }

    public void printResult(Map<Rank, Integer> checkResult, double rateOfReturn) {
        printLottoResult(checkResult);
        System.out.println(printRate(rateOfReturn));
    }

    private void printLottoResult(Map<Rank, Integer> checkResult) {
        checkResult.forEach((winResult, integer) -> {
            StringBuilder builder = new StringBuilder();
            builder.append(winResult.matchedCount).append("개 일치 ");
            if (winResult.equals(Rank.SECOND)) {
                builder.deleteCharAt(builder.length()-1);
                builder.append(", 보너스 볼 일치 ");
            }
            String reward = String.format("%,d원", winResult.reward);
            builder.append("(").append(reward).append(")");
            builder.append(" - ").append(integer).append("개");
            System.out.println(builder.toString());
        });
    }
    public String printRate(double rate){
        return String.format("총 수익률은 %,.1f%%입니다.",rate);
    }
}
