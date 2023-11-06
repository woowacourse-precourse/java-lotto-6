package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class inputPriceAndCalculateLottoCount {
    int price;

    int inputPrice(){
        int inputPrice;
        try{
            System.out.println("구입금액을 입력해 주세요.");
            inputPrice = Integer.parseInt(readLine());
            validLottoCount(inputPrice);
            price = inputPrice;
        }catch(IllegalArgumentException e) {
            System.out.println("금액은 1000원 단위여야 합니다");
            inputPrice();
        }
        return price;
    }

    int calculateLottoCount(){
        return price / 1000;
    }

    void validLottoCount(int inputPrice){
        if (inputPrice % 1000 > 0) {
            throw new IllegalArgumentException("[Error]");
        }
    }
}
