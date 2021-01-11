package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImpl;
import core.basesyntax.dao.UserDao;
import core.basesyntax.dao.UserDaoImpl;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String NAME_PATTERN = "(?)[A-Z]([a-z]{3,})";
    @Inject
    private BetDao betDao;
    @Inject
    private UserDao userDao;

    public void handle() {
        Scanner scanner = new Scanner(System.in);
        betDaoAdd(scanner);
        userDaoAdd(scanner);
    }

    private void betDaoAdd(Scanner scanner) {
        System.out.println("Enter please risk and you bet or 'q' to exit");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                return;
            }
            Bet bet = null;
            try {
                String[] betData = command.split(" ");
                int value = Integer.parseInt(betData[0]);
                double risk = Double.parseDouble(betData[1]);
                bet = new Bet(value, risk);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Please, enter a valid data");
            }
            if (bet != null) {
                betDao.add(bet);
                System.out.println(bet);
            }
        }
    }

    private void userDaoAdd(Scanner scanner) {
        System.out.println("Enter you name or 'q' to exit");
        while (true) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("q")) {
                return;
            }
            if (name.isEmpty() || !name.matches(NAME_PATTERN)) {
                System.out.println("Please, enter a valid data");
                continue;
            }
            userDao.add(new User(name));
            return;
        }
    }
}
