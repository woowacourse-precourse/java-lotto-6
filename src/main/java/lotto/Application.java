package lotto;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.dto.ResponseDto.LottoGameResultDto;
import lotto.view.View;

public class Application {

    static LottoMachine lottoMachine = new LottoMachine();
    static View view = new View();

    public static void main(String[] args) {
        lottoGame();
    }

    private static void lottoGame(){
        purchaseLotto();
        createResult();
        view.close();
    }

    private static void createResult() {
        while (true){
            try {
                String winningNumber = view.inputWinningNumber();
                String bonusNumber = view.inputBonusNumber();

                LottoGameResultDto winningResult = lottoMachine.createWinningLotto(winningNumber,
                    bonusNumber);

                view.printWinningStatistics(winningResult);
                break;
            }catch (IllegalArgumentException illegalArgumentException){
                view.println(illegalArgumentException.getMessage());
            }
        }

    }

    private static void purchaseLotto() {
        while (true){
            try {
                String purchaseAmount = view.inputPurchaseAmount();
                List<List<Integer>> issuedLotto = lottoMachine.issuanceLotto(purchaseAmount);
                view.printIssuedLotto(issuedLotto);
                break;
            }catch (IllegalArgumentException illegalArgumentException){
                view.println(illegalArgumentException.getMessage());
            }
        }

    }
}
