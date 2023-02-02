package canteen;

import canteen.dish.Dish;
import canteen.dish.DishContent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.List;

public class CanteenService {
    private final LocalDate date;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final String URL_STRING = "https://www.stwno.de/infomax/daten-extern/csv/HS-R-tag/%s.csv";

    public CanteenService(LocalDate date) {
        this.date = date;
    }

    public List<Dish> getDishes() {
        return getReader().lines()
                .skip(1)
                .filter(l -> l.contains(formatter.format(date)))
                .map(Dish::fromString).toList();
    }

    private BufferedReader getReader() {
        var url = getUrl();
        try {
            var inputStreamReader = new InputStreamReader(url.openStream(), "Cp1252");
            return new BufferedReader(inputStreamReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private URL getUrl() {
        int week = this.date.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
        try {
            return new URL(String.format(URL_STRING, week));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
