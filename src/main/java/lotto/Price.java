package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Price {
    private int price;

    public Price() {
        this.price = 0;
    }

    public int getPrice() {
        return price;
    }

    public int getTicket() {
        return price / 1000;
    }

    public void inputPrice() {
        while (true) {
            String input = Console.readLine();
            if (isValidPrice(input)) {
                this.price = parsePrice(input);
                break;
            }
        }
    }

    private boolean isValidPrice(String input) {
        try {
            validatePrice(input);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    private void validatePrice(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 금액은 문자를 제외한 숫자만 입력해 주세요.");
        }

        int price = parsePrice(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000 단위로 입력해 주세요.");
        }
    }

    private boolean isNumeric(String input) {
        try {
            parsePrice(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int parsePrice(String price) {
        return Integer.parseInt(price);
    }
}
