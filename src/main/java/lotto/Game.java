package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
import lotto.domain.Money;
import lotto.input.InputBonus;
import lotto.input.InputLotto;
import lotto.input.InputMoney;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private final String MESSAGE_LOTTO_COUNT = "개를 구매했습니다.";
    private final String SPLIT_CHARACTER = ",";

    private LottoManager lottoManager;
    private Lotto winningLotto;
    private Money money;
    private Bonus bonus;

    public Game() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoManager = new LottoManager(lottoList);
    }

    public void renderMoneyView() {
        while (true) {
            try {
                InputMoney inputMoney = new InputMoney();
                Integer input = Integer.parseInt(inputMoney.getUserInput());
                money = new Money(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void renderBonus() {
        while (true) {
            try {
                InputBonus inputBonus = new InputBonus();
                String input = inputBonus.getUserInput();
                bonus = new Bonus(Integer.parseInt(input), winningLotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void renderLotto() {
        int lottoCount = money.calculateLottoCount();
        System.out.println(lottoCount + MESSAGE_LOTTO_COUNT);
        for (int i = 0; i < lottoCount; i++) {
            lottoManager.add(lottoManager.createLotto());
        }
        lottoManager.renderAllLotte();
    }

    public void renderWinningLotto() {
        while (true) {
            try {
                InputLotto inputLotto = new InputLotto();
                String lotto = inputLotto.getUserInput();
                Integer[] lottos = convertStringToInteger(splitNumber(lotto));
                winningLotto = new Lotto(convertArrayToList(lottos));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> convertArrayToList(Integer[] inputs) {
        return Arrays.asList(inputs);
    }

    private Integer[] convertStringToInteger(String[] inputs) {
        Integer[] numbers = new Integer[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        return numbers;
    }

    private String[] splitNumber(String input) {
        return input.split(SPLIT_CHARACTER);
    }
}