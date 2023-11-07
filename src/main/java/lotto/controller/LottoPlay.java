package lotto.controller;

import lotto.Domain.Lotto;
import lotto.InputData;
import lotto.service.RandomNumber;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoPlay {

    public void play(Input input, Output output){

        makeLottoInput(input,output);
        makeWinInput(input, output);

    }

    private List<Lotto> makeLottoInput(Input input, Output output){
        RandomNumber randomNumber = new RandomNumber();

        output.howManyLotto();
        List<Lotto> lottolists = randomNumber.lottoList();
        output.printLine();
        return lottolists;
    }
    //

    //
    private void makeWinInput(Input input, Output output){
        InputData inputData = new InputData();
        output.printWinNumber();
        Lotto lottoWin = new Lotto(inputData.lottoList(input.inputWinNumber()));

        output.printLine();
        input.inputBonusNumber();
        output.printLine();

    }

    private void result(Input input,Output output){
        //랜덤값 복권과 당첨번호비교 Match
        //당첨금 계산 Prize
        //수익율 계산 Prize
        //출력

    }


}
