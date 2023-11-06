package lotto.view;

import lotto.model.domain.Lotto;
import lotto.model.domain.Lottos;
import lotto.model.domain.Rank;
import lotto.model.domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {

    public static void printStartMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseMesssage(int purchaseCount) {
        System.out.println(" ");
        System.out.println(purchaseCount+"개를 구매했습니다.");
    }

    public void printPurchasedLottoList(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            List<Integer> oneLotto = lotto.getLotto();
            printPurchasedOneLotto(oneLotto);
        }
    }

    public void printPurchasedOneLotto(List<Integer> oneLotto) {
        StringBuilder lottoStringBuilder = new StringBuilder();
        ArrayList<Integer> oneLottoArrayList = lottoNumToArraryList(oneLotto);
        lottoStringBuilder.append("[");
        for (int lottoNum : oneLottoArrayList) {
            lottoStringBuilder.append(lottoNum);
            if(oneLottoArrayList.get(5)!=lottoNum){
                lottoStringBuilder.append(", ");
            }
        }
        lottoStringBuilder.append("]");
        System.out.println(lottoStringBuilder);
    }

    public ArrayList<Integer> lottoNumToArraryList(List<Integer> oneLotto) {
        ArrayList<Integer> oneLottoArrayList = new ArrayList<>();
        oneLottoArrayList.addAll(oneLotto);
        Collections.sort(oneLottoArrayList);
        return oneLottoArrayList;
    }

    public static void printInputWinnerNumMessage() {
        System.out.println(" ");
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonusNumMessasge() {
        System.out.println(" ");
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printResult(User user) {
        System.out.println(" ");
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 3; i < 8; i++) {
            if(i==6) {
                printBonusResult(i, user);
                continue;
            }
            if(i == 7){
                printAllCorrectResult(user);
                break;
            }
            Rank rank = Rank.lottoRank(i);
            String prizeForPrint = rank.getPrizeForPrint();
            int eachRankCount = user.getLottoRanks()[i];

            System.out.println(i+"개 일치 ("+prizeForPrint+"원) - "+eachRankCount+"개");
        }
    }

    public void printAllCorrectResult(User user) {
        int eachRankCount = user.getLottoRanks()[7];
        Rank rank = Rank.lottoRank(6);
        String prizeForPrint = rank.getPrizeForPrint();
        System.out.println("6개 일치 ("+prizeForPrint+"원) - "+eachRankCount+"개");
    }

    public void printBonusResult(int i, User user) {
        Rank rank = Rank.lottoRank(10);
        String prizeForPrint = rank.getPrizeForPrint();
        int eachRankCount = user.getLottoRanks()[i];
        System.out.println("5개 일치, 보너스 볼 일치 ("+prizeForPrint+"원) - "+eachRankCount+"개");
    }

    public void printProfitRate(User user, float profitRate) {
        System.out.println("총 수익률은 "+profitRate+"%입니다.");
    }
}
