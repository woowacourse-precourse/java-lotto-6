package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void listToList(List<Integer> fromList, List<Integer> toList) {
        Collections.sort(fromList);
        toList.addAll(fromList);
    }

    public static void main(String[] args) {
        Input input = new Input();
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Analyzer analyzer = new Analyzer();

        int ticket = input.inputPurchaseAmount();
        List<Integer> winningNumbers = input.inputWinningNumbers();
        int bonusNumber = input.inputBonusNumber();
        List<Integer> allTicketNumbers = new ArrayList<>();
        Map<Integer, Integer> ticketResults = new HashMap<>();

        for (int i = 0; i < ticket; i++) {
            listToList(lotto.generateLotto(), allTicketNumbers);
        }
        ticketResults = analyzer.fillTicketResults(ticket,winningNumbers,allTicketNumbers,bonusNumber);

    }
}
