package lotto;

public class Validator {
    public static void buyCheck(String inputText) {
        try {
            int price = Integer.parseInt(inputText);
            if (price % 1000 != 0) {
                System.out.println("[ERROR] 1000원 단위로 입력해 주세요.");
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 정수만 입력해 주세요.");
            throw new IllegalArgumentException("[ERROR] 정수만 입력해 주세요.");
        }
    }
}
