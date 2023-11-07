package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class View {
    /* 프로그램에서 콘솔에 출력하는 안내 메시지 */
    public void printMessage(Cmd cmd) {
        if(cmd == Cmd.START_CMD)
            System.out.println("구입금액을 입력해 주세요.");
        else if(cmd == Cmd.PRINT_NUMBEROFLOTTO)
            System.out.println(Control.calculateNumberOfLotto() + "개를 구매했습니다.");
        else if(cmd == Cmd.PRINT_LOTTO_NUMBER) {
            for (int i = 0; i < Control.count; i++)
                System.out.println(Control.sortLottoNumber(Control.lottos.get(i).getNumbers()));
        }
        else if(cmd == Cmd.PRINT_CORRECT_LOTTO_NUMBER)
            System.out.println("당첨 번호를 입력해 주세요.");
        else if(cmd == Cmd.PRINT_BONUS_NUMBER)
            System.out.println("보너스 번호를 입력해 주세요.");
        else if(cmd == Cmd.RESULT){
            System.out.println("당첨 통계\n---");
            System.out.println("3개 일치 (5,000원) - " + Control.threeCorrect + "\n4개 일치 (50,000원) - " + Control.fourCorrect);
            System.out.println("5개 일치 (1,500,000원) - " + Control.fiveCorrect);
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Control.fiveBonusCorrect);
            System.out.println("6개 일치 (2,000,000,000원) - " + Control.sixCorrect + "\n총 수익률은 " + Control.calculateRateOfReturn() + "%");
        }

    }

    /* 프로그램에서 사용자에게 입력 받는 모든 상황 */
    public void inputUser(Cmd cmd){
        if (cmd == Cmd.INPUT_MONEY)
            Control.inputMoney = Integer.parseInt(Console.readLine());
        else if(cmd == Cmd.INPUT_CORRECT_LOTTO_NUMBER)
            Control.correctNumber = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        else if(cmd == Cmd.INPUT_BONUS_NUMBER)
            Control.bonusNumber = Integer.parseInt(Console.readLine());
    }
}
