package lotto.service;

import lotto.model.*;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private PurchaseAmount purchaseAmount;
    private List<Lotto> issuedLotto;
    private Lotto winningNumbers;
    private BonusNumber bonusNumber;
    private MatchingCount matchingCount;

    public int inputPurchaseAmount(String input){
        purchaseAmount = new PurchaseAmount(input);
        return purchaseAmount.getPurchaseAmount();
    }

    public List<Lotto> createIssuedLotto(int issuedLottoCount){
        issuedLotto = new ArrayList<>();
        for(int i=1; i<=issuedLottoCount; i++){
            issuedLotto.add(new Lotto());
        }
        return issuedLotto;
    }

    public void inputWinningNumbers(String input){
        List<Integer> tempWinningNumbers = LottoInputParser.notNumber(input);
        winningNumbers = new Lotto(tempWinningNumbers);
    }

    public void inputBonusNumber(String input){
        bonusNumber = new BonusNumber(input, winningNumbers);
    }

    public List<Integer> calculateMatchingCount(){
        matchingCount = new MatchingCount();
        for(Lotto lotto : issuedLotto){
            matchingCount.updateMatchingCounts(lotto, winningNumbers, bonusNumber);
        }
        return matchingCount.getMatchingCounts();
    }

    public String calculateTotalReturnRate(){
        double profit = Calculate.totalProfit(matchingCount.getMatchingCounts());
        return Calculate.totalReturnRate(profit, purchaseAmount.getPurchaseAmount());
    }

}
