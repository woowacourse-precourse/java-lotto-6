package lotto.Lottery.Util;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {

    public List<Integer> generateWinner(String userInputWinners){
        List<Integer> Winners = new ArrayList<>();

        String[] winners = userInputWinners.split(",");

        // error 입력 갑이 숫자가 아닌 경우 걸러냄
        for(String winner : winners){ //
            try{
                int winnerNumber = Integer.parseInt(winner);
                Winners.add(winnerNumber);
            } catch(NumberFormatException e){
                throw new IllegalArgumentException("[ERROR] 입력값 중 숫자가 아닌 값이 있습니다.");
            }
        }

        return Winners;
    }
}
