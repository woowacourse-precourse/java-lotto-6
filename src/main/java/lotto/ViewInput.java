package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ViewInput {
    private static StringTokenizer tokens;
    private static InputVerification inputVerification = new InputVerification();

    public int getPurchaseAmount() {
        boolean isValid = false;
        int purchaseAmount = 0;

        while(!isValid) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                purchaseAmount = Integer.parseInt(Console.readLine());
                isValid = inputVerification.isMultipleOfThousand(purchaseAmount);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1000 단위 수가 아닙니다.");
            }
        }
        return purchaseAmount;
    }

    public List<Integer> getWinningNumbers() {
        boolean isValid = false;
        List<Integer> winningNumbers = new ArrayList<>();

        while(!isValid) {
            try {
                winningNumbers.clear();

                System.out.println("당첨 번호를 입력해 주세요.");
                tokens = new StringTokenizer(Console.readLine(), ",");

                while(tokens.hasMoreTokens()) {
                    winningNumbers.add(Integer.parseInt(tokens.nextToken().trim()));
                }
                isValid = inputVerification.verifyWinningNumbers(winningNumbers);
            }
            catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 입력이 아닙니다.");
            }
        }
        return winningNumbers;
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        boolean isValid = false;
        int bonusNumber = 0;

        while(!isValid) {
            try {
                System.out.println("\n보너스 번호를 입력해 주세요.");
                bonusNumber = Integer.parseInt(Console.readLine().trim());

                isValid = inputVerification.verifyBonusNumber(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 입력이 아닙니다.");
            }
        }
        return bonusNumber;
    }
}
