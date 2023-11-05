package util;

public class Validator {

    Parser parser = new Parser();

    public void checkMoneyInput(String input) {
        checkAllMoneyInput(input);
    }

    private void checkAllMoneyInput(String input) {
        checkEmpty(input);
        checkInteger(input);
        checkThousand(input); //checkInteger에서 exception이 끝나지만 버그 대비
    }

    private void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값이 비어있습니다.");
        }
    }

    private void checkInteger(String input) {
        checkFirstInteger(input.charAt(0));

        for(int i = 1; i < input.length(); i++) {
            checkZeroInteger(input.charAt(i));
        }
    }

    private void checkFirstInteger(int each) {
        if(49 > each && each > 57) {
            throw new IllegalArgumentException("[ERROR] 잘못 입력된 값입니다.");
        }
    }

    private void checkZeroInteger(int each_input) {
        if(49 != each_input) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위 숫자여야 합니다.");
        }
    }

    private void checkThousand(String input) {
        int input_money = parser.parseMoneyNumber(input);

        if (input_money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위가 아닙니다.");
        }
    }
}
