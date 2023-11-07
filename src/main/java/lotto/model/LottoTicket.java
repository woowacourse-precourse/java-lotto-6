package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoNumberGenerator;
import lotto.util.Validator;

// 책임: 사용자가 구매한 로또의 모음을 관리합니다.
//  LottoTicket은 이러한 여러 Lotto 객체들의 컬렉션을 관리하며, 구매한 전체 로또에 대한 정보와 로직을 캡슐화합니다.
public class LottoTicket {

    private final List<Lotto> lottoEntries = new ArrayList<>();

    //당첨 번호를 받아서 매칭 결과를 확인하는 메서드 등이 있을 수 있습니다.
    public LottoTicket(final int numberOfTickets) {
        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> numbers = LottoNumberGenerator.generate();
            Validator.validate(numbers);
            this.lottoEntries.add(new Lotto(numbers));
        }
    }

    public List<Lotto> getLottoEntries() {
        return lottoEntries;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottoEntries) {
            sb.append(lotto.toString()).append("\n");
        }
        return sb.toString();
    }
}
