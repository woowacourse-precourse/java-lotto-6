package lotto.controller.numbercandidatestring;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.LottoNumber;

public class NumberCandidateStrings {

    private final List<NumberCandidateString> numberCandidateStrings;

    private NumberCandidateStrings(List<NumberCandidateString> numberCandidateStrings) {
        this.numberCandidateStrings = numberCandidateStrings;
    }

    public List<LottoNumber> toLottoNumberList(){
        return numberCandidateStrings.stream().map(NumberCandidateString::toNumber).map(LottoNumber::new).toList();
    }

    public static NumberCandidateStrings from(String numberCandiate){
        List<NumberCandidateString> numberCandidateStrings = Arrays.stream(toSplit(numberCandiate))
                .map(NumberCandidateString::new)
                .toList();
        return new NumberCandidateStrings(numberCandidateStrings);
    }

    private static String[] toSplit(String numberCandiate) {
        return numberCandiate.split(",");
    }
}
