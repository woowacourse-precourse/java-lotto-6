package lotto;

import java.util.List;

public class Main {
    private User user;
    private List<LottoResult> results;
    Main(){
        user = new User();
        extractResult();
        new Calculator(user.getPrice(),results);
    }
    private void extractResult(){
        results= user.getLottos()
                .stream()
                .map(e->new LottoResult(e.getNumbers(),user.getAnswers()))
                .toList();
    }

}
