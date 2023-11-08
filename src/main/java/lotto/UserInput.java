package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public static int getUserPurchaseAmount() {
        int purchaseAmount = 0;
        while(true) {
            System.out.println("구입금액을 입력해주세요.");
            String str = Console.readLine();
            try {
                // TODO : 예외처리 분리 및 추가
                purchaseAmount = Integer.parseInt(str);
                return purchaseAmount;
            }catch (Exception e) {
                System.out.println("[ERROR] 올바른 값이 아닙니다. ");
            }
        }
    }
    public static String[] getUserLottoNumbers() {
        while(true) {
            System.out.println("당첨 번호를 입력해주세요.");
            String lottoNumbers = Console.readLine();

            try{
                // TODO : 예외처리 분리 및 추가
                String[] arr = lottoNumbers.split(",");
                return arr;
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static int getUserBonusNumber() {
        int number = 0;
        while(true) {
            System.out.println("보너스 번호를 입력해주세요.");
            String bonusNumber = Console.readLine();
            try {
                number = Integer.parseInt(bonusNumber);
                return number;
            } catch (Exception e) {
                System.out.println("[ERROR] 올바른 값이 아닙니다. ");
            }
        }
    }
}
