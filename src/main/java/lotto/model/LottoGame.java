package lotto.model;

import lotto.controller.InputController;
import lotto.controller.OutputController;
import lotto.domain.Lotto;
import lotto.domain.LottoBoard;
import lotto.domain.Player;
import lotto.domain.Prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private LottoBoard lottoBoard;
    private Player player;

    private Map<Prize, Integer> result = new HashMap<>();

    public void initResult() {
        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
    }

    public Integer sumOfReturns(Map<Prize, Integer> result) {
        Integer sum = 0;
        for (Map.Entry<Prize, Integer> entry : result.entrySet()) {
            Prize prize = entry.getKey();
            int count = entry.getValue();
            sum += count * prize.getPrizeAmount();
        }

        return sum;
    }


    public LottoGame() {
        InputController inputController = new InputController();
        OutputController outputController = new OutputController();

        initResult();

        inputController.startGame();
        lottoBoard = new LottoBoard(inputController.getMoney());


        player = new Player(inputController.playerInput());

        for (int i = 0; i < lottoBoard.getTickets(); i++) {
            compareLottoAndPlayer(lottoBoard.getOneLotto(i), player.getNumbers(), player.getBonus());
        }

        outputController.printResult(result, sumOfReturns(result), lottoBoard.getTickets());
    }

    void compareLottoAndPlayer(Lotto lotto, List<Integer> numbers, Integer bonus) {
        int numSame = 0;
        Boolean hasBonus = false;
        for (Integer num : numbers) {
            if (lotto.getNumbers().contains(num)) {
                numSame++;
            }
        }
        if (lotto.getNumbers().contains(bonus)) {
            hasBonus = true;
        }

        renewalResult(numSame, hasBonus);
    }


    void renewalResult(int numSame, boolean hasBonus) {
        Prize prize = null;
        for (Prize p : Prize.values()) {
            if (p.getMatchingNumbers() == numSame) {
                if (numSame == 5 && hasBonus) {
                    if (p == Prize.FIVE_MATCH_WITH_BONUS) {
                        prize = p;
                        break;
                    }
                } else {
                    prize = p;
                    break;
                }
            }
        }

        if (prize != null) {
            result.put(prize, result.get(prize) + 1);
        }
    }

}
