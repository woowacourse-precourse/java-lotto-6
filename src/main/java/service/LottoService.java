package service;

public class LottoService {
    private LottoService(){}

    private static LottoService instance = new LottoService();

    public static LottoService getInstance(){
        return instance;
    }

}
