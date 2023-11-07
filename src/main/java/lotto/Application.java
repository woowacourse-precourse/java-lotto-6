package lotto;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("구입금액을 입력해 주세요.");
        int num = 0;

        try {
            num = Integer.parseInt(Console.readLine());
            if(num % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println("[ERROR] 구입금액은 1000의 배수여야 합니다.");
        }

        System.out.println();

        int bought = num / 1000;
        System.out.println(bought + "개를 구매했습니다.");

        Lotto[] lottoNum = new Lotto[bought];
        for(int i = 0; i < bought; i++) {
            lottoNum[i] = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lottoNum[i].getNumbers());
        }

        for(Lotto l : lottoNum) {
            System.out.println(l.getNumbers().toString());
        }
    }
}
