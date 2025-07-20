import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;

public class DateTimeAPIExample {

    public static void main(String[] args) {
        // Get current local date
        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        // Get current local time
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);

        // Get current local date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current Date and Time: " + currentDateTime);

        // Get current date and time with a specific time-zone
        ZoneId newYorkZone = ZoneId.of("America/New_York");
        ZonedDateTime currentDateTimeInNewYork = ZonedDateTime.now(newYorkZone);
        System.out.println("Current Date and Time in New York: " + currentDateTimeInNewYork);

        // Get current date and time in the default system time-zone
        ZonedDateTime currentDateTimeWithZone = ZonedDateTime.now();
        System.out.println("Current Date and Time (with default zone): " + currentDateTimeWithZone);
    }
}