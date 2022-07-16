package webclient.backend.common;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class Utils {
    /**
     * Метод возвращает дату в текущем регионе
     */
    public static LocalDateTime toZoneMSK(LocalDateTime dateTime) {
        if (ZoneId.systemDefault().getId().equals("Europe/Moscow")) return dateTime;

        return dateTime.toInstant(ZoneOffset.UTC).atZone(ZoneId.of("+3")).toLocalDateTime();
    }
}
