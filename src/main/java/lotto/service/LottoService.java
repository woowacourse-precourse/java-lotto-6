package lotto.service;

public class LottoService {
    public static Integer inputNumberOfLotto(String price) {
        return validatePrice(price) / 1000;
    }

    private static Integer validatePrice(String price) {
        try {
            int tempPrice = Integer.parseInt(price);
            if (tempPrice % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
            }
            return tempPrice;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }
}
