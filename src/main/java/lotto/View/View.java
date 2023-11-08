package lotto.View;

import static lotto.Global.PrintPhrase.BONUS_NUMBER_INPUT;
import static lotto.Global.PrintPhrase.PURCHASE_INPUT;
import static lotto.Global.PrintPhrase.PURCHASE_RESULT;
import static lotto.Global.PrintPhrase.RATE_OF_RETURN_RESULT;
import static lotto.Global.PrintPhrase.WINNER_NUMBER_INPUT;
import static lotto.Global.PrintPhrase.WINNING_INFORMATION_OUTPUT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Global.LottoResult;

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
        outputView.printPhrase(PURCHASE_INPUT.getPhrase());
        return inputView.singleNumberInput();
    }

    private void putSpacing() {
        outputView.printPhrase("");
    }

    public void putLottoSellResult(List<String> lottos) {
        putSpacing();
        outputView.printPhrase(PURCHASE_RESULT.getResultState(lottos.size()));
        outputView.printMultiplePhrase(lottos);
    }

    public List<Integer> getWinningLottoNumber(int length) {
        putSpacing();
        outputView.printPhrase(WINNER_NUMBER_INPUT.getPhrase());
        return inputView.numberListSplitInput(length);
    }

    public int getBonusLottoNumber() {
        putSpacing();
        outputView.printPhrase(BONUS_NUMBER_INPUT.getPhrase());
        return inputView.singleNumberInput();
    }

    public void putLottoResult(HashMap<String, Integer> result, float rateOfResult) {
        putSpacing();
        outputView.printPhrase(WINNING_INFORMATION_OUTPUT.getPhrase());
        outputView.printMultiplePhrase(getLottoResultPhrase(result, rateOfResult));
    }

    private List<String> getLottoResultPhrase(HashMap<String, Integer> lottoResult, float rateOfResult) {
        List<String> result = new ArrayList<>();
        List<LottoResult> resultType = List.of(LottoResult.values());
        for (LottoResult type : resultType) {
            result.add(type.getResultState(lottoResult.get(type.name())));
        }
        result.add(RATE_OF_RETURN_RESULT.getResultState(rateOfResult));
        return result;
    }

}
