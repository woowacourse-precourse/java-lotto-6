package lotto;

import java.util.List;

public class PlayLotto {
    private final View view = new View();
    private final LottoNumscompare lottoNumscompare = new LottoNumscompare();
    private UserlottoNums userlottoNums;
    private int lottoPurchaseNum;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private double profitSummary;

    public PlayLotto(){
        lottoInput();
        lottoCompare();
        lottoOutput();
    }

    private void lottoInput(){
        view.lottoPurchaseAmountInput();
        lottoPurchaseNum = view.getLottoPurchaseNum();
        userlottoNums = new UserlottoNums(lottoPurchaseNum);
        view.lottoPurchaseNumbersOutput();
        for(int i = 0; i<lottoPurchaseNum; i++){
            view.userLottoNumbersOutput(userlottoNums.getlottoNum(i));
        }
        winningNumbers = view.winningNumberInput();
        bonusNumber = view.bonusNumberInput();
    }

    private void lottoCompare(){
        for(int i = 0; i < lottoPurchaseNum; i++){
            lottoNumscompare.winningRanksUpdate(userlottoNums.getlottoNum(i), lottoNumscompare.compareLotto(userlottoNums.getlottoNum(i), winningNumbers), bonusNumber);
        }
        profitSummary = lottoNumscompare.calculateProfitSummary(lottoPurchaseNum);
    }


    private void lottoOutput(){
        view.setUserWinningRanks(lottoNumscompare.getUserWinningRanks());
        view.setProfitSummary(profitSummary);
        view.winningStatisticsOutput();
        view.profitSummaryOutput();
    }
}
