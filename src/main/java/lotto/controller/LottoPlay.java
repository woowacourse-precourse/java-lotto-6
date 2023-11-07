package lotto.controller;

import lotto.view.Input;
import lotto.view.Output;

public class LottoPlay {

    public void play(Input input, Output output){
        makeLottoInput(input,output);
        makeWinInput(input, output);


    }

    private void makeLottoInput(Input input, Output output){
        input.readMoney();
        output.printLine();
        // 몇개를 구매했는지 출력
        // 랜덤값 복권 발행
    }

    private void makeWinInput(Input input, Output output){
        input.inputWinNumber();
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
