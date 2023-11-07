package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.enums.LottoRank;
import lotto.io.InputManager;
import lotto.io.OutputManager;

import java.util.*;

public class LottoGameManager {
    private static final int LOTTO_PRICE = 1000;
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final int money;

    private List<Lotto> lottos;
    private Map<LottoRank, Integer> lottoResult;

    public LottoGameManager() {
        inputManager = InputManager.getInstance();
        outputManager = OutputManager.getInstance();
        money = readPurchase();
        printLottoListMsg();
        winningNumbers = readWinningNumber();
        bonusNumber = readBonusNumber();
    }

    public void run() {
        generateLottoResultMap();
        printLottoResult();

        double benefitRate = getBenefitRate();
        outputManager.printBenefitRateMsg(benefitRate);
    }

    public int readPurchase() {
        outputManager.printPurchaseMsg();
        int money = inputManager.readPurchase();

        return money;
    }

    public List<Integer> readWinningNumber() {
        outputManager.printWinningNumberMsg();
        List<Integer> winningNumbers = inputManager.readWinningNumber();

        return winningNumbers;
    }

    public int readBonusNumber() {
        outputManager.printBonusNumberMsg();

        int bonusNumber = 0;
        while(true) {
            try {
                bonusNumber = inputManager.readInputBonusNumber();
                if(winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[Error] 보너스 번호는 당첨 번호와 중복 될 수 없습니다.");
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public void printLottoListMsg() {
        generateLottos();
        outputManager.printLottoListMsg(lottos);
    }

    public void printLottoResult() {
        outputManager.printLottoResultMsg(lottoResult);
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    public void generateLottos() {
        lottos = new ArrayList<>();
        int amount = money / LOTTO_PRICE;

        for (int idx = 0; idx < amount; idx++) {
            Lotto lotto = new Lotto(generateRandomNumbers());
            lottos.add(lotto);
        }
    }

    public List<LottoRank> rankLottos() {
        List<LottoRank> lottoRanks = new ArrayList<>();

        for(Lotto lotto : lottos) {
            LottoRank rank = lotto.getLottoRank(winningNumbers, bonusNumber);
            lottoRanks.add(rank);
        }

        return lottoRanks;
    }

    public void generateLottoResultMap() {
        List<LottoRank> lottoRanks = rankLottos();

        lottoResult = new LinkedHashMap<>();
        lottoResult.put(LottoRank.THIRD, 0);
        lottoResult.put(LottoRank.FOURTH, 0);
        lottoResult.put(LottoRank.FIFTH_WITHOUT_BONUS, 0);
        lottoResult.put(LottoRank.FIFTH_WITH_BONUS, 0);
        lottoResult.put(LottoRank.SIXTH, 0);

        for(LottoRank rank : lottoRanks) {
            if(rank != LottoRank.NONE) {
                lottoResult.put(rank, lottoResult.get(rank) + 1);
            }
        }
    }

    public double getBenefitRate() {
        int prize = 0;

        for(LottoRank rank : lottoResult.keySet()) {
            prize += rank.prize * lottoResult.get(rank);
        }

        return (double) prize/ (double) money * 100.0;
    }

}
