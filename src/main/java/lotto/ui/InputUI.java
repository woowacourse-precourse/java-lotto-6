package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 민경수
 * @description input ui
 * @since 2023.11.04
 **********************************************************************************************************************/
public class InputUI {

    private static final String DELIMITER = ",";

    public int getAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                return validate(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");

        return getWinningLottoNumbers(Console.readLine());
    }

    public int getBonusBall() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        return Integer.parseInt(bonusNumber);
    }

    private int validate(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구매 금액을 확인해주세요. 입력한 구매금액 : " + number);
        }
    }

    private ArrayList<Integer> getWinningLottoNumbers(String numbers) {
        try {
            return Arrays.stream(numbers.split(DELIMITER))
                    .map(Integer::valueOf)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 입력하신 로또 번호를 확인해주세요. 입력한 로또 번호" + numbers);
        }
    }

}