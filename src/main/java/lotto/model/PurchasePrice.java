package lotto.model;

import camp.nextstep.edu.missionutils.Console;

public class PurchasePrice {

    private final int PIECE_OF_LOTTO;
    private static final int LOTTO_PRICE_EACH = 1000;

    public PurchasePrice(String priceFromUser){

        isNotDigits(priceFromUser);
        isUnder1000(priceFromUser);
        isNotDivisibleBy1000(priceFromUser);
        this.PIECE_OF_LOTTO = Integer.parseInt(priceFromUser) / 1000;
    }

    public int getCountPieceOfLotto(){
        return this.PIECE_OF_LOTTO;
    }

    private void isUnder1000(String purchasePrice) throws IllegalArgumentException{
        if(Integer.parseInt(purchasePrice) < LOTTO_PRICE_EACH){
            throw new IllegalArgumentException("[ERROR] 로또 한장은 1000원입니다.");
        }
    }
    private void isNotDigits(String purchasePrice) throws IllegalArgumentException{
        try{
            if(purchasePrice.matches("[^0-9]")){
                throw new IllegalArgumentException("[ERROR] 올바른 금액을 입력해주세요.");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
    private void isNotDivisibleBy1000(String purchasePrice) throws IllegalArgumentException{
        if(Integer.parseInt(purchasePrice) % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }
}
