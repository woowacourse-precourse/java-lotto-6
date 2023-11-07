package lotto.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Global.LottoResult;
import lotto.Global.PrintPhrase;

public class View {
    private InputView inputView;
    private OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void printErrorMessage(String message) {
        outputView.printPhrase(message);
    }

    public int getLottoBuyAmout() {
        outputView.printPhrase(PrintPhrase.PURCHASE_INPUT.getPhrase());
        return inputView.SingleNumberInput();
    }

    public void putLottoSellResult(List<String> lottos) {
        outputView.printPhrase(LottoResult.PURCHASE_RESULT.getResultState(lottos.size()));
        outputView.printMultiplePhrase(lottos);
    }

    public List<Integer> getWinningLottoNumber(int length) {
        outputView.printPhrase(PrintPhrase.WINNER_NUMBER_INPUT.getPhrase());
        return inputView.NumberListSplitInput(length);
    }

    public int getBonusLottoNumber() {
        outputView.printPhrase(PrintPhrase.BONUS_NUMBER_INPUT.getPhrase());
        return inputView.SingleNumberInput();
    }

    public void putLottoResult(HashMap<String, Integer> result, float rateOfResult) {
        outputView.printPhrase(PrintPhrase.WINNING_INFORMATION_OUTPUT.getPhrase());
        outputView.printMultiplePhrase(getLottoResultPhrase(result, rateOfResult));
    }

    private List<String> getLottoResultPhrase(HashMap<String, Integer> lottoResult, float rateOfResult) {
        List<String> result = new ArrayList<>();
        List<LottoResult> resultType = List.of(LottoResult.FIFTH_RESULT, LottoResult.FOURTH_RESULT,
                LottoResult.THIRD_RESULT, LottoResult.SECOND_RESULT, LottoResult.FIRST_RESULT);
        for (LottoResult type : resultType) {
            result.add(type.getResultState(lottoResult.get(type.getName())));
        }
        result.add(LottoResult.RATE_OF_RETURN_RESULT.getResultState(rateOfResult));
        return result;
    }

}
