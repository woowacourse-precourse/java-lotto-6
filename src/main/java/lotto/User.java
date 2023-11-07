package lotto;

import camp.nextstep.edu.missionutils.Console;
import util.Validate;

import java.util.ArrayList;
import java.util.List;

public class User {
    public int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = Integer.parseInt(Console.readLine());

        try {
            Validate.isValidPrice(price);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPrice();
        }

        return price;
    }

    public List<Integer> winningNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() < 6) {
            int num = Integer.parseInt(Console.readLine());
            if (!numbers.contains(num))
                numbers.add(num);
        }

        try {
            Validate.isValidLotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningNumbers();
        }
        return numbers;
    }

    public int bonusNumber() {
        int bonusNumber = Integer.parseInt(Console.readLine());

        try {
            Validate.isValidBonus(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber();
        }

        return bonusNumber;
    }
}
