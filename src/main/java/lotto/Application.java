package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {

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
        System.out.println();
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

    }
}
