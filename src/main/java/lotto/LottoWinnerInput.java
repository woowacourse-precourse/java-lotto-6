package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class LottoWinnerInput {
    static String lottoWinnerInputNum;
    static List<Integer> lottoWinnerNum = new ArrayList<>();

    static void inputWinningNumbers() {
        try {
            lottoWinnerNum = new ArrayList<>();
            lottoWinnerInputNum = Console.readLine();
            String[] lottoWinnerInputNumTemp = lottoWinnerInputNum.split(",");

            for (String elements : lottoWinnerInputNumTemp) {
                lottoWinnerNum.add(Integer.parseInt(elements));
            }
            Collections.sort(lottoWinnerNum);

            Lotto validate = new Lotto(lottoWinnerNum); // 생성자를 이용한 에외 검증
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            GameController.reInput = true;
        }
    }
}


