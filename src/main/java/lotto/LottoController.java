package lotto;

import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private static Lotto lotto;
    private static LottoAmount lottoAmount;
    static List<Integer> winNums;
    private static List<Integer> playerLottoNums;
    private static RandomLotto randomLotto;
    private static boolean result = true;

    public void start() {
        int bonusNum = 0;
        int amount = getInputAmount();
        int count = lottoAmount.calculateLottoCount();
        Output.printLottoCount(count);

        List<List<Integer>> lottoList = new ArrayList<>();
        purchasedLotto(lottoList,count);

        //당첨 번호 입력
        winNums = getInputWinNum();
        //보너스 번호 입력
        List<Integer> passedWinNums = lotto.getNumbers();

        getInputBonusNum(bonusNum,passedWinNums);

        checkRank(lottoList, bonusNum,amount);

    }

    public static List<Integer> getInputWinNum() {
        while (true) {
            try {
                winNums = Input.inputWinNums();
                lotto = new Lotto(winNums);
                return winNums;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getInputAmount() {
        while (true) {
            try {
                int amount = Input.inputLottoAmount();
                lottoAmount = new LottoAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int compareLists(List<Integer> winNums, List<Integer> playerLottoNums) {
        int count = 0;
        for (int num : winNums) {
            if (playerLottoNums.contains(num)) {
                count++;
            }
        }
        return count;
    }

    public static double rate(int[] prizeRank, int amount) {
        float totalPrice = 0;
        Ranking[] values = Ranking.values();
        for (int i = 3; i < values.length; i++) {
            totalPrice += prizeRank[i] * values[i].getRankingValue();
        }
        totalPrice /= amount;
        totalPrice *= 100;
        return totalPrice;
    }

    public static void getInputBonusNum(int bonusNum, List<Integer> passedWinNums) {
        while (result) {
            bonusNum = Input.inputBonusNum();
            result = lotto.validateBonusNum(bonusNum, passedWinNums);
        }
    }

    public static void purchasedLotto(List<List<Integer>> lottoList,int count) {
        //구매 로또 출력
        for (int i = 0; i < count; i++) {
            playerLottoNums = randomLotto.setRandomLotto();
            System.out.println(playerLottoNums);
            lottoList.add(playerLottoNums);
        }
    }

    public static void checkRank(List<List<Integer>> lottoList, int bonusNum, int amount) {
        int[] prizeRank = new int[8];
        for (int i = 0; i < lottoList.size(); i++) {
            int matchingNumbers = compareLists(lottoList.get(i), winNums);
            if (matchingNumbers == 5 && lottoList.get(i).contains(bonusNum)) {
                prizeRank[7]++;
                continue;
            }
            prizeRank[matchingNumbers]++;
        }
        Output.printResul(prizeRank, rate(prizeRank, amount));
    }

}
