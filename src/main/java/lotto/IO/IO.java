package lotto.IO;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoFactory.LottoChecker;
import lotto.LottoFactory.LottoRank;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class IO {

    public static String InputCash(){
        System.out.println("구입금액을 입력해주세요");
        return Console.readLine();
    }

    public static void PrintCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }

    public static String InputWinningLotto(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String InputBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void printRanking(LottoRank[] ranks) {
        Arrays.sort(ranks, Comparator.comparingLong(LottoRank::getPrizeMoney));
        NumberFormat formatter = NumberFormat.getInstance();

        for (LottoRank rank : ranks) {
            String bonusBall = getBonusBallText(rank);
            String prizeMoney = formatter.format(rank.getPrizeMoney());

            printRank(rank, bonusBall, prizeMoney);
        }
    }

    private static String getBonusBallText(LottoRank rank) {
        return Optional.of(rank)
                .filter(LottoRank::isBonusBallMatch)
                .map(r -> ", 보너스 볼 일치")
                .orElse("");
    }

    private static void printRank(LottoRank rank, String bonusBall, String prizeMoney) {
        Map<LottoRank, Integer> ranking = rank.getRanking();
        String rankDescription = rank.getMatchCount() + "개 일치" + bonusBall + " (" + prizeMoney + "원) - ";

        System.out.println(rankDescription + ranking.getOrDefault(rank, 0) + "개");
    }


    public static void printRate(double rate){
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    public static void PrintBuyLotto(LottoChecker lottoChecker){
        System.out.println(lottoChecker.toString());
    }


}

