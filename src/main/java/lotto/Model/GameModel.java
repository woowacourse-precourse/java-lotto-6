package lotto.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Controller.ErrorMessage;

public class GameModel {
    private final String DIVIDE_POINT =",";
    private LottoPlayer lottoPlayer;
    private LottoHost lottoHost;

    public void initGameModel(Integer insertData){
        lottoPlayer = new LottoPlayer(insertData);
        lottoHost = new LottoHost();
    }

    public void initAnswerByStrings(String insertData){
        List<String> splitData= Arrays.asList(insertData.split(DIVIDE_POINT));

        validateIntegerList(splitData);

        List<Integer> answerNumbers = splitData.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        lottoHost.initAnswerLotto(answerNumbers);
    }

    public void initBonus(Integer insertNumber){
        lottoHost.initBonusNumber(insertNumber);
    }


    public ArrayList<LottoData> transferPlayerLottoDatas(){
        return lottoPlayer.getLottoDatas();
    }

    public ScoreBoard getRoundScore(){
        Integer bonusNumber = lottoHost.getBonusNumberData();
        LottoData roundLotto = lottoHost.getLottoData();

        return lottoPlayer.calculateScore(roundLotto,bonusNumber);
    }

    private void validateIntegerList(List<String> insertDatas){
       if(isContainsChar(insertDatas)){
           throw new IllegalArgumentException(ErrorMessage.LOTTO_NOT_NUMBER.getMessage());
       }
    }

    private boolean isContainsChar(List<String> insertDatas){
        for (String data : insertDatas) {
            try {
                Integer.parseInt(data);
            } catch (NumberFormatException e) {
                return true;
            }
        }
        return false;
    }

    public void lottoIssuance(){
        Integer purchaseQuanity = lottoPlayer.orderLottos();
        giveLottos(purchaseQuanity);
    }

    public double getRoundEarnRate(){
        return lottoPlayer.getEarnRate();
    }

    private void giveLottos(Integer quanity){
        for(int i=0;i<quanity;i++){
            Lotto lotto = lottoHost.generateLotto();
            lottoPlayer.receiveLotto(lotto);
        }
    }


   }
