package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UIView {
    // INPUT
    public static Integer getPurchaseMoney() {
        Integer parsedPurchaseMoney;

        try {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseMoney = Console.readLine();
            parsedPurchaseMoney = Integer.parseInt(purchaseMoney);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }

        return parsedPurchaseMoney;
    }

    public static List<Integer> getLuckyNumbers() {
        List<Integer> parsedLuckyNumbers = new ArrayList<>();

        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String[] luckyNumbers = Console.readLine().split(",");
            for(String token : luckyNumbers) {
                parsedLuckyNumbers.add(Integer.parseInt(token));
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }

        return parsedLuckyNumbers;
    }

    public static Integer getBonusNumber() {
        Integer parsedBonusNumber;

        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumber = Console.readLine();
            parsedBonusNumber = Integer.parseInt(bonusNumber);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException();
        }

        return parsedBonusNumber;
    }
}
