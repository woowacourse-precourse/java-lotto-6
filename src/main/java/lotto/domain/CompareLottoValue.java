package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class CompareLottoValue {
    public static final int LOTTO_LEN = 6;
    public static final int FIRST_RANK = 6;
    public static final int SECOND_OR_THIRD = 5;
    static int resultScore = 0;
    public static void compareValueStart(List<Integer> winningBalls, List<List<Integer>> lottoRepo, Integer bonusBall){
        System.out.println(lottoRepo);
        System.out.println(winningBalls);
        // 당첨볼을 정수리스트로 변환
        for (int i = 0; i<lottoRepo.size(); i++){
            // 각 로또와 당첨볼을 받아 비교하는 함수
            compareLottoValue(winningBalls, lottoRepo.get(i), bonusBall);
        }
        // 로또의 갯수만큼 전달 시(위의 반복문 수행완료시) 총 수익률 계산하고 로또결과와 수익률 출력하는 함수 호출
    }



    public static void compareLottoValue(List<Integer> winningBalls, List<Integer> lottoBalls, Integer bonusBall){ // 점수 비교하는 함수
        resultScore = 0;
        for(int j = 0; j<LOTTO_LEN; j++){ // 생성된 로또를 반복하며
            if(winningBalls.get(j) == lottoBalls.get(j)){
                // 자동으로 같은 자리가 비교되어 값만 같은지 알면 됨
                resultScore +=1;
            }
        }
        // 점수가 6점일 경우
        if(resultScore == FIRST_RANK){
            firstRankScoreAdd();
        }

        // 점수가 5점일 경우 2등을 가리기 위한 함수 호출
        if(resultScore == SECOND_OR_THIRD){
            secondRankChance(lottoBalls, bonusBall);
        }
        lottoRank(resultScore);
    }

    public static Integer secondRankChance(List<Integer> lottoBalls, Integer bonusBall){
        for(int lottoBall : lottoBalls){
            if(lottoBall == bonusBall){
                resultScore += 1;
            }
        }
        return resultScore;
    }

    public static Integer firstRankScoreAdd(){
        resultScore += 1;
        return resultScore;
    }

    public static void lottoRank(Integer resultScore){
        System.out.println(resultScore);
        // 이 함수에서는 몇개가 똑같은지에 대한 점수를 받아서 열거형(WinningAmounts)의 count값을 올릴 것임
    }
}