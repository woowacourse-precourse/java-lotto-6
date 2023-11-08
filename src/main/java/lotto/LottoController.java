package lotto;

import lotto.view.InputAmountOfMoney;
import lotto.view.InputWinningNumber;
import lotto.view.OutputView;

public class LottoController {
    private final InputAmountOfMoney inputAmountOfMoney;
    private final InputWinningNumber inputWinningNumber;
    private final OutputView outputView;
    private AllLottoNumbers allLottoNumbers;
    private LottoStatistics lottoStatistics;

    public LottoController() {
        this.inputAmountOfMoney = new InputAmountOfMoney();
        this.inputWinningNumber = new InputWinningNumber();
        this.outputView = new OutputView();
    }


    public void startLotto() {
        drawLotto();   //보너스 번호까지 입력함
        checkResult();
    }

    private void drawLotto() {
        outputView.print_Input_Amount_Of_Money();
        inputAmountOfMoney.Input();

        //input이 들어가기 전에 적용되어서 생긴 문제
        this.allLottoNumbers = new AllLottoNumbers(inputAmountOfMoney.getTotalLottoCount());

        int totalLottoCount = inputAmountOfMoney.getTotalLottoCount();
        outputView.print_How_Many_Buy(totalLottoCount);

        outputView.print_PurchasedLotto(allLottoNumbers.getAllLottoNumbers());

        outputView.print_INPUT_WINNING_NUMBER();
        inputWinningNumber.Input(); //당첨 + 보너스 넘버 입출력
    }

    private void checkResult() {
        this.lottoStatistics = new LottoStatistics(allLottoNumbers.getAllLottoNumbers(),
                inputWinningNumber.getWinningNumber(), inputAmountOfMoney.getAmountOfMoney());

        outputView.print_TotalPrize(lottoStatistics.getCount(), lottoStatistics.getProfitability());
    }
}
