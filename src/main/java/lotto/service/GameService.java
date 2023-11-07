package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.Message;
import lotto.domain.Buyer;
import lotto.domain.GameResult;
import lotto.domain.Lotto;
import lotto.domain.WinningInfo;
import lotto.dto.GameResultDTO;
import lotto.dto.LottoDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameService {

    private final int NUMBER_START_RANGE = 1;
    private final int NUMBER_END_RANGE = 45;
    private final int MAX_COUNT = 6;
    private final int UNIT_MONEY = 1000;
    private final int METHOD_PURCHASE_AMOUNT = 1;
    private final int METHOD_SAVE_WINNING_NUMBERS = 2;
    private final int METHOD_SAVE_BONUS_NUMBER = 3;
    private final String REGEXP_PATTERN_NO_NUMBER = "^[\\d]*$";
    private final Buyer buyer = new Buyer();
    private final WinningInfo winningInfo = new WinningInfo();
    private final GameResult gameResult = new GameResult(winningInfo);

    public void purchaseLotto(String input) {

        savePurchaseAmount(input);

        int amount = buyer.getAmount();

        savePurchaseNumbers(amount);
    }

    private void savePurchaseAmount(String input) {

        validateInput(input, METHOD_PURCHASE_AMOUNT);

        int money = Integer.parseInt(input);
        buyer.saveAmount(money);
    }

    private void savePurchaseNumbers(int amount) {

        for(int i=0; i<amount; i++) {

            List<Integer> numbers = createNumbers();

            buyer.saveNumbers(numbers);
        }
    }

    public void saveWinningNumbers(String input) {

        validateInput(input, METHOD_SAVE_WINNING_NUMBERS);

        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(Integer::parseInt).toList();

        winningInfo.saveWinningNumbers(winningNumbers);
    }

    public void saveBonusNumber(String input) {

        validateInput(input, METHOD_SAVE_BONUS_NUMBER);
        validateBonusNumber(input);

        int bonusNumber = Integer.parseInt(input);
        winningInfo.saveBonusNumber(bonusNumber);
    }

    public int getPurchaseAmount() {

        return buyer.getAmount();
    }

    public List<LottoDTO> getPurchaseLottos() {

        List<Lotto> lottos = buyer.getLottos();

        return domainToDto(lottos);
    }

    public GameResultDTO getGameResult() {

        List<Lotto> lottos = buyer.getLottos();

        gameResult.matchPurchasedLottos(lottos);

        GameResultDTO gameResultDTO = new GameResultDTO(gameResult.getPrize());

        return gameResultDTO;
    }

    public double getYieldRate() {

        long prizeMoney = gameResult.getPrizeMoney();

        int amount = buyer.getAmount();

        return (double) prizeMoney/(amount * UNIT_MONEY) * 100;
    }

    private List<Integer> createNumbers() {

        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(NUMBER_START_RANGE, NUMBER_END_RANGE, MAX_COUNT);

        return numbers;
    }

    private void validateInput(String input, int methodName) {

        String REGEXP = REGEXP_PATTERN_NO_NUMBER;

        String removeComma = input.replaceAll("\\,", "");

        if (!removeComma.matches(REGEXP)) {

            findErrorMethod(methodName);
        }
    }

    private void validateBonusNumber(String input){

        String [] tmp = input.split(",");

        if(tmp.length != 1) {

            throw new IllegalArgumentException(Message.BONUS_NUMBERS_SIZE_ERROR_MESSAGE.name());
        }
    }

    private void findErrorMethod(int methodName) {

        if (methodName == METHOD_PURCHASE_AMOUNT) {

            throw new IllegalArgumentException(Message.INPUT_MONEY_ERROR_MESSAGE.name());
        }

        if (methodName == METHOD_SAVE_WINNING_NUMBERS) {

            throw new IllegalArgumentException(Message.INPUT_WINNING_NUMBERS_ERROR_MESSAGE.name());
        }

        if (methodName == METHOD_SAVE_BONUS_NUMBER) {

            throw new IllegalArgumentException(Message.INPUT_BONUS_NUMBER_ERROR_MESSAGE.name());
        }
    }

    private List<LottoDTO> domainToDto(List<Lotto> lottos) {

        List<LottoDTO> lottoDTOS = new ArrayList<>();

        for(Lotto lotto : lottos) {

            LottoDTO lottoDTO = new LottoDTO();
            lottoDTO.makeLottoDTO(lotto.getNumbers());
            lottoDTOS.add(lottoDTO);
        }

        return lottoDTOS;
    }
}
