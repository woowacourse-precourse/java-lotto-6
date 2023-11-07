package lotto.domain.user;

import lotto.domain.lotto.Lotto;
import lotto.global.enums.Separator;
import lotto.global.enums.ViewMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserLottoResponse {
    private List<Lotto> lottoList = new ArrayList<>();

    public UserLottoResponse(User user){
        this.lottoList = user.getMyLotto();
    }

    public void outputLottoSize(){
        System.out.println(this.lottoList.size() + ViewMessage.OUTPUT_LOTTO_SIZE.getMessage());
    }

    @Override
    public String toString(){
        return lottoList.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining(Separator.NEW_LINE.toString())) + Separator.NEW_LINE;
    }
}
