package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputService {
    static private final String requestMoney ="구입금액을 입력해 주세요.";
    static private final String requestWinningNums ="당첨 번호를 입력해 주세요.";
    static private final String requestBonusNum ="보너스 번호를 입력해 주세요.";
    private static final String informIssuedLottoCount = "%d개를 구매했습니다.";
    private static final String informRankCount =  " - %d개";
    private static final String informReturnOfRate = "총 수익률은 %.1f%%입니다.";
    private static final String informWinRecord ="당첨 통계\n---";
    public static void requestMoney(){
        System.out.println(requestMoney);
    }
    public static void requestWinningNums(){
        System.out.println(requestWinningNums);
    }
    public static void requestBonusNum(){
        System.out.println(requestBonusNum);
    }
    public static void printLottoCount(int lottoCount){
        System.out.println(String.format(informIssuedLottoCount,lottoCount));
        System.out.println();
    }

    public static void printIssuedLotto(List<Lotto> lottoes){
        lottoes.stream().forEach((lotto) ->{
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        });
        System.out.println();
    }

    public static void printRankStatus(Rank rank){
        System.out.print(rank.getStatus());
    }

    public static void printRankCount(int count){
        System.out.println(String.format(informRankCount,count));
    }

    public static void printAllWinRecord(Map<Rank,Integer> rankingResult){
        System.out.println(informWinRecord);
        rankingResult.keySet().stream().forEach((rank)->{
            printRankStatus(rank);
            printRankCount(rankingResult.get(rank));
                });
        System.out.println();
    }

    public static void printReturnOfRate(double profitRate){
        System.out.println(String.format(informReturnOfRate,profitRate));
    }
}
