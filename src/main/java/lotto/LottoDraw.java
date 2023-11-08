package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import input.ConvertInput;
import input.Customer;
import java.util.List;
import output.Matched;
import value.*;

public class LottoDraw {
    public List<Integer> LottoNums;
    public int bonusNum;
    Customer costomer = new Customer();
    Lotto lotto;
    int drawCount;

    
    LottoDraw() {
        drawCount = costomer.getDrawCount();
        System.out.println(drawCount + LottoDefaultMessage.TOTAL_LOTTO_COUNT.getString());
        for (int i = 0; i < drawCount; i++) {
            costomer.buyLotto();
        }
    }

    public void start() {
        getLottoNumbers();
        bonusNum = getBonusNumber();

        Matched matched = new Matched();
        for (Lotto lot : costomer.lottos) {
            List<Integer> match = lot.compareNumbers(lotto.getNumbers());
            System.out.println(match);
            matched.updateMatched(match.size(), lot.compareBonusNumber(bonusNum));
        }
        matched.showStatistics();
    }

    public void getLottoNumbers() {
        System.out.println("\n" + LottoDefaultMessage.INSERT_LOTTO_NUMBERS.getString());
        List<Integer> lottoNums = ConvertInput.ListInput(readLine());
        lotto = new Lotto(lottoNums);
    }

    public int getBonusNumber() {
        System.out.println("\n" + LottoDefaultMessage.INSERT_BONUS_NUMBER.getString());
        return ConvertInput.numInput(readLine());
    }
}
