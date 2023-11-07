package lotto.view;

import lotto.domain.Lottos;

public class OutputView {
    public void inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void announceMoney(long money){
        System.out.println(money/1000+"개를 구매했습니다.");
    }

    public void inputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottos(Lottos lottos){
        System.out.println(lottos);
    }
}
