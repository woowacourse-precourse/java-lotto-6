package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.controller.MessageManager;
import lotto.domain.Lotto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserService {

    public int calculateCount(int payMoney){
        return payMoney / 1000;
    }

    public ArrayList<Lotto> createLotto(int count) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MessageManager.LOTTO_MIN, MessageManager.LOTTO_MAX, MessageManager.LOTTO_SIZE);
            ArrayList<Integer> changeTypeNumbers = new ArrayList<>(numbers);
            Collections.sort(changeTypeNumbers);
            Lotto lotto = new Lotto(changeTypeNumbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    public ArrayList<Integer> changeWinningNumberType(String readLine){
        String[] items = readLine.split(",");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String item : items) {
            numbers.add(Integer.parseInt(item));
        }
        return numbers;
    }

    public int compareLotto(Lotto lotto, Lotto winningNumber){
        int sum = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumber.getNumbers().contains(number)) {
                sum += 1;
            }
        }
        return sum;
    }

    public ArrayList<Integer> calculateWinningCount(List<Lotto> lottos, Lotto winningNumber, int bonusNumber) {
        ArrayList<Integer> winningCount = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        for (Lotto lotto : lottos) {
            int count = compareLotto(lotto, winningNumber);
            if (count == 6) {
                winningCount.set(0, winningCount.get(0) + 1);
            } else if (count == 5 && lotto.getNumbers().contains(bonusNumber)) {
                winningCount.set(1, winningCount.get(1) + 1);
            } else if (count == 5) {
                winningCount.set(2, winningCount.get(2) + 1);
            } else if (count == 4) {
                winningCount.set(3, winningCount.get(3) + 1);
            } else if (count == 3) {
                winningCount.set(4, winningCount.get(4) + 1);
            }
        }
        return winningCount;
    }

    public int calculateWinnerMoney(ArrayList<Integer> winnersResult){
        int total = 0;

        for (int i = 0; i < 5; i++) {
            total += MessageManager.WINNER_TYPE.get(i).getPrize() * winnersResult.get(i);
        }
        return total;
    }

    public String calculateRateMoney(int payMoney, int winnerMoney){
        return String.format("%.1f", ((float) winnerMoney / (float) payMoney) * 100);
    }

}
