package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import com.sun.source.doctree.AttributeTree;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    public int receiveMoney() {
        String inputMoney = Console.readLine();
        while (!Validators.validateMoney(inputMoney)) {
            inputMoney = Console.readLine();
        }
        return Integer.parseInt(inputMoney);
    }

    public void printTickets(int numberOfTickets) {
        ArrayList<Object> customerTickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            customerTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6)));
            System.out.println(customerTickets.get(i));
        }
    }
    public List<Integer> setWinningNumbers() {
        String inputWinningNumbers = Console.readLine();
        while(!Validators.validateWinningNumbers(inputWinningNumbers)) {
            inputWinningNumbers = Console.readLine();
        }
        String[] stringWinningNumbers = inputWinningNumbers.split(",");

        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumber : stringWinningNumbers) {
            winningNumbers.add(Integer.parseInt(winningNumber));
        }
        return winningNumbers;
    }
    public int setBonusNumber() {
        String inputBonusNumber = Console.readLine();
        while (true) {
            try {
                Validators.validateStringIsIntegerConvertable(inputBonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        return Integer.parseInt(inputBonusNumber);
    }


}
