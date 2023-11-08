package lotto.controller;
import static lotto.domain.LottoAmount.priceCalculation;
import static lotto.domain.LottoAmount.purchaseAmountValidate;
import static lotto.view.OutputView.howManyLotto;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoNumbers;

public class LottoController {
    public static int ticketCount = 0;

    private static List<Integer> lotto = new ArrayList<>();
    private static List<Lotto> lottoList;
    private static List<Integer> userNumber = new ArrayList<>();

    public static void run(){
        userInputLottoAmount();
        setLotto();
    }
    public static void userInputLottoAmount(){
        purchaseAmountValidate();
        ticketCount = priceCalculation();
        System.out.println(howManyLotto(ticketCount));
    }

    public static void setLotto(){
        lottoList = createLottoNumbers(ticketCount);
//        userNumber = userNumber();
    }

    public static List<Lotto> createLottoNumbers(int ticketCount) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoList.add(createLotto());
        }
        return lottoList;
    }

    public static Lotto createLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lotto = new ArrayList<>();

        lotto = lottoNumbers.setRandomNumbers();
        System.out.println(lotto);
        return new Lotto(lotto);
    }


    public static void userInputLottoNumber(){

    }
}
