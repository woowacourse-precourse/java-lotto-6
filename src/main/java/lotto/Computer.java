package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    final String ASK_PRICE = "구입금액을 입력해 주세요.";

    final String ONLY_NUMBER_ERROR_MESSAGE = "[ERROR] 구입 금액은 숫자만 가능합니다.";
    final String AMOUNT_OF_MONEY_MUST_DIVIDED_THOUSAND = "[ERROR] 금액은 1000원 단위로 나누어 떨어져야합니다.";
    final int LOTTO_PRICE = 1000;
    final int LOTTO_NUMBER = 6;
    final int MIN_NUMBER = 1;
    final int MAX_NUMBER = 45;

    String getPriceFromUser(){
        System.out.println(ASK_PRICE);

        return Console.readLine();
    }

    void validatePrice(String input){
        int amount = 1;

        try{
            amount = Integer.parseInt(input);
        } catch (IllegalArgumentException e){
            System.out.println(ONLY_NUMBER_ERROR_MESSAGE);
        }


        if((amount % LOTTO_PRICE) != 0){
            throw new IllegalArgumentException(AMOUNT_OF_MONEY_MUST_DIVIDED_THOUSAND);
        }
    }

    int changeInputToInt(String input){
        return Integer.parseInt(input);
    }


    List<Lotto> buyLotto(int price){
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < (price % LOTTO_PRICE); i++){
            lottos.add(issueNewLotto());
        }

        return lottos;
    }

    Lotto issueNewLotto(){
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,LOTTO_NUMBER));
    }
}
