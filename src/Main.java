import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Oleg", Arrays.asList(new Course("Math"), new Course("Testing"),
                new Course("English"))));
        students.add(new Student("Anton", Arrays.asList(new Course("Boxing"),
                new Course("Russian"), new Course("Testing"), new Course("English"))));
        students.add(new Student("Gleb", Arrays.asList(new Course("Math"))));

        System.out.println(students.stream()
                .map(s -> s.getCourses())
                .flatMap(c -> c.stream())
                .collect(Collectors.toSet()));


        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(2)
                .collect(Collectors.toList()));


        Course course = new Course("Math");
        System.out.println(students.stream()
                .filter(s -> s.getCourses().contains(course))
                .collect(Collectors.toList()));
    }
}
