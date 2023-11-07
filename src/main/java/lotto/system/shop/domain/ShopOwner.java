package lotto.system.shop.domain;

import lotto.system.shop.domain.ticket.Ticket;

public interface ShopOwner <T extends Ticket<?>,R> {

    Machine<T, R> getMachine();

    Viewer getViewer();

    Reader getReader();
}
