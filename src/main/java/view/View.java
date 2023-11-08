package view;

import lotto.Lotto;

import java.util.List;

public class View {

    public StringBuilder sb;
    public InputView inputView;
    public OutputView outputView;
    private final String ERROR_MSG_HEAD = "[ERROR]";

    public View(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int showUserMoneyViewAndGetMoney(){
        outputView.guideUserInsertMoney();
        return inputView.inputMoneyFromUser();
    }

    public void showUserPurchasedLottoView(List<Lotto> lottos){
        outputView.guideUserLottoInfo(lottos);
    }

    public List<Integer> showUserWinnerNumberViewAndGetNumbers(){
        outputView.guideUserInsertWinnerNumbers();
        return inputView.inputLottoWinnerNumberFromUser();
    }

    public int showUserBonusNumberViewAndGetNumber(List<Integer> winNumber){
        outputView.guideUserInsertBounsNumber();
        return inputView.inputBonusNumberFromUser(winNumber);
    }

    public void showUserLottoResultsView(String result, double amountRatio){
        outputView.guideUserLottoResults(result, amountRatio);
    }

    public void printBlank(){
        System.out.println();
    }


    public void printErrorMsg(String message){
        System.out.println(makeErrorString(message));
    }

    public String makeErrorString(String message){
        sb = new StringBuilder();
        sb.append(
                String.format("%s %s",ERROR_MSG_HEAD, message)
        );
        return sb.toString();
    }
}
