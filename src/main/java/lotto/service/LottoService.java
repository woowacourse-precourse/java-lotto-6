package lotto.service;

public class LottoService {

    private static final Integer DIVIDE_STANDARD = 1000;

    public Integer purchaseLottoWithValidPrice(Integer inputMoney) {
        validateInputMoney(inputMoney);

        return inputMoney/DIVIDE_STANDARD;
    }

    private void validateInputMoney(Integer inputMoney) {
        if (!(inputMoney % DIVIDE_STANDARD == 0)) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }
}
