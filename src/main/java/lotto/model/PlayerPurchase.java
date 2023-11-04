package lotto.model;

public class PlayerPurchase {
    private static final int Lotto_Price = 1000;
    private int inputPrice; // 내가 입력한 금액

    public PlayerPurchase(String amount) { // 내가 입력했을 때 8000은 문자열
        int lotto_Price = convertToInt(amount);
        validatePriceCount(lotto_Price);
        this.inputPrice = lotto_Price;
    }


    // 구입 금액에서 1000을 나눔.
    public int calculateLottoCount() {
        return inputPrice / Lotto_Price;
    }

    private static int convertToInt(String amount) {
        return Integer.parseInt(amount);
    }

    private void validatePriceCount(int amount) {
        validateLottoPrice(amount);
        validateLottoCount(amount);
    }

    private void validateLottoPrice(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 한다");
        }
    }

    private void validateLottoCount(int amount) {
        if (amount % Lotto_Price != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다");
        }
    }
}
