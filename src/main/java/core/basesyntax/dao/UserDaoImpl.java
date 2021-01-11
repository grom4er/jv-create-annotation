package core.basesyntax.dao;

import core.basesyntax.db.StorageUsers;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.User;
import java.util.List;

@Dao
public class UserDaoImpl implements UserDao {
    @Override
    public void add(User user) {
        StorageUsers.users.add(user);
    }

    @Override
    public List<User> getAll() {
        return StorageUsers.users;
    }
}
