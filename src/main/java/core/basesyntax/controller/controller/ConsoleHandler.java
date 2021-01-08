package core.basesyntax.controller.controller;

import core.basesyntax.controller.dao.BetDao;
import core.basesyntax.controller.dao.BetDaoImpl;
import core.basesyntax.controller.dao.UserDao;
import core.basesyntax.controller.dao.UserDaoImpl;
import core.basesyntax.controller.model.Bet;
import core.basesyntax.controller.model.User;
import java.util.Scanner;

public class ConsoleHandler {
    private static final String NAME_PATTERN = "[A-z]{2,}";
    private final BetDao betDao = new BetDaoImpl();
    private final UserDao userDao = new UserDaoImpl();

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
            if (name.isEmpty() || name.matches(NAME_PATTERN)) {
                System.out.println("Please, enter a valid data");
                continue;
            }
            userDao.add(new User(name));
            return;
        }
    }
}
