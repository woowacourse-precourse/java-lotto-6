package lotto.view;

import static lotto.constant.Format.DOUBLEFORMAT;
import static lotto.constant.Message.OUTPUTANSWERNUMBER;
import static lotto.constant.Message.OUTPUTBONUSNUMBER;
import static lotto.constant.Message.OUTPUTBUYINGMESSAGE;
import static lotto.constant.Message.OUTPUTFIFTHRANK;
import static lotto.constant.Message.OUTPUTFIRSTRANK;
import static lotto.constant.Message.OUTPUTFOURTHRANK;
import static lotto.constant.Message.OUTPUTLOTTOAMOUNTOFMONEY;
import static lotto.constant.Message.OUTPUTSECONDRANK;
import static lotto.constant.Message.OUTPUTTHIRDRANK;
import static lotto.constant.Message.OUTPUTWINNINGREWARDRATE;
import static lotto.constant.Message.OUTPUTWINNINGSTATIC;
import static lotto.constant.Rank.FIFTHRANK;
import static lotto.constant.Rank.FIRSTRANK;
import static lotto.constant.Rank.FOURTHRANK;
import static lotto.constant.Rank.SECONDRANK;
import static lotto.constant.Rank.THIRDRANK;

import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoAmountofMoney;
import lotto.model.RandomLottos;

public class DisplayOutput {

    public void outputLottoAmountofMoney() {
        System.out.println(OUTPUTLOTTOAMOUNTOFMONEY.getValue());
    }

    public void outputAnswerLotto() {
        System.out.println(OUTPUTANSWERNUMBER.getValue());
    }

    public void outputBonusNumber() {
        System.out.println(OUTPUTBONUSNUMBER.getValue());
    }

    public void outputRandomLottos(RandomLottos randomLottos, LottoAmountofMoney lottoAmountofMoney) {
        System.out.printf(OUTPUTBUYINGMESSAGE.getValue(), lottoAmountofMoney.getLottoAmountofMoney() / 1000);
        int randomLottoNumbers = randomLottos.getRandomLottos().size();
        List<Lotto> randomLotto = randomLottos.getRandomLottos();
        for (int i = 0; i < randomLottoNumbers; i++) {
            System.out.println(randomLotto.get(i).getLotto().toString());
        }
    }

    public void outputWinningStatics(HashMap<String, Integer> winningStatics) {
        System.out.println(OUTPUTWINNINGSTATIC.getValue());
        System.out.printf(OUTPUTFIFTHRANK.getValue(), winningStatics.get(FIFTHRANK.getValue()));
        System.out.printf(OUTPUTFOURTHRANK.getValue(), winningStatics.get(FOURTHRANK.getValue()));
        System.out.printf(OUTPUTTHIRDRANK.getValue(), winningStatics.get(THIRDRANK.getValue()));
        System.out.printf(OUTPUTSECONDRANK.getValue(), winningStatics.get(SECONDRANK.getValue()));
        System.out.printf(OUTPUTFIRSTRANK.getValue(), winningStatics.get(FIRSTRANK.getValue()));
    }

    public void outputWinningReward(Double winningReward) {
        System.out.printf(OUTPUTWINNINGREWARDRATE.getValue(), String.format(DOUBLEFORMAT.getValue(), winningReward),
                '%');
    }
}
