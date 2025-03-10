import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercises {

    public boolean validateEmail(String email) {
        // Updated regex that disallows a dot at the beginning or end of the local part
        String regex = "^[A-Za-z0-9]+([A-Za-z0-9._%+-]*[A-Za-z0-9])?@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public String findDate(String string) {
        // Updated regex to handle dates surrounded by punctuation or spaces
        String regex = "(\\b(\\d{4}-\\d{2}-\\d{2}|(0?[1-9]|[12]\\d|3[01])[-\\/.](0?[1-9]|1[0-2])[-\\/.](\\d{4}))\\b)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        // Look for a match and return it
        if (matcher.find()) {
            return matcher.group().replaceAll("[^\\d/.-]", ""); // Remove any extra surrounding punctuation
        }

        return null;
    }

    public int findValidPasswords(String string) {
        // Regex to match a valid password with all conditions
        String regex = "\\b(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*_])[A-Za-z\\d!@#$%^&*_]{8,}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }



    public List<String> findPalindromes(String string) {
        List<String> list = new ArrayList<>();
        String regex = "\\b[a-zA-Z]{3,}\\b"; // Match words with at least 3 letters (ignores punctuation)
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            String word = matcher.group();
            String cleanWord = word.toLowerCase();
            if (cleanWord.equals(new StringBuilder(cleanWord).reverse().toString())) {
                list.add(word);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Exercises exercises = new Exercises();

        // Testing validateEmail
        System.out.println(exercises.validateEmail("test@example.com"));
        System.out.println(exercises.validateEmail("invalid-email"));

        // Testing findDate
        System.out.println(exercises.findDate("Today is 12/03/2024 and tomorrow is 13-03-2024."));

        // Testing findValidPasswords
        System.out.println(exercises.findValidPasswords("Passw0rd! abc123 Qwerty@12"));

        // Testing findPalindromes
        System.out.println(exercises.findPalindromes("Anna went to kayak on the river. Level up!"));
    }
}