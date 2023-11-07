package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.WinningLotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    public int getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = 0;
        try {
            money = Integer.parseInt(Console.readLine());
            validPrice(money);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 구입금액은 숫자여야 합니다.");
            getPurchasePrice();
        }
        return money;
    }

    private void validPrice(int money) {
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 로또 1개의 가격은 1,000원입니다. 올바른 구입금액을 입력하셔야 합니다.");
            getPurchasePrice();
        }
    }

    public WinningLotto getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        try {
            for (String numberString : numberStrings) {
                int number = Integer.parseInt(numberString);
                validNumber(number);
                numbers.add(number);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 당첨 번호는 숫자여야 합니다.");
            getWinningNumbers();
        }
        validWinningNumber(numbers);
        return new WinningLotto(numbers);
    }

    private void validWinningNumber(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 당첨 번호는 6개여야 합니다.");
            getWinningNumbers();
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            System.out.println("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            getWinningNumbers();
        }
    }

    private void validNumber(int number) {
        if (number < 1 || number > 45) {
            System.out.println("[ERROR] 당첨 숫자는 1에서 45 사이여야 합니다.");
        }
    }

}
