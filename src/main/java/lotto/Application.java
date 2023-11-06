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
        System.out.println(volume+"개를 구매했습니다.");
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
        System.out.println("3개 일치 (5,000원) - " +map.get(MatchingCount.THREE) +"개");
        System.out.println("4개 일치 (50,000원) - " +map.get(MatchingCount.FOUR) +"개");
        System.out.println("5개 일치 (1,500,000원) - " +map.get(MatchingCount.FIVE) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " +map.get(MatchingCount.FIVE_BONUS) +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " +map.get(MatchingCount.SIX) +"개");
        Calculator calculator = new Calculator();
        int sumPrize = calculator.getProfitMoney(matchingCounts);
        double profitPercentage = calculator.getProfitPercentage(sumPrize, volume);
        System.out.println("총 수익률은 " +profitPercentage + "%입니다.");
    }
}
