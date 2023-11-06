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

        WinningCheckMachine winningCheckMachine = new WinningCheckMachine();
        winningCheckMachine.check(lottos, winningLottoNumber, lottoPurchase);
    }
}
