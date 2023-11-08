package lotto.domain;

public record PlayerBuyPrice(String amount) {

    private static int MIN_AMOUNT = 1_000;
    private static int MAX_AMOUNT = 10_000_000;

    public PlayerBuyPrice {
        validateCharacterFromAmount(amount);
    }

    private void validateCharacterFromAmount(String input) {
        for (int idx = 0; idx < input.length(); idx++) {
            if (!Character.isDigit(input.charAt(idx))){
                throw new IllegalArgumentException("[ERROR] 구입 금액에 문자가 들어갈 수 없습니다. 구입 금액은 숫자만 입력해주세요.");
            }
        }
    }

}
