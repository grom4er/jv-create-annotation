package core.basesyntax.controller.dao;

import core.basesyntax.controller.db.StorageBets;
import core.basesyntax.controller.model.Bet;
import core.basesyntax.lib.Dao;

import java.util.List;
@Dao
public class BetDaoImpl implements BetDao {
    @Override
    public void add(Bet bet) {
        StorageBets.bets.add(bet);
    }

    @Override
    public List<Bet> getAll() {
        return StorageBets.bets;
    }
}
