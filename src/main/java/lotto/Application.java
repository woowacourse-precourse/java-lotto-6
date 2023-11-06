package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoProgram lottoProgram = new LottoProgram();

        List<Lotto> lottos = lottoProgram.buyLottos();
        List<Integer> winningNumbers = lottoProgram.inputWinningNumbers();
        int bonus = lottoProgram.inputBonus(winningNumbers);

        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonus);

        lottoProgram.showLottoResult(winningNumber, lottos);
    }
}
