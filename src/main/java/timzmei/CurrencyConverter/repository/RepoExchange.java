package timzmei.CurrencyConverter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import timzmei.CurrencyConverter.model.Exchange;

import javax.money.NumberValue;
import java.util.Date;
import java.util.List;

/**
 * Created by timur_guliev on 26.03.2021.
 */
@Repository
public interface RepoExchange extends JpaRepository<Exchange, Long> {

    @Modifying
    @Query(
            value = "INSERT INTO request_exchange (id_user, from_currency, to_currency, from_value) VALUES (:id_user, :from_currency, :to_currency, :from_value)",
            nativeQuery = true)
    void insertExchange(@Param("id_user") int userId, @Param("from_currency") String fromCurrencyCode, @Param("to_currency") String toCurrencyCode, @Param("from_value") double valueFrom);

    @Query(value = "SELECT LAST_INSERT_ID()",
            nativeQuery = true)
    int getLastId();

    @Query(value = "SELECT ex.id_user FROM request_exchange ex WHERE ex.from_value > :from_value ORDER BY ex.from_value",
            nativeQuery = true)
    List<Integer> getUserMostSingleExchange(@Param("from_value") double from_value);

    @Query(value = "SELECT ex.id_user, SUM(ex.from_value) AS sum FROM request_exchange ex WHERE sum > :from_value ORDER BY sum",
            nativeQuery = true)
    List<Integer> getUserMostOverallExchange(@Param("from_value") double value);

    @Query(value = "SELECT COUNT(ex.from_currency + ex.from_currency) AS exchange FROM request_exchange ex ORDER BY exchange",
            nativeQuery = true)
    List<Exchange> getCurrencyRating();
}
