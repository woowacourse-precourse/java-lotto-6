package lotto.system.shop.domain;

import lotto.system.shop.domain.ticket.lotto.LottoTicket;
import lotto.system.shop.machine.LottoMachine;
import lotto.system.shop.reader.ConsoleReader;
import lotto.system.shop.viewer.ConsoleViewer;

public class LottoShopOwner implements ShopOwner<LottoTicket, LottoRank> {

    @Override
    public Machine<LottoTicket, LottoRank> getMachine() {
        return new LottoMachine();
    }

    @Override
    public Viewer getViewer() {
        return new ConsoleViewer();
    }

    @Override
    public Reader getReader() {
        return new ConsoleReader();
    }
}
