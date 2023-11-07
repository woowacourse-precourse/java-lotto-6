package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoAmountofMoney;
import lotto.model.RandomLottos;

public class DisplayOutput {

    private final String OUTPUTLOTTOAMOUNTOFMONEY = "구입금액을 입력해 주세요.";
    private final String OUTPUTANSWERNUMBER = "당첨 번호를 입력해 주세요.";
    private final String OUTPUTBONUSNUMBER = "보너스 번호를 입력해 주세요.";

    public void outputLottoAmountofMoney() {
        System.out.println(OUTPUTLOTTOAMOUNTOFMONEY);
    }

    public void outputAnswerLotto() {
        System.out.println(OUTPUTANSWERNUMBER);
    }

    public void outputBonusNumber() {
        System.out.println(OUTPUTBONUSNUMBER);
    }

    public void outputRandomLottos(RandomLottos randomLottos, LottoAmountofMoney lottoAmountofMoney) {
        System.out.printf("%d개를 구매했습니다.\n", lottoAmountofMoney.getLottoAmountofMoney() / 1000);
        int randomLottoNumbers = randomLottos.getRandomLottos().size();
        List<Lotto> randomLotto = randomLottos.getRandomLottos();
        for (int i = 0; i < randomLottoNumbers; i++) {
            System.out.println(randomLotto.get(i).getLotto().toString());
        }
    }

    public void outputWinningStatics(HashMap<String, Integer> winningStatics) {
//        for (String grade : winningStatics.keySet()) {
//            System.out.println(grade + " " + winningStatics.get(grade).toString());
//        }
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %s개\n", winningStatics.get("FIFTH"));
        System.out.printf("4개 일치 (50,000원) - %s개\n", winningStatics.get("FOURTH"));
        System.out.printf("5개 일치 (1,500,000원) - %s개\n", winningStatics.get("THIRD"));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n", winningStatics.get("SECOND"));
        System.out.printf("6개 일치 (2,000,000,000원) - %s개\n", winningStatics.get("FIRST"));
    }

    public void outputWinningReward(Double winningReward) {
        System.out.printf("총 수익률은 %s%c입니다.", String.format("%.1f", winningReward), '%');
    }
}
