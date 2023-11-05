package lotto.application;

import camp.nextstep.edu.missionutils.Console;

public class IOService {
    private final String BEFORE_PURCHASE_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";

    private final String LOTTO_CNT_MESSAGE = "개를 구매했습니다.";
    private final String ERROR_INTEGER = "[ERROR] 구입 금액은 정수여야 합니다.";
    private final String ERROR_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야합니다.";


    private final String ERROR_MINIMUM = "[ERROR] 구입 금액이 1000원보다 작을 수는 없습니다.";
    public void printBeforePurchaseLottoMessage() {
        System.out.println(BEFORE_PURCHASE_LOTTO_MESSAGE);
    }

    public void printLottoCount(int cnt) {
        System.out.println(cnt + LOTTO_CNT_MESSAGE);
    }
    public long scanPurchaseAmount() {
        boolean success = true;
        String purchaseAmount;
        do {
            purchaseAmount = Console.readLine();

            success = validatePurchaseAmount(purchaseAmount);
        }while(!success);

        return Long.parseLong(purchaseAmount);
    }
    public boolean validatePurchaseAmount(String purchaseAmount) {
        try {
            validateLong(purchaseAmount);
            validateMinimum(purchaseAmount);
            validateUnit(purchaseAmount);
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    private void validateLong(String number){
        try {
            Long.parseLong(number);
        }
        catch (NumberFormatException e){
            System.out.println(ERROR_INTEGER);
            throw new IllegalArgumentException();
        }
    }

    private void validateMinimum(String number) {
        if (Long.parseLong(number) < 1000) {
            System.out.println(ERROR_MINIMUM);
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(String number) {
        if(!number.endsWith("000")) {
            System.out.println(ERROR_UNIT);
            throw new IllegalArgumentException();
        }
    }
}
