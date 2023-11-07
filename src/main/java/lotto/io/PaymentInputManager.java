package lotto.io;

import java.util.NoSuchElementException;

public class PaymentInputManager extends InputManager<Integer> {
    private static PaymentInputManager INSTANCE;

    private PaymentInputManager() {
    }

    public static PaymentInputManager getInstance() {
        if (INSTANCE == null) INSTANCE = new PaymentInputManager();
        return INSTANCE;
    }


    @Override
    public Integer input() {
        while (true) {
            try {
                String inputLine = consoleAdapter.readLine();
                return validation(inputLine);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
            } catch (NoSuchElementException e) {
                throw new IllegalArgumentException("[ERROR] 입력이 존재하지 않습니다.");
            }
        }
    }

    @Override
    public Integer validation(String inputLine) throws NumberFormatException {
        int money = Integer.parseInt(inputLine);
        if (money % 1000 != 0 || money / 1000 == 0) throw new IllegalArgumentException();
        return money;
    }
}
