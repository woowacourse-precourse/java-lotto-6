package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static lotto.util.Phrase.InputPhrase.INPUT_COST;
import static lotto.util.Phrase.InputPhrase.INPUT_ORIGINALNUMBER;
import static lotto.util.Phrase.InputPhrase.INPUT_BONUS;

public class InputView {

    public int inputCost() {
        while (true) {
            System.out.println(INPUT_COST.printMessage());
            String cost = Console.readLine();

            try {
                int costValue = Integer.parseInt(cost);
                if (costValue <= 0 || costValue % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 입력된 비용은 1000으로 나누어 떨어지지 않습니다.");
                }
                return costValue;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 올바른 숫자 형식이 아닙니다. 다시 입력하세요.");
            }
        }
    }

    public List<Integer> inputOriginalNumber() {
        System.out.println(INPUT_ORIGINALNUMBER.printMessage());
        String input = Console.readLine();
        List<Integer> numbers = new ArrayList<>();

        while (!input.isEmpty()) {
            String[] parts = input.split(",");
            boolean hasError = false;

            for (String part : parts) {
                try {
                    int number = Integer.parseInt(part.trim());
                    if (number > 0 && number <= 45) {
                        numbers.add(number);
                    }
                    if (number <= 0 || number > 45) {
                        hasError = true;
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                } catch (NumberFormatException e) {
                    hasError = true;
                    throw new IllegalArgumentException("[ERROR] 숫자를 쉼표(',')를 기준으로 입력해야합니다.");
                }
            }
            if (hasError) {
                //System.out.println("[ERROR] 잘못된 값이 포함되어 있습니다. 다시 입력하세요.");
                System.out.println(INPUT_ORIGINALNUMBER.printMessage());
                input = Console.readLine();
            } else {
                input = "";
            }
        }

        return numbers;
    }



    public int inputBonus(){
        System.out.println(INPUT_BONUS.printMessage());
        String bonus = Console.readLine();
        //exception
        //return bonus;
        return Integer.parseInt(bonus);
    }

}
