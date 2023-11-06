package lotto;

import lotto.Controller.PrintScreen;
import lotto.vo.issuanced.LottosNumber;
import lotto.service.generator.LottoIssuance;
import lotto.service.FindWinning;

public class LottoControl {
    LottoIssuance issuance = new LottoIssuance();
    PrintScreen print = new PrintScreen();
    FindWinning winning = new FindWinning();


    public void run() {
        LottoIssuancePrograss();
        LottoWinningPrograss();
    }

    private void LottoIssuancePrograss() {
        issuance.Issuance();
        print.PrintLottoIssuance();
    }

    private void LottoWinningPrograss() {
        winning.FindLottoWinning(LottosNumber.GetLottos(), winning);
    }
}
