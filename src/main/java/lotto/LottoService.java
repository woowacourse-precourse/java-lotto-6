package lotto;

import user.User;

import java.util.List;

public class LottoService {
    private final int LOTTO_PRICE = 1000;
    private final User user = new User();

    public LottoService() {
    }

    public void run() {
        Output.printGameStartMessage();
        int userMoney = user.inputMoney();
        int numberOfLottoes = userMoney / LOTTO_PRICE;

        Output.printUserMoney(userMoney);
        Output.printNumberOfLottoes(numberOfLottoes);

        List<Lotto> lottos = LottoGenerator.generateLottos(numberOfLottoes);
        for (Lotto lotto : lottos) {
            Output.printLottoSixNumbers(lotto);
        }

        Output.printLottoNumbersMessage();
        List<String> sixLottoNumbers = user.inputSixLottoNumbers();
        Output.printLottoNumbers(sixLottoNumbers);

        Output.printBonusNumberMessage();
        String bonusNumber = user.inputBonusNumber();
        Output.printBonusNumber(bonusNumber);

        LottoResultChecker lottoResultChecker = new LottoResultChecker(lottos, sixLottoNumbers, bonusNumber);
        lottoResultChecker.calculator();

        ReturnCalculator returnCalculator = new ReturnCalculator(lottoResultChecker.lottoResult);
        returnCalculator.calculrator();

        Output.printReturn(returnCalculator.totalWinningAmount, userMoney);
    }
}
