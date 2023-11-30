package View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String price() {
        String price = null;
        try {
            price = Console.readLine();
        } catch (Exception e) {
        }
        return price;
    }

    public String prizeNumber() {
        String prizeNumber = null;
        try {
            prizeNumber = Console.readLine();
            noComma(prizeNumber);
        } catch (Exception e) {
        }
        return prizeNumber;
    }

    private void noComma(String prizeNumber) {
        if (prizeNumber.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 입력하신 번호가 ,로 나누어져있지 않습니다.");
        }
    }

    public String bonusNumber() {
        String bonusNumber = null;
        try {
            bonusNumber = Console.readLine();
        } catch (Exception e) {
        }
        return bonusNumber;
    }
}
