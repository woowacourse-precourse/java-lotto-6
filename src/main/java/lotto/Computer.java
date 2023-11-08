package lotto;

public class Computer {
    final String ASK_PRICE = "구입금액을 입력해 주세요.";
    final String ONLY_NUMBER_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자만 가능합니다.";
    final String PRICE_MUST_DIVIDED_THOUSAND = "[ERROR] 금액은 1000원 단위로 나누어 떨어져야합니다."
    String getPriceFromUser(){
        System.out.println(ASK_PRICE);

        return camp.nextstep.edu.missionutils.Console.readLine();
    }

    void validatePrice(String input){
        int price = 1;

        try{
            price = Integer.parseInt(input);
        } catch (IllegalArgumentException e){
            System.out.println(ONLY_NUMBER_ERROR_MESSAGE);
        }


        if((price % 1000) != 0){
            throw new IllegalArgumentException(PRICE_MUST_DIVIDED_THOUSAND);
        }
    }
}
