package lotto.Input;

public class BonusNumber {
    private static int number;

    public static int takeInput() {
        do {
            String input = camp.nextstep.edu.missionutils.Console.readLine();
            if (makeNumber(input)) {
                break;
            }
        } while (true);
        return number;
    }

    private static boolean makeNumber(String input) {
        try {
            RangeCheck.validateRange(input);
            number = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return false;
        }
        return true;
    }
}
