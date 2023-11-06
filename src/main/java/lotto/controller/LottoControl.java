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
        setPurchasePrice();



        printLottoAmount();

        generateLottoNumbers = new GenerateLottoNumbers(PIECE_OF_LOTTO);
        printAllLottos();

        lottoWinNumbers = new LottoWinNumbers(InputView.getWinNumberFromUserInput());
        WIN_NUMBERS = lottoWinNumbers.getLottoWinNumbers();

        BonusNumber bonusNumber = new BonusNumber(InputView.getBonusNumberFromUserInput());
        BONUS_NUMBER = bonusNumber.getBonusNumber();

        MatchedNumbers matchedNumbers = new MatchedNumbers(ALL_LOTTOS,WIN_NUMBERS);
        mappingMatchedLottos();
        fiveWithBonusFinder(matchedNumbers.getLOTTO_MATCHED_COUNT_LIST());
        OutputView.printLottoStates(matchedNumbers.getLOTTO_MATCHED_COUNT_LIST());
        OutputView.printTotalReturn(matchedNumbers.getLOTTO_MATCHED_COUNT_LIST(),String.valueOf(PIECE_OF_LOTTO * 1000));



    }
    private void setLottoWinNumbers(){

    }

    private void mappingMatchedLottos(){
        BONUS_FLAG = new boolean[PIECE_OF_LOTTO];
        for(int index = 0; index < ALL_LOTTOS.size(); index++){
            if(ALL_LOTTOS.get(index).contains(BONUS_NUMBER)){
                BONUS_FLAG[index] = true;
            }
        }
    }
    private void fiveWithBonusFinder(ArrayList<String> matchedCountList){
        for(String count : matchedCountList){
            if(count.equals("5") && BONUS_FLAG[matchedCountList.indexOf(count)]){
                matchedCountList.set(matchedCountList.indexOf(count),"5wB");
            }
        }
    }

    private void setPurchasePrice(){
        try{
            getPriceFromUser();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            setPurchasePrice();
        }
    }
    private void getPriceFromUser(){
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
