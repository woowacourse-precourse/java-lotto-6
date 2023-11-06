package lotto;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        System.out.println("구입금액을 입력해 주세요.");
        int volume = user.inputPurchasingVolume();
        List<Lotto> allLotto = user.getLottoAsMuchAsVolume(volume);
        for(Lotto lotto : allLotto){
            System.out.println(lotto.getNumbers().toString());
        }
        MatchingMachine machine = new MatchingMachine();
        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = user.inputWinningNumbers();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNum = user.inputBonusNumber();
        List<MatchingCount> matchingCounts = machine.countAllLottoMatchingNumbers(allLotto,winningNumber,bonusNum);
        System.out.println("\n당첨 통계 \n ---");
        Map<MatchingCount, Integer> map = machine.getLottoResultAsMap(matchingCounts);
        System.out.println( "3개 일치 (" + MatchingCount.THREE.getPrizeMoney() + ") - " + map.get(MatchingCount.THREE) +"개");
        System.out.println( "4개 일치 (" + MatchingCount.FOUR.getPrizeMoney() + ") - " + map.get(MatchingCount.FOUR) +"개");
        System.out.println( "5개 일치 (" + MatchingCount.FIVE.getPrizeMoney() + ") - " + map.get(MatchingCount.FIVE) +"개");
        System.out.println( "5개 일치, 보너스볼 일치 (" + MatchingCount.FIVE_BONUS.getPrizeMoney() + ") - " + map.get(MatchingCount.FIVE_BONUS) +"개");
        System.out.println( "6개 일치 (" + MatchingCount.SIX.getPrizeMoney() + ") - " + map.get(MatchingCount.SIX) +"개");
        Calculator calculator = new Calculator();
        int sumPrize = calculator.getProfitMoney(matchingCounts);
        double profitPercentage = calculator.getProfitPercentage(sumPrize, volume);
        System.out.println("총 수익률은 " +profitPercentage + "%입니다.");
    }
}
