package core.basesyntax.controller;

import core.basesyntax.controller.controller.ConsoleHandler;
import core.basesyntax.controller.dao.BetDao;
import core.basesyntax.controller.factory.Factory;
import core.basesyntax.lib.Injector;

import java.lang.reflect.InvocationTargetException;

public class Application {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ConsoleHandler handler = (ConsoleHandler) Injector
                .getInstance(ConsoleHandler.class);
        handler.handle();

        BetDao betDao = Factory.getBetDao();
    }
}
