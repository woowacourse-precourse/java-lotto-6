package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
                System.out.println(Control.lottos.get(i).getNumbers());
        }
        else if(cmd == Cmd.PRINT_CORRECT_LOTTO_NUMBER)
            System.out.println("당첨 번호를 입력해 주세요.");
        else if(cmd == Cmd.PRINT_BONUS_NUMBER)
            System.out.println("보너스 번호를 입력해 주세요.");
        else if(cmd == Cmd.RESULT){
            System.out.println("당첨 통계\n---\n3개 일치 (5,000원) - " + Control.threeCorrect + "개");
            System.out.println("4개 일치 (50,000원) - " + Control.fourCorrect + "개\n5개 일치 (1,500,000원) - " + Control.fiveCorrect + "개");
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Control.fiveBonusCorrect + "개");
            System.out.println("6개 일치 (2,000,000,000원) - " + Control.sixCorrect + "개\n총 수익률은 " + Control.calculateRateOfReturn() + "%입니다.");
        }

    }

    /* 프로그램에서 사용자에게 입력 받는 모든 상황 */
    public void inputMoney() {
        try {
            Control.inputMoney = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 정수를 입력해주세요.");
            inputMoney();
        }
    }
    public void inputCorrectLottoNumber() {
        try{
            Control.correctNumber = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            if(!Control.isSizeCorrect(Control.correctNumber))
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6자리로 입력해주세요.");

            if(Control.isDuplication(Control.correctNumber))
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputCorrectLottoNumber();
        }
    }

    public void inputBonusNumber() {
        try{
            Control.bonusNumber = Integer.parseInt(Console.readLine());
            if(Control.isBonusNumberInLottoNumber(Control.bonusNumber)){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputBonusNumber();
        }

    }
}
