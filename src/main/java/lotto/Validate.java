package lotto;

import java.util.List;

public class Validate {

    // 입력받은 금액이 1000원 단위가 아니면 예외 발생
    public void handleNonThousandUnit(String price) {
        try {
            Double.parseDouble(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        if (Double.parseDouble(price) % 1000 != 0.0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    // 당첨 번호가 숫자가 아니거나 6개가 아니거나 1~45의 범위가 아니면 예외 발생
    public void handleInvalidNumberCount(String sixNumber) {
        String replaceNumber = sixNumber.replace(",","");
        try {
            Long.parseLong(replaceNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        if (sixNumber.split(",").length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 번호를 입력해주세요.");
        }
        for (String number : sixNumber.split(",")) {
            if (Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45) {
                throw new IllegalArgumentException("[ERROR] 1 ~ 45의 번호를 입력해주세요.");
            }
        }
    }

    // 보너스 번호가 숫자가 아니거나 1~45의 범위가 아니면 예외 발생
    public void handleInvalidNumberInput(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
        if (Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45의 번호를 입력해주세요.");
        }
    }

    // 당첨 번호 중복이면 예외 발생
    public void handleDuplicateNumbers(List<Integer> winnerNumbers) {
        if (winnerNumbers.size() != winnerNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 번호는 중복되지 않게 입력해주세요.");
        }
    }

    // 보너스 번호 중복이면 예외 발생
    public void handleDuplicateNumbers(List<Integer> winnerNumbers, String bonusNumber) {
        if (winnerNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 번호는 중복되지 않게 입력해주세요.");
        }
    }
}
