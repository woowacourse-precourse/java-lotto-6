package lotto.Domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparison extends QuickPicks {
    private static int bonusCount;

    private static final List<Integer> correctCount = new ArrayList<>();

    public static final List<Integer> correctType = new ArrayList<>();


    public int correctBalls (List<Integer> winningBalls, int gameNumber ) {

        int count= 0;

        for (int i = 0; i < winningBalls.size(); i++) {

            if(winningBalls.contains(lottoLog.get(gameNumber).get(i))) {
                count++;
            }
        }
        return count;
    }

    public void traverseGames (List<Integer> winningBalls, int gameCount, int bonus){

        for (int i = 0; i < gameCount; i++) {
            correctCount.add(correctBalls(winningBalls,i));

            if((correctBalls(winningBalls, i) == 5) && lottoLog.get(gameCount).contains(bonus)) {
                bonusCount++;
            }
        }
    }
    private int threeCorrect (){
        return Collections.frequency(correctCount,3);
    }

    private int fourCorrect (){
        return Collections.frequency(correctCount,4);
    }

    private int fiveCorrect (){
        return Collections.frequency(correctCount,5) - bonusCount;
    }

    private int fiveAndBonusCorrect(){
        return bonusCount;
    }

    private int sixCorrect (){
        return Collections.frequency(correctCount,6);
    }

    public void overAllWinning(){
        correctType.add(threeCorrect());
        correctType.add(fourCorrect());
        correctType.add(fiveCorrect());
        correctType.add(fiveAndBonusCorrect());
        correctType.add(sixCorrect());
    }

}
