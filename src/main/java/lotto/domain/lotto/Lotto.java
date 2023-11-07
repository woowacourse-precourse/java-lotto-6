package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> produceLottoTicket() {
        List<Integer> lottoTicket = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoTicket);
        return lottoTicket;
    }

    public static void showLottoTicket(List<Integer> lottoTicket) {
        System.out.println(lottoTicket.toString());
    }

    public static List<Lotto> gatherLottoTickets(Integer quantity) {
        List<Lotto> lottoTicketList = new ArrayList<>();
        for (int producedLotto = 1; producedLotto <= quantity; producedLotto++) {
            List<Integer> lottoTicket = produceLottoTicket();
            showLottoTicket(lottoTicket);

            Lotto lotto = new Lotto(lottoTicket);

            lottoTicketList.add(lotto);
        }
        System.out.println();
        return lottoTicketList;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
