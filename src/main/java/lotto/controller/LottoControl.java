package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.GenerateLottoNumbers;
import lotto.model.LottoWinNumbers;
import lotto.model.MatchedNumbers;
import lotto.model.PurchasePrice;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoControl {
    PurchasePrice purchasePrice;
    GenerateLottoNumbers generateLottoNumbers;
    LottoWinNumbers lottoWinNumbers;
    private String PRICE_FROM_USER;
    private int PIECE_OF_LOTTO;
    private ArrayList<List<String>> ALL_LOTTOS;
    private ArrayList<String> WIN_NUMBERS;
    private String BONUS_NUMBER;
    private boolean[] BONUS_FLAG;


    public LottoControl(){
        setPriceFromUser();
        purchasePrice = new PurchasePrice(PRICE_FROM_USER);
        printLottoAmount();
        generateLottoNumbers = new GenerateLottoNumbers(PIECE_OF_LOTTO);
        printAllLottos();
        lottoWinNumbers = new LottoWinNumbers(InputView.getWinNumberFromUserInput());
        WIN_NUMBERS = lottoWinNumbers.getLottoWinNumbers();
        BonusNumber bonusNumber = new BonusNumber(InputView.getBonusNumberFromUserInput());
        BONUS_NUMBER = bonusNumber.getBonusNumber();
        MatchedNumbers matchedNumbers = new MatchedNumbers(ALL_LOTTOS,WIN_NUMBERS);
        mappingMatchedLottos(ALL_LOTTOS,BONUS_NUMBER);
        fiveWithBonusFinder(matchedNumbers.getLOTTO_MATCHED_COUNT_LIST());



    }
    private void mappingMatchedLottos(ArrayList<List<String>> allLottos, String bonusNumber){
        BONUS_FLAG = new boolean[PIECE_OF_LOTTO];
        for(int index = 0; index < allLottos.size(); index++){
            if(allLottos.get(index).contains(bonusNumber)){
                BONUS_FLAG[index] = true;
            }
        }
    }
    private void fiveWithBonusFinder(ArrayList<String> matchedCountList){
        for(String count : matchedCountList){
            if(count.equals("5") && BONUS_FLAG[matchedCountList.indexOf(count)]){
                matchedCountList.set(matchedCountList.indexOf(count),"5/wB");
            }
        }
    }

    private void setPriceFromUser(){
        PRICE_FROM_USER = InputView.getPriceFromUserInput();
    }
    private void setPieceOfLotto(){
        PIECE_OF_LOTTO = purchasePrice.getCountPieceOfLotto();
    }

    private void printLottoAmount(){
        setPieceOfLotto();
        OutputView.printPieceOfLottoAmount(PIECE_OF_LOTTO);
    }
    private void printAllLottos(){
        setAllLottos();
        OutputView.printAllLottos(ALL_LOTTOS);
    }
    private void setAllLottos(){
        ALL_LOTTOS = generateLottoNumbers.getAllLottos();
    }


}
