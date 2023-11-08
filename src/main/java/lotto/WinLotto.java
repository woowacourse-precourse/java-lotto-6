package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WinLotto {

    private final Lotto winLotto;
    private final int bonusNumber;

    public WinLotto(){
        Lotto lotto = new Lotto(getIntegers());

        this.winLotto = lotto;
        this.bonusNumber = extracted();
    }


    private static int extracted() {
        System.out.println();   //개행
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonus = Integer.parseInt(Console.readLine());
        return bonus;
    }

    private static List<Integer> getIntegers() {
        System.out.println();   //개행
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWin = Console.readLine();

        String[] win = inputWin.split(",");


        List<Integer> inputNumbers = new ArrayList<>();

        for(int i = 0; i< win.length; i++){
            inputNumbers.add(Integer.parseInt(win[i]));

        }
        return inputNumbers;
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}