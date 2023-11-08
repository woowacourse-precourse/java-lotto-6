package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.LottoResult;
import lotto.validator.LottoPurchaseAmountValidator;
import lotto.validator.WinningLottoValidator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 로또 게임을 진행하는 클래스
 */
public class LottoGame {

    private List<Lotto> lottos = new ArrayList<>(); // 구입한 로또

    private Map<LottoResult, Integer> lottoResults = new LinkedHashMap<>(); // 로또 결과

    private int totalPurchaseAmount = 0;

    private int totalWinningMoney = 0;

    private List<Integer> winningNums = new ArrayList<>();

    private Integer bonusNum;

    private LottoPurchaseAmountValidator lottoPurchaseAmountValidator;

    private WinningLottoValidator winningLottoValidator;

    public LottoGame(LottoPurchaseAmountValidator lottoPurchaseAmountValidator, WinningLottoValidator winningLottoValidator) {
        this.lottoPurchaseAmountValidator = lottoPurchaseAmountValidator;
        this.winningLottoValidator = winningLottoValidator;
        initLottoResults();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    /**
     * 로또 게임을 시작한다.
     */
    public void start() {
        getPurchaseAmount();
        generateLottos(this.totalPurchaseAmount);
        printPurchasedLottos();
        getWinningLotto();
        calculateResult();
        printResult();
    }

    /**
     * 로또 결과를 초기화한다.
     */
    public void initLottoResults() {
        Arrays.stream(LottoResult.values()).forEach(lottoResult -> lottoResults.put(lottoResult, 0));
    }

    /**
     * 구입 금액을 입력받는다.(유효한 금액을 입력할 때까지 반복)
     */
    private void getPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmountInput = Console.readLine();
            try {
                if (lottoPurchaseAmountValidator.isValid(purchaseAmountInput)) {
                    this.totalPurchaseAmount = Integer.parseInt(purchaseAmountInput);
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(String.format("[ERROR] %s", e.getMessage()));
            }
        }
    }

    /**
     * 구입 금액만큼 로또 번호를 생성한다.
     * @param purchaseAmount 구입 금액
     */
    public void generateLottos(int purchaseAmount) {
        for (int i = 0; i < purchaseAmount / GameDetail.AMOUNT_UNIT; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }
    }

    /**
     * 구입한 로또를 출력한다.
     */
    private void printPurchasedLottos() {
        int size = 0;
        if (lottos != null) {
            size = lottos.size();
        }
        System.out.println(String.format("%d개를 구매했습니다.", size));
        if (lottos != null) {
            lottos.stream().forEach(lotto -> System.out.println(lotto.toString()));
        }
    }

    /**
     * 당첨 번호와 보너스 번호를 입력받는다.
     */
    private void getWinningLotto() {
        getWinningNums();
        getBonusNum();
    }

    /**
     * 당첨번호를 입력받는다.(유효한 번호를 입력할 때까지 반복)
     */
    private void getWinningNums() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String inputNums = Console.readLine();
            if (winningLottoValidator.isValidWinningNums(inputNums)) {
                this.winningNums = Arrays.stream(inputNums.split(GameDetail.WINNING_NUM_SEPARATOR))
                        .map(num -> Integer.parseInt(num))
                        .collect(Collectors.toList());
                break;
            }
        }
    }

    /**
     * 보너스번호를 입력받는다.(유효한 번호를 입력할 때까지 반복)
     */
    private void getBonusNum() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNum = Console.readLine();

            if (winningLottoValidator.isValidBonusNum(bonusNum)
                    && winningLottoValidator.isUniqueBonusNum(this.winningNums, Integer.parseInt(bonusNum))) {
                    this.bonusNum = Integer.parseInt(bonusNum);
                    break;
            }
        }
    }

    /**
     * 당첨결과를 출력한다.
     */
    private void printResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        lottoResults.forEach((key, value) -> {
            if (!LottoResult.NO_MATCH.equals(key)) {
                System.out.println(String.format("%s - %d개", key.toString(), value));
            }
        });
        System.out.println(String.format("총 수익률은 %s%%입니다.", getProfitRate()));
    }

    /**
     * 로또 당첨 결과를 계산한다.
     */
    private void calculateResult() {
        lottos.stream().forEach(lotto -> {
            LottoResult result = lotto.getLottoResult(winningNums, bonusNum);
            lottoResults.put(result, lottoResults.getOrDefault(result.getMatchCount(), 0) + 1);
        });
        this.totalWinningMoney = lottoResults.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }

    /**
     * 수익률을 계산한다.
     * @return 계산된 수익률(%)
     */
    private double getProfitRate() {
        if (totalPurchaseAmount == 0 || totalWinningMoney == 0) {
            return 0;
        }
        return (double) totalWinningMoney / totalPurchaseAmount * 100;
    }

}
