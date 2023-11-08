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

    private List<Lotto> makeLottoInput(Input input, Output output) {
        RandomNumber randomNumber = new RandomNumber();
        output.howManyLotto();
        while (true) {
            try {
                List<Lotto> lottolists = randomNumber.lottoList();
                output.printLine();
                return lottolists;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    private Lotto makeWinInput(Input input, Output output){
        InputData inputData = new InputData();
        output.printWinNumber();
        while(true) {
            try {
                Lotto lottoWin = new Lotto(inputData.lottoList(input.inputWinNumber()));
                output.printLine();
                return lottoWin;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int makeBonusInput(Input input, Output output) {
        output.printBonusNumber();
        while(true){
            try{
                String bonus = input.inputBonusNumber();
                output.printLine();
                return Integer.parseInt(bonus);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
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
