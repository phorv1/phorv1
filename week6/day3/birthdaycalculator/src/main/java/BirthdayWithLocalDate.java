import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BirthdayWithLocalDate implements BirthDayCalculator<LocalDate> {

  @Override
  public LocalDate parseDate(String str) {
    // TODO - return with the parsed date; format is: yyyy-MM-dd
    return LocalDate.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }

  @Override
  public String printMonthAndDay(LocalDate date) {
    // TODO - return the date formatted: month & day (MM. dd.)
    return date.format(DateTimeFormatter.ofPattern("MM. dd."));
  }

  @Override
  public boolean isAnniversaryToday(LocalDate date) {
    // TODO - return with true if today is the same month+day as date
    MonthDay receivedMonthDay = MonthDay.of(date.getMonth(), date.getDayOfMonth());
    return receivedMonthDay.equals(MonthDay.now());
  }

  @Override
  public int calculateAgeInYears(LocalDate birthday) {
    // TODO - return how many years age the input date 'birthday' was
    return Period.between(birthday, LocalDate.now()).getYears();
  }

  @Override
  public int calculateDaysToNextAnniversary(LocalDate date) {
    // TODO - the number of days remaining to the next anniversary of 'date' (e.g. if tomorrow, return 1)
    int daysToNextAnniversary;

    if (MonthDay.now().equals(MonthDay.from(date))) {
      daysToNextAnniversary = 0;
    } else {
      boolean isAnniversaryNextYear = MonthDay.now().isAfter(MonthDay.from(date));

      LocalDate nextAnniversary = LocalDate.of(LocalDate.now().getYear() + ((isAnniversaryNextYear) ? 1 : 0), MonthDay.from(date).getMonth(), MonthDay.from(date).getDayOfMonth());
      daysToNextAnniversary = (int) ChronoUnit.DAYS.between(LocalDate.now(), nextAnniversary);
    }

    return daysToNextAnniversary;
  }

  public static void main(String[] args) {
    new BirthdayWithLocalDate().run();
  }

  private void run() {

    print("Birthday with java.util.Date.");
    String birthdayStr = readInput("What day were you born (yyyy-mm-dd)?");

    LocalDate birthdayDate = parseDate(birthdayStr);
    print("Your birthday: " + printMonthAndDay(birthdayDate));

    if (isAnniversaryToday(birthdayDate)) {
      int ageInYears = calculateAgeInYears(birthdayDate);
      print("Congratulations! Today is your " + ageInYears + "th birthday!");
    } else {
      int daysLeft = calculateDaysToNextAnniversary(birthdayDate);
      print("You have to wait only " + daysLeft + " days for your next birthday.");
    }
  }

  private void print(String line) {
    System.out.println(line);
  }

  private String readInput(String message) {
    System.out.print(message + ": ");
    return input.nextLine();
  }

  private final Scanner input = new Scanner(System.in, "UTF-8");
}