package lotto.controller;

import lotto.Domain.Lotto;
import lotto.InputData;
import lotto.service.Match;
import lotto.service.RandomNumber;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoPlay {

    public void play(Input input, Output output){

        List<Lotto> lottoPlayList = makeLottoInput(input,output);
        Lotto winNumber = makeWinInput(input, output);
        int bonus = makeBonusInput(input,output);
        long sumPrize = result(lottoPlayList,winNumber,bonus);
        statistics(sumPrize,lottoPlayList.size()*1000);

    }

    private List<Lotto> makeLottoInput(Input input, Output output){
        RandomNumber randomNumber = new RandomNumber();
        output.howManyLotto();
        List<Lotto> lottolists = randomNumber.lottoList();
        output.printLine();
        return lottolists;
    }

    private Lotto makeWinInput(Input input, Output output){
        InputData inputData = new InputData();
        output.printWinNumber();
        Lotto lottoWin = new Lotto(inputData.lottoList(input.inputWinNumber()));
        output.printLine();
        return lottoWin;
    }

    private int makeBonusInput(Input input, Output output) {
        output.printBonusNumber();
        String bonus = input.inputBonusNumber();
        output.printLine();
        return Integer.parseInt(bonus);
    }

    private long result(List<Lotto> lottoPlayList, Lotto winNumber, int bonus){
        Output output = new Output();
        output.printResultstart();
        Match match = new Match();
        match.lottoResult(lottoPlayList,winNumber,bonus);
        output.printLottoResult(match);
        return match.sumPrize();
    }

    private void statistics(long sumPrize,long money){
        Output output = new Output();
        Match match = new Match();
        output.printRate(match.rate(sumPrize,money));
    }


}
