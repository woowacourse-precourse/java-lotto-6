package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.data.Rewards;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LottoModel {

    private final InputUI inputUI;
    private final OutputUI outputUI;
    private final int CHECK_BONUS = 999;
    private List<Lotto> publishedLottos;
    private boolean bonus;
    private int totalEarnedMoney;
    private HashMap<Rewards, Integer> winningTable;
    private HashMap<Integer, Integer> winningNumsTable;


    public LottoModel() {
        this.inputUI = new InputUI();
        this.outputUI = new OutputUI();
        this.publishedLottos = new ArrayList<>();
        this.winningTable = initWinningTable();
        this.totalEarnedMoney = 0;
    }

    public void publishLotto(int numOfLotto) {
        List<Integer> randNums;
        try {
            for (int i = 0; i < numOfLotto; i++) {
                randNums = generateNewLotto();
                randNums.sort(Comparator.naturalOrder());
                publishedLottos.add(new Lotto(randNums));
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public List<Integer> generateNewLotto() {
        List<Integer> generated = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return generated;
    }

    public String publishTicket(List<Integer> lottoNums) {
        lottoNums.sort(Comparator.naturalOrder());
        List<String> sortedNums = lottoNums.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        String Ticket = String.format("[%s]", String.join(", ", sortedNums));
        return Ticket;
    }


    public String computeRate(double winningRate) {
        return String.format("%.1f", winningRate);
    }

    public void computeLotto(List<Lotto> published, List<Integer> winnings, int bonusNum) {

        for (Lotto lotto : published) {
            bonus = false;
            winningNumsTable = compareLotto(winnings, lotto, bonusNum);
            int result = sumOfWinningNumsTable();
            winningTable = makeWinningTable(result, bonus);
        }

    }

    public int sumOfWinningNumsTable() {
        int result = 0;
        for (int value : winningNumsTable.values()) {
            result += value;
        }
        return result;
    }

    public HashMap<Rewards, Integer> makeWinningTable(int result, boolean bonus) {
        Rewards[] rewards = Rewards.values();
        for (Rewards reward : rewards) {
            if (result == reward.correctLottos() && bonus == reward.correctBonus()) {
                totalEarnedMoney += reward.money();
                int updateNum = winningTable.getOrDefault(reward, 0) + 1;
                winningTable.put(reward, updateNum);
            }
        }
        return winningTable;
    }

    public HashMap<Rewards, Integer> initWinningTable() {
        HashMap<Rewards, Integer> winningTable = new HashMap<>();
        Rewards[] rewards = Rewards.values();
        for (Rewards reward : rewards) {
            winningTable.put(reward, 0);
        }
        return winningTable;
    }

    public HashMap<Integer, Integer> initWinningNumsTable(List<Integer> winnings) {
        HashMap<Integer, Integer> winningNums = new HashMap<>();
        for (int winningnum : winnings) {
            winningNums.put(winningnum, 0);
        }
        return winningNums;
    }

    public HashMap<Integer, Integer> compareLotto(List<Integer> winnings, Lotto lotto, int bonusNum) {
        HashMap<Integer, Integer> winningNumsTable = initWinningNumsTable(winnings);
        for (int number : lotto.getNumbers()) {
            if (winningNumsTable.containsKey(number)) {
                winningNumsTable.put(number, 1);
            }
            if (number == bonusNum) {
                winningNumsTable.put(CHECK_BONUS, 1);
            }
        }
        return winningNumsTable;
    }


}
