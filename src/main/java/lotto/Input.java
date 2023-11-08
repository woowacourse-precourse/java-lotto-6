package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Input {
    public static int getPurchaseAmount() {
        int purchaseAmount = 0;
        while(true) {
            System.out.println("구입금액을 입력해주세요.");
            String str = Console.readLine();
            try {
                purchaseAmount = Integer.parseInt(str);
                return purchaseAmount;
            }catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 값이 아닙니다. ");
            }
        }
    }
    public static String[] getLottoNumbers() {
        while(true) {
            System.out.println("당첨 번호를 입력해주세요.");
            String lottoNumbers = Console.readLine();
            try{
                String[] array = lottoNumbers.split(",");
                Arrays.sort(array);
                return array;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static int getBonusNumber() {
        int number = 0;
        while(true) {
            System.out.println("보너스 번호를 입력해주세요.");
            String bonusNumber = Console.readLine();
            try {
                number = Integer.parseInt(bonusNumber);
                return number;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 올바른 값이 아닙니다. ");
            }
        }
    }
}