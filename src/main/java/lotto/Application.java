package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자로부터 로또 구입 금액 입력받고 purchaseAmount는 로또 장수가 된다.
        int purchaseAmount = getPurchaseAmount();

        // 로또 발행
        Lotto lottos = Lotto.generateRandomLotto(purchaseAmount);

        // 당첨 번호 입력
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        // 결과 출력
        showResults(lottos, winningNumbers, bonusNumber);
    }

    // 로또 구입 금액 입력받고 1000으로 나눠 떨어지면 구매 장수 반환
    private static int getPurchaseAmount() {
        int amount;
        while (true) {
            try {
                System.out.print("구입 금액을 입력하세요: ");
                amount = Integer.parseInt(Console.readLine());
                if (amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력하세요.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력하세요. illegal");
            }
        }
        return amount;
    }

    // 당첨 번호 입력
    private static List<Integer> getWinningNumbers() {
        System.out.print("당첨 번호를 입력하세요 (1~45 사이의 숫자, 쉼표로 구분): ");
        return Arrays.stream(Console.readLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    // 보너스 번호 입력
    private static int getBonusNumber() {
        int bonus;
        while (true) {
            try {
                System.out.print("보너스 번호를 입력하세요 (1~45 사이의 숫자): ");
                bonus = Integer.parseInt(Console.readLine());
                if (bonus < 1 || bonus > 45) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return bonus;
    }

    // 결과 출력
    private static void showResults(Lotto lottos, List<Integer> winningNumbers, int bonusNumber) {
        // 결과 계산 및 출력
        System.out.println("출력은 미완성");
    }
}