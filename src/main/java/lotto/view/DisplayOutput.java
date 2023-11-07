package lotto.view;

import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
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
    public void outputRandomLottos(RandomLottos randomLottos){
        int randomLottoNumbers = randomLottos.getRandomLottos().size();
        List<Lotto> randomLotto = randomLottos.getRandomLottos();
        for(int i=0; i<randomLottoNumbers; i++){
            //String lottoOutput = String.join( ",",randomLotto.get(i).getLotto().toString());
            System.out.println(randomLotto.get(i).getLotto().toString());
        }
    }
    public void outputWinningStatics(HashMap<String, Integer> winningStatics){
        for(String grade : winningStatics.keySet()){
            System.out.println(grade +" "+ winningStatics.get(grade).toString());
        }
    }

    public void outputWinningReward(Double winningReward) {
        System.out.println("winningReward = " + winningReward);
    }
}
