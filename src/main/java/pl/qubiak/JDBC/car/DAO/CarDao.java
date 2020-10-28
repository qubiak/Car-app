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

    public void save(CarModel car){

        String sql = "INSERT INTO Car VALUES(?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{
                car.getCarId(),
                car.getMark(),
                car.getModel(),
                car.getColor()
        });

    }
// to do -> validacja
    @EventListener(ApplicationReadyEvent.class)
    public void dbInit() {
        save(new CarModel(1, "Hyundai", "Accent", "Zielony"));
        save(new CarModel(2, "Daewoo", "Leganza", "Niebieski"));
        save(new CarModel(3, "Citroen", "C4 picasso", "Czarny"));
        save(new CarModel(4, "Kia", "Sportage", "Szary"));

    }

}


/*    @Bean
    public void dbInit() {
        String sql = "CREATE TABLE Car(car_id int, mark varchar(255), model varchar(255), color varchar(255));";
        getJdbcTemplate().update(sql);
    }

 */