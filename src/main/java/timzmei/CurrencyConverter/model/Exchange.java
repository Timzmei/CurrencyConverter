package timzmei.CurrencyConverter.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by timur_guliev on 26.03.2021.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request_exchange")
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Column(name = "id_user")
    @NotNull
    private int userId;

    @Column(name = "from_currency")
    @NotNull
    private String fromCurrencyCode;

    @Column(name = "to_currency")
    @NotNull
    private String toCurrencyCode;

    @Column(name = "from_value")
    @NotNull
    private double value;



}
