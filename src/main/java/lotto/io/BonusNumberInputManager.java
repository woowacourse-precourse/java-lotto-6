package lotto.io;

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
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputLine = consoleAdapter.readLine();
                return validation(inputLine);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public Integer validation(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            validateNumberRange(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
