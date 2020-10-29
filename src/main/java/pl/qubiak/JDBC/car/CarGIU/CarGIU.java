package pl.qubiak.JDBC.car.CarGIU;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.qubiak.JDBC.car.DAO.CarDao;
import pl.qubiak.JDBC.car.Model.CarModel;

@Route
public class CarGIU extends VerticalLayout {

    private TextField textFieldId;
    private TextField textFieldMark;
    private TextField textFieldModel;
    private TextField textFieldColor;
    private Button button;
    private CarDao carDao;

    @Autowired
    public CarGIU(CarDao carDao) {
        this.textFieldId = new TextField("ID");
        this.textFieldMark = new TextField("Mark");
        this.textFieldModel = new TextField("Model");
        this.textFieldColor = new TextField("Color");
        this.button = new Button("Dodaj");
        this.carDao = carDao;


        button.addClickListener(ClickEvent -> {
            CarModel car = new CarModel(
                    Integer.parseInt(textFieldId.getValue()),
                    textFieldMark.getValue(),
                    textFieldModel.getValue(),
                    textFieldColor.getValue());
            carDao.save(car);
        });

        add(textFieldId, textFieldMark, textFieldModel, textFieldColor, button);
    }
}
