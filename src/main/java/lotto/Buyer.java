package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
    public int takeLottoPurchaseAmountFromBuyer() {
        System.out.println("구입 금액을 입력해주세요.");
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    public boolean validatePurchaseAmount(int money) {
        return money % 1000 == 0;
    }

    public int getLottoPurchaseAmount() {
        int money = takeLottoPurchaseAmountFromBuyer();
        if (validatePurchaseAmount(money)) {
            return money;
        }
        throw new IllegalArgumentException("천원단위로 입력해주세요.");
    }

    public List<Integer> getLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

//    public int getBonusNumber(List<Integer> LottoNumbers) {
//        int bonusNumber;
//        do {
//            bonusNumber = Randoms.pickNumberInRange(1, 45);
//        } while (LottoNumbers.contains(bonusNumber));
//        return bonusNumber;
//    }

    public List<List<Integer>> generateLottoNumbers() {
        int money = getLottoPurchaseAmount();
        int frequency = money/1000;
        System.out.println();
        System.out.println(frequency + "개를 구매했습니다.");
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < frequency; i++) {
            List<Integer> lottoNumber = getLottoNumber();
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }
}
