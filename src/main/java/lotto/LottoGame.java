package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    private LottoController lc;

    public void start(LottoGame lottoGame){
        lc = new LottoController();
        lc.makeLottoGameInstance(lottoGame);
        System.out.println("구입금액을 입력해 주세요.");
        boolean isValidated = lc.howMuchIsIt(Console.readLine());
        if(isValidated) buyLotto();
    }

    public void buyLotto(){
        String lottoList = lc.buyLotto();
        System.out.println(lottoList);
        pickWinningNumber();
    }

    public void pickWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.(,로 구분하여 숫자와 ,만 입력)");
        boolean isValidated = lc.pickWinningNumber(Console.readLine());
        if(isValidated) {
            pickBonusNumber();
        }
    }

    public void pickBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        boolean isValidated = lc.pickBonusNumber(Console.readLine());
        if(isValidated){
            printResult();
        }
    }

    public void printResult(){
        String result = lc.lottoResult();
        System.out.println(result);
        Console.close();
    }
}
