package lotto.domain;


import camp.nextstep.edu.missionutils.Console;

public class LottoGameMachine {


    public int insertLottoPayment(){
        int insertAmount;
        System.out.println("구매 금액을 입력해 주세요.");
        // 구입 금액을 입력받는다.
        insertAmount = Integer.parseInt(Console.readLine());
        // 금액이 1000 단위인지 검사한다.
        validateLottoPayment(insertAmount);
        return 0;
    }

    public void validateLottoPayment(int insertAmount){
        if(insertAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해주세요.");
        }

    }

    public void issueLotto(int NumberOfIssuingLotto){

    }

    public void arrangeAscendingOrder(){

    }

    public void createNumbers() {

    }

    public void insertWinningNumber() {

    }

    public void insertBonusNumber() {

    }

    public void compareNumbers() {

    }
    public void printResult() {

    }


}
