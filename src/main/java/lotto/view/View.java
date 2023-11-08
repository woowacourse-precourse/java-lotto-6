package lotto.view;

import java.util.List;
import lotto.controller.InputController;
import lotto.controller.LottoController;
import lotto.entity.Lotto;
import lotto.entity.LottoScore;

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
        List<Integer> results = inputController.getNumbers();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = inputController.getNumber();

        System.out.println("당첨통계");
        System.out.println("---");
        LottoScore lottoScore = lottoController.lottoScore(results, lottoGenerate, bonus);
        scoreView(lottoScore);

    }

    public void countView(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public void lottoView(List<Lotto> lottos){
         for(Lotto lotto : lottos){
             System.out.println(lotto.getNumbers().toString());
         }
    }
    public void scoreView(LottoScore lottoScore){
        System.out.println("3개 일치 (5,000원): " + lottoScore.getCorrect3() + "개");
        System.out.println("4개 일치 (50,000원): " + lottoScore.getCorrect4() + "개");
        System.out.println("5개 일치 (1,500,000원): " + lottoScore.getCorrect5() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원): " + lottoScore.getCorrect5Bonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원): " + lottoScore.getCorrect6() + "개");
    }

}
