import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");

        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 100; i++) {

            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        System.out.println(teenCount(persons));

        conscripts(persons).forEach(System.out::println);

        workers(persons).forEach(System.out::println);
    }

    public static Long teenCount(List<Person> persons) {

        return persons
                .stream()
                .filter(person -> person.getAge() < 18)
                .count();

    }

    public static List<String> conscripts(List<Person> persons) {

        return persons
                .stream()
                .filter(person -> person.getSex().equals(Sex.MAN))
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27)
                .map(Person::getFamily)
                .toList();
    }

    public static List<Person> workers(List<Person> persons) {

        return persons
                .stream()
                .filter(p -> p.getAge() >= 18 && ((p.getSex().equals(Sex.WOMAN) && p.getAge() <= 60) ||
                        (p.getSex().equals(Sex.MAN) && p.getAge() <= 65)))
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .toList();
    }
}
