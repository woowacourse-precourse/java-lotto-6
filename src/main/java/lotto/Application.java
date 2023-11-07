package lotto;

import camp.nextstep.edu.missionutils.*;
import lotto.domain.enums.Rank;

import java.security.cert.TrustAnchor;
import java.util.*;


public class Application {

    static Map<Rank, Integer> createLottoRanksMap(List<Integer> winningNumber, List<Lotto> lottos, int bonusNumber) {
        Map<Rank, Integer> lottoRanks = new HashMap<>();
        lottoRanks.put(Rank.NOT, 0);
        lottoRanks.put(Rank.FIFTH, 0);
        lottoRanks.put(Rank.FOURTH, 0);
        lottoRanks.put(Rank.THIRD, 0);
        lottoRanks.put(Rank.SECOND, 0);
        lottoRanks.put(Rank.FIRST, 0);
        for (int i = 0; i < lottos.size(); i++) {
            Rank rank = Lotto.judgeLottoRank(winningNumber, lottos.get(i), bonusNumber);
            lottoRanks.put(rank, lottoRanks.get(rank) + 1);
        }
        return lottoRanks;
    }

    static double computeRateOfReturn(Map<Rank, Integer> lottoRanks, long purchaseAmount) {
        long proceeds;
        proceeds = lottoRanks.get(Rank.FIFTH) * 5000 + lottoRanks.get(Rank.FOURTH) * 50000 + lottoRanks.get(Rank.THIRD) * 1500000 + lottoRanks.get(Rank.SECOND) * 30000000 + lottoRanks.get(Rank.FIRST) * 2000000000;
        return (double) proceeds / purchaseAmount * 100;
    }

    static void printResult(Map<Rank, Integer> lottoRanks, double rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoRanks.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoRanks.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoRanks.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 불 일치 (30,000,000원) - %d개\n", lottoRanks.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoRanks.get(Rank.FIRST));
        System.out.printf("총 수익률은 %.1f%%입니다\n", Math.round(rateOfReturn * 100.) / 100.);
    }

    static long getPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            long purchaseAmount = Integer.parseInt(Console.readLine());
            if (purchaseAmount % 1000 != 0)
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000의 배수인 숫자여야 합니다.");
            System.out.println(String.format("%d개를 구매했습니다.", purchaseAmount / 1000));
            return purchaseAmount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000의 배수인 숫자여야 합니다.");
        }
    }
    static boolean isWinningNumberValid(List<Integer> winningNumber){
     if(Collections.max(winningNumber) > 45)
         return false;
     if(Collections.min(winningNumber) < 1)
         return false;
     return true;
    }

    static List<Integer> getWinningNumber() {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            List<String> winningNumberOfString = List.of(Console.readLine().split(","));
            List<Integer> winningNumber = new ArrayList<>();
            for (int i = 0; i < 6; i++)
                winningNumber.add(Integer.parseInt(winningNumberOfString.get(i)));
            if(!isWinningNumberValid(winningNumber))
                throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 1 ~ 45인 6개의 숫자여야 합니다.");
            System.out.println(winningNumber);
            return winningNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 1 ~ 45인 6개의 숫자여야 합니다.");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 1 ~ 45인 6개의 숫자여야 합니다.");
        }
    }

    static int getBonusNumber(){
        try{
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Integer.parseInt(Console.readLine());
            System.out.println(bonusNumber);
            if ( bonusNumber < 1 || bonusNumber > 45 )
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45인 숫자여야 합니다.");
            return bonusNumber;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45인 숫자여야 합니다.");
        }
    }

    public static void game() {
        //이것들도 각각..메서드로 뺴서 딱 걔네들을 불러줘야할 듯
        long purchaseAmount = 0;
        try {
            purchaseAmount = getPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 구입 금액은 1000의 배수인 숫자여야 합니다.");
            game();
        }
        List<Lotto> lottos = Lotto.createLottos(purchaseAmount / 1000);
        List<Integer> winningNumber = null;
        try {
            winningNumber = getWinningNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 당첨 번호는 1 ~ 45인 6개의 숫자여야 합니다.");
            //이거..끊긴거부터해야하는데 ㅠ
            game();
        }
        int bonusNumber = 0;
        try {
            bonusNumber = getBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스 번호는 1 ~ 45인 숫자여야 합니다.");
            //이거..끊긴거부터해야하는데 ㅠ
            game();
        }

        Map<Rank, Integer> lottoRanks = createLottoRanksMap(winningNumber, lottos, bonusNumber);

        double rateOfReturn = computeRateOfReturn(lottoRanks, purchaseAmount);

        printResult(lottoRanks, rateOfReturn);

    }

    public static void main(String[] args) {
        game();
    }
}
