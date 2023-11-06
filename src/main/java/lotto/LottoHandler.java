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

    public List<Lotto> issueLottoNumbers(int lottoTicket) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoTicket; i++) {
            lottos.add(pickNumbersOrderByAsc());
        }

        OutputHandler.printLottos(lottos);
        return lottos;
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

    public void winningResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        OutputHandler.printLineBreakMessage("당첨 통계");
        OutputHandler.printMessage("---");
        Map<WinningKind, Integer> winningResult = calculateWinningResult(lottos, winningLotto, bonusNumber);
    }

    public Map<WinningKind, Integer> calculateWinningResult(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        Map<WinningKind, Integer> winningResult = new HashMap<>();
        for (Lotto lotto : lottos) {
            if (lotto.equals(winningLotto)) {
                winningResult.put(WinningKind.FIRST, 1);
            }
        }
        return winningResult;
    }
}
