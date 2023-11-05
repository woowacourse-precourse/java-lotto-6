package lotto;

import View.Input;
import View.Output;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoApplication {
    private static int LOTTO_PRICE = 1000;
    private int matchingNumbersCounter;
    private boolean bonusMatch;
    private boolean[] rankCounter = new boolean[6]; // 등수 결정 index 0은 사용하지 않음

    void execute() {
        int receivedAmount = getReceivedAmount();

        List<Lotto> createdLottos = new ArrayList<>();
        for (int i = 0; i < getNumberOfLotto(receivedAmount); i++) {
            createdLottos.add(drawLotto());
        }
        Output.printCreatedLottos(createdLottos);

        Lotto pickedNumbers = getPickedNumbers();
        Bonus bonus = getBonusNumber();

        Ticket ticket = new Ticket(pickedNumbers, bonus); // 구매자의 티켓

        compareTicketAndLottos(ticket, createdLottos);

        decideRank();
    }

    private int getReceivedAmount() {
        int receivedAmount;

        try {
            receivedAmount = Integer.parseInt(Input.readReceivedAmount());
            validateReceivedAmount(receivedAmount);
        } catch (NumberFormatException nfe) { // 정수값 입력하지 않았을 경우
            throw new IllegalArgumentException();
        }

        return receivedAmount;
    }

    private void validateReceivedAmount(int receivedAmount) {
        if (!(receivedAmount % LOTTO_PRICE == 0)) {
            throw new IllegalArgumentException();
        }
    }

    private Lotto getPickedNumbers() {
        try {
            List<Integer> pickedNumbers = Arrays.stream(Input.readPickedNumbers().trim().split(","))
                    .map(Integer::valueOf)
                    .toList(); // String[]을 List<Integer>로 변환 

            return new Lotto(pickedNumbers);
        } catch (NumberFormatException nfe) { // pickedNumbers 중 정수값이 없을 경우
            throw new IllegalArgumentException();
        }

    }

    private Bonus getBonusNumber() {
        try {
            return new Bonus(Integer.parseInt(Input.readBonusNumber()));
        } catch (NumberFormatException nfe) { // 정수값 입력하지 않았을 경우
            throw new IllegalArgumentException();
        }
    }

    private Lotto drawLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.START_NUMBER, Lotto.END_NUMBER, 6));
    }

    private int getNumberOfLotto(int receivedAmount) {
        return receivedAmount / LOTTO_PRICE;
    }

    private void compareTicketAndLottos(Ticket ticket, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            compareTicketAndLotto(ticket, lotto);
        }
    }

    private void compareTicketAndLotto(Ticket ticket, Lotto lotto) {
        List<Integer> ticketNumbers = ticket.getLotto().getNumbers();
        int bonusNumber = ticket.getBonus().getNumber();

        List<Integer> lottoNumbers = lotto.getNumbers();

        for (Integer ticketNumber : ticketNumbers) {
            if (lottoNumbers.contains(ticketNumber)) {
                matchingNumbersCounter++;

            }
        }

        bonusMatch = matchingNumbersCounter == 5 && lottoNumbers.contains(bonusNumber);
    }

    private void decideRank() {
        if (matchingNumbersCounter == 6) {
            rankCounter[1] = true;
        }

        if (matchingNumbersCounter == 5) {
            if (bonusMatch) {
                rankCounter[2] = true;
            }

            rankCounter[3] = true;
        }

        if (matchingNumbersCounter == 4) {
            rankCounter[4] = true;
        }

        if (matchingNumbersCounter == 3) {
            rankCounter[5] = true;
        }
    }
}
