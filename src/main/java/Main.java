import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");

        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");

        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10_000_000; i++) {

            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        var teenCount = persons
                .stream()
                .filter(person -> person.getAge() < 18)
                .count();

        System.out.println(teenCount);

        var conscripts = persons
                .stream()
                .filter(person -> person.getSex().equals(Sex.MAN))
                .filter(person -> person.getAge() >= 18 && person.getAge() < 27)
                .map(Person::getFamily)
                .toList();

        conscripts.forEach(System.out::println);

        var worker = persons
                .stream()
                .filter(p -> p.getAge() >= 18 && ((p.getSex().equals(Sex.WOMAN) && p.getAge() <= 60) ||
                        (p.getSex().equals(Sex.MAN) && p.getAge() <= 65)))
                .filter(person -> person.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .toList();

        worker.forEach(System.out::println);
    }
}
