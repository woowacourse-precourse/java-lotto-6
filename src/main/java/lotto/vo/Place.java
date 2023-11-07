package lotto.vo;

import static lotto.message.LottoMessage.FIFTH_PLACE;
import static lotto.message.LottoMessage.FIRST_PLACE;
import static lotto.message.LottoMessage.FOURTH_PLACE;
import static lotto.message.LottoMessage.SECOND_PLACE;
import static lotto.message.LottoMessage.THIRD_PLACE;

import java.util.Arrays;
import java.util.List;

public final class Place {
    private final List<String> placeMessage;

    public Place() {
        this.placeMessage = Arrays.asList("", FIFTH_PLACE.getMessage(), FOURTH_PLACE.getMessage(),
                THIRD_PLACE.getMessage(), SECOND_PLACE.getMessage(), FIRST_PLACE.getMessage());
    }

    public String getMessage(int index) {
        return placeMessage.get(index);
    }
}
