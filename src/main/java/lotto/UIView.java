package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UIView {
    private static final String[] lottoResultPrefixes = {
            "6개 일치 (2,000,000,000원)",
            "5개 일치, 보너스 볼 일치 (30,000,000원)",
            "5개 일치 (1,500,000원)",
            "4개 일치 (50,000원)",
            "3개 일치 (5,000원)"
    };

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

        if(parsedPurchaseMoney % Lotto.PRICE != 0) {
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

    // OUTPUT
    public static void showSelectedNumbers(List<List<Integer>> selectedNumbers) {
        System.out.println(selectedNumbers.size() + "개를 구매했습니다.");
        for(List<Integer> numbers : selectedNumbers) {
            System.out.println(numbers.toString());
        }
    }

    public static void showLottoResults(List<Integer> lottoResults) {
        for(int i = lottoResultPrefixes.length - 1; i >= 0; i--) {
            System.out.println(lottoResultPrefixes[i] + " - " + lottoResults.get(i) + "개");
        }
    }

    public static void showReturnRate(Float returnRate) {
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }
}
