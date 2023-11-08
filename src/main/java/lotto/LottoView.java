package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoView {
    private static List<List<Integer>> lottoList = new ArrayList<>();
    private static Lotto lotto;
    private static int price;
    private static int bonus;
    private static List<Integer> lottoNum;

    static Validator validator = new Validator();
    static Map<Rank, Integer> Ranking = new EnumMap<>(Rank.class);


    public static void enterBuyPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        String inputstr = Console.readLine();
        price = validator.validatePrice(inputstr);
    }
    public static void enterLottoNum(){
        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> inputstr = Arrays.asList(Console.readLine().split(","));
        lottoNum = inputstr.stream()
                .map(s -> Integer.parseInt(s))
                .toList();
        lotto = new Lotto(lottoNum);
    }
    public static void enterBonus(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputstr = Console.readLine();
        bonus = validator.validateBonus(inputstr);
        lotto.setBonus(bonus);
    }
    static void initLottoList(int price){
        int lottonum = price / 1000;
        System.out.println(lottonum+"개를 구매했습니다.");
        for(int i=0;i<lottonum;i++){
            List<Integer> pickedlotto = Randoms.pickUniqueNumbersInRange(1,45,6);
            lottoList.add(pickedlotto);
        }
        for(List<Integer> picked:lottoList){
            System.out.println(picked);
        }
    }

    static void initRanking(){
        System.out.println("당첨 통계");
        Ranking.put(Rank.FIRST,0);
        Ranking.put(Rank.SECOND,0);
        Ranking.put(Rank.THIRD,0);
        Ranking.put(Rank.FOURTH,0);
        Ranking.put(Rank.FIFTH,0);
        System.out.println("---");
    }

    public static void drawLottoRank(){
        initRanking();
        for(List<Integer> pickedNum : lottoList){
            int matchCount =  lotto.calculateNumbers(pickedNum);
            boolean isBonusMatched = lotto.isBonusinPicked(pickedNum);
            if(matchCount == 6) Ranking.put(Rank.FIRST,Ranking.get(Rank.FIRST)+1);
            if(matchCount == 5 && isBonusMatched) Ranking.put(Rank.SECOND,Ranking.get(Rank.SECOND)+1);
            if(matchCount == 5 && !isBonusMatched) Ranking.put(Rank.THIRD,Ranking.get(Rank.THIRD)+1);
            if(matchCount == 4) Ranking.put(Rank.FOURTH,Ranking.get(Rank.FOURTH)+1);
            if(matchCount == 3) Ranking.put(Rank.FIFTH,Ranking.get(Rank.FIFTH)+1);
        }
        for(Rank rank : Ranking.keySet()){
            System.out.println(rank.getStatus() + " - " + Ranking.get(rank)+"개");
        }
    }

    public static void calculateReturn(){
        float totalReturn = 0;
        int totalEarned = 0;
        for(Rank rank: Ranking.keySet()){
            totalEarned += rank.getReward() * Ranking.get(rank);
        }
        totalReturn = (float) totalEarned /price*100;
        System.out.println("총 수익률은 "+String.format("%.1f",totalReturn)+"%입니다.");
    }
    public void run(){
        enterBuyPrice();
        initLottoList(price);

        enterLottoNum();

        enterBonus();

        drawLottoRank();
        calculateReturn();
    }
}
