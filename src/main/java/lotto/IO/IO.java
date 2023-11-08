package lotto.IO;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoFactory.LottoChecker;
import lotto.LottoFactory.LottoRank;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class IO { //여긴 무조건 정적호출로 해보자

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
        Arrays.sort(ranks, Comparator.comparingLong(LottoRank::getPrizeMoney));  // 당첨금액을 기준으로 오름차순 정렬
        NumberFormat formatter = NumberFormat.getInstance();
        for (LottoRank rank : ranks) {
            Map<LottoRank, Integer> ranking = rank.getRanking();
            String bonusBall = Optional.of(rank)
                    .filter(LottoRank::isBonusBallMatch)
                    .map(r -> ", 보너스 볼 일치")
                    .orElse("");
            String prizeMoney = formatter.format(rank.getPrizeMoney());
            String rankDescription = rank.getMatchCount() + "개 일치" + bonusBall + " (" + prizeMoney + "원) - ";
            System.out.println(rankDescription + ranking.getOrDefault(rank, 0) + "개");
        }
    }

    public static void PrintBuyLotto(LottoChecker lottoChecker){
        System.out.println(lottoChecker.toString());
    }


}

