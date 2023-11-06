package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Statistics;

import java.util.*;

import static lotto.controller.InputController.*;

public class LottoService {

    public static int getAmountOfLottoTickets() {
        int amountOfLottoTickets = money / 1000;

        // [예외처리] 1000원으로 나누어 떨어지지 않는 경우
        return amountOfLottoTickets;
    }
    public static List<Lotto> makeLottoTickets() {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < getAmountOfLottoTickets(); i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            // [예외처리] 랜덤으로 생성한 수에 중복된 번호가 있는 경우
            Lotto ticketNumbers = new Lotto(numbers);
            lottoTickets.add(ticketNumbers);
        }

        return lottoTickets;
    }
    public static int compareWithWinningNumbers(Lotto lottoTicket) {
        List<Integer> lottoNumbers = lottoTicket.getNumbers();
        Set<Integer> findCorrectNumbers = new HashSet<>(lottoNumbers);
        int countingCorrectNumbers = 0;

        for (Integer num : winningNumbers) {
            if(findCorrectNumbers.contains(num)) {
                countingCorrectNumbers++;
            }
        }
        if (countingCorrectNumbers == 5) {
            countingCorrectNumbers = compareWithBonusNumber(lottoNumbers);
        }
        return countingCorrectNumbers;
    }
    public static List<Integer> countCorrectNumbers(List<Lotto> lottoTickets) {
        List<Integer> amountOfCorrectNumbers = new ArrayList<>();
        for (Lotto lottoTicket : lottoTickets) {
            amountOfCorrectNumbers.add(compareWithWinningNumbers(lottoTicket));
        }
        System.out.println(amountOfCorrectNumbers.toString());
        return amountOfCorrectNumbers;
    }
    public static int compareWithBonusNumber(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (number == bonusNumber) {
                return 7;
            }
        }
        return 5;
    }
    public static int countCorrespondingTickets(int number,List<Integer> amountOfCorrectNumbers) {
        int counter = 0;
        for (Integer correctNumbers : amountOfCorrectNumbers) {
            if (correctNumbers == number) {
                counter ++;
            }
        }
        return counter;
    }
    public static List<Statistics> makeStatistics(List<Integer> amountOfCorrectNumbers) {
        List<Statistics> lottoStatistics = new ArrayList<>();
        lottoStatistics.add(new Statistics("3개 일치 (5,000원)",5000, countCorrespondingTickets(3, amountOfCorrectNumbers)));
        lottoStatistics.add(new Statistics("4개 일치 (50,000원)",50000, countCorrespondingTickets(4, amountOfCorrectNumbers)));
        lottoStatistics.add(new Statistics("5개 일치 (1,500,000원)",1500000, countCorrespondingTickets(5, amountOfCorrectNumbers)));
        lottoStatistics.add(new Statistics("5개 일치, 보너스 볼 일치 (30,000,000원)",30000000, countCorrespondingTickets(7, amountOfCorrectNumbers)));
        lottoStatistics.add(new Statistics("6개 일치 (2,000,000,000원)",2000000000, countCorrespondingTickets(6, amountOfCorrectNumbers)));

        return lottoStatistics;
    }
    public static double getEarningRate(List<Statistics> lottoStatistics) {
        double earningRate = 0;
        for (Statistics statistics : lottoStatistics) {
            earningRate += statistics.getValueNumber()*statistics.getAmountOfTickets();
        }
        earningRate = earningRate / money * 100;
        return earningRate;
    }
}
