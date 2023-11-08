package lotto.Controller;

import lotto.IO.IO;
import lotto.LottoFactory.LottoRank;

public class PrintResult implements Printing{
    double rate;

    public PrintResult(double rate) {
        this.rate = rate;
    }

    @Override
    public void PrintResult(){
        IO.printRanking(LottoRank.values());
        IO.printRate(rate);
    }

}
