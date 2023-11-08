package lotto.view;

import java.util.List;
import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.entity.Lotto;

public class View {

    private final InputController inputController = new InputController();
    private final LottoController lottoController = new LottoController();

    public void main(){
        System.out.println("구입 금액을 입력해 주세요.");
        int money = inputController.getNumber();

        int count = lottoController.getCount(money);
        countView(count);
        List<Lotto> lottoGenerate = lottoController.lottoGenerate(count);
        lottoView(lottoGenerate);

        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = inputController.getNumbers();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = inputController.getNumber();
        
    }

    public void countView(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public void lottoView(List<Lotto> lottos){
         for(Lotto lotto : lottos){
             System.out.println(lotto.getNumbers().toString());
         }
    }



}
