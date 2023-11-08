package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LottoUserInput {
    
    private Lotto lotto = new Lotto();
    
    public int getUserPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmount = Console.readLine();
            if (!purchaseAmount.matches("\\d+")) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
            }
            int amount = Integer.parseInt(purchaseAmount);
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1000원단위로 입력해야 합니다.");
            }
            System.out.println();
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getUserPurchaseAmount();
        }
    }
    
    public List<Integer> getWinningNumber() {
        System.out.println();
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();
            String[] numberList = input.split(",");
            List<Integer> winningNumber = new ArrayList<>();
            for (String numberValue : numberList) {
                int number = Integer.parseInt(numberValue.trim());
                winningNumber.add(number);
            }
            lotto.validate(winningNumber);
            return winningNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }
    
    public int getValidBonusNumber(HashSet<Integer> winningNumber) {
        try {
            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNum = Integer.parseInt(Console.readLine());
            System.out.println();
            if (bonusNum < 1 || bonusNum > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (winningNumber.contains(bonusNum)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호와 중복된 보너스 번호가 입력되었습니다. 보너스 번호를 다시 입력하세요.");
            }
            return bonusNum;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidBonusNumber(winningNumber);
        }
    }
    
}
