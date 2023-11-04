package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class NumberGenerator {
    final static int LOTTOCOSTUNIT = 1000;

    public int inputBuyCost(){
        String buycost = Console.readLine();
        return Integer.parseInt(buycost);
    }

    public int createUnitLotto(int buycost){
        int buycount = buycost/LOTTOCOSTUNIT;
        return buycount;
    }

    public List<Integer> createRandomNumbers(){
        return null;
    }

    public List<Integer> sortAscendingNumbers(List<Integer> sortLottoNumbers){
        return null;
    }
}
