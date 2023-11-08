package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;
import lotto.lottoUI.LottoUI;

public class LottoNumberSetter {

    public static void parseWinningNumbers(int count) {
        List<Integer> winningNumbers = new ArrayList<>();

        while (true) {
            try {
                String[] tokens = input_Winning_Numbers();
                winningNumbers.clear(); // 각 시도마다 당첨 번호 초기화
                for (String token : tokens) {
                    int number = Integer.parseInt(token.trim());
                    winningNumbers.add(number);
                }
                Lotto lotto = new Lotto(winningNumbers);
                break; // 정상 입력 시 루프 종료
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                // 예외 발생 시 다시 입력을 받도록 유도
            }
        }
    }

    private static String[] input_Winning_Numbers() {
        LottoUI.InputWinningNumber();
        String input = readLine();
        String[] tokens = input.split(",");
        return tokens;
    }
}