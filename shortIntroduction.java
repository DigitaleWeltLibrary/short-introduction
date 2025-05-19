
import java.time.Year;
import java.util.Scanner;

class shortIntroduction {

    private static final Scanner scanner = new Scanner(System.in);
    private static int yearOfBirth;

    public static void main(String[] args) {
        String UserName = getName();
        Integer age = getBirth();

        scanner.close();

        writeToConsole("\n\n\n");
        writeToConsole("Hello " + UserName + ", your age is: " + age);
        writeToConsole("Your life runs from " + yearOfBirth + " to " + currentYear() + " (today).");
    }

    /* NOTE get the name of the person */
    private static String getName() {
        writeToConsole("Enter your name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            writeToConsole("Name cannot be empty");
            return getName();
        }

        return name.trim();
    }

    /* NOTE asks for the year of birth */
    private static int getBirth() {
        writeToConsole("Enter your year of birth: ");
        String yearOfBirthstr = scanner.nextLine().trim();

        try {
            int year = Integer.parseInt(yearOfBirthstr);

            if (yearOfBirthstr.isEmpty()) {
                writeToConsole("Year of birth cannot be empty");
                return getBirth();
            }

            if (yearOfBirthstr.length() != 4) {
                writeToConsole("Year of birth must be 4 digits");
                return getBirth();
            }

            yearOfBirth = year;
            int age = getAge(year);

            return age;
        } catch (Exception e) {
            writeToConsole("Year of birth must be a number");
            return getBirth();
        }
    }

    /* NOTE calculate the current age */
    private static int getAge(int YearOfBirth) {
        int year = currentYear();
        int age = year - YearOfBirth;
        return age;
    }

    /* NOTE get current year */
    private static int currentYear() {
        return Year.now().getValue();
    }

    /* NOTE write to console */
    private static void writeToConsole(String message) {
        System.out.println(message);
    }

}
