package lotto;

import View.Input;
import View.Output;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {
    private static int LOTTO_PRICE = 1000;
    private int[] rankCounters = new int[6]; // 1등 ~ 5등, index 0은 사용 안 함 

    void execute() {
        int receivedAmount = getReceivedAmount();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < getNumberOfLotto(receivedAmount); i++) {
            lottos.add(drawLotto());
        }
        Output.printCreatedLottos(lottos);

        Lotto pickedNumbers = getPickedNumbers();
        Bonus bonus = getBonusNumber();

        Ticket ticket = new Ticket(pickedNumbers, bonus); // 구매자의 티켓

        compareTicketAndLottos(ticket, lottos);
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
        } catch(NumberFormatException nfe) { // pickedNumbers 중 정수값이 없을 경우
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
    }
}
