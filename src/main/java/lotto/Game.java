package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Game() {

    }

    void play() {
        System.out.println("구입금액을 입력해 주세요.");
        double purchaseAmount = Double.parseDouble(readLine());

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("1000원으로 나누어떨어지지 않습니다");
        }

        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("구입금액은 1000원 보다 커야합니다.");
        }
        int lottoNum = (int) (Math.round(purchaseAmount / 1000));

        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningNum = readLine().split(",");

        if (winningNum.length != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }

        List<Integer> nums = new ArrayList<>();
        try {
            for (String num : winningNum) {
                int number = Integer.parseInt(num);
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException("각 번호는 1~45사이 값이여야 합니다.");
                }
                if (nums.contains(number)) {
                    throw new IllegalArgumentException("중복된 번호가 존재합니다.");
                }
                nums.add(number);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수여야합니다.");
        }

        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int bonusNum = Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수여야합니다.");
        }
    }
}
