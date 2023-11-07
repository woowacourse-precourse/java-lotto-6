package UI;

import lotto.ExceptionMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputPriceAndCalculateLottoCount {
    int price;

    public int inputPrice(){
        int inputPrice;
        try{
            System.out.println("구입금액을 입력해 주세요.");
            inputPrice = Integer.parseInt(readLine());
            validLottoCount(inputPrice);
            price = inputPrice;
        }catch(IllegalArgumentException e) {
            System.out.println(ExceptionMessage.NOT_DIVDE_1000.label());
            inputPrice();
        }
        return price;
    }

    public int calculateLottoCount(){
        return price / 1000;
    }

    public void validLottoCount(int inputPrice){
        if (inputPrice % 1000 > 0) {
            throw new IllegalArgumentException();
        }
    }
}
