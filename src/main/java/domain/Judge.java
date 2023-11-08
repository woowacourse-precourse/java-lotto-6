package domain;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    private int correctNumberCount;
    private ArrayList<Integer> rank = new ArrayList<>();

    public ArrayList<Integer> matchNumbers(ArrayList<Lotto> myLotto, ArrayList<Integer> winningNumber,
        int bonusNumber){

        List<Integer> lottoNumber;

        for (Lotto lotto : myLotto) {
            correctNumberCount = 0;
            boolean isBonusCorrect = false;
            lottoNumber = lotto.getNumber();
            for (int number : lottoNumber) {
                correctNumberCount = matchWithSimpleNumber(number, winningNumber);
                isBonusCorrect = matchWithBonusNumber(number, bonusNumber);
            }
            countWin(correctNumberCount, isBonusCorrect);
        }
        return rank;
    }

    public int matchWithSimpleNumber(int lottoNumber, ArrayList<Integer> winningNumber){
        for (Integer winNumber : winningNumber) {
            if (winNumber.equals(lottoNumber)) {
                correctNumberCount += 1;
            }
        }
        return correctNumberCount;
    }

    public boolean matchWithBonusNumber(int number, int bonusNumber){
        return number == bonusNumber;
    }

    public void countWin(int correctNumberCount, boolean isBonusCorrect){
        if(correctNumberCount < 3){
            rank.add(0);
        } else if(correctNumberCount == 3){
            rank.add(5);
        } else if(correctNumberCount == 4){
            rank.add(4);
        } else if(correctNumberCount == 5){
            rank.add(3);
        } else if(correctNumberCount == 5 && isBonusCorrect){
            rank.add(2);
        } else if(correctNumberCount == 6){
            rank.add(1);
        }
    }
}
