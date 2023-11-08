package lotto.model;

import java.util.List;

public class LottoInfo {
    
    private static int inputbuycost;
    private static int createlottonumber;
    private static List<List<Integer>> createLottoNumbers;
    private static int inputbonusnumber;
    private static int correctCount;

    public void setInputBuyCost(int inputbuycost){
        LottoInfo.inputbuycost = inputbuycost;
    }
    public int getInputBuyCost(){
        return inputbuycost;
    }

    public void setCreateLottoNumber(int createlottonumber){
        LottoInfo.createlottonumber = createlottonumber;
    }
    public int getCreateLottoNumber(){
        return createlottonumber;
    }

    public void setCreateLottoNumbers(List<List<Integer>> createLottoNumbers){
        LottoInfo.createLottoNumbers = createLottoNumbers;
    }
    public List<List<Integer>> getCreateLottoNumbers(){
        return createLottoNumbers;
    }

    public void setInputBonusNumber(int inputbonusnumber){
        LottoInfo.inputbonusnumber = inputbonusnumber;
    }
    public int getInputBonusNumber(){
        return inputbonusnumber;
    }

    public void setCorrectCount(int correctCount){
        LottoInfo.correctCount = correctCount;
    }
    public int getCorrectCount(){
        return correctCount;
    }
}
