package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {

    private static final String DOES_NOT_HAVE_A_SUCH_STATION_ERROR = "해당하는 역이 존재하지 않습니다.";
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public static Station findStation(String name) {
        return stations.stream()
                .filter(station->station.getName().equals(name))
                .findFirst()
                .orElseThrow(()->new IllegalArgumentException(DOES_NOT_HAVE_A_SUCH_STATION_ERROR));
    }
}
