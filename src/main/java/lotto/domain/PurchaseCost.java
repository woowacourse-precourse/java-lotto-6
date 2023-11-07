package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseCost {

    private final long purchaseCost;

    public PurchaseCost(String purchaseCost) {
        try{
            validateNumber(purchaseCost);
            validateNegativeNumber(purchaseCost);
            validateNumberUnit(purchaseCost);
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            new PurchaseCost(Console.readLine());
        }

        this.purchaseCost = Long.parseLong(purchaseCost)/1000;
    }


    // 숫자가 아닌 경우
    public void validateNumber(String purchaseCost) {
        try {
            long num = Long.parseLong(purchaseCost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자가 아닙니다.");
        }


    }

    public void validateNegativeNumber(String purchaseCost){
        // 로또 구입 금액이 0보다 작거나 같은 경우
        if(Long.parseLong(purchaseCost) <= 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액이 0이하입니다.");
        }
    }

    // 입력받은 로또 구입 금액을 1000천 단위로 입력 받지 않은 경우
    public void validateNumberUnit(String purchaseCost){
        if(Long.parseLong(purchaseCost)%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력하세요.");
        }
    }


    public long getPurchaseCost() {
        return purchaseCost;
    }
}
