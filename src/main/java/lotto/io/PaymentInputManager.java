package lotto.io;

import static java.text.MessageFormat.format;

public class PaymentInputManager extends InputManager<Integer> {
    private static PaymentInputManager INSTANCE;

    private PaymentInputManager() {
    }

    public static PaymentInputManager getInstance() {
        if (INSTANCE == null) INSTANCE = new PaymentInputManager();
        return INSTANCE;
    }


    @Override
    public Integer input() throws IllegalArgumentException{
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputLine = consoleAdapter.readLine();
                return validation(inputLine) / 1000;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public Integer validation(String inputLine) throws IllegalArgumentException {
        int money;
        try {
            money = Integer.parseInt(inputLine);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        if (money % 1000 != 0 || money / 1000 == 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
        System.out.println(format("{0}개를 구매했습니다.", money / 1000));
        return money;
    }
}
