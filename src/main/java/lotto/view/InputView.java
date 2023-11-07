package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.LottoValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {

    private StringTokenizer st;
    private LottoValidation lottoValidation = new LottoValidation();
    private List<Integer> winningNumbers = new ArrayList<>();

    public int inputPurchasePrice() {
        String input = Console.readLine();
        lottoValidation.validatePurchasePrice(input);
        int purchasePrice = Integer.parseInt(input);
        return purchasePrice;
    }

    public List<Integer> inputWinningNumbers() {
        String input = Console.readLine();
        lottoValidation.validateWinningNumbers(input);
        winningNumbers = stringToListInteger(input);
        return winningNumbers;
    }

    public int inputBonusNumber() {
        String input = Console.readLine();
        lottoValidation.validateBonusNumber(input, winningNumbers);
        return Integer.parseInt(input);
    }

    private List<Integer> stringToListInteger(String input) {
        String value = input.replace(" ", "");
        st = new StringTokenizer(value, ",");
        List<Integer> winningNumbers = new ArrayList<>();
        while (st.hasMoreTokens()) {
            winningNumbers.add(Integer.valueOf(st.nextToken()));
        }
        return winningNumbers;
    }
}
