package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        if (purchaseAmount % LOTTO_PRICE != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력되어야 합니다.");
            throw new IllegalArgumentException();
        }
        return purchaseAmount;
    }

    public List<Integer> getWinnigNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                                            .map(Integer::parseInt)
                                            .collect(Collectors.toList());
        for(int number : winningNumbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
        return winningNumbers;
    }

    public int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            System.out.println("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }
    
}
