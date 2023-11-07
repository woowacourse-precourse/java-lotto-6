package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    Message message = new Message();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void playLotto() {
        int money = 0;
        int purchaseNumber = 0;
        int bonusInput = 0;
        List<List<Integer>> allNumbers = new ArrayList<>();
        money = purchaseResult(purchaseNumber, money, allNumbers);
    }

    // 구입 금액 입력 받고 예외 처리한 뒤 리턴
    public int purchaseResult(int purchaseNumber, int money, List<List<Integer>> allNumbers) {
        message.purchaseMessage();
        try {
            int moneyInput = Integer.parseInt(Console.readLine());
            money = validateOfMoney(moneyInput);
            purchaseNumber = calculatePurchaseNumber(money);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            System.out.println();
            return purchaseResult(0, 0, allNumbers); //예외 발생 시 기존 값 초기화 해줌
        }

        return money;
    }

    private int validateOfMoney(int moneyInput) {
        //1000단위의 숫자만 입력 받음
        if (moneyInput % 1000 != 0 || moneyInput < 1000) {
            throw new IllegalArgumentException();
        }

        return moneyInput;
    }

    private int calculatePurchaseNumber(int money) {
        return money / 1000;
    }
}
