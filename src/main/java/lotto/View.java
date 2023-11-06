package lotto;

public class View {

    void printAskMoneyInput(){

        String askInputMoney= "구입금액을 입력해 주세요.";
        System.out.println(askInputMoney);
    }

    void printPurchasedLottoAmount(int number){

        String askInputMoney= "개를 구매했습니다.";

        System.out.println("\n"+number+askInputMoney);
    }

    void printPurchasedLottoNumbers(Lotto lotto){

        System.out.println(lotto.getNumbers());
    }
    
    void printAskWinningNumber(){
        
        String askWinningNumber = "\n당첨 번호를 입력해 주세요.";

        System.out.println(askWinningNumber);
    }

    void printAskBonusNumber(){

        String asKBonusNumber = "\n보너스 번호를 입력해 주세요.";

        System.out.println(asKBonusNumber);
    }
}
