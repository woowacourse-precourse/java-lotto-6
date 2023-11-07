package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class OutputView {
    public static void requestMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printAmountLotto(int amount){
        System.out.printf("%d개를 구매했습니다.\n", amount);
    }

    public static void printLottoList(List<Lotto> lottoNumbersList){
        for(Lotto lottoNumbers : lottoNumbersList) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public static void requestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printWinningResult(LottoResult lottoResult){
        System.out.println("당청통계");
        System.out.print("---");
//        TODO.당첨 결과 출력
        Rank[] ranks = Rank.values();
        for (int i = ranks.length - 1; i >= 0; i--) {
            Rank rank = ranks[i];
            int count = lottoResult.getResult().get(rank);
            int winningMoney = rank.getWinningMoney();
            String messageFormat = rank.getMessageFormat();
            System.out.printf(messageFormat, rank.getCountOfMatch(), winningMoney, count);
            System.out.println();
        }
    }
}
