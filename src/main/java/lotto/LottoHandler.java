package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class LottoHandler {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;


    public List<Lotto> issueLottoNumbers(int lottoTicket) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoTicket; i++) {
            lottos.add(pickNumbersOrderByAsc());
        }

        OutputHandler.printLottos(lottos);
        return lottos;
    }

    public Map<WinningKind, Integer> winningResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        Map<WinningKind, Integer> winningResult = calculateResult(lottos, winningLotto, bonusNumber);
        OutputHandler.printWinningStatistics(winningResult);
        return winningResult;
    }

    public void rateOfReturnResult(int numberOfLotto, Map<WinningKind, Integer> winningResult) {
        int revenue = calculateRevenue(winningResult);
        double rateOfReturn = calculateRateOfReturn(numberOfLotto, revenue);
        OutputHandler.printRateOfReturn(rateOfReturn);
    }

    public int calculateLottoTicketCount(String receivedPurchasePrice) {
        int purchasePrice;
        try {
            purchasePrice = Integer.parseInt(removeSpaces(receivedPurchasePrice));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }

        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] " + formatPrice(LOTTO_PRICE) + "원 단위로만 입력해 주세요.");
        }
        return purchasePrice / LOTTO_PRICE;
    }

    private Lotto pickNumbersOrderByAsc() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_START_NUMBER,
                LOTTO_LAST_NUMBER,
                LOTTO_NUMBER_COUNT
        );
        List<Integer> lottoNumbers = sort(numbers);
        return new Lotto(lottoNumbers);
    }

    public Lotto receiveWinningLotto(String receivedWinningLotto) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] separatedWinningLotto = receivedWinningLotto.split(",");
        try {
            for (String winningLotto : separatedWinningLotto) {
                winningNumbers.add(Integer.parseInt(removeSpaces(winningLotto)));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
        List<Integer> winningLottoNumbers = sort(winningNumbers);
        return new Lotto(winningLottoNumbers);
    }

    public int receiveBonusNumber(String receivedBonusNumber) {
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(removeSpaces(receivedBonusNumber));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
        validBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private void validBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_START_NUMBER || bonusNumber > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException("[ERROR] " + LOTTO_START_NUMBER + " 이상 " + LOTTO_LAST_NUMBER + " 이하의 숫자를 입력해 주세요.");
        }
    }

    private void winningResultInitialize(Map<WinningKind, Integer> winningResult) {
        winningResult.put(WinningKind.FIFTH, 0);
        winningResult.put(WinningKind.FOURTH, 0);
        winningResult.put(WinningKind.THIRD, 0);
        winningResult.put(WinningKind.SECOND, 0);
        winningResult.put(WinningKind.FIRST, 0);
    }

    public int winningNumberCount(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    private Map<WinningKind, Integer> calculateResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        Map<WinningKind, Integer> winningResult = new HashMap<>();
        winningResultInitialize(winningResult);

        for (Lotto lotto : lottos) {
            int winningNumberCount = winningNumberCount(lotto, winningLotto);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            calculateWinning(winningNumberCount, bonusMatch, winningResult);
        }
        return winningResult;
    }

    public void calculateWinning(int winningNumberCount, boolean bonusMatch, Map<WinningKind, Integer> winningResult) {
        if (winningNumberCount == 3) {
            winningResult.put(WinningKind.FIFTH, winningResult.get(WinningKind.FIFTH) + 1);
            return;
        }
        if (winningNumberCount == 4) {
            winningResult.put(WinningKind.FOURTH, winningResult.get(WinningKind.FOURTH) + 1);
            return;
        }
        if (winningNumberCount == 5) {
            if (bonusMatch) {
                winningResult.put(WinningKind.SECOND, winningResult.get(WinningKind.SECOND) + 1);
                return;
            }
            winningResult.put(WinningKind.THIRD, winningResult.get(WinningKind.THIRD) + 1);
            return;
        }
        if (winningNumberCount == 6) {
            winningResult.put(WinningKind.FIRST, winningResult.get(WinningKind.FIRST) + 1);
        }
    }

    public int calculateRevenue(Map<WinningKind, Integer> winningResult) {
        int revenue = 0;
        for (WinningKind winningKind : WinningKind.values()) {
            revenue += (winningKind.getPrice() * winningResult.get(winningKind));
        }
        return revenue;
    }

    public double calculateRateOfReturn(int numberOfLotto, int revenue) {
        int investmentAmount = numberOfLotto * LOTTO_PRICE;
        double rateOfReturn = (double) revenue / investmentAmount * 100;
        return rounds(rateOfReturn, 1);
    }

    private double rounds(double number, int decimalPoint) {
        return new BigDecimal(number).setScale(decimalPoint, RoundingMode.HALF_UP).doubleValue();
    }

    private List<Integer> sort(List<Integer> numbers) {
        List<Integer> lottoNumbers = numbers.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return lottoNumbers;
    }

    public String formatPrice(int price) {
        return String.format("%,d", price);
    }

    public String removeSpaces(String inputValue) {
        return inputValue.replaceAll("\\s+", "");
    }
}
