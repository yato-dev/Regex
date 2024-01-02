import java.util.regex.Pattern;

public class User {
    String firstName;

    User(String firstName) {
        if (!validate(firstName)) {
            throw new IllegalArgumentException(" First letter should be capital ");
        }
        this.firstName = firstName;
    }

    private boolean validate(String firstName) {
        Pattern pattern = Pattern.compile("^[A-Z].{2,}$");
        boolean matcher = pattern.matcher(firstName).matches();
        System.out.println(matcher);
        return matcher;
    }

}