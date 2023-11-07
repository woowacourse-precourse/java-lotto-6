package View.Concrete;

import View.InputView;

public class InputTextView implements InputView {
    public void introduceMoneyInput(){
        System.out.println("구입금액을 입력해 주세요");
    }

    public void introduceWinningNumberInput(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void introduceBonusNumberInput(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
