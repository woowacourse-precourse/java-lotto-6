package lotto.service;

public class LottoService {
    public static Integer inputPrice(String price) {
        return validatePrice(price) / 1000;
    }

    private static Integer validatePrice(String price) {
        int tempPrice = Integer.parseInt(price);
        if (tempPrice % 1000 == 0) {
            return tempPrice;
        }
        throw new IllegalArgumentException("잘못된 숫자");
    }


}
