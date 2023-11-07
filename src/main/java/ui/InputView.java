package ui;

import camp.nextstep.edu.missionutils.Console;

class InputView {
    private InputView() {
    }

    /**
     * @return 로또 장 수
     */
    public static int getMoney() {
        String input = Console.readLine();
        int money;
        try {
            money = Integer.parseInt(input);

            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 금액입니다.", e);
        }
        return money;
    }
}
