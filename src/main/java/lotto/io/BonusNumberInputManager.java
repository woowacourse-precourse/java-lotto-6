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
        Integer result = null;
        try {
             result = setResult();
         } catch (IllegalArgumentException e) {
             System.out.println(e.getMessage());
             result=setResult();
         }
        return result;
    }

    private Integer setResult() {
        Integer result;
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputLine = consoleAdapter.readLine();
        result=validation(inputLine);
        return result;
    }

    @Override
    public Integer validation(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);
            validateNumberRange(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
