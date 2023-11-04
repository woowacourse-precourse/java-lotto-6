package lotto.domain.model;

public class LottoSaleSystem {

    private int purchaseMoney;
    private int purchaseCount;

    public void isValidMoney(String input) {
        try {
            int purchaseMoney = Integer.parseInt(input);
            isValidMoneyUnit(purchaseMoney);
            this.purchaseMoney = purchaseMoney;
            this.purchaseCount = purchaseMoney / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    // 구매 금액이 1000원 단위인지 검사
    private void isValidMoneyUnit(int purchaseMoney) {
        if (purchaseMoney <= 0 || purchaseMoney % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해 주세요.");
        }
    }

}
