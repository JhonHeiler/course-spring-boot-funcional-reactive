import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 21, 11, 10, 25);
        List<String> textString = Arrays.asList("mariela", "carlo", "heiler");
        User user1 = new User("Healer", 23);
        User user2 = new User("Cristian", 20);
        User user3 = new User("Karen", 16);
        List<User> users = Arrays.asList(user1, user2, user3);

        System.out.println("List of prime numbers: " + getPrime(numbers));
        System.out.println("List of text String in Uppercase : " + getStringUppercase(textString));
        System.out.println("List of  squared number : " + getSquare(numbers));
        System.out.println("List of users : " + getUsers(users));
        List<Integer> listOfnumbers1 = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

        function1(listOfnumbers1).forEach(System.out::println);




    }

    private static List<Integer> getPrime(List<Integer> numbers) {
        return numbers.stream().filter(Main::isPrime).toList();
    }

    private static List<String> getStringUppercase(List<String> textString) {
        return textString.stream().map(String::toUpperCase).toList();
    }

    private static List<Double> getSquare(List<Integer> numbers) {
        return numbers.stream().map(n -> Math.pow(n, 2)).toList();
    }

    private static List<String> getUsers(List<User> users) {

        return users.stream().map(User::getName).toList();
    }

    public static boolean isPrime(int number) {
        if (number == 0 || number == 1 || number == 4) {
            return false;
        }
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }



    private static List<Integer> function1(List<Integer> myList) {

        Predicate<Integer> num_primo = num -> {
            IntStream myIntStream = IntStream.rangeClosed(1, num)
                    .filter(n -> num % n == 0);

            return myIntStream.count() <= 2;
        };
        return myList.stream()
                .filter(num_primo)
                .collect(Collectors.toList());
    }


}

class User {
    private final String name;
    private final Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}