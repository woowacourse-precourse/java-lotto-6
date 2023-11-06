package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ViewInput {
    private static StringTokenizer tokens;

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        int purchaseAmount = Integer.parseInt(Console.readLine());
        // 입력 검증
        return purchaseAmount;
    }

    public List<Integer> getWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        tokens = new StringTokenizer(Console.readLine(), ",");

        List<Integer> winningNumbers = new ArrayList<>();
        // 입력수 검증
        while(tokens.hasMoreTokens()) {
            winningNumbers.add(Integer.parseInt(tokens.nextToken().trim()));
        }
        // 당첨번호 조건 검증
        return winningNumbers;
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        int bonusNumber = Integer.parseInt(Console.readLine());
        // 보너스 번호 조건 검증

        return bonusNumber;
    }
}
