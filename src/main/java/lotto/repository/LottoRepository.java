package lotto.repository;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {

    static List<List<Integer>> lottoRepo = new ArrayList<>();
    public static void lottoSave(List<Integer> lottoBalls){
        lottoRepo.add(lottoBalls);
    }
    public static List<List<Integer>> getLottoRepo(){
        return lottoRepo;
    }
}
