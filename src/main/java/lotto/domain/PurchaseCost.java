package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class PurchaseCost {

    private long purchaseCost;
    /**
     * 구입 금액 검증 후, 저장 -> 이후, 로또 구입개수를 결정하는데 사용하기 위해 1000으로 나누어서 저장함
     */
    public PurchaseCost(String purchaseCost) {
        try{
            validateNumber(purchaseCost);
            validateNegativeNumber(purchaseCost);
            validateNumberUnit(purchaseCost);
            this.purchaseCost = Long.parseLong(purchaseCost)/1000;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            new PurchaseCost(Console.readLine());
        }
    }


    /**
     * 숫자 인지 검증
     */
    public void validateNumber(String purchaseCost) {
        try {
            long num = Long.parseLong(purchaseCost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자가 아닙니다.");
        }
    }


    /**
     * 로또 구입 금액이 0이하인지 검증
     */
    public void validateNegativeNumber(String purchaseCost){
        if(Long.parseLong(purchaseCost) <= 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액이 0이하입니다.");
        }
    }

    /**
     * 1000단위로 입력 받았는지 검증
     */
    public void validateNumberUnit(String purchaseCost){
        if(Long.parseLong(purchaseCost)%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력하세요.");
        }
    }

    public long getPurchaseCost() {
        return purchaseCost;
    }
}