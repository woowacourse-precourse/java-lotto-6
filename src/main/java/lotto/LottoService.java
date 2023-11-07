package lotto;

import lotto.controller.calculation.Calculation;
import lotto.controller.lottomaker.LottoMaker;
import lotto.lottoenum.LottoRanking;
import lotto.repository.Repository;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private boolean isUseFulLottoCount = true;
    private boolean isUseFulAnswerLotto = true;
    private boolean isUseFulBonusNumber = true;
    Output output;
    Input input;
    Repository repository;
    Calculation calculation;
    LottoMaker lottoMaker;
    public LottoService(Output output, Input input, Repository repository, Calculation calculation, LottoMaker lottoMaker) {
        this.output = output;
        this.input = input;
        this.repository = repository;
        this.calculation = calculation;
        this.lottoMaker = lottoMaker;
    }

    public void game(){
        getMoney();
        makeRandomLotto();
        makeAnswerLotto();
        makeBonusNumber();
        makeCalculateAndPrintResult();
    }

    private void makeCalculateAndPrintResult() {
        List<LottoRanking> lottoRankings = new ArrayList<>();
        for(Lotto lotto : repository.getLottoNumbers()){
            lottoRankings.add(lotto.lotteryCheck(repository.getAnswerLotto().getLottoDetail(),
                    repository.getBonusNumber()));
        }
        output.printResult(lottoRankings);
        output.printCalculation(calculation.getCalculation(lottoRankings));
    }

    private void makeBonusNumber() {
        output.printGetBonusNum();
        do{
            repository.saveBonusNumber(input.getBonusNum());
            if(repository.getBonusNumber() != 0){
                isUseFulBonusNumber = false;
            }
        }while(isUseFulBonusNumber);
        System.out.println();
    }

    private void makeAnswerLotto() {
        output.printGetLottoAnswer();
        do{
            List<Integer> tempAnswer = input.getLottoAnswerNum();
            if(!tempAnswer.isEmpty()){
                answerLottoValidate(tempAnswer);
            }
        }while(isUseFulAnswerLotto);
        System.out.println();
    }

    private void answerLottoValidate(List<Integer> tempAnswer) {
        try{
            repository.setAnswerLotto(new Lotto(tempAnswer));
            isUseFulAnswerLotto = false;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void getMoney() {
        output.printPurchaseAmount();
        do {
            repository.setCountLotto(input.getLottoCount());
            if(repository.getCountLotto() != 0){
                isUseFulLottoCount = false;
            }
        }while(isUseFulLottoCount);
        System.out.println();
    }

    private void makeRandomLotto(){
        for(int i = 0; i<repository.getCountLotto(); i++){
            repository.saveLottoNumbers(new Lotto(lottoMaker.makeLotto()));
        }
        output.printRandomLottoNum(repository.getLottoNumbers());
        System.out.println();
    }
}
