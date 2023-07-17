import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;

public class Test {

    private static List<Person> persons = new ArrayList<>();

    @BeforeAll
    public static void initPersons() {

        System.out.println("initPersons");

        persons.add(new Person("Alex", "Bondit", 46, Sex.MAN, Education.HIGHER));

        persons.add(new Person("Roman", "Whilter", 13, Sex.MAN, Education.ELEMENTARY));

        persons.add(new Person("Anna", "Filman", 15, Sex.WOMAN, Education.ELEMENTARY));

        persons.add(new Person("Dmitriy", "Badrismaslov", 26, Sex.MAN, Education.SECONDARY));

        persons.add(new Person("Sergey", "Elshin", 18, Sex.MAN, Education.ELEMENTARY));

        persons.add(new Person("Inna", "Smith", 55, Sex.WOMAN, Education.HIGHER));

    }

    @org.junit.jupiter.api.Test
    public void testTeenCount() {

        long result = Main.teenCount(persons);
        Assertions.assertEquals(2, result);

    }

    @org.junit.jupiter.api.Test
    public void testConscripts() {

        var result = Main.conscripts(persons);
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.containsAll(List.of("Badrismaslov", "Elshin")));
    }

    @org.junit.jupiter.api.Test
    public void testWorkers() {

        var result = Main.workers(persons);
        Assertions.assertEquals(2, result.size());

    }

}
