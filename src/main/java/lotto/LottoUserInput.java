package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @author 김지환
 * 
 * 로또를 위한 유저의 입력을 담당하는 클래스
 */
public class LottoUserInput {
    
    /*유저의 구입금액 입력 및 exception관리*/
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
    
    /*유저의 당첨번호를 입력받는 클래스*/
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
            validateSixNumbers(winningNumber);
            validateLottoNumbers(winningNumber);
            checkDuplicateNumbers(winningNumber);
            return winningNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }
    
    /*유효하지 않은 숫자일 경우 exception*/
    private void validateLottoNumbers(List<Integer> numbers) {
        for(int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
    
    /*중복된 숫자일 경우 exception*/
    private void checkDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numberSet  = new HashSet<>();

        for (int number : numbers) {
            if (!numberSet.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 번호가 입력되었습니다.");
            }
        }
    }
    
    /*6자리의 숫자가 아닐경우 exception*/
    private void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자만 가능합니다.");
        }
    }
    
    /*보너스번호를 입력받는 메서드*/
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
