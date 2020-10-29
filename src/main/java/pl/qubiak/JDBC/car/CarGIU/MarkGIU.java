package pl.qubiak.JDBC.car.CarGIU;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import pl.qubiak.JDBC.car.DAO.CarDao;

import java.util.List;
import java.util.Map;

@Route
public class MarkGIU extends VerticalLayout {

    private TextField textFieldMark;
    private TextArea textArea;
    private Button button;
    private CarDao carDao;

    public MarkGIU(CarDao carDao) {
        this.textFieldMark = new TextField("Mark");
        this.textArea = new TextArea();
        this.button = new Button("Pokaż");


        button.addClickListener(x -> {
           List<Map<String, Object>> mapa = carDao.showByMark(textFieldMark.getValue());
            textArea.setValue(mapa.toString());
        });
        this.carDao = carDao;

    add(textFieldMark, textArea, button);
    }
}
