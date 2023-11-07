package lotto.view;

import java.util.List;
import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.entity.Lotto;

public class View {

    private final InputController inputController = new InputController();
    private final LottoController lottoController = new LottoController();

    public void main(){
        int money = inputController.getNumber();
        List<Integer> numbers = inputController.getNumbers();
        int bonus = inputController.getNumber();
        int count = lottoController.getCount(money);
        countView(count);
        List<Lotto> lottoGenerate = lottoController.lottoGenerate(count);
        lottoView(lottoGenerate);

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
