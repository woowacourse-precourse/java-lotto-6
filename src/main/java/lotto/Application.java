package lotto;

import java.util.*;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> lottos = generateLottos(purchaseAmount / 1000);

        printLottoTickets(lottos);

        Lotto winningLotto = new Lotto(inputWinningNumbers());
        int bonusNumber = inputBonusNumber();

        printResult(lottos, winningLotto, bonusNumber, purchaseAmount);

    }
    // 입력받고 로또 생성
    private static int inputPurchaseAmount(){

        try{
            System.out.println("구입금액을 입력해 주세요");
            int purchaseAmount = Integer.parseInt(Console.readLine());
            System.out.println();

            validPurchaseAmount(purchaseAmount);

            return purchaseAmount;
        }
        catch(IllegalArgumentException e){
            System.out.println("[ERROR] 구입금액은 1,000원 단위로 입력해야 합니다.");
            System.out.println();

            return inputPurchaseAmount();
        }
    }
    private static void validPurchaseAmount(int amount){
        if(amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Lotto> generateLottos(int count){
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i<count; i++){
            lottos.add(new Lotto(generateRandomNumbers()));
        }
        return lottos;
    }
    private static List<Integer> generateRandomNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    // 당첨 로또 생성
    private static List<Integer> inputWinningNumbers() {
        while(true){
            try{
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                System.out.println();

                String[] numbers = input.split(",");

                List<Integer> winningNumbers = Arrays.stream(numbers)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                Lotto winningLotto = new Lotto(winningNumbers);
                return winningNumbers;
            }
            catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println();
            }
        }


    }
    
    private static int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber =  Integer.parseInt(Console.readLine());
        System.out.println();

        return bonusNumber;
    }

    // 결과 계산
    private enum WinningPrize {
        MATCH_3(3, 5000),
        MATCH_4(4, 50000),
        MATCH_5(5, 1500000),
        MATCH_5_BONUS(5, 30000000),
        MATCH_6(6, 2000000000);

        private final int matchCount;
        private final int prizeMoney;

        WinningPrize(int matchCount, int prizeMoney) {
            this.matchCount = matchCount;
            this.prizeMoney = prizeMoney;
        }

        public int getMatchCount() {
            return matchCount;
        }

        public int getPrizeMoney() {
            return prizeMoney;
        }
    }


    private static Map<String, Integer> calculateResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber){
        Map<String, Integer> resultMap = new HashMap<>();

        for(Lotto lotto : lottos){
            int matchCount = winningLotto.countMatchedNumbers(lotto);

            if(matchCount<3)continue;

            boolean bonusMatch = winningLotto.isBonusMatched(bonusNumber);
            String key = getKey(matchCount, bonusMatch);

            resultMap.put(key, resultMap.getOrDefault(key, 0) + 1);
        }
        return resultMap;
    }

    private static long getPrizeMoney(Map<String, Integer>resultMap){
        long totalPrizeMoney = 0;
        for(WinningPrize prize : WinningPrize.values()){
            boolean bonusMatch = false;
            if(prize == WinningPrize.MATCH_5_BONUS)
                bonusMatch = true;
            String key = getKey(prize.getMatchCount(), bonusMatch);
            totalPrizeMoney += prize.getPrizeMoney() * resultMap.getOrDefault(key, 0);
        }
        return totalPrizeMoney;
    }

    private static double calculateEarningsRate(int purchaseAmount, long totalPrizeMoney){
        return ((double) totalPrizeMoney) / purchaseAmount * 100;
    }

    private static void printResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber, int purchaseAmount){
        Map<String, Integer> resultMap = calculateResult(lottos, winningLotto, bonusNumber);

        long totalPrizeMoney = getPrizeMoney(resultMap);
        double earningsRate = calculateEarningsRate(purchaseAmount, totalPrizeMoney);

        System.out.println("당첨 통계");
        System.out.println("---");
        printLottoResult(resultMap);
        printEarningsRate(earningsRate);
    }

    private static void printLottoTickets(List<Lotto> lottos){
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for(Lotto lotto : lottos){
            lotto.printLotto();
        }
        System.out.println();
    }
    private static void printLottoResult(Map<String, Integer> resultMap){

        for(WinningPrize prize : WinningPrize.values()){
            boolean bonusMatch = false;
            if(prize == WinningPrize.MATCH_5_BONUS)
                bonusMatch = true;
            String key = getKey(prize.getMatchCount(), bonusMatch);

            System.out.printf("%s (%,d원) - %d개\n", key, prize.getPrizeMoney(), resultMap.getOrDefault(key, 0));
        }
    }

    private static void printEarningsRate(double earningsRate){
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningsRate);
    }

    private static String getKey(int matchCount, boolean bonusMatch){
        if(matchCount == 5 && bonusMatch){
            return "5개 일치, 보너스 볼 일치";
        }
        
        return matchCount + "개 일치";
    }
}
