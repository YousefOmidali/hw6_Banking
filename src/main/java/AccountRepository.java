import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {
    private Connection connection = MyConnection.connection;

    public AccountRepository() throws SQLException {
        String createTable = "create table if not exists account (\n" +
                "first_name varchar (200),\n" +
                "last_name varchar (200),\n" +
                "national_code int ,\n" +
                "Id serial primary key ,\n" +
                "branch account_branch\n" +
                ");";
        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
        preparedStatement.close();

    }

    public void insert(Account account) throws SQLException {
        String insert = "insert into account (first_name, last_name, national_code,amount, branch) values (?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setString(1, account.getFirstName());
        preparedStatement.setString(2, account.getLastName());
        preparedStatement.setInt(3, account.getNationalCode());
        preparedStatement.setInt(4, account.getAmount());
        preparedStatement.setString(5, account.getBranch());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public void update(Account account) throws SQLException {
        String update = "update Account set first_name = ?,last_name = ?, national_code = ?, amount = ?, branch = ? " +
                "where Id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, account.getFirstName());
        preparedStatement.setString(2, account.getLastName());
        preparedStatement.setInt(3, account.getNationalCode());
        preparedStatement.setInt(4, account.getAmount());
        preparedStatement.setString(5, account.getBranch());
        preparedStatement.execute();
        preparedStatement.close();

    }

    public void delete(Integer id) throws SQLException {
        String delete = "delete from Account where Id = ? ;";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public Account findByNationalCode(Integer nationalCode) throws SQLException {
        String findByNationalCode = "SELECT * FROM Account " +
                "WHERE national_code = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findByNationalCode);
        preparedStatement.setInt(1, nationalCode);
        ResultSet resultSet = preparedStatement.executeQuery();
        Account account = null;
        if (resultSet.next()) {
            account = new Account(resultSet.getInt("amount"),resultSet.getInt("Id"),resultSet.getString("branch"));
        }
        return account;
    }

}

