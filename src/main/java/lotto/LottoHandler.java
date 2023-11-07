package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoHandler {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;

    public int lottoCountForPurchasePrice() {
        int lottoTicket = 0;
        boolean validPrice = false;

        while (!validPrice) {
            try {
                OutputHandler.printMessage("구입금액을 입력해 주세요.");
                lottoTicket = calculateLottoTicketCount(Console.readLine());
                validPrice = true;
            } catch (IllegalArgumentException e) {
                OutputHandler.printMessage(e.getMessage());
            }
        }
        OutputHandler.printLineBreakMessage(lottoTicket + "개를 구매했습니다.");
        return lottoTicket;
    }

    public List<Lotto> issueLottoNumbers(int lottoTicket) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoTicket; i++) {
            lottos.add(pickNumbersOrderByAsc());
        }

        OutputHandler.printLottos(lottos);
        return lottos;
    }

    public Lotto winningLotto() {
        boolean validWinning = false;
        Lotto winningLotto = null;
        while (!validWinning) {
            try {
                OutputHandler.printLineBreakMessage("당첨 번호를 입력해 주세요.");
                winningLotto = receiveWinningLotto(Console.readLine());
                validWinning = true;
            } catch (IllegalArgumentException e) {
                OutputHandler.printMessage(e.getMessage());
            }
        }
        return winningLotto;
    }

    public int bonusNumber() {
        boolean validBonusNumber = false;
        int bonusNumber = 0;

        while (!validBonusNumber) {
            try {
                OutputHandler.printLineBreakMessage("보너스 번호를 입력해 주세요.");
                bonusNumber = receiveBonusNumber(Console.readLine());
                validBonusNumber = true;
            } catch (IllegalArgumentException e) {
                OutputHandler.printMessage(e.getMessage());
            }
        }
        return bonusNumber;
    }

    public Map<WinningKind, Integer> winningResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        Map<WinningKind, Integer> winningResult = calculateResult(lottos, winningLotto, bonusNumber);
        OutputHandler.printWinningStatistics(winningResult);
        return winningResult;
    }

    public double rateOfReturnResult(int numberOfLotto, Map<WinningKind, Integer> winningResult) {
        int revenue = calculateRevenue(winningResult);
        return 0;
    }

    public int calculateLottoTicketCount(String receivedPurchasePrice) {
        int purchasePrice;
        try {
            purchasePrice = Integer.parseInt(receivedPurchasePrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }

        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] " + LOTTO_PRICE + "원 단위로만 입력해 주세요.");
        }
        return purchasePrice / LOTTO_PRICE;
    }

    private Lotto pickNumbersOrderByAsc() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LOTTO_START_NUMBER,
                LOTTO_LAST_NUMBER,
                LOTTO_NUMBER_COUNT
        );
        numbers.sort(Comparator.naturalOrder());
        return new Lotto(numbers);
    }

    public Lotto receiveWinningLotto(String receivedWinningLotto) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] separatedWinningLotto = receivedWinningLotto.split(",");
        try {
            for (String winningLotto : separatedWinningLotto) {
                winningNumbers.add(Integer.parseInt(winningLotto));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
        winningNumbers.sort(Comparator.naturalOrder());
        return new Lotto(winningNumbers);
    }

    public int receiveBonusNumber(String receivedBonusNumber) {
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(receivedBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }
        validBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private void validBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_START_NUMBER || bonusNumber > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1 이상 45 이하의 숫자를 입력해 주세요.");
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

    private int calculateRevenue(Map<WinningKind, Integer> winningResult) {

        return 0;
    }
}
