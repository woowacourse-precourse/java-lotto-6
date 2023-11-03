package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoModel {

    private final InputUI inputUI;
    private List<Lotto> publishedLottos;

    public LottoModel() {
        this.inputUI = new InputUI();
        this.publishedLottos = new ArrayList<>();
    }

    public void publishLotto(int cost) {
        List<Integer> randNums;
        try {
            for (int i = 0; i < cost; i++) {
                randNums = generateNewLotto();
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
        String Ticket = String.format("[%s]", String.join(",", sortedNums));
        return Ticket;
    }





}
