package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoView lottoView = new LottoView();
        LottoService lottoService = new LottoService();

        lottoView.inputPrice();
        lottoView.inputValidate();
        lottoView.printNumber();
        for(int i=0; i< lottoView.number; i++){
            List<Integer> randomNumbers = lottoService.createLottoList();
            lottoView.printLottoList(randomNumbers);
        }
        lottoView.inputWinNumber();
        lottoService.saveWinNumber(lottoView.winNumber);
        lottoView.inputBonusNumber();
        lottoService.compareWinNumber(lottoService.lotto.getNumbers(),lottoView.bonusNumber);
        lottoView.printWin();
        lottoView.printProfit();

    }
}
