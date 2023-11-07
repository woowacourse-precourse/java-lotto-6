package lotto.v3.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoBonusNumberView {
    public int requestBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return parseBonusNumber(Console.readLine());
    }

    private int parseBonusNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 비어있습니다.");
        }

        int number;
        try {
            number = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
        }

        return number;
    }
}

