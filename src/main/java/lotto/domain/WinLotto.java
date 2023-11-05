package lotto.domain;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class WinLotto {
    public static void winningNumber() {
        //당첨 번호 및 보너스 번호 입력
        System.out.println("당첨 번호를 입력해 주세요.");
        while(true){
            List<Integer> inputWinningNumber = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(readLine(), ",");
            for(int i = 0; i < 6; i++){
                int num = Integer.valueOf(st.nextToken());
                inputWinningNumber.add(num);
            }
        }
    }

    public static void winningDetails(){
        //당첨 내역 출력
    }

    public static void rateOfRevenue(){
        //수익률 출력(소수점 둘째 자리에서 반올림)
    }
}
