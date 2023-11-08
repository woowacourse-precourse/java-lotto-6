package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static HashMap<Integer, Integer> rewardMap = new HashMap<>() {
        {
            put(0, 6);
            put(5000, 5);
            put(50000, 4);
            put(1500000, 3);
            put(30000000, 2);
            put(2000000000, 1);
        }
    };

    public static List<Integer> rewardList = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));

    public static List<Lotto> setLottoList(Integer purchaseCount) {

        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; purchaseCount > i; i++) {
            List<Integer> luckyNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            luckyNumbers.sort(null);

            Lotto lotto = new Lotto(luckyNumbers);
            lottoList.add(lotto);
        }

        return lottoList;
    }

    public static void printLotto(List<Lotto> lottoList) {
        Integer lottoCount = lottoList.size();
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
        for (int i = 0; lottoCount > i; i++) {
            lottoList.get(i).printLotto();
        }
    }

    public static Integer getLottoReward(List<Lotto> lottoList, List<Integer> luckyNumber, Integer bonusNumber) {
        Integer sumReward = 0;
        for (Lotto lotto : lottoList) {
            Integer reward = lotto.matchingLotto(luckyNumber, bonusNumber);
            if (reward > 0) {
                rewardList.set(rewardMap.get(reward), rewardList.get(reward) + 1);
            }
        }

        return sumReward;
    }

    public static void main(String[] args) {

        System.out.println("구매금액을 입력해 주세요.");
        Integer purchaseCount;

        while (true) {
            try {
                String purchaseAmount = Console.readLine();
                purchaseCount = Validator.purchaseAmountValidation(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 구매금액을 입력해주세요.");
            }
        }

        List<Lotto> lottoList = setLottoList(purchaseCount);
        printLotto(lottoList);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        List<Integer> luckyNumbers = new ArrayList<>();
        while (true) {
            try {
                String luckyNumberString = Console.readLine();
                Validator.LuckyNumberValidation(luckyNumberString);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 당첨 번호를 입력해주세요.");
            }
        }

        System.out.println("\n보너스 번호를 입력해 주세요.");
        Integer bonusNumber = 0;
        while (true) {
            try {
                String bonusNumberString = Console.readLine();
                Validator.NumberValidation(bonusNumberString);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 보너스 번호를 입력해주세요.");
            }
        }

        Integer sumReward = getLottoReward(lottoList, luckyNumbers, bonusNumber);

        System.out.println(sumReward);
    }
}
