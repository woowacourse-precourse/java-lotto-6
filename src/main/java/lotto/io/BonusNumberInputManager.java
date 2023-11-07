package lotto.io;

import java.util.NoSuchElementException;

public class BonusNumberInputManager extends InputManager<Integer> {
    private static BonusNumberInputManager INSTANCE;

    private BonusNumberInputManager() {
    }

    public static BonusNumberInputManager getInstance() {
        if (INSTANCE == null) INSTANCE = new BonusNumberInputManager();
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
            } catch (NoSuchElementException e) {
                throw new IllegalArgumentException("[ERROR] 입력이 존재하지 않습니다.");
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("[ERROR] 1~45 범위 내의 값을 입력해주세요.");
            }
        }
    }

    @Override
    public Integer validation(String input) throws IndexOutOfBoundsException {
        int bonusNumber = Integer.parseInt(input);
        validateNumberRange(bonusNumber);
        return bonusNumber;
    }
}
