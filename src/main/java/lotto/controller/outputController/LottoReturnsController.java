
package lotto.controller.outputController;


import lotto.view.outputView.LottoReturnsOutput;



public class LottoReturnsController {
    private final LottoReturnsOutput returnsOutput;

    public LottoReturnsController(LottoReturnsOutput returnsOutput) {
        this.returnsOutput = returnsOutput;
    }

    public void displayReturnRate(double returnRate) {
        returnsOutput.displayReturnRate(returnRate);
    }
}
