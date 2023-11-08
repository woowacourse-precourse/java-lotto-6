package lotto.service;

import lotto.dto.Bingo;
import lotto.dto.Lotto;
import lotto.dto.Lottos;

public class FindBingo {
    int correctNum = 0;
    int bonusFlag = 0;

    public void findBingos(Lottos lottos, Lotto userLotto, int bonusNum){

        for ( Lotto lotto : lottos.getLottos() ){
            correctNum = 0;
            bonusFlag = 0;
            compareUserLotto(lotto, userLotto, bonusNum);

            checkBingoList(correctNum, bonusFlag);
        }
    }

    public void compareUserLotto(Lotto lotto, Lotto userLotto, int bonusNum){
        for ( int i : userLotto.getNumbers() ){
            for ( int j : lotto.getNumbers()){
                compareNumber(i,j,bonusNum);
            }
        }
    }

    public void compareNumber(int i, int j, int bonusNum ){
        if ( i == j ) correctNum++;
        if ( bonusNum == j ) bonusFlag = 1;
    }

    public void checkBingoList(int correctNum, int bonusFlag){
        findBingo3(correctNum);
        findBingo4(correctNum);
        findBingo5(correctNum, bonusFlag);
        findBingo5wB(correctNum, bonusFlag);
        findBingo6(correctNum);
    }

    public void findBingo3( int correctNum ){
        if ( correctNum == 3 ) Bingo.getBingo3().correctLotto++;
    }

    public void findBingo4( int correctNum ){
        if ( correctNum == 4 ) Bingo.getBingo4().correctLotto++;
    }

    public void findBingo5( int correctNum, int bonusFlag ){
        if ( correctNum == 5 && bonusFlag == 0 ) Bingo.getBingo5().correctLotto++;
    }

    public void findBingo5wB( int correctNum, int bonusFlag ){
        if ( correctNum == 5 && bonusFlag == 1 ) Bingo.getBingo5wB().correctLotto++;
    }

    public void findBingo6( int correctNum ){
        if ( correctNum == 6 ) Bingo.getBingo6().correctLotto++;
    }
}
