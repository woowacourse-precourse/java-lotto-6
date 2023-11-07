package ui;

import camp.nextstep.edu.missionutils.Console;
import dto.BonusNumberDTO;
import dto.CommonNumberDTO;
import dto.MoneyDTO;
import java.util.List;
import java.util.stream.Stream;

class InputView {
    private InputView() {
    }

    /**
     * @return 1000 단위로 끊어진 로또 구매 금액.
     */
    public static MoneyDTO getMoney() {
        while (true) {
            try {
                String input = Console.readLine();
                int money = Integer.parseInt(input);
                return new MoneyDTO(money);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static CommonNumberDTO getCommonNumbers() {
        while (true) {
            try {
                String input = Console.readLine();
                String[] inputNumbers = input.split(",");

                List<Integer> integers = Stream.of(inputNumbers).map(Integer::parseInt).toList();

                return new CommonNumberDTO(integers);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static BonusNumberDTO getBonusNumbers(CommonNumberDTO commonNumbers) {
        while (true) {
            try {
                String input = Console.readLine();
                int number = Integer.parseInt(input);
                return new BonusNumberDTO(commonNumbers, number);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
