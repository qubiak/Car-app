package pl.qubiak.JDBC.car.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.qubiak.JDBC.car.Model.CarModel;

@Repository
public class CarDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(CarModel car){

        String sql = "INSERT INTO Car VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{
                car.getCarId(),
                car.getMark(),
                car.getModel(),
                car.getColor()
        });

    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbInit() {
        add(new CarModel(1, "Hyundai", "Accent", "Zielony"));
        add(new CarModel(2, "Daewoo", "Leganza", "Niebieski"));
        add(new CarModel(3, "Citroen", "C4 picasso", "Czarny"));
        add(new CarModel(4, "Kia", "Sportage", "Szary"));

    }

}


/*    @Bean
    public void dbInit() {
        String sql = "CREATE TABLE Car(car_id int, mark varchar(255), model varchar(255), color varchar(255));";
        getJdbcTemplate().update(sql);
    }

 */