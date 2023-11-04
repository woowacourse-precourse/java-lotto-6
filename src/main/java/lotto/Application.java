package lotto;
/*
    2023 11 04 다시 만들기로 결정
*/
import java.util.ArrayList;
import java.util.List;

import java.util.Collections;
import java.lang.Math;
import java.text.DecimalFormat;

import lotto.Lotto;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


public class Application {
    final static int[] prices = { 2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000, 0 };

    enum ErrorType { 
        NUMBERANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."), 
        DUP("[ERROR] 로또 번호는 중복할 수 없습니다."),
        MONEY("[ERROR] 금액은 1000으로 나누어 떨어져야 합니다."),
        NOTINTEGER("[ERROR] 정수를 입력해 주세요.");

        final private String name; 
        public String getName() { 
            return name; 
        } 
        private ErrorType(String name){ 
            this.name = name; 
        } 
    }

    // 랜덤 번호 6개 뽑기
    private static List<Integer> setRandomNumbers() {
        List<Integer> box = new ArrayList<>();
        while (box.size() != 6) {
            int rd = Randoms.pickNumberInRange(1, 45);
            if (box.contains(rd))
                continue;
            box.add(rd);
        }
        Collections.sort(box);
        System.out.println(box);
        return box;
    }



    public static void main(String[] args) {
        
    }
}
