package lotto;

import java.util.List;
import lotto.util.LottoRandomNumbersGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        int lottoPurchaseAmount = InputView.getLottoPurchaseAmount();

        List<Lotto> lottoNumbers = LottoRandomNumbersGenerator.generateLottoNumbers(lottoPurchaseAmount);
        OutputView.printLottoNumbersByPurchaseAmount(lottoNumbers);





    }
}
