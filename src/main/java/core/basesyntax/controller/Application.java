package core.basesyntax.controller;

import core.basesyntax.controller.controller.ConsoleHandler;

public class Application {
    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        System.out.println("Enter please risk and you bet");
        handler.handle();
    }
}
