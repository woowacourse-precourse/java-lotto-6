package lotto.instance;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.storage.LottoStorage;
import lotto.view.Communicator;

public class InstanceContainer {
    private final LottoController lottoController;

    public InstanceContainer() {
        this.lottoController = genereateLottoController();
    }

    public LottoController getLottoController() {
        return lottoController;
    }

    private LottoStorage generateLottoStorage() {
        return new LottoStorage();
    }

    private LottoService generateLottoService() {
        return new LottoService(generateLottoStorage());
    }

    private Communicator generateCommunicator() {
        return new Communicator();
    }

    private LottoController genereateLottoController() {
        return new LottoController(generateCommunicator(), generateLottoService());
    }
}
