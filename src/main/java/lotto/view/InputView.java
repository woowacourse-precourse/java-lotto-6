package lotto.view;

public class InputView {
    private final String DELIMITER = ",";

    public long validateCustomerMoneyInput(final String moneyInput) {
        if (moneyInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }

        moneyInput.chars().forEach(o -> {
            if (!Character.isDigit(o)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
            }
        });

        return Long.parseLong(moneyInput);
    }

    public String[] validateWinningNumberInput(final String winningNumberInput) {
        if (winningNumberInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
        if (!winningNumberInput.contains(",")) {
            throw new IllegalArgumentException("[ERROR] ','로 구분해주시길 바랍니다.");
        }

        String[] splitByDelimiter = this.validateEachWinningNumberInput(winningNumberInput);

        return splitByDelimiter;
    }

    public String[] validateEachWinningNumberInput(final String winningNumberInput) {
        String[] splitByDelimiter = winningNumberInput.split(DELIMITER);

        for (String eachWinningNumber : splitByDelimiter) {
            if (eachWinningNumber.chars().anyMatch(c -> !Character.isDigit((char) c))) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
            }
        }

        return splitByDelimiter;
    }

    public int validateBonusNumberInput(final String bonusNumberInput) {
        if (bonusNumberInput.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
        if (bonusNumberInput.chars().anyMatch(c -> !Character.isDigit((char) c))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }

        int bonusNumber = Integer.parseInt(bonusNumberInput);

        return bonusNumber;
    }
}
