package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.WinNumber;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.validator.LottoNumberValidator;
import lotto.validator.PriceValidator;

public class LotteryGame {
    private List<Lotto> lottoList;
    private WinNumber winNumber;
    private int cost;
    private Map<Rank, Integer> result;
    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void run() {
        init();
        outputHandler.print(Messasge.RESULT);
        result = getResult();
    }

    private void init() {
        outputHandler.print(Messasge.REQUEST_PRICE);
        lottoList = getLottoList(getPrice());
        outputHandler.print(Messasge.REQUEST_NUMBERS);
        winNumber = getWinNumber();
        outputHandler.print(Messasge.getResultMessage(result, getProfitRate(cost)));
    }

    private int getPrice() {
        while (true) {
            try {
                String inputPrice = inputHandler.readLine();
                PriceValidator.isInteger(inputPrice);

                int price = Integer.parseInt(inputPrice);

                PriceValidator.validateCost(price);
                PriceValidator.validateThousand(price);

                cost = price;
                return price;
            } catch (IllegalArgumentException e) {
                outputHandler.print(Messasge.ERROR + e.getMessage());
            }
        }
    }

    private List<Lotto> getLottoList(int price) {
        int count = price / 1000;
        Lotto[] lottos = new Lotto[price / 1000];
        for (int i = 0; i < count; i++) {
            lottos[i] = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return Arrays.asList(lottos);
    }

    private WinNumber getWinNumber() {
        while (true) {
            try {
                List<Integer> numbers = getLottoNumbers();
                return new WinNumber(numbers, getBonusNumber(numbers));
            } catch (IllegalArgumentException e) {
                outputHandler.print(e.getMessage());
            }
        }
    }

    private List<Integer> getLottoNumbers() {
        while (true) {
            try {
                String[] inputNumbers = inputHandler.readLine().split(",");
                Integer[] numbers = new Integer[inputNumbers.length];
                for (String number : inputNumbers) {
                    LottoNumberValidator.isInteger(number);
                }
                // 출력 위치 변경 필요
                outputHandler.print(Messasge.REQUEST_BONUS_NUMBER);
                return Arrays.asList(numbers);
            } catch (IllegalArgumentException e) {
                outputHandler.print(Messasge.ERROR + e.getMessage());
            }
        }
    }

    private int getBonusNumber(List<Integer> numbers) {
        while (true) {
            try {
                String inputNumber = inputHandler.readLine();
                LottoNumberValidator.isInteger(inputNumber);
                int bonusNumber = Integer.parseInt(inputNumber);
                LottoNumberValidator.validateDuplicatedNumber(numbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                outputHandler.print(Messasge.ERROR + e.getMessage());
            }
        }
    }

    private Map<Rank, Integer> getResult(){
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottoList){
            Rank rank = lotto.getRank(winNumber);
            result.put(rank, result.getOrDefault(rank, 0)+1);
        }
        return result;
    }

    private double getProfitRate(int cost){
        long totalReward = 0L;

        for(Rank rank : result.keySet()){
            totalReward += rank.reward * result.get(rank) ;
        }

        return (double) totalReward / cost * 100;
    }
}