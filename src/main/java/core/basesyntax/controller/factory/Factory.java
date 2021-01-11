package core.basesyntax.controller.factory;

import core.basesyntax.controller.dao.BetDao;
import core.basesyntax.controller.dao.BetDaoImpl;
import core.basesyntax.controller.dao.UserDao;
import core.basesyntax.controller.dao.UserDaoImpl;

public class Factory {
    private static BetDao betDao;
    private static UserDao userDao;

    public static BetDao getBetDao() {
        if (betDao == null) {
            betDao = new BetDaoImpl();
        }
        return betDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }
}