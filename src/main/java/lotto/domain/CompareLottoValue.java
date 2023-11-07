package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class CompareLottoValue {
    public static final int LOTTO_LEN = 6;
    public static void compareValueStart(List<Integer> winningBalls, List<List<Integer>> lottoRepo){
        System.out.println(lottoRepo);
        System.out.println(winningBalls);
        // 당첨볼을 정수리스트로 변환
        for (int i = 0; i<lottoRepo.size(); i++){
            // 각 로또와 당첨볼을 받아 비교하는 함수
            compareLottoValue(winningBalls, lottoRepo.get(i));
        }
    }



    public static void compareLottoValue(List<Integer> winningBalls, List<Integer> lottoBalls){ // 점수 비교하는 함수
        for(int j = 0; j<LOTTO_LEN; j++){ // 생성된 로또를 반복하며
            // 자리와 값이 맞는지
            // 당첨 시 결과 값(enum 배열 값 +1, , 수익금 갱신)
        }
    }

    // 로또의 갯수만큼 전달 시 총 수익률 계산하고 출력
}