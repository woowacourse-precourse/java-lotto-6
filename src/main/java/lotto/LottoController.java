package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class LottoController {


    private Integer getPurchasePrice() {
        String input = Console.readLine();
        try {
            int price = Integer.parseInt(input);
            validatePrice(price);
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 가격은 1000원으로 나누어 떨어지는 숫자여야 합니다.");
        }
    }

    private void validatePrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 가격은 1000원으로 나누어 떨어지는 숫자여야 합니다.");
        }
    }

    private Integer getBonusNumber() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private List<Integer> getWinningNumbers() {
        String input = Console.readLine();
        return convertInputNumbers(input);
    }

    private List<Integer> convertInputNumbers(String input) {
        try {
            return Arrays.stream(input.split(",")).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

}
