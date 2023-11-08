package lotto;

import lotto.dto.LottoPurchaseDto;
import lotto.dto.WinningLottoNumberDto;
import lotto.utils.InputUtils;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        LottoPurchaseDto lottoPurchase = lottoMachine.purchase();
        List<Lotto> lottos = lottoMachine.publish(lottoPurchase.getQuantity());

        WinningLottoNumberDto winningLottoNumber = InputUtils.getWinningLottoNumber();

        WinningCheck winningCheck = new WinningCheck();
        winningCheck.check(lottos, winningLottoNumber, lottoPurchase);
    }
}
