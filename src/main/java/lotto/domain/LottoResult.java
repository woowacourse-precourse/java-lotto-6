package lotto.domain;

import java.util.List;

public class LottoResult {
    public int first = 0;
    public int second = 0;
    public int third = 0;
    public int fourth = 0;
    public int fifth = 0;

    public void compareLottoTicket(List<Integer> lottoNumbers, List<Integer> ticketNumbers) {
        int lottoMatch = compareLottoNumber(lottoNumbers, ticketNumbers);
        boolean bonusMatch = compareBonusNumber(lottoNumbers, ticketNumbers);

        getLottoRank(lottoMatch, bonusMatch);
    }

    public int compareLottoNumber(List<Integer> lottoNumbers, List<Integer> ticketNumbers) {
        int lottoMatch = 0;
        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            if (ticketNumbers.contains(lottoNumbers.get(i))) {
                lottoMatch += 1;
            }
        }
        return lottoMatch;
    }

    public boolean compareBonusNumber(List<Integer> lottoNumbers, List<Integer> ticketNumbers) {
        if (ticketNumbers.contains(lottoNumbers.get(6))) {
            return true;
        }
        return false;
    }

    public void compareAllLottoTicket(List<Integer> lottoNumbers, List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            compareLottoTicket(lottoNumbers, lottoTicket.lottoNumber);
        }
    }

    public void getLottoRank(int lottoMatch, boolean bonusMatch) {
        if (lottoMatch == 3) {
            this.fifth += 1;
        } else if (lottoMatch == 4) {
            this.fourth += 1;
        } else if (lottoMatch == 5 && bonusMatch) {
            this.second += 1;
        } else if (lottoMatch == 5) {
            this.third += 1;
        } else if (lottoMatch == 6) {
            this.first += 1;
        }
    }

    public double getProfitMargin(int money) {
        double prize = getPrize();
        double profitMargin = Math.round(((prize / money) * 100) * 10 / 10.0);

        return profitMargin;
    }

    public double getPrize() {
        double prize =
                (first * 2000000000) + (second * 30000000) + (third * 1500000) + (fourth * 50000) + (fifth * 5000);
        return prize;
    }

}

