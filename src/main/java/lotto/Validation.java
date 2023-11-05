package lotto;

public class Validation {

    public int parsePurchaseAmount(String userInput) {
        int inputMoney = 0;
        try {
            inputMoney = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 숫자가 아닌 입력입니다.");
        }

        return inputMoney;
    }

    public void validateUnderZero(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] : 0보다 큰 숫자를 입력해야 합니다.");
        }
    }

    public void validateDivideThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] : 입력 금액은 1000 단위여야 합니다.");
        }
    }

    public String[] validateWinNumbersFormat(String winNumbersInput) {
        String[] splitWinNumbersInput = winNumbersInput.split(",");
        if (splitWinNumbersInput.length != 6) {
            throw new IllegalArgumentException("[ERROR] : 당첨 번호는 6개여야 합니다.");
        }
        for (int i = 0; i < winNumbersInput.length(); i++) {
            if (!Character.isDigit(winNumbersInput.charAt(i)) && winNumbersInput.charAt(i) != ',') {
                throw new IllegalArgumentException("[ERROR] : 숫자, 구분자(,)만 입력 가능합니다.");
            }
        }
        return splitWinNumbersInput;
    }

    public int[] validateWinNumbersInRange(String[] splitWinNumbersInput) {
        int[] winNumbers = new int[6];
        for (int i = 0; i < splitWinNumbersInput.length; i++) {
            int temp = Integer.parseInt(splitWinNumbersInput[i]);
            if (temp < 0 || temp > 45) {
                throw new IllegalArgumentException("[ERROR] : 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            winNumbers[i] = temp;
        }
        return winNumbers;
    }

}
