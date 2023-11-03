package verifier;

public class WinnerNumberVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumberCount(input);
        checkEachNumeric(input);
        checkEachRange(input);
    }

    private void checkEachNumeric(String input) {
        String[] numbers = input.split(",");
        for (String number : numbers) {
            try {
                Integer.parseInt(number);
            } catch (Exception e) {
                throw new IllegalArgumentException("입력된 값은 숫자가 아닙니다.");
            }
        }
    }

    private void checkNumberCount(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("당첨번호는 6개의 숫자가 아닙니다.");
        }
    }

    private void checkEachRange(String input) {
        String[] inputs = input.split(",");
        for (String num : inputs) {
            int number = Integer.parseInt(num);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또번호는 1~45사이의 숫자이어야 합니다.");
            }
        }
    }

}
