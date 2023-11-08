package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoGame {

    private int purchaseAmount;
    private int numberOfPurchase;

    public void start() {
        System.out.println("구입 금액을 입력해주세요.");
        inputPurchaseAmount();
        printNumberOfPurchase();
        printRandomLottoNumber();

    }

    private void inputPurchaseAmount() {
        setPurchaseAmount(Integer.parseInt(readLine()));
    }

    private void setPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("1000원 단위로만 입력이 가능합니다.");
        } else if (purchaseAmount % 10 == 0) {
            this.purchaseAmount = purchaseAmount;
            this.numberOfPurchase = purchaseAmount / 1000;
        }
    }

    private void checkPurchaseAmount() {
        if (this.purchaseAmount % 10 != 0) {
            throw new IllegalArgumentException("1000원 단위로만 입력이 가능합니다.");
        }
    }

    private int getNumberOfPurchase() {
        return this.numberOfPurchase;
    }

    public void setNumberOfPurchase() {
        if (this.purchaseAmount % 10 == 0) {
            this.numberOfPurchase = purchaseAmount / 1000;
        }
    }

    private void printNumberOfPurchase() {
        System.out.println(getNumberOfPurchase() + "개를 구매했습니다.");
    }

    private void printRandomLottoNumber() {

    }
}
