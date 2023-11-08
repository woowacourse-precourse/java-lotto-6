package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Buyer {
    public int takeLottoPurchaseAmountFromBuyer() {
        System.out.println("구입 금액을 입력해주세요.");
        String money = Console.readLine();
        if (validator.isNumeric(money)) {
            return Integer.parseInt(money);
        }
        System.out.println("[ERROR] 숫자가 아닙니다.");
//        throw new NumberFormatException("[ERROR] 숫자가 아닙니다.");
        return 0;
    }

    public int getLottoPurchaseAmount() {
        int money = takeLottoPurchaseAmountFromBuyer();
        if (validator.validatePurchaseAmount(money)) {
            return money;
        }
        System.out.println("[ERROR] 천원단위로 입력해주세요.");
//        throw new IllegalArgumentException("[ERROR] 천원단위로 입력해주세요.");
        return 0;
    }

    public List<Integer> getLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

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

    public List<Integer> getWinningNumber() {
        System.out.println("당첨번호를 입력해주세요.");
        String winningNumberString = Console.readLine();
        if (!validator.validateWinningNumber(winningNumberString)) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
        // 입력받은 문자열을 쉼표로 분할하여 스트림 생성

        return Arrays.stream(winningNumberString.split(","))
                .map(String::trim) // 공백 제거
                .map(Integer::parseInt) // 각 문자열을 정수로 변환
                .toList();
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        String bonusNumberString = Console.readLine();
        if (!validator.validateBonusNumber(bonusNumberString)) {
            System.out.println("[ERROR] 잘못된 입력입니다.");
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
        if (validator.isNumeric(bonusNumberString)) {
            return Integer.parseInt(bonusNumberString);
        }
        System.out.println("[ERROR] 숫자가 아닙니다.");
//        throw new NumberFormatException("[ERROR] 숫자가 아닙니다.");
        return 0;
    }
}
