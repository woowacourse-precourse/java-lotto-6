package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {

        System.out.println("구매금액을 입력해 주세요.");
        Integer purchaseAmount;

        while (true) {
            try {
                String purchaseAmountString = Console.readLine();
                purchaseAmount = Validator.purchaseAmountValidation(purchaseAmountString);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 구매금액을 입력해주세요.");
            }
        }

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; purchaseAmount > i; i++) {
            List<Integer> luckyNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            luckyNumbers.sort(null);

            Lotto lotto = new Lotto(luckyNumbers);
            lottoList.add(lotto);
        }
    }
}
