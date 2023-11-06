package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class PaymentInputManager extends InputManager<Integer> {
    private static PaymentInputManager INSTANCE;

    public static PaymentInputManager getInstance() {
        return INSTANCE;
    }


    @Override
    public Integer input() {
        while (true) {
            try {
                String inputLine = consoleAdapter.readLine();
                return validation(inputLine) / 1000;
            } catch (NumberFormatException | NoSuchElementException e) {
                throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
            } catch (IllegalStateException e) {
                throw new IllegalArgumentException("[ERROR] Scanner is closed.");
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
