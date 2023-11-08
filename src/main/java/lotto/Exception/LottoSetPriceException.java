package lotto.Exception;

public class LottoSetPriceException {

    public int checkPriceException(String initialPrice) {
        try {
            int price = Integer.parseInt(initialPrice);
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }
}
