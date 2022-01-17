import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardRepository {
    private Connection connection = MyConnection.connection;

    public CardRepository() throws SQLException {
        String createTable = "create table if not exists employee (\n" +
                "id integer," +
                "card_number bigint, " +
                "cvv2 integer, " +
                "password integer, " +
                "CONSTRAINT fk_Card_id FOREIGN KEY (id) REFERENCES Account (Id));";
        PreparedStatement preparedStatement = connection.prepareStatement(createTable);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public void insert(Card card) throws SQLException {
        String insert = "insert into card(card_number, cvv2 , password ) values (?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setLong(1, card.getCardNumber());
        preparedStatement.setInt(2, card.getCvv2());
        preparedStatement.setString(3, card.getPassword());
        preparedStatement.execute();
        preparedStatement.close();
    }

    public void update(Card card, Long cardNumber) throws SQLException {
        String update = "update card set card_number = ? , cvv2 = ? , password = ? where card_number = ? ;";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setLong(1, card.getCardNumber());
        preparedStatement.setInt(2, card.getCvv2());
        preparedStatement.setString(3, card.getPassword());
        preparedStatement.setLong(4, cardNumber);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public void delete(Long cardNumber) throws SQLException {
        String delete = "delete from card where card_number = ? ;";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setLong(1, cardNumber);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public Boolean checkByCardNumber(Long cardNumber) throws SQLException {
        Boolean status = false;
        String exists = "select * from card where card_number = ? ;";
        PreparedStatement preparedStatement = connection.prepareStatement(exists);
        preparedStatement.setLong(1, cardNumber);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            status = true;
        return status;

    }

    public Boolean checkCardNumberDigits(Long cardNumber) throws SQLException {
        Boolean status = false;
        int digit = 0;
        if (cardNumber > 0) {
            cardNumber /= 10;
            digit++;
            if (digit == 16 || digit == 12)
                status = true;
        }
        return status;
    }
}
