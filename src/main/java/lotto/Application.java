package lotto;

import java.util.List;

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
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumber = user.inputWinningNumbers();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNum = user.inputBonusNumber();
        List<MatchingCount> matchingCounts = machine.countAllLottoMatchingNumbers(allLotto,winningNumber,bonusNum);
        System.out.println(matchingCounts.toString());
        Calculator calculator = new Calculator();
        int sumPrize = calculator.getProfitMoney(matchingCounts);
        System.out.println(sumPrize);
        double profitPercentage = calculator.getProfitPercentage(sumPrize, volume);
        System.out.println(profitPercentage);
    }
}
