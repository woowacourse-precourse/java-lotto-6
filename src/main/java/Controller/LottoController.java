package Controller;


import Model.InputModel;
import Model.LottoModel;
import Utils.LottoRank;
import Utils.Messages;
import VIew.LottoView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoController {
    List<Integer> winningLottoNumber;
    Map<LottoRank, Integer> correctLottoNumber = new EnumMap<>(LottoRank.class);
    List<Lotto> lottoNumbers = new ArrayList<>();
    int payment, countOfLotto, bonusNumber;
    double total;

    private final InputManager inputManager;
    private final InputModel  inputModel;
    private final LottoModel lottoModel;
    private LottoView lottoView;

    public LottoController(InputManager inputManger, InputModel inputModel, LottoView lottoView) {
        initializeCorrectLottoNumberMap();
        this.inputManager = inputManger;
        this.inputModel = inputModel;
        this.lottoModel = new LottoModel();
        this.lottoView = lottoView;
    }

    public void run() {
        promptForPurchaseAmount();
        generateLottoTickets();
        promptForWinningNumbers();
        promptForBonusNumber();
        Map<LottoRank, Integer> statistics = checkWinningStatistics(lottoNumbers, winningLottoNumber, bonusNumber);
        printWinningStatistics(statistics);
        printTotalEarnings();
    }

    private Map<LottoRank, Integer> checkWinningStatistics(List<Lotto> lottoNumbers, List<Integer> winningLottoNumber, int bonusNumber) {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottoNumbers) {
            LottoRank rank = checkLottoNumber(lotto, winningLottoNumber, bonusNumber);
            statistics.merge(rank, 1, Integer::sum);
            total += rank.getPrizeMoney();
        }
        return statistics;
    }

    private void promptForPurchaseAmount() {
        payment = inputManager.promptForPayment(Messages.INPUT_MONEY);
        lottoModel.setPayment(payment);
        countOfLotto = lottoModel.getCountOfLotto();
    }

    private void generateLottoTickets() {
        for (int i = 0; i < countOfLotto; i++) {
            lottoNumbers.add(createLotto());
        }
        System.out.println(countOfLotto + "개를 구매했습니다.");
        lottoNumbers.forEach(lotto -> System.out.println(lotto.getLottoArray()));
    }

    private void promptForWinningNumbers() {
        System.out.println(Messages.INPUT_WINNING_NUMBERS);
        Lotto lotto = gettingLottoWinningNumbers(Console.readLine());
        winningLottoNumber = lotto.getLottoArray();
    }

    private void promptForBonusNumber() {
        System.out.println(Messages.INPUT_BONUS_NUMBER);
        bonusNumber = Integer.parseInt(Console.readLine());
        winningLottoNumber.add(bonusNumber);
    }

    private void printWinningStatistics(Map<LottoRank, Integer> statistics) {
        System.out.println(Messages.WINNING_STATISTICS);
        System.out.println(Messages.UNDER_BAR);

        // 당첨 통계를 출력합니다. 여기서는 계산된 통계 맵을 사용합니다.
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) { // NONE을 제외한 모든 등수에 대해 출력
                String description = rank.getDescription();
                int count = statistics.getOrDefault(rank, 0); // 등수에 해당하는 티켓 수가 없으면 기본값으로 0을 사용
                System.out.println(description + " - " + count + "개");
            }
        }
    }



    private void printTotalEarnings() {
        System.out.println("총 수익률은 " + calculateAverage(total) + "%입니다.");
    }

    private String calculateAverage(double total) {
        double earningsRate = (total / payment ) * 100;
        return String.format("%.1f", earningsRate);
    }

    private LottoRank checkLottoNumber(Lotto lotto, List<Integer> winningNumbers, int bonusNum) {
        int matchCount = 0;
        boolean bonusMatch = false;

        for (int number : lotto.getLottoArray()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
            if (number == bonusNum) {
                bonusMatch = true;
            }
        }

        // 이제 당첨 등수를 LottoRank.valueOf를 사용하여 계산합니다.
        return LottoRank.valueOf(matchCount, bonusMatch);
    }



    public void initializeCorrectLottoNumberMap() {
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.NONE) { // NONE은 맵에 포함시키지 않음
                correctLottoNumber.put(rank, 0);
            }
        }
    }

    private Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public Lotto gettingLottoWinningNumbers(String lottoNumbers) {
        List<Integer> lottoNumbersArray = Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(lottoNumbersArray);

    }
}
