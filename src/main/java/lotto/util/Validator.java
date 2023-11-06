package lotto.util;

public class Validator {
    public static void validateInputAmount(String amount){
        try{
            Integer.parseInt(amount);
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 올바른 금액을 입력하세요.");
            return;
        }
        if(Integer.parseInt(amount) < 1000 && Integer.parseInt(amount) >=0 ){
            throw new IllegalArgumentException("[ERROR] 1000원 이상부터 구매가 가능합니다");
        }
    }
}
