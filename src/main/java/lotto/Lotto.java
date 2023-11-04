package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int inputBuyMoney(){

        String input = Console.readLine();
        int money;

        try {
            money = Integer.parseInt(input);

            if(money % 1000 != 0){
                throw new IllegalArgumentException();
            }

        } catch (NumberFormatException ex){
            money = -1;
            System.out.println("[ERROR] 구매 금액은 숫자로 입력되어야 합니다.");
        } catch (IllegalArgumentException ex){
            money = -1;
            System.out.println("[ERROR] 구매 금액은 1000으로 나누어 떨어져야 합니다.");
        }

        return money;
    }
}
