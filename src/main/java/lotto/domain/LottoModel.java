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
    private List<Lotto> publishedLottos;
    private int totalEarnedMoney;
    private HashMap<Rewards, Integer> winningTable;
    private HashMap<Integer, Integer> winningNumsTable;


    public LottoModel() {
        this.inputUI = new InputUI();
        this.outputUI = new OutputUI();
        this.publishedLottos = new ArrayList<>();
        this.winningTable = new HashMap<>();
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




}
